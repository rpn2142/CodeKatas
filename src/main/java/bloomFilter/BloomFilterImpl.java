package bloomFilter;

import bloomFilter.api.BloomFilter;
import bloomFilter.api.HashGenerator;

import javax.inject.Inject;
import java.util.List;

public class BloomFilterImpl<T> implements BloomFilter<T> {

    private HashGenerator<T> hashGenerator;
    private int bitVector;

    @Inject
    public BloomFilterImpl(HashGenerator<T> hashGenerator) {
        this.hashGenerator = hashGenerator;
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
        for (int hash : hashes) {
            if (!containedInBitVector(hash)) {
                return false;
            }
        }
        return true;
    }

    private void recordAllHashes(int[] hashes) {
        for (int hash : hashes) {
            bitVector |= hash;
        }
    }

    private boolean containedInBitVector(int item) {
        int hash = this.bitVector;

        while (item > 0) {
            int itemBit = item & 1;
            int hashBit = hash & 1;
            if (itemBit == 1 && hashBit != 1) {
                return false;
            }
            item >>= 1;
            hash >>= 1;
        }

        return true;
    }
}
