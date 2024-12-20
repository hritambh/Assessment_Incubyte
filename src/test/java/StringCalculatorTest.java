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

    @Test
    public void testAddWithNewLines() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);  // The input "1\n2,3" should return 6
    }

    @Test
    public void testAddWithCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);  // The input "//;\n1;2" should return 3
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        calculator.add("1,-2,3");  // Should throw an exception for -2
    }

    // custom delimeter of "*" ,if so then multiply the nos instead of adding
    @Test
    public void testMultiplyWithCustomDelimeter(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//*\n2*3*4*2");
        assertEquals(48,result);
    }

    // Designing a string caluclator that accept a string
    // do addition operationon the elements of the string if the delimeter is '+'
    // do multipliaction if the dilimeter in '*'
    // throw illegal argumnet exception if any of the element is negative




}
