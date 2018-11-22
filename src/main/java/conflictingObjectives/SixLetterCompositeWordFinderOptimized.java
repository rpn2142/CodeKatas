package conflictingObjectives;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Iterables.isEmpty;

public class SixLetterCompositeWordFinderOptimized implements SixLetterCompositeWordFinder {
    private Set<String> dictionary;

    public SixLetterCompositeWordFinderOptimized() {
        this.dictionary = new HashSet<>();
    }

    @Override
    public List<String> getSixLetterCompositeWords() {
        List<String> result = new ArrayList<>(dictionary.size());
        for (String str : dictionary) {
            if (str.length() == 6) {
                for (int i = 1; i < str.length(); i++) {
                    if (dictionary.contains(str.substring(0, i)) && dictionary.contains(str.substring(i))) {
                        result.add(str);
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public void loadDictionary(Set<String> dictionary) {
        if (isEmpty(dictionary)) {
            throw new IllegalArgumentException("Empty dictionary");
        }
        this.dictionary = dictionary;
    }

}
