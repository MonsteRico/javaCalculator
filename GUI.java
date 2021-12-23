import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

/**
 * JAVADOCS
 *
 * @author Matthew Gardner
 * @version December 23, 2021
 */
public class GUI extends JComponent implements Runnable {
    public Container content;
    public JLabel numberLabel;
    public static Calculator calc;
    Hashtable<JButton, String> buttonMap = new Hashtable<JButton, String>();

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = buttonMap.get(e.getSource());
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
                    calc.decimals = false;
                    calc.operation = "+";
                    break;
                case "X":
                    calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                    calc.decimals = false;
                    calc.operation = "*";
                    break;
                case "-":
                    calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                    calc.decimals = false;
                    calc.operation = "-";
                    break;
                case "/":
                    calc.editingNumber = (calc.editingNumber == 1 ? 2 : 1);
                    calc.decimals = false;
                    calc.operation = "/";
                    break;
                case "=":
                    calc.performOperation();
                    break;
                case "+/-":
                    calc.changeSign();
                    break;
                case "C":
                    calc.operation = "C";
                    calc.performOperation();
                    break;
                case ".":
                    calc.addToNum(".");
                    break;
                default:
                    calc.editingNumber = (calc.editingNumber == 1 ? 2 :1);
                    break;
            }
        }
    };

    // MAIN method
    public static void main(String[] args) {
        GUI gui = new GUI();
        calc = new Calculator(gui);
        SwingUtilities.invokeLater(gui);
    }



    public void run() {
            JFrame frame = new JFrame("Calculator");

            content = frame.getContentPane();
            content.setLayout(new BorderLayout());
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridBagLayout());
            content.add(mainPanel, BorderLayout.NORTH);

            numberLabel = new JLabel("0");
            GridBagConstraints numberLabelConstraints = new GridBagConstraints();
            numberLabelConstraints.gridx = 0;
            numberLabelConstraints.gridy = 0;
            numberLabelConstraints.gridheight = 1;
            numberLabelConstraints.gridwidth = 4;
            numberLabelConstraints.weightx = 1.0;
            numberLabelConstraints.ipady = 6;
            numberLabelConstraints.insets = new Insets(2,1,2,1);
            int startY = numberLabelConstraints.gridheight;
            numberLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
            numberLabel.setHorizontalAlignment(JLabel.CENTER);
            mainPanel.add(numberLabel, numberLabelConstraints);

            calcButton("C", mainPanel, 0, startY+1);
            calcButton("+/-", mainPanel, 1, startY+1);
            calcButton("%", mainPanel, 2, startY+1);
            calcButton("/", mainPanel, 3, startY+1);
            calcButton("7", mainPanel, 0, startY+2);
            calcButton("8", mainPanel, 1, startY+2);
            calcButton("9", mainPanel, 2, startY+2);
            calcButton("X", mainPanel, 3, startY+2);
            calcButton("4", mainPanel, 0, startY+3);
            calcButton("5", mainPanel, 1, startY+3);
            calcButton("6", mainPanel, 2, startY+3);
            calcButton("-", mainPanel, 3, startY+3);
            calcButton("1", mainPanel, 0, startY+4);
            calcButton("2", mainPanel, 1, startY+4);
            calcButton("3", mainPanel, 2, startY+4);
            calcButton("+", mainPanel, 3, startY+4);
            calcButton("0", mainPanel, 0, startY+5, 2, 1);
            calcButton(".", mainPanel, 2, startY+5);
            calcButton("=", mainPanel, 3, startY+5);

            frame.setSize(400, 600);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            resizeLabelText(numberLabel);

    }

    public void setNumberText(int number) {
        String numberAsString = Integer.toString(number);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                numberLabel.setText(numberAsString);
            }
        });
    }    

    public void setNumberText(String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                numberLabel.setText(text);
            }
        });
    }

    private void calcButton(String text, JPanel mainPanel, int gridx, int gridy) {
        JButton button = new JButton(text);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(2,2,2,2);
        if (gridy > 5) {
            c.insets = new Insets(2, 2, 15, 2);
        }
        c.fill = GridBagConstraints.BOTH;
        button.setBorder(new RoundedBorder(10));
        mainPanel.add(button, c);
        button.addActionListener(actionListener);
        buttonMap.put(button, text);
    }

    private void calcButton(String text, JPanel mainPanel, int gridx, int gridy, int gridwidth, int gridheight) {
        JButton button = new JButton(text);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = 1;
        c.gridwidth = gridwidth;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(2,2,2,2);
        if (gridy >5) {
            c.insets = new Insets(2,2,15,2);
        }
        c.fill = GridBagConstraints.BOTH;
        button.setBorder(new RoundedBorder(10));
        mainPanel.add(button, c);
        button.addActionListener(actionListener);
        buttonMap.put(button, text);
    }

    public void reformatContent() {
        content.remove(1);
        content.revalidate();
        content.repaint();
    }

    public void resizeLabelText(JLabel label) {
        Font labelFont = label.getFont();
        String labelText =label.getText();
        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();
        double widthRatio = (double)componentWidth/ (double)stringWidth;
        int newFontSize = (int)(labelFont.getSize()*widthRatio);
        int componentHeight = label.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
    }
}
