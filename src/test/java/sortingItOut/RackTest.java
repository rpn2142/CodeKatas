package sortingItOut;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RackTest {

    @Test
    public void testBallRetrieval() {
        Rack rack = new Rack();
        assertEquals(Lists.newArrayListWithExpectedSize(0), rack.getSelectedBallsInSortedOrder());

        rack.selectBall(20);
        assertEquals(Lists.newArrayList(20), rack.getSelectedBallsInSortedOrder());

        rack.selectBall(10);
        rack.selectBall(20);
        assertEquals(Lists.newArrayList(10, 20), rack.getSelectedBallsInSortedOrder());

        rack.selectBall(30);
        assertEquals(Lists.newArrayList(10, 20, 30), rack.getSelectedBallsInSortedOrder());

    }
}