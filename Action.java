import javax.swing.AbstractAction;
import java.awt.event.*;

/**
 * The Action class is used to create an action that can be used in the GUI.
 * In GUI.java, it is used to add action listeners to different key presses.
 * *
 * 
 * @author Matthew Gardner
 * @version 1.0
 * @since 1.0
 */

public class Action extends AbstractAction {
    Calculator calc;
    String text;

    /*
     * Constructor for the Action class.
     * 
     * @param calc The calculator object that the action is being used on.
     * 
     * @param text The text to be parsed in the action e.g.<!-- --> the key pressed.
     */

    public Action(Calculator calc, String text) {
        super();
        this.calc = calc;
        this.text = text;
    }

    /*
     * The actionPerformed method is used to perform the action.
     * It takes in the action event and uses the text to determine what method to
     * run.
     * 
     * @param e The action event that is being performed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = this.text;
        // Run a different calculator method depending on the buttonText.
        switch (buttonText) {
            // The first 10 cases handle numbers, adding them to the calculator display.
            case "0":
                calc.addToNum(buttonText);
                break;
            case "1":
                calc.addToNum(buttonText);
                break;
            case "2":
                calc.addToNum(buttonText);
                break;
            case "3":
                calc.addToNum(buttonText);
                break;
            case "4":
                calc.addToNum(buttonText);
                break;
            case "5":
                calc.addToNum(buttonText);
                break;
            case "6":
                calc.addToNum(buttonText);
                break;
            case "7":
                calc.addToNum(buttonText);
                break;
            case "8":
                calc.addToNum(buttonText);
                break;
            case "9":
                calc.addToNum(buttonText);
                break;
            case "+":
                // Flip the editing number and set the operation to addition.
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "+";
                calc.decimals = false;
                break;
            case "X":
                // Flip the editing number and set the operation to multiplication.
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "*";
                calc.decimals = false;
                break;
            case "-":
                // Flip the editing number and set the operation to subtraction.
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "-";
                calc.decimals = false;
                break;
            case "/":
                // Flip the editing number and set the operation to division.
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "/";
                calc.decimals = false;
                break;
            case "%":
                // Set the editing number to 1 and set the operation to percentage.
                // Also perform the operation immediately and reset decimals
                calc.editingNumber = 1;
                calc.operation = "%";
                calc.performOperation();
                calc.decimals = false;
                break;
            case "=":
                // Perform the operation
                calc.performOperation();
                break;
            case "+/-":
                // Negate the number
                calc.negate();
                break;
            case "C":
                // Clear the calculator
                calc.operation = "C";
                calc.performOperation();
                break;
            case ".":
                // Add a decimal to the number
                calc.addToNum(".");
                break;
            default:
                // Do nothing
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                break;
        }
    }
}
