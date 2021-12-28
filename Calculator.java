import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal numOne;
    public BigDecimal numTwo;
    public BigDecimal previousNumTwo;
    public int editingNumber;
    public boolean editingDecimals;
    public boolean haventEditedDecimalOne;
    public boolean haventEditedDecimalTwo;
    public String operation;
    public GUI guiReference;
    public boolean showDecimals;
    public boolean decimals;

    public Calculator(GUI gui) {
        this.editingNumber = 1;
        this.decimals = false;
        this.showDecimals = false;
        this.numOne = new BigDecimal("0.0");
        this.numTwo = new BigDecimal("0.0");
        this.editingDecimals = false;
        this.haventEditedDecimalOne = true;
        this.haventEditedDecimalTwo = true;
        this.previousNumTwo = new BigDecimal("0.0");
        this.guiReference = gui;
    }

    public void performOperation() {
        BigDecimal result = new BigDecimal("0.0");
        switch (operation) {
            case "+":
                result = add();
                this.operation = "repeat+";
                this.previousNumTwo = new BigDecimal(this.numTwo.toPlainString());
                this.numTwo = new BigDecimal("0.0");
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                this.performOperation();
                break;
            case "repeat+":
                this.numTwo = this.previousNumTwo;
                result = add();
                this.numOne = result;
                this.numTwo = new BigDecimal("0.0");
                this.operation = "repeat+";
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                break;
            case "-":
                result = subtract();
                this.operation = "repeat-";
                this.previousNumTwo = new BigDecimal(this.numTwo.toPlainString());
                this.numTwo = new BigDecimal("0.0");
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                this.performOperation();
                break;
            case "repeat-":
                this.numTwo = this.previousNumTwo;
                result = subtract();
                this.numOne = result;
                this.numTwo = new BigDecimal("0.0");
                this.operation = "repeat-";
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                break;
            case "*":
                result = multiply();
                this.operation = "repeat*";
                this.previousNumTwo = new BigDecimal(this.numTwo.toPlainString());
                this.numTwo = new BigDecimal("0.0");
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                this.performOperation();
                break;
            case "repeat*":
                this.numTwo = this.previousNumTwo;
                result = multiply();
                this.numOne = result;
                this.numTwo = new BigDecimal("0.0");
                this.operation = "repeat*";
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                break;
            case "/":
                result = divide();
                this.operation = "repeat/";
                this.previousNumTwo = new BigDecimal(this.numTwo.toPlainString());
                this.numTwo = new BigDecimal("0.0");
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                this.performOperation();
                break;
            case "repeat/":
                this.numTwo = this.previousNumTwo;
                result = divide();
                this.numOne = result;
                this.numTwo = new BigDecimal("0.0");
                this.operation = "repeat/";
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                break;
            case "%":
                this.numTwo = new BigDecimal("100.0");
                result = divide();
                this.numOne = result;
                this.numTwo = new BigDecimal("0.0");
                this.operation = "";
                decimals = false;
                haventEditedDecimalOne = true;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                break;
            case "":
                return;
            default:
                this.numOne = new BigDecimal("0.0");
                this.numTwo = new BigDecimal("0.0");
                this.previousNumTwo = new BigDecimal("0.0");
                this.operation = "";
                decimals = false;
                haventEditedDecimalOne = true;
                this.showDecimals = false;
                haventEditedDecimalTwo = true;
                this.editingNumber = 1;
                break;
        }
        guiReference.setNumberText(numToText(result));
    }

    private BigDecimal divide() {
        BigDecimal result;
        try {
            result = this.numOne.divide(this.numTwo);
        } catch (ArithmeticException e) {
            result = this.numOne.divide(this.numTwo, new MathContext(8, RoundingMode.HALF_UP));
        }
        if (result.toPlainString().indexOf(".") != -1) {
            this.showDecimals = true;
        }
        return result;
    }

    private BigDecimal multiply() {
        return this.numOne.multiply(this.numTwo);
    }

    private BigDecimal subtract() {
        return this.numOne.subtract(this.numTwo);
    }

    private BigDecimal add() {
        return this.numOne.add(this.numTwo);
    }

    public String numToText(BigDecimal number) {
        number = number.stripTrailingZeros();
        String num = number.toPlainString();
        if (num.equals("0.0")) {
            return "0";
        } else if (!showDecimals && num.indexOf(".") != -1) {
            return num.substring(0, num.indexOf("."));
        } else {
            return num;
        }
    }

    public void addToNum(String numberToAdd) {
        if (numberToAdd.equals(".")) {
            this.decimals = true;
            this.showDecimals = true;
            if (this.editingNumber == 1) {
                guiReference.setNumberText(numToText(this.numOne));
            } else {
                guiReference.setNumberText(numToText(this.numTwo));
            }
            return;
        }
        if (!decimals) {
            if (this.editingNumber == 1) {
                String[] numOneStrings = this.numOne.toPlainString().replace(".", "_").split("_");
                numOneStrings[0] += numberToAdd;
                this.numOne = new BigDecimal(numOneStrings[0] + "." + numOneStrings[1]);
                guiReference.setNumberText(numToText(this.numOne));
            } else {
                String[] numTwoStrings = this.numTwo.toPlainString().replace(".", "_").split("_");
                numTwoStrings[0] += numberToAdd;
                this.numTwo = new BigDecimal(numTwoStrings[0] + "." + numTwoStrings[1]);
                guiReference.setNumberText(numToText(this.numTwo));
            }
        } else {
            if (this.editingNumber == 1) {
                String[] numOneStrings = this.numOne.toPlainString().replace(".", "_").split("_");
                numOneStrings[1] += numberToAdd;
                if (haventEditedDecimalOne) {
                    haventEditedDecimalOne = false;
                    numOneStrings[1] = numOneStrings[1].substring(1);
                }
                this.numOne = new BigDecimal(numOneStrings[0] + "." + numOneStrings[1]);
                guiReference.setNumberText(numToText(this.numOne));
            } else {
                String[] numTwoStrings = this.numTwo.toPlainString().replace(".", "_").split("_");
                numTwoStrings[1] += numberToAdd;
                if (haventEditedDecimalTwo) {
                    haventEditedDecimalTwo = false;
                    numTwoStrings[1] = numTwoStrings[1].substring(1);
                }
                this.numTwo = new BigDecimal(numTwoStrings[0] + "." + numTwoStrings[1]);
                guiReference.setNumberText(numToText(this.numTwo));
            }
        }
    }

    public void negate() {
        if (this.editingNumber == 1) {
            this.numOne = this.numOne.negate();
            guiReference.setNumberText(numToText(this.numOne));
        } else {
            this.numTwo = this.numTwo.negate();
            guiReference.setNumberText(numToText(this.numTwo));
        }
    }
}
