package test.java;

import main.java.StringCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testAddEmptyString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);  // An empty string should return 0
    }

    @Test
    public void testAddSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1");
        assertEquals(1, result);  // The input "1" should return 1
    }

    @Test
    public void testAddTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2");
        assertEquals(3, result);  // The input "1,2" should return 3
    }

    @Test
    public void testAddMultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2,3");
        assertEquals(6, result);  // The input "1,2,3" should return 6
    }
}
