package stringCalculator;

import com.sun.org.apache.xpath.internal.operations.Neg;

import java.util.Set;

/**
 * Created by pramraj on 1/28/18.
 */
public class NegativeNumbersException extends RuntimeException {

    public NegativeNumbersException(Set<Integer> negativeNumbers) {
        super("negatives not allowed - " + toString(negativeNumbers));
    }

    private static String toString(Set<Integer> negativeNumbers) {
        String result = "";
        for( Integer i : negativeNumbers )
            result += (result.length()==0)? i : "," + i;
        return result;
    }
}
