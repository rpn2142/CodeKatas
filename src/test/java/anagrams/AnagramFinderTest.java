package anagrams;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnagramFinderTest {

    @Test
    public void getAnagrams() {
        List<String> wordSet = Lists.newArrayList("abc", "bac", "xyz", "zyx", "a");
        AnagramFinder anagramFinder = new AnagramFinder();

        List<List<String>> anagramList = anagramFinder.findAnagrams(wordSet);
        assertEquals(2, anagramList.size());

        assertTrue(anagramList.contains(Lists.newArrayList("abc", "bac")));
        assertTrue(anagramList.contains(Lists.newArrayList("xyz", "zyx")));

    }

    @Test
    public void testOnDataSet() throws IOException {
        List<String> wordSet = FileUtils.readLines(new File(getClass().getClassLoader().getResource("wordlist.txt").getFile()),
                "utf-8");

        AnagramFinder anagramFinder = new AnagramFinder();
        List<List<String>> anagramList = anagramFinder.findAnagrams(wordSet);
        assertEquals(20683, anagramList.size());
    }
}