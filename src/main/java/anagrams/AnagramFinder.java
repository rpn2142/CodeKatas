package anagrams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class AnagramFinder {
    private static String sortCharsInString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> findAnagrams(List<String> wordSet) {
        return wordSet.stream()
                .collect(groupingBy(AnagramFinder::sortCharsInString))
                .values()
                .stream()
                .filter(list -> list.size() > 1)
                .collect(toList());
    }
}
