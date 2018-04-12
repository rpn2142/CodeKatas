package stringCalculator;


import java.util.*;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by pramraj on 1/28/18.
 */
public class StringCalculator {

    public int add(String str) {

        if( isNullOrEmpty(str) )
            return 0;
        else {
            StringCalculatorInput args = new StringCalculatorInput(str);

            String input = args.getInput();
            String delimiter = args.getDelimiter();

            return add(input.split(delimiter));
        }
    }

    private int add(String[] inputs) {
        int result = 0;
        Set<Integer> negativeNumbers = new HashSet<Integer>();

        for( String input : inputs )
            result += getValue(input, negativeNumbers);

        throwIfAnyNegativeNumberFound(negativeNumbers);
        return result;

    }

    private int getValue(String input, Set<Integer> negativeNumbers) {
        int value = Integer.parseInt(input);
        captureIfNegativeNumber(value, negativeNumbers);
        return  isLargeNumber(value)? 0 : value;
    }

    private boolean isLargeNumber(int value) {
        return value > 1000;
    }

    private void throwIfAnyNegativeNumberFound(Set<Integer> negativeNumbers) {
        if( ! negativeNumbers.isEmpty() )
            throw new NegativeNumbersException(negativeNumbers);
    }

    private void captureIfNegativeNumber(int value, Set<Integer> negativeNumbers) {
        if( value < 0 )
            negativeNumbers.add(value);
    }
}
