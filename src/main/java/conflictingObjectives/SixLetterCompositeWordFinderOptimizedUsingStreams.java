package conflictingObjectives;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Iterables.isEmpty;

public class SixLetterCompositeWordFinderOptimizedUsingStreams implements SixLetterCompositeWordFinder {
    private Set<String> dictionary;

    public SixLetterCompositeWordFinderOptimizedUsingStreams() {
        this.dictionary = new HashSet<>();
    }

    @Override
    public List<String> getSixLetterCompositeWords() {
        return dictionary.stream()
                .parallel()
                .filter(str -> {
                    if (str.length() != 6)
                        return false;
                    for (int i = 1; i < str.length(); i++)
                        if (dictionary.contains(str.substring(0, i)) && dictionary.contains(str.substring(i)))
                            return true;
                    return false;
                }).collect(Collectors.toList());
    }

    @Override
    public void loadDictionary(Set<String> dictionary) {
        if (isEmpty(dictionary)) {
            throw new IllegalArgumentException("Empty dictionary");
        }
        this.dictionary = dictionary;
    }

}
