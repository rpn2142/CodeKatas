package bloomFilter;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spellChecker.bloomFilter.BloomFilterImpl;
import spellChecker.bloomFilter.api.HashGenerator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BloomFilterTest {

    @Mock
    HashGenerator<String> mockHashGenerator;

    /*
       Bits that will be set for test words hello, world and test
       hello - 1,2
       world - 2,4
       test  - 4,8
    */


    @Test
    public void checkBloomFilterWorking() {
        BloomFilterImpl<String> bloomFilter = new BloomFilterImpl<String>(mockHashGenerator);
        when(mockHashGenerator.generateHashes("hello")).thenReturn(new int[]{1, 2});
        when(mockHashGenerator.generateHashes("world")).thenReturn(new int[]{2, 4});
        when(mockHashGenerator.generateHashes("test")).thenReturn(new int[]{4, 8});

        assertFalse(bloomFilter.mightContain("hello"));
        assertFalse(bloomFilter.mightContain("world"));
        assertFalse(bloomFilter.mightContain("test"));


        bloomFilter.addAll(Lists.newArrayList("hello"));
        assertTrue(bloomFilter.mightContain("hello"));
        assertFalse(bloomFilter.mightContain("world"));
        assertFalse(bloomFilter.mightContain("test"));

        bloomFilter.addAll(Lists.newArrayList("test"));
        assertTrue(bloomFilter.mightContain("hello"));
        assertTrue(bloomFilter.mightContain("world")); // should return true for 'world', although it is not yet added
        assertTrue(bloomFilter.mightContain("test"));

        verify(mockHashGenerator, times(4)).generateHashes("hello");
        verify(mockHashGenerator, times(4)).generateHashes("test");
        verify(mockHashGenerator, times(3)).generateHashes("world");
        verifyNoMoreInteractions(mockHashGenerator);

    }

}