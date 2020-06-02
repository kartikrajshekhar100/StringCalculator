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
    
    @Test
    public void NumberStringReturningSameNumber() {
        assertEquals(calculator.add("9"), 9);
        assertEquals(calculator.add("7"), 7);
    }
    
    @Test
    public void TwoNumbersSeperatedByCommaSummed() {
        assertEquals(calculator.add("11,22"), 33);
        assertEquals(calculator.add("100,15"), 115);
    }
    
    @Test
    public void ManyNumbersSummedSeperatedByComma() {
        assertEquals(calculator.add("1,2,3,4,5,6,7"), 28);
        assertEquals(calculator.add("10,15,200"),225);
    }
    
    @Test
    public void ManyNumbersSummedSeperatedByCommaAndNewLineCharacter() {
        assertEquals(calculator.add("1,2\n3,4\n10"), 20);
        assertEquals(calculator.add("1\n1\n2,4"),8);
    }
    
    @Test
    public void customDeliminators() {
        assertEquals(calculator.add("//,\n1,2,3,4"), 10);
        assertEquals(calculator.add("//;\n1;2;3;4"), 10);
    }
    
    @Test
    public void NegativException() {
    	try
    	{
    		calculator.add("-51,-58,17,-10");
    	}
    	catch(RuntimeException ex)
    	{
    		assertEquals("Negatives found: [-51, -58, -10]", ex.getMessage() );
    	}
    }


}