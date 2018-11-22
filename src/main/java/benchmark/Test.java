package benchmark;

import conflictingObjectives.SixLetterCompositeWordFinder;
import conflictingObjectives.SixLetterCompositeWordFinderOptimized;
import conflictingObjectives.SixLetterCompositeWordFinderReadable;
import org.apache.commons.io.FileUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {

        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void initOptimized() throws IOException {
        Set<String> largeDictionary = new HashSet<>(FileUtils.readLines(new File(getClass().getClassLoader().getResource("wordlist.txt").getFile()),
                "utf-8"));
        SixLetterCompositeWordFinder sixLetterCompositeWordFinder = new SixLetterCompositeWordFinderOptimized();
        sixLetterCompositeWordFinder.loadDictionary(largeDictionary);
        sixLetterCompositeWordFinder.getSixLetterCompositeWords().size();

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void initReadable() throws IOException {
        Set<String> largeDictionary = new HashSet<>(FileUtils.readLines(new File(getClass().getClassLoader().getResource("wordlist.txt").getFile()),
                "utf-8"));
        SixLetterCompositeWordFinder sixLetterCompositeWordFinder = new SixLetterCompositeWordFinderReadable();
        sixLetterCompositeWordFinder.loadDictionary(largeDictionary);
        sixLetterCompositeWordFinder.getSixLetterCompositeWords().size();
    }
}
