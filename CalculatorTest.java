import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.*;

/**
 * Unit test for Calculator.java.
 * 
 * @author Matthew Gardner
 * @version 1.0
 */
public class CalculatorTest {
    @Test
    public void testRepeatOperations() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.numTwo = new BigDecimal("1");
        calc.operation = "+";
        calc.performOperation();
        // Repeat the operation
        calc.performOperation();
        BigDecimal expected = new BigDecimal("3");
        assertEquals("Repeat Add did not work correctly", expected, calc.numOne);
        calc.operation = "-";
        calc.numTwo = new BigDecimal("1");
        calc.performOperation();
        // Repeat the operation
        calc.performOperation();
        expected = new BigDecimal("1");
        assertEquals("Repeat Subtract did not work correctly", expected, calc.numOne);
        calc.operation = "*";
        calc.numOne = new BigDecimal("1");
        calc.numTwo = new BigDecimal("2");
        calc.performOperation();
        // Repeat the operation
        calc.performOperation();
        expected = new BigDecimal("4");
        assertEquals("Repeat Multiply did not work correctly", expected, calc.numOne);
        calc.operation = "/";
        calc.numOne = new BigDecimal("4");
        calc.numTwo = new BigDecimal("2");
        calc.performOperation();
        // Repeat the operation
        calc.performOperation();
        expected = new BigDecimal("1");
        assertEquals("Repeat Divide did not work correctly", expected, calc.numOne);
    }

    @Test
    public void testAddToNum() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.addToNum("1");
        BigDecimal expected = new BigDecimal("1.0");
        assertEquals("Adding 1 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("2");
        expected = new BigDecimal("12.0");
        assertEquals("Adding 2 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("3");
        expected = new BigDecimal("123.0");
        assertEquals("Adding 3 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("4");
        expected = new BigDecimal("1234.0");
        assertEquals("Adding 4 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("5");
        expected = new BigDecimal("12345.0");
        assertEquals("Adding 5 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("6");
        expected = new BigDecimal("123456.0");
        assertEquals("Adding 6 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("7");
        expected = new BigDecimal("1234567.0");
        assertEquals("Adding 7 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("8");
        expected = new BigDecimal("12345678.0");
        assertEquals("Adding 8 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("9");
        expected = new BigDecimal("123456789.0");
        assertEquals("Adding 9 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("0");
        expected = new BigDecimal("1234567890.0");
        assertEquals("Adding 0 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum(".");
        calc.addToNum("1");
        expected = new BigDecimal("1234567890.1");
        assertEquals("Adding decimal 1 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("2");
        expected = new BigDecimal("1234567890.12");
        assertEquals("Adding decimal 2 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("3");
        expected = new BigDecimal("1234567890.123");
        assertEquals("Adding decimal 3 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("4");
        expected = new BigDecimal("1234567890.1234");
        assertEquals("Adding decimal 4 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("5");
        expected = new BigDecimal("1234567890.12345");
        assertEquals("Adding decimal 5 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("6");
        expected = new BigDecimal("1234567890.123456");
        assertEquals("Adding decimal 6 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("7");
        expected = new BigDecimal("1234567890.1234567");
        assertEquals("Adding decimal 7 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("8");
        expected = new BigDecimal("1234567890.12345678");
        assertEquals("Adding decimal 8 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("9");
        expected = new BigDecimal("1234567890.123456789");
        assertEquals("Adding decimal 9 to numOne did not work correctly", expected, calc.numOne);
        calc.addToNum("0");
        expected = new BigDecimal("1234567890.1234567890");
        assertEquals("Adding decimal 0 to numOne did not work correctly", expected, calc.numOne);

        calc.editingNumber = 2;
        calc.decimals = false;
        calc.addToNum("1");
        expected = new BigDecimal("1.0");
        assertEquals("Adding 1 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("2");
        expected = new BigDecimal("12.0");
        assertEquals("Adding 2 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("3");
        expected = new BigDecimal("123.0");
        assertEquals("Adding 3 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("4");
        expected = new BigDecimal("1234.0");
        assertEquals("Adding 4 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("5");
        expected = new BigDecimal("12345.0");
        assertEquals("Adding 5 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("6");
        expected = new BigDecimal("123456.0");
        assertEquals("Adding 6 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("7");
        expected = new BigDecimal("1234567.0");
        assertEquals("Adding 7 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("8");
        expected = new BigDecimal("12345678.0");
        assertEquals("Adding 8 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("9");
        expected = new BigDecimal("123456789.0");
        assertEquals("Adding 9 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("0");
        expected = new BigDecimal("1234567890.0");
        assertEquals("Adding 0 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum(".");
        calc.addToNum("1");
        expected = new BigDecimal("1234567890.1");
        assertEquals("Adding decimal 1 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("2");
        expected = new BigDecimal("1234567890.12");
        assertEquals("Adding decimal 2 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("3");
        expected = new BigDecimal("1234567890.123");
        assertEquals("Adding decimal 3 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("4");
        expected = new BigDecimal("1234567890.1234");
        assertEquals("Adding decimal 4 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("5");
        expected = new BigDecimal("1234567890.12345");
        assertEquals("Adding decimal 5 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("6");
        expected = new BigDecimal("1234567890.123456");
        assertEquals("Adding decimal 6 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("7");
        expected = new BigDecimal("1234567890.1234567");
        assertEquals("Adding decimal 7 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("8");
        expected = new BigDecimal("1234567890.12345678");
        assertEquals("Adding decimal 8 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("9");
        expected = new BigDecimal("1234567890.123456789");
        assertEquals("Adding decimal 9 to numTwo did not work correctly", expected, calc.numTwo);
        calc.addToNum("0");
        expected = new BigDecimal("1234567890.1234567890");
        assertEquals("Adding decimal 0 to numTwo did not work correctly", expected, calc.numTwo);
    }

    @Test
    public void testAdd() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.numTwo = new BigDecimal("2");
        BigDecimal result = calc.add();
        assertEquals("Addition of 1+2 did not result in 3", new BigDecimal("3"), result);
        calc.numOne = new BigDecimal("1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.add();
        assertEquals("Addition of 1.5+0.3 did not result in 1.8", new BigDecimal("1.8"), result);
        calc.numOne = new BigDecimal("-1");
        calc.numTwo = new BigDecimal("2");
        result = calc.add();
        assertEquals("Addition of -1+2 did not result in 1", new BigDecimal("1"), result);
        calc.numOne = new BigDecimal("-1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.add();
        assertEquals("Addition of -1.5+0.3 did not result in -1.2", new BigDecimal("-1.2"), result);
    }

    @Test
    public void testSubtract() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.numTwo = new BigDecimal("2");
        BigDecimal result = calc.subtract();
        assertEquals("Subtraction of 1-2 did not result in -1", new BigDecimal("-1"), result);
        calc.numOne = new BigDecimal("1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.subtract();
        assertEquals("Subtraction of 1.5-0.3 did not result in 1.2", new BigDecimal("1.2"), result);
        calc.numOne = new BigDecimal("-1");
        calc.numTwo = new BigDecimal("2");
        result = calc.subtract();
        assertEquals("Subtraction of -1-2 did not result in -3", new BigDecimal("-3"), result);
        calc.numOne = new BigDecimal("-1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.subtract();
        assertEquals("Subtraction of -1.5-0.3 did not result in -1.8", new BigDecimal("-1.8"), result);
    }

    @Test
    public void testMultiply() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.numTwo = new BigDecimal("2");
        BigDecimal result = calc.multiply();
        assertEquals("Multiplication of 1*2 did not result in 2", new BigDecimal("2"), result);
        calc.numOne = new BigDecimal("1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.multiply();
        assertEquals("Multiplication of 1.5*0.3 did not result in 0.45", new BigDecimal("0.45"), result);
        calc.numOne = new BigDecimal("-1");
        calc.numTwo = new BigDecimal("2");
        result = calc.multiply();
        assertEquals("Multiplication of -1*2 did not result in -2", new BigDecimal("-2"), result);
        calc.numOne = new BigDecimal("-1");
        calc.numTwo = new BigDecimal("-2");
        result = calc.multiply();
        assertEquals("Multiplication of -1*-2 did not result in 2", new BigDecimal("2"), result);
        calc.numOne = new BigDecimal("-1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.multiply();
        assertEquals("Multiplication of -1.5*0.3 did not result in -0.45", new BigDecimal("-0.45"), result);
        calc.numOne = new BigDecimal("-1.5");
        calc.numTwo = new BigDecimal("-0.3");
        result = calc.multiply();
        assertEquals("Multiplication of -1.5*-0.3 did not result in 0.45", new BigDecimal("0.45"), result);
    }

    @Test
    public void testDivide() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.numTwo = new BigDecimal("2");
        BigDecimal result = calc.divide();
        assertEquals("Division of 1/2 did not result in 0.5", new BigDecimal("0.5"), result);
        calc.numOne = new BigDecimal("1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.divide();
        assertEquals("Division of 1.5/0.3 did not result in 5", new BigDecimal("5"), result);
        calc.numOne = new BigDecimal("-1");
        calc.numTwo = new BigDecimal("2");
        result = calc.divide();
        assertEquals("Division of -1/2 did not result in -0.5", new BigDecimal("-0.5"), result);
        calc.numOne = new BigDecimal("-1");
        calc.numTwo = new BigDecimal("-2");
        result = calc.divide();
        assertEquals("Division of -1/-2 did not result in 0.5", new BigDecimal("0.5"), result);
        calc.numOne = new BigDecimal("-1.5");
        calc.numTwo = new BigDecimal("0.3");
        result = calc.divide();
        assertEquals("Division of -1.5/0.3 did not result in -5", new BigDecimal("-5"), result);
        calc.numOne = new BigDecimal("-1.5");
        calc.numTwo = new BigDecimal("-0.3");
        result = calc.divide();
        assertEquals("Division of -1.5/-0.3 did not result in 5", new BigDecimal("5"), result);
    }

    @Test
    public void testPercentage() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.operation = "%";
        calc.performOperation();
        assertEquals("Percentage did not work on 1", new BigDecimal("0.01"), calc.numOne);
        assertEquals("Percentage did not reset numTwo", new BigDecimal("0.0"), calc.numTwo);
        assertEquals("Percentage did not reset decimals", false, calc.decimals);
        assertEquals("Percentage did not reset haventEditedDecimalOne", true, calc.haventEditedDecimalOne);
        assertEquals("Percentage did not reset haventEditedDecimalTwo", true, calc.haventEditedDecimalTwo);
        assertEquals("Percentage did not reset editingNumber", 1, calc.editingNumber);
        assertEquals("Percentage did not clear operation value", "", calc.operation);
        calc.operation = "%";
        calc.performOperation();
        assertEquals("Percentage did not work on 0.01", new BigDecimal("0.0001"), calc.numOne);
        assertEquals("Percentage did not reset numTwo", new BigDecimal("0.0"), calc.numTwo);
        assertEquals("Percentage did not reset decimals", false, calc.decimals);
        assertEquals("Percentage did not reset haventEditedDecimalOne", true, calc.haventEditedDecimalOne);
        assertEquals("Percentage did not reset haventEditedDecimalTwo", true, calc.haventEditedDecimalTwo);
        assertEquals("Percentage did not reset editingNumber", 1, calc.editingNumber);
        assertEquals("Percentage did not clear operation value", "", calc.operation);
        calc.operation = "%";
        calc.negate();
        calc.performOperation();
        assertEquals("Percentage did not work on -0.0001", new BigDecimal("-0.000001"), calc.numOne);
        assertEquals("Percentage did not reset numTwo", new BigDecimal("0.0"), calc.numTwo);
        assertEquals("Percentage did not reset decimals", false, calc.decimals);
        assertEquals("Percentage did not reset haventEditedDecimalOne", true, calc.haventEditedDecimalOne);
        assertEquals("Percentage did not reset haventEditedDecimalTwo", true, calc.haventEditedDecimalTwo);
        assertEquals("Percentage did not reset editingNumber", 1, calc.editingNumber);
        assertEquals("Percentage did not clear operation value", "", calc.operation);
    }

    @Test
    public void testClear() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.numTwo = new BigDecimal("2");
        calc.previousNumTwo = new BigDecimal("10");
        calc.decimals = true;
        calc.haventEditedDecimalOne = false;
        calc.showDecimals = true;
        calc.haventEditedDecimalTwo = false;
        calc.editingNumber = 2;
        calc.operation = "C";
        calc.performOperation();
        assertEquals("Clear did not clear the numOne", new BigDecimal("0.0"), calc.numOne);
        assertEquals("Clear did not clear the numTwo", new BigDecimal("0.0"), calc.numTwo);
        assertEquals("Clear did not clear the previousNumTwo", new BigDecimal("0.0"), calc.previousNumTwo);
        assertEquals("Clear did not reset decimals", false, calc.decimals);
        assertEquals("Clear did not reset haventEditedDecimalOne", true, calc.haventEditedDecimalOne);
        assertEquals("Clear did not reset showDecimals", false, calc.showDecimals);
        assertEquals("Clear did not reset haventEditedDecimalTwo", true, calc.haventEditedDecimalTwo);
        assertEquals("Clear did not reset editingNumber", 1, calc.editingNumber);
        assertEquals("Clear did not clear operation value", "", calc.operation);
    }

    @Test
    public void testNegate() {
        GUI dummyGUI = new GUI();
        Calculator calc = new Calculator(dummyGUI);
        calc.numOne = new BigDecimal("1");
        calc.editingNumber = 1;
        calc.negate();
        assertEquals("The negate method did not negate 1 (numOne)", new BigDecimal("-1"), calc.numOne);
        calc.editingNumber = 2;
        calc.numTwo = new BigDecimal("-1");
        calc.negate();
        assertEquals("The negate method did not negate -1 (numTwo)", new BigDecimal("1"), calc.numTwo);
        calc.numOne = new BigDecimal("1.5");
        calc.editingNumber = 1;
        calc.negate();
        assertEquals("The negate method did not negate 1.5 (numOne)", new BigDecimal("-1.5"), calc.numOne);
        calc.editingNumber = 2;
        calc.numTwo = new BigDecimal("-1.5");
        calc.negate();
        assertEquals("The negate method did not negate -1.5 (numTwo)", new BigDecimal("1.5"), calc.numTwo);
    }
}
