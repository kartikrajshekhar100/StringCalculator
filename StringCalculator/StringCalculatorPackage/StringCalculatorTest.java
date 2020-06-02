package StringCalculatorPackage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void initialize() {
        calculator = new StringCalculator();
    }

    @Test
    public void EmptyStringReturningZero() {
        assertEquals(calculator.add(""), 0);
    }

}