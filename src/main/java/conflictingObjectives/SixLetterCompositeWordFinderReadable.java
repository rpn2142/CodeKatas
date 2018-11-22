package conflictingObjectives;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Iterables.isEmpty;

public class SixLetterCompositeWordFinderReadable implements SixLetterCompositeWordFinder {

    private Set<String> dictionary;

    public SixLetterCompositeWordFinderReadable() {
        this.dictionary = new HashSet<>();
    }

    @Override
    public List<String> getSixLetterCompositeWords() {
        List<String> result = new ArrayList<>(dictionary.size());
        for (String str : dictionary) {
            if (isSixLetterWord(str) && isCompositeWord(str)) {
                result.add(str);
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

    private boolean isSixLetterWord(String str) {
        return str.length() == 6;
    }

    private boolean isCompositeWord(String str) {
        for (int i = 1; i < str.length(); i++) {
            String firstHalf = str.substring(0, i);
            String secondHalf = str.substring(i);
            if (dictionary.contains(firstHalf) && dictionary.contains(secondHalf)) {
                return true;
            }
        }
        return false;
    }

}
