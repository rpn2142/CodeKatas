package countingCodeLines;


import countingCodeLines.api.LineCounter;
import countingCodeLines.api.LineReader;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LineCounterImplTest {

    @Mock
    private LineReader mockLineReader;

    private LineCounter lineCounter;

    @Test
    public void countLines() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("abcd" , "bcd", null);
        assertEquals(2, lineCounter.countLines());
    }

    @Test
    public void IgnoreWhiteSpaces() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("abcd" , "", "\t\t", "\n", "    ", "\r\n", "bcd", null);
        assertEquals(2, lineCounter.countLines());
    }

    @Test
    public void IgnoreSingleCommentLines() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("abcd" , "// single line comment", "bcdf","//bcd", null);
        assertEquals(2, lineCounter.countLines());
    }

    @Test
    public void IgnoreBlockCommentLines() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("abcd" , "/* multi line comment", "end of comment*/","bcd", null);
        assertEquals(2, lineCounter.countLines());
    }

    @Test
    public void IgnoreBlockCommentLinesWithTextNearCommentStart() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("abcd" , "HelloWorld/* multi line comment", "end of comment*/","//bcd", null);
        assertEquals(2, lineCounter.countLines());
    }

    @Test
    public void IgnoreBlockCommentLinesWithTextNearCommentEnd() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("abcd" , "/* multi line comment", "end of comment*/helloWorld","//bcd", null);
        assertEquals(2, lineCounter.countLines());
    }

    @Test
    public void handleBlockCommentInSingleLine() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("/*abcd*/" , "something/*abcd*/", "/*abcd*/something","something/*abcd*/something", null);
        assertEquals(3, lineCounter.countLines());
    }

    @Test
    public void handleBlockCommentInStringLiteral() {
        lineCounter = new LineCounterImpl(mockLineReader);
        when(mockLineReader.readLine()).thenReturn("String abcd = \"/*abcd*/\"" , "abcd", null);
        assertEquals(2, lineCounter.countLines());
    }

    @After
    public void tearDown() {
        reset(mockLineReader);
    }



}