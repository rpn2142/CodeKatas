package sortingItOut;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortingCharactersTest {

    SortingCharacters sortingCharacters = new SortingCharacters();

    @Test
    public void sortedOutput() {
        assertEquals("abcvx", sortingCharacters.sorted("axcbv"));
    }

    @Test
    public void ignoreWhitespace() {
        assertEquals("abcvx", sortingCharacters.sorted("ax cbv"));
    }


    @Test
    public void ignorePuncutation() {
        assertEquals("abcvx", sortingCharacters.sorted("!a#x@c%b^v&"));
    }

    @Test
    public void checkRepetition() {
        assertEquals("abbcccvxxxx", sortingCharacters.sorted("xcaxcxcbvxb"));
    }
}