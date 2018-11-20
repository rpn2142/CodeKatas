package spellChecker;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spellChecker.api.SpellChecker;
import spellChecker.bloomFilter.api.BloomFilter;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpellCheckerTest {

    @Mock
    private BloomFilter<String> mockBloomFilter;


    @Test
    public void testSpellCheckerLoadingOfWords() {
        SpellChecker spellChecker = new SpellCheckerImpl(mockBloomFilter);

        List<String> wordList = Lists.newArrayList("hello", "test");
        spellChecker.addAll(wordList);
        verify(mockBloomFilter, times(1)).addAll(wordList);

    }

    @Test
    public void testIfSpellCheckerReturnsBloomFiltersResponse() {
        SpellChecker spellChecker = new SpellCheckerImpl(mockBloomFilter);

        when(mockBloomFilter.mightContain("hello")).thenReturn(true);
        when(mockBloomFilter.mightContain("world")).thenReturn(false);

        assertTrue(spellChecker.isSpelledCorrectly("hello"));
        assertFalse(spellChecker.isSpelledCorrectly("world"));
    }
}
