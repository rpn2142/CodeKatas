package bloomFilter.api;

public interface HashGenerator<T> {
    int[] generateHashes(T item);
}
