package spellChecker.bloomFilter;

import spellChecker.bloomFilter.api.BloomFilter;
import spellChecker.bloomFilter.api.HashGenerator;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class BloomFilterImpl<T> implements BloomFilter<T> {
    private int bitSetLength;
    private HashGenerator<T> hashGenerator;
    private BitSet bitSet;

    @Inject
    public BloomFilterImpl(HashGenerator<T> hashGenerator) {
        this.hashGenerator = hashGenerator;
        bitSetLength = 1024;
        bitSet = new BitSet(bitSetLength);
    }

    @Override
    public void addAll(List<T> items) {
        for (T item : items) {
            int[] hashes = this.hashGenerator.generateHashes(item);
            recordAllHashes(hashes);
        }
    }

    @Override
    public boolean mightContain(T item) {
        int[] hashes = this.hashGenerator.generateHashes(item);
        return !isAnyPositionNotSet(hashes);
    }

    private boolean isAnyPositionNotSet(int[] hashes) {
        return Arrays.stream(hashes)
                .anyMatch(this::isNotSet);
    }

    private void recordAllHashes(int[] hashes) {
        Arrays.stream(hashes)
                .map(hash -> hash % bitSet.size())
                .forEach(bitSet::set);
    }

    private boolean isNotSet(int position) {
        return !bitSet.get(position % bitSet.size());
    }
}
