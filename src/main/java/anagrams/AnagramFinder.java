package anagrams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class AnagramFinder {
    public List<List<String>> findAnagrams(List<String> wordSet) {
        return wordSet.stream()
                .collect(groupingBy(s -> sortCharsInString(s)))
                .values()
                .stream()
                .filter(list -> list.size() > 1)
                .collect(toList());
    }

    private String sortCharsInString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
