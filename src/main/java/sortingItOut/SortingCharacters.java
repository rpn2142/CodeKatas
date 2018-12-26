package sortingItOut;

import joptsimple.internal.Strings;

public class SortingCharacters {

    final int[] charIndex2CountMap;

    public SortingCharacters() {
        this.charIndex2CountMap = new int[26];
    }

    public String sorted(String str) {
        buildCharIndex2CountMap(str);
        return buildSortedString();
    }

    private void buildCharIndex2CountMap(String str) {
        str.toLowerCase()
                .chars()
                .filter( Character::isLetter )
                .forEach( this::incrementIndexCount );
    }

    private int incrementIndexCount(int c) {
        return charIndex2CountMap[c-'a']++;
    }

    private String buildSortedString() {
        StringBuilder resultString = new StringBuilder();
        for( int i=0; i<charIndex2CountMap.length; i++) {

            char character = (char) ('a' + i);
            int count = charIndex2CountMap[i];

            resultString.append( Strings.repeat(character, count) );
        }
        return resultString.toString();
    }
}
