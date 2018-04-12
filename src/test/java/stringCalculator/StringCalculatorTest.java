package stringCalculator;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by pramraj on 1/28/18.
 */
public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void testBasic() {
        assertEquals("emptyString should result in 0", 0, stringCalculator.add(null));
        assertEquals("emptyString should result in 0", 0, stringCalculator.add(""));
        assertEquals("single int should result in same value", 1, stringCalculator.add("1"));
        assertEquals("should result in sum", 3, stringCalculator.add("0,1,2"));
    }

    @Test
    public void testunknownAmountOfNumbers() {
        assertEquals("should result in sum", sumUpto(5), stringCalculator.add("1,2,3,4,5"));
        assertEquals("should result in sum", sumUpto(7), stringCalculator.add("1,2,3,4,5,6,7"));
    }

    @Test
    public void testMixofNewLineAndComma() {
        assertEquals("should result in sum", sumUpto(5), stringCalculator.add("1,2\n3,4,5"));
        assertEquals("should result in sum", sumUpto(7), stringCalculator.add("1,2,3,4,5\n6\n7"));
    }


    @Test
    public void textInvalidInput() {
        boolean exceptionThrown = false;
        try {
            assertEquals("should result in sum", sumUpto(5), stringCalculator.add("1,\n3,4,5"));
        } catch(Exception e) {
            exceptionThrown = true;
        }
        assertTrue("exception must be thrown", exceptionThrown);

    }

    @Test
    public void testCustomDelimiter() {
        assertEquals("should result in sum",3, stringCalculator.add("//.\n1.2"));
        assertEquals("should result in sum",3, stringCalculator.add("//[abcd]\n1abcd2"));
        assertEquals("should result in sum",3, stringCalculator.add("//;\n1;2"));
        assertEquals("should result in sum",22, stringCalculator.add("//[//]\n5//6//11"));
        assertEquals("should result in sum",6, stringCalculator.add("//[***]\n1***2***3"));
        assertEquals("should result in sum",10, stringCalculator.add("//[***][%][$]\n1%2$3***4"));
    }

    @Test
    public void testNegativeNumberError() {
        boolean thrown =false;

        try {
            assertEquals("negative number should result in exception", 1, stringCalculator.add("-1,2,-15"));
        } catch(Exception e) {
            thrown=true;
            assertTrue("error message should match", e.getMessage().startsWith("negatives not allowed"));
            assertTrue("error message should contain negatives -1", e.getMessage().contains("-1"));
            assertTrue("error message should contain negatives -15", e.getMessage().contains("-15"));
        }
        assertTrue("exception must be thrown", thrown);

        assertEquals("should result in sum", 13, stringCalculator.add("1,3,4,5"));

    }

    @Test
    public void testLargeNumbers() {
        assertEquals("should result in sum", sumUpto(5)-1, stringCalculator.add("1001,2,3,4,5"));
    }

    private int sumUpto(int n) {
        return (n*(n+1))/2;
    }
}
