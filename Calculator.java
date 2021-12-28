import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The Calculator class is used to perform calculations.
 *
 * @author Matthew Gardner
 * @version 1.0
 * @since 1.0
 */
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

    /**
     * Constructor for the Calculator class.
     * 
     * @param guiReference The GUI object for this calculator object.
     */
    public Calculator(GUI guiReference) {
        this.editingNumber = 1;
        this.decimals = false;
        this.showDecimals = false;
        this.numOne = new BigDecimal("0.0");
        this.numTwo = new BigDecimal("0.0");
        this.editingDecimals = false;
        this.haventEditedDecimalOne = true;
        this.haventEditedDecimalTwo = true;
        this.previousNumTwo = new BigDecimal("0.0");
        this.guiReference = guiReference;
    }

    /**
     * The performOperation method is used to perform the current operation with the
     * current numbers.
     */
    public void performOperation() {
        // Create a result variable.
        BigDecimal result = new BigDecimal("0.0");
        switch (operation) {
            case "+":
                // Run the add method.
                // Set the operation to repeat addition and save the previous numTwo
                // so that the operation can be repeated multiple times in a row.
                // Also reset the decimals values to allow decimals to be input again.
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
                // Run the subtract method.
                // Set the operation to repeat subtraction and save the previous numTwo
                // so that the operation can be repeated multiple times in a row.
                // Also reset the decimals values to allow decimals to be input again.
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
                // Run the multiply method.
                // Set the operation to repeat multiplication and save the previous numTwo
                // so that the operation can be repeated multiple times in a row.
                // Also reset the decimals values to allow decimals to be input again.
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
                // Run the divide method.
                // Set the operation to repeat division and save the previous numTwo
                // so that the operation can be repeated multiple times in a row.
                // Also reset the decimals values to allow decimals to be input again.
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
                // Set numTwo to 100 and run the divide method
                // Then reset numTwo to 0 and reset the decimals
                // Reset operation to empty string.
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
                // Do nothing.
                return;
            default:
                // Reset everything to default values
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
        // Call setNumberText on the GUI with the result converted to text.
        guiReference.setNumberText(numToText(result));
    }

    /**
     * The divide method is used to divide the current numbers.
     *
     * @return The result of the division.
     */
    private BigDecimal divide() {
        BigDecimal result;
        // Try dividing the number and catch a repeating number exception.
        try {
            result = this.numOne.divide(this.numTwo);
        } catch (ArithmeticException e) {
            result = this.numOne.divide(this.numTwo, new MathContext(8, RoundingMode.HALF_UP));
        }
        // If there is a decimal in the number, turn on showDecimals.
        if (result.toPlainString().indexOf(".") != -1) {
            this.showDecimals = true;
        }
        return result;
    }

    /**
     * The multiply method is used to multiply the current numbers.
     *
     * @return The result of the multiplication.
     */
    private BigDecimal multiply() {
        return this.numOne.multiply(this.numTwo);
    }

    /**
     * The subtract method is used to subtract the current numbers.
     *
     * @return The result of the subtraction.
     */
    private BigDecimal subtract() {
        return this.numOne.subtract(this.numTwo);
    }

    /**
     * The add method is used to add the current numbers.
     *
     * @return The result of the addition.
     */
    private BigDecimal add() {
        return this.numOne.add(this.numTwo);
    }

    /**
     * The negate method is used to negate the current number.
     */
    public void negate() {
        if (this.editingNumber == 1) {
            // Use the BigDecimal.negate method to negate the number.
            this.numOne = this.numOne.negate();
            guiReference.setNumberText(numToText(this.numOne));
        } else {
            // Use the BigDecimal.negate method to negate the number.
            this.numTwo = this.numTwo.negate();
            guiReference.setNumberText(numToText(this.numTwo));
        }
    }

    /**
     * The numToText method is used to convert a number to a String.
     *
     * @param number The number to convert to a String.
     * @return The number converted to a String.
     */
    public String numToText(BigDecimal number) {
        // Get rid of any extra zeros at the end of the number.
        number = number.stripTrailingZeros();
        String num = number.toPlainString();
        if (num.equals("0.0")) {
            return "0";
        } else if (!showDecimals && num.indexOf(".") != -1) {
            // If showDecimals is false and there is no decimal in the number,
            // remove the decimal.
            return num.substring(0, num.indexOf("."));
        } else {
            // Return the number as a plain string.
            return num;
        }
    }

    /**
     * The addToNum method adds a String number to the current number being
     * displayed.
     * 
     * @param numberToAdd The number String to add to the current number.
     */
    public void addToNum(String numberToAdd) {
        // Handle if a decimal is added
        if (numberToAdd.equals(".")) {
            // Turn on decimals and showDecimals
            this.decimals = true;
            this.showDecimals = true;
            if (this.editingNumber == 1) {
                // Set the number text to the number being edited.
                guiReference.setNumberText(numToText(this.numOne));
            } else {
                guiReference.setNumberText(numToText(this.numTwo));
            }
            return;
        }
        // If not editing the decimals
        if (!decimals) {
            if (this.editingNumber == 1) {
                // Convert the number to an array of strings,
                // index 0 contains everything before the decimal,
                // index 1 contains everything after the decimal.
                String[] numOneStrings = this.numOne.toPlainString().replace(".", "_").split("_");
                // Since we are not editing the decimal, we can add the number to the end of the
                // first index.
                numOneStrings[0] += numberToAdd;
                // Convert the array of strings back to a number.
                this.numOne = new BigDecimal(numOneStrings[0] + "." + numOneStrings[1]);
                // Set the number text to the number being edited.
                guiReference.setNumberText(numToText(this.numOne));
            } else {
                // Do the same thing as above, but for the second number.
                String[] numTwoStrings = this.numTwo.toPlainString().replace(".", "_").split("_");
                numTwoStrings[0] += numberToAdd;
                this.numTwo = new BigDecimal(numTwoStrings[0] + "." + numTwoStrings[1]);
                guiReference.setNumberText(numToText(this.numTwo));
            }
        } else {
            // If editing the decimals
            if (this.editingNumber == 1) {
                // Convert the number to an array of strings,
                // index 0 contains everything before the decimal,
                // index 1 contains everything after the decimal.
                String[] numOneStrings = this.numOne.toPlainString().replace(".", "_").split("_");
                // Add the number to the part after the decimal.
                numOneStrings[1] += numberToAdd;
                if (haventEditedDecimalOne) {
                    // If this is the first time editing the decimal, we have to remove the 0 it
                    // starts with.
                    haventEditedDecimalOne = false;
                    numOneStrings[1] = numOneStrings[1].substring(1);
                }
                // Convert the array of strings back to a number.
                this.numOne = new BigDecimal(numOneStrings[0] + "." + numOneStrings[1]);
                // Set the number text to the number being edited.
                guiReference.setNumberText(numToText(this.numOne));
            } else {
                // Do the same thing as above, but for the second number.
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
}
