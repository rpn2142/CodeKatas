package conflictingObjectives;

import java.util.List;
import java.util.Set;

public interface SixLetterCompositeWordFinder {
    List<String> getSixLetterCompositeWords();

    void loadDictionary(Set<String> dictionary);
}
