package stringCalculator;


import org.apache.commons.lang.StringUtils;
import java.util.regex.Pattern;

/**
 * Created by pramraj on 1/28/18.
 */
public class StringCalculatorInput {

    public static final String DEFAULT_DELIMITER = ",|\\n";
    private String input;
    private String delimiter;

    public StringCalculatorInput(String str) {
        if( str == null )
            str = "";
        if( hasCustomDelimiter(str) ) {
            input = extractInput(str);
            delimiter = extractDelimiter(str);
        } else {
            input = str;
            delimiter = DEFAULT_DELIMITER;
        }
    }


    private String extractInput(String str) {
        return str.split("\\n")[1];
    }

    private String extractDelimiter(String str) {
        String firstLine = str.split("\\n")[0];
        String delimiters = firstLine.substring(2);
        if( delimiters.length() == 1 )
            return Pattern.quote(delimiters);
        else
            return getPattern(delimiters);
    }

    private String getPattern(String delimiters) {
        String[] tokens = delimiters.substring(1, delimiters.length()-1).split(Pattern.quote("]["));
        for(int i=0; i<tokens.length; i++)
            tokens[i] = Pattern.quote(tokens[i]);
        return StringUtils.join(tokens, '|');

    }

    private boolean hasCustomDelimiter(String str) {
        return str.startsWith("//") & str.contains("\n");
    }


    public String getInput() {
        return input;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
