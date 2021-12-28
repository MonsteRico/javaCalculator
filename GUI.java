import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

/**
 * The GUI class is used to create the GUI for the calculator.
 * 
 * @author Matthew Gardner
 * @version 1.0
 * @since 1.0
 */
public class GUI extends JComponent implements Runnable {
    public Container content;
    public JLabel numberLabel;
    public static Calculator calc;
    Hashtable<JButton, String> buttonMap = new Hashtable<JButton, String>();

    ActionListener actionListener = new ActionListener() {
        // The ActionListener object for all the buttons
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = buttonMap.get(e.getSource());
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
                    // Toggle the sign of the number
                    calc.negate();
                    break;
                case "C":
                    // Clear the calculator
                    calc.operation = "C";
                    calc.performOperation();
                    break;
                case ".":
                    // Add decimal point to the number
                    calc.addToNum(".");
                    break;
                default:
                    // Flip the editing number (should never happen)
                    calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                    break;
            }
        }
    };

    // The main method used to run the program
    public static void main(String[] args) {
        // Create a new GUI, set the calculator field to a new Calculator object, and
        // start the GUI thread
        GUI gui = new GUI();
        calc = new Calculator(gui);
        SwingUtilities.invokeLater(gui);
    }

    // The run method used to create the GUI
    public void run() {
        // Create a new JFrame and set the title
        JFrame frame = new JFrame("Calculator");

        // Set the content and create the mainPanel
        content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        content.add(mainPanel, BorderLayout.NORTH);

        // Create the numberLabel and add it to the mainPanel
        numberLabel = new JLabel("0");
        GridBagConstraints numberLabelConstraints = new GridBagConstraints();
        numberLabelConstraints.gridx = 0;
        numberLabelConstraints.gridy = 0;
        numberLabelConstraints.gridheight = 1;
        numberLabelConstraints.gridwidth = 4;
        numberLabelConstraints.weightx = 1.0;
        numberLabelConstraints.ipady = 6;
        numberLabelConstraints.insets = new Insets(2, 1, 2, 1);
        int startY = numberLabelConstraints.gridheight;
        numberLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        numberLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(numberLabel, numberLabelConstraints);

        // Create the buttons and add them to the mainPanel
        calcButton("C", mainPanel, 0, startY + 1);
        calcButton("+/-", mainPanel, 1, startY + 1);
        calcButton("%", mainPanel, 2, startY + 1);
        calcButton("/", mainPanel, 3, startY + 1);
        calcButton("7", mainPanel, 0, startY + 2);
        calcButton("8", mainPanel, 1, startY + 2);
        calcButton("9", mainPanel, 2, startY + 2);
        calcButton("X", mainPanel, 3, startY + 2);
        calcButton("4", mainPanel, 0, startY + 3);
        calcButton("5", mainPanel, 1, startY + 3);
        calcButton("6", mainPanel, 2, startY + 3);
        calcButton("-", mainPanel, 3, startY + 3);
        calcButton("1", mainPanel, 0, startY + 4);
        calcButton("2", mainPanel, 1, startY + 4);
        calcButton("3", mainPanel, 2, startY + 4);
        calcButton("+", mainPanel, 3, startY + 4);
        calcButton("0", mainPanel, 0, startY + 5, 2, 1);
        calcButton(".", mainPanel, 2, startY + 5);
        calcButton("=", mainPanel, 3, startY + 5);

        // Add KeyListeners to the frame
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0),
                "add");
        mainPanel.getActionMap().put("add", new Action(calc, "+"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0),
                "subtract");
        mainPanel.getActionMap().put("subtract", new Action(calc, "-"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0),
                "divide");
        mainPanel.getActionMap().put("divide", new Action(calc, "/"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0),
                "multiply");
        mainPanel.getActionMap().put("multiply", new Action(calc, "*"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0),
                "equals");
        mainPanel.getActionMap().put("equals", new Action(calc, "="));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0),
                "zero");
        mainPanel.getActionMap().put("zero", new Action(calc, "0"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0),
                "one");
        mainPanel.getActionMap().put("one", new Action(calc, "1"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0),
                "two");
        mainPanel.getActionMap().put("two", new Action(calc, "2"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0),
                "three");
        mainPanel.getActionMap().put("three", new Action(calc, "3"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0),
                "four");
        mainPanel.getActionMap().put("four", new Action(calc, "4"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0),
                "five");
        mainPanel.getActionMap().put("five", new Action(calc, "5"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0),
                "six");
        mainPanel.getActionMap().put("six", new Action(calc, "6"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0),
                "seven");
        mainPanel.getActionMap().put("seven", new Action(calc, "7"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0),
                "eight");
        mainPanel.getActionMap().put("eight", new Action(calc, "8"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0),
                "nine");
        mainPanel.getActionMap().put("nine", new Action(calc, "9"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0),
                "decimal");
        mainPanel.getActionMap().put("decimal", new Action(calc, "."));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0),
                "backspace");
        mainPanel.getActionMap().put("backspace", new Action(calc, "C"));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
                "enter");
        mainPanel.getActionMap().put("enter", new Action(calc, "="));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0),
                "decimal");
        mainPanel.getActionMap().put("decimal", new Action(calc, "."));

        // Set the frame to visible, pack it, add it to the screen
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Resize the label to start
        resizeLabelText(numberLabel);
    }

    /**
     * Set the numberLabel to the given number (runs on the EDT)
     * 
     * @param number The number to set the label to
     */
    public void setNumberText(int number) {
        String numberAsString = Integer.toString(number);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                numberLabel.setText(numberAsString);
            }
        });
    }

    /**
     * Set the numberLabel text to the given string (runs on the EDT)
     * 
     * @param text The text to set the label to
     */
    public void setNumberText(String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                numberLabel.setText(text);
            }
        });
    }

    /**
     * Create a new button for the calculator
     * 
     * @param text      The text to display on the button
     * @param mainPanel The panel to add the button to
     * @param gridx     The gridx position of the button
     * @param gridy     The gridy position of the button
     */
    private void calcButton(String text, JPanel mainPanel, int gridx, int gridy) {
        JButton button = new JButton(text);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(2, 2, 2, 2);
        if (gridy > 5) {
            c.insets = new Insets(2, 2, 15, 2);
        }
        c.fill = GridBagConstraints.BOTH;
        button.setBorder(new RoundedBorder(10));
        mainPanel.add(button, c);
        button.addActionListener(actionListener);
        buttonMap.put(button, text);
    }

    /**
     * Create a new button for the calculator
     * 
     * @param text       The text contained on this button
     * @param mainPanel  The panel to add this button to
     * @param gridx      The gridx position of this button
     * @param gridy      The gridy position of this button
     * @param gridwidth  The number of grid cells wide this button will take up
     * @param gridheight The number of grid cells high this button will take up
     */
    private void calcButton(String text, JPanel mainPanel, int gridx, int gridy, int gridwidth, int gridheight) {
        JButton button = new JButton(text);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = 1;
        c.gridwidth = gridwidth;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(2, 2, 2, 2);
        if (gridy > 5) {
            c.insets = new Insets(2, 2, 15, 2);
        }
        c.fill = GridBagConstraints.BOTH;
        button.setBorder(new RoundedBorder(10));
        mainPanel.add(button, c);
        button.addActionListener(actionListener);
        buttonMap.put(button, text);
    }

    /**
     * Reformat the content
     */
    public void reformatContent() {
        content.remove(1);
        content.revalidate();
        content.repaint();
    }

    /**
     * Resizes the text of the label to fit the text
     *
     * @param label the label to resize
     */
    public void resizeLabelText(JLabel label) {
        Font labelFont = label.getFont();
        String labelText = label.getText();
        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();
        double widthRatio = (double) componentWidth / (double) stringWidth;
        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
    }
}
