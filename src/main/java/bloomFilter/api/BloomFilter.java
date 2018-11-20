package bloomFilter.api;

import java.util.List;

public interface BloomFilter<T> {
    void addAll(List<T> items);

    boolean mightContain(T item);
}
