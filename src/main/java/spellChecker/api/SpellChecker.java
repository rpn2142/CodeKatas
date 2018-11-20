package spellChecker.api;

import java.util.List;

public interface SpellChecker {
    boolean isSpelledCorrectly(String word);

    void addAll(List<String> words);
}
