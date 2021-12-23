import java.math.BigDecimal;

public class Calculator {
    public long numOne;
    public long numTwo;
    public BigDecimal decimalOne;
    public BigDecimal decimalTwo;
    public long previousNumTwo;
    public BigDecimal previousDecimalTwo;
    public int editingNumber;
    public boolean decimals;
    public String operation;
    public boolean haventEditedDecimalOne;
    public boolean haventEditedDecimalTwo;
    public GUI guiReference;
    public Calculator(GUI gui) {
        this.decimals = false;
        this.haventEditedDecimalOne = true;
        this.haventEditedDecimalTwo = true;
        this.numOne = 0;
        this.numTwo = 0;
        this.decimalOne = new BigDecimal("0.0");
        this.decimalTwo = new BigDecimal("0.0");
        this.editingNumber = 1;
        this.guiReference = gui;
    }
    
    public long add() {
        BigDecimal decimalResult;
        if (decimals) {
            decimalResult = this.decimalOne.add(this.decimalTwo);
            if (decimalResult.compareTo(new BigDecimal("1.0")) >= 0) {
                decimalResult = decimalResult.subtract(new BigDecimal("1.0"));
                numOne+=1;
            } else if (decimalResult.compareTo(new BigDecimal("-1.0")) <= 0) {
                decimalResult = decimalResult.add(new BigDecimal("1.0"));
                numOne -= 1;
            }
            this.decimalOne = decimalResult;
        }
        return numOne + numTwo;
    }

    public long subtract() {
        BigDecimal decimalResult;
        if (decimals) {
            decimalResult = this.decimalOne.subtract(this.decimalTwo);
            if (decimalResult.compareTo(new BigDecimal("0.0")) == -1 && (numOne-numTwo) > 0) {
                decimalResult = decimalResult.add(new BigDecimal("1.0"));
                numOne -= 1;
            } else if (decimalResult.compareTo(new BigDecimal("-1.0")) == -1 && (numOne - numTwo) <= 0) {
                decimalResult = decimalResult.add(new BigDecimal("1.0"));
                numOne -= 1;
            }
            this.decimalOne = decimalResult;
        }
        return numOne - numTwo;
    }

    public long multiply() {
        return numOne * numTwo;
    }

    public long divide() {
        return (long)(numOne/numTwo);
    }

    public void performOperation() {
        long result;
        switch (operation) {
            case "+":
                result = add();
                this.numOne = result;
                this.previousNumTwo = this.numTwo;
                this.numTwo = 0;
                this.previousDecimalTwo = this.decimalTwo;
                this.decimalTwo = new BigDecimal("0.0");
                this.operation = "repeat+";
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                if (!decimals) {
                    guiReference.setNumberText(numToString(this.numOne));
                }
                else {
                    guiReference.setNumberText(numToString(this.numOne, this.decimalOne));
                }
                break;
            case "repeat+":
                this.numTwo = this.previousNumTwo;
                this.decimalTwo = this.previousDecimalTwo;
                result = add();
                this.numOne = result;
                this.numTwo = 0;
                this.decimalTwo = new BigDecimal("0.0");
                this.operation = "repeat+";
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                if (!decimals) {
                    guiReference.setNumberText(numToString(this.numOne));
                } else {
                    guiReference.setNumberText(numToString(this.numOne, this.decimalOne));
                }                break;
            case "-":
                result = subtract();
                this.numOne = result;
                this.previousNumTwo = this.numTwo;
                this.numTwo = 0;
                this.previousDecimalTwo = this.decimalTwo;
                this.decimalTwo = new BigDecimal("0.0");
                this.operation = "repeat-";
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                if (!decimals) {
                    guiReference.setNumberText(numToString(this.numOne));
                } else {
                    guiReference.setNumberText(numToString(this.numOne, this.decimalOne));
                }
                break;
            case "repeat-":
                this.numTwo = this.previousNumTwo;
                this.decimalTwo = this.previousDecimalTwo;
                result = subtract();
                this.numOne = result;
                this.numTwo = 0;
                this.decimalTwo = new BigDecimal("0.0");
                this.operation = "repeat-";
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                if (!decimals) {
                    guiReference.setNumberText(numToString(this.numOne));
                } else {
                    guiReference.setNumberText(numToString(this.numOne, this.decimalOne));
                }
                break;
            case "*":
                result = multiply();
                this.numOne = result;
                this.previousNumTwo = this.numTwo;
                this.numTwo = 0;
                this.operation = "repeat*";
                this.editingNumber = 1;
                guiReference.setNumberText(Long.toString(this.numOne));
                break;
            case "repeat*":
                this.numTwo = this.previousNumTwo;
                result = multiply();
                this.numOne = result;
                this.numTwo = 0;
                this.operation = "repeat*";
                this.editingNumber = 1;
                guiReference.setNumberText(Long.toString(this.numOne));
                break;
            case "/":
                if (this.numTwo == 0) {
                    guiReference.setNumberText("DIV BY 0");
                    this.numOne = 0;
                    this.numTwo = 0;
                    this.editingNumber = 1;
                    return;
                }
                result = divide();
                this.numOne = result;
                this.previousNumTwo = this.numTwo;
                this.numTwo = 0;
                this.operation = "repeat/";
                this.editingNumber = 1;
                guiReference.setNumberText(Long.toString(this.numOne));
                break;
            case "repeat/":
                this.numTwo = this.previousNumTwo;
                result = divide();
                this.numOne = result;
                this.numTwo = 0;
                this.operation = "repeat/";
                this.editingNumber = 1;
                guiReference.setNumberText(Long.toString(this.numOne));
                break;
            default:
                this.numOne = 0;
                this.numTwo = 0;
                this.operation = "";
                this.decimalOne = new BigDecimal("0.0");
                this.decimalTwo = new BigDecimal("0.0");
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.decimals = false;
                this.editingNumber = 1;
                guiReference.setNumberText(Long.toString(this.numOne));
                break;
        }
    }

    public String numToString(long num) {
        return Long.toString(num);
    }

    public String numToString(long num, BigDecimal decimal) {
        if (decimal.compareTo(new BigDecimal("0.0")) == -1) {
            if (num < 0) {
                return Long.toString(num) + decimal.toPlainString().substring(2);
            } else {
                return "-"+ Long.toString(num) + decimal.toPlainString().substring(2);
            }
        }
        else {
            return Long.toString(num) + decimal.toPlainString().substring(1);
        }
    }

    public String numToString(long num, String point) {
        return Long.toString(num) + ".";
    }

    public void changeDecimalSign() {
        if (this.editingNumber == 1) {
            this.decimalOne = this.decimalOne.negate();
            guiReference.setNumberText(numToString(this.numOne, this.decimalOne));
        } else {
            this.decimalTwo = this.decimalTwo.negate();
            guiReference.setNumberText(numToString(this.numTwo, this.decimalTwo));
        }
    }

    public void changeSign() {
        if (this.editingNumber == 1) {
            String numOneString = Long.toString(this.numOne);
            if (numOneString.substring(0,1).equals("-")) {
                numOneString = numOneString.substring(1, numOneString.length());
            } else {
                numOneString = "-" + numOneString;
            }
            this.numOne = Long.parseLong(numOneString);
            guiReference.setNumberText(numToString(this.numOne));
        } else {
            String numTwoString = Long.toString(this.numTwo);
            if (numTwoString.substring(0, 1).equals("-")) {
                numTwoString = numTwoString.substring(1, numTwoString.length());
            } else {
                numTwoString = "-" + numTwoString;
            }
            this.numTwo = Long.parseLong(numTwoString);
            guiReference.setNumberText(numToString(this.numTwo));
        }   
        if (decimals) {
            changeDecimalSign();
        }
     }

    public void addToNum(String numberToAdd) {
        if (numberToAdd.equals(".") && !decimals) {
            if (this.editingNumber == 1) {
                decimals = true;
                guiReference.setNumberText(numToString(this.numOne, "."));
            } else {
                decimals = true;
                guiReference.setNumberText(numToString(this.numTwo, "."));
            }
            return;
        }
        if (!decimals) {
            if (this.editingNumber == 1) {
                String numOneString = Long.toString(this.numOne);
                numOneString+=numberToAdd;
                this.numOne = Long.parseLong(numOneString);
                guiReference.setNumberText(numToString(this.numOne));
            } else {
                String numTwoString = Long.toString(this.numTwo);
                numTwoString += numberToAdd;
                this.numTwo = Long.parseLong(numTwoString);
                guiReference.setNumberText(numToString(this.numTwo));
            }
        }
        else {
            if (this.editingNumber == 1) {
                String numOneString = this.decimalOne.toPlainString();
                numOneString += numberToAdd;
                if (haventEditedDecimalOne) {
                    numOneString = numOneString.substring(0,2) + numOneString.substring(3);
                    haventEditedDecimalOne = false;
                }
                this.decimalOne = new BigDecimal(numOneString);
                guiReference.setNumberText(numToString(this.numOne, this.decimalOne));
            } else {
                String numTwoString = this.decimalTwo.toPlainString();
                numTwoString += numberToAdd;
                if (haventEditedDecimalTwo) {
                    numTwoString = numTwoString.substring(0, 2) + numTwoString.substring(3);
                    haventEditedDecimalTwo = false;
                }
                this.decimalTwo = new BigDecimal(numTwoString);
                guiReference.setNumberText(numToString(this.numTwo, this.decimalTwo));
            }
        }
    }
}
