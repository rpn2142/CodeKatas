package spellChecker;

import spellChecker.api.SpellChecker;
import spellChecker.bloomFilter.api.BloomFilter;

import javax.inject.Inject;
import java.util.List;

public class SpellCheckerImpl implements SpellChecker {

    private BloomFilter<String> bloomFilter;

    @Inject
    public SpellCheckerImpl(BloomFilter<String> bloomFilter) {
        this.bloomFilter = bloomFilter;
    }


    @Override
    public boolean isSpelledCorrectly(String word) {
        return bloomFilter.mightContain(word);
    }

    @Override
    public void addAll(List<String> words) {
        bloomFilter.addAll(words);
    }
}
