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
}
