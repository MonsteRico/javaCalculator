import javax.swing.AbstractAction;
import javax.swing.*;
import java.awt.event.*;
public class Action extends AbstractAction {
    Calculator calc;
    String text;
    public Action(Calculator calc, String text) {
        super();
        this.calc = calc;
        this.text = text;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = this.text;
        switch (buttonText) {
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
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "+";
                calc.decimals = false;
                break;
            case "X":
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "*";
                calc.decimals = false;
                break;
            case "-":
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "-";
                calc.decimals = false;
                break;
            case "/":
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                calc.operation = "/";
                calc.decimals = false;
                break;
            case "%":
                calc.editingNumber = 1;
                calc.operation = "%";
                calc.performOperation();
                calc.decimals = false;
                break;
            case "=":
                calc.performOperation();
                break;
            case "+/-":
                calc.negate();
                break;
            case "C":
                calc.operation = "C";
                calc.performOperation();
                break;
            case ".":
                calc.addToNum(".");
                break;
            default:
                calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                break;
        }
    }
}
