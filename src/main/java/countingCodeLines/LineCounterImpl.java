package countingCodeLines;

import countingCodeLines.api.LineCounter;
import countingCodeLines.api.LineReader;
import org.apache.commons.lang.StringUtils;

public class LineCounterImpl implements LineCounter {

    private LineReader lineReader;

    public LineCounterImpl(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    @Override
    public int countLines() {
        String line;
        int count = 0;
        boolean inMultiLineCommentBlock = false;
        while( (line = lineReader.readLine()) != null) {
            if( StringUtils.isBlank(line) || line.startsWith("//")) {
                continue;
            }
            if( line.contains("/*") ) {
                inMultiLineCommentBlock = true;
            }
            if( ! inMultiLineCommentBlock ) {
                count++;
            }
            if( line.contains("*/") ) {
                inMultiLineCommentBlock = false;
            }

            if( (line.contains("/*") && ! line.substring(0, line.indexOf("/*")).isEmpty()) ||
                    ( line.contains("*/")) &&
                            ( line.indexOf("*/") + 2 < line.length() &&
                                    ! line.substring(line.indexOf("*/") + 2).isEmpty() )
                    ) {
                count++;
            }
        }
        return count;
    }
}
