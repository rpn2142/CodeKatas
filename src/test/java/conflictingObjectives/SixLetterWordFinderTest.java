package conflictingObjectives;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SixLetterWordFinderTest {

    private SixLetterCompositeWordFinder sixLetterCompositeWordFinder;
    private Set<String> dictionary = Sets.newHashSet("barely", "bar", "ely", "abc");


    public SixLetterWordFinderTest(SixLetterCompositeWordFinder sixLetterCompositeWordFinder) {
        this.sixLetterCompositeWordFinder = sixLetterCompositeWordFinder;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new SixLetterCompositeWordFinderReadable()},
                {new SixLetterCompositeWordFinderOptimized()}
        });
    }


    @Test
    public void getSixLetterCompositeWords() {
        sixLetterCompositeWordFinder.loadDictionary(dictionary);
        assertEquals(Lists.newArrayList("barely"), sixLetterCompositeWordFinder.getSixLetterCompositeWords());
    }

    @Test
    public void testWithBigDictionary() throws IOException {
        Set<String> largeDictionary = new HashSet<>(FileUtils.readLines(new File(SixLetterWordFinderTest.class.getClassLoader().getResource("wordlist.txt").getFile()),
                "utf-8"));
        sixLetterCompositeWordFinder.loadDictionary(largeDictionary);
        long start = System.currentTimeMillis();
        assertEquals(18914, sixLetterCompositeWordFinder.getSixLetterCompositeWords().size());
        System.out.println(sixLetterCompositeWordFinder.getClass().getSimpleName() + ": " + (System.currentTimeMillis() - start));
    }
}