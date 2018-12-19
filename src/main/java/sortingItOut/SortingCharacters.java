package sortingItOut;

import joptsimple.internal.Strings;

public class SortingCharacters {

    final int[] charIndex2CountMap;

    public SortingCharacters() {
        this.charIndex2CountMap = new int[26];
    }

    public String sorted(String str) {
        computeCharCount(str);
        return buildResultString();
    }

    private void computeCharCount(String str) {
        str.toLowerCase()
                .chars()
                .filter( Character::isLetter )
                .forEach(this::incrementIndexCount);
    }

    private int incrementIndexCount(int c) {
        return charIndex2CountMap[c-'a']++;
    }

    private String buildResultString() {
        StringBuilder resultString = new StringBuilder();
        for( int i=0; i<charIndex2CountMap.length; i++) {
            resultString.append(Strings.repeat((char)(i+'a'), charIndex2CountMap[i]));
        }
        return resultString.toString();
    }
}
