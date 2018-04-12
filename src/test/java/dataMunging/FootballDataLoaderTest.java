package dataMunging;

import dataMunging.api.Data;
import dataMunging.football.FootballData;
import dataMunging.football.FootballDataLoader;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by pramraj on 3/4/18.
 */
public class FootballDataLoaderTest {

    @Test
    public void footballDataLoading() {
        FootballDataLoader footballDataLoader = new FootballDataLoader();
        List<Data> footballDataList = footballDataLoader.load(new File(getClass().getClassLoader().getResource("football_sample.txt").getFile()));

        for( Data data : footballDataList )
            System.out.println(data.toString());

        assertTrue("1st record", footballDataList.contains(new FootballData("Arsenal", 79, 36)));
        assertTrue("2nd record", footballDataList.contains(new FootballData("Ipswich", 41, 64)));

        assertEquals("size must be 2", 2, footballDataList.size());
    }
}
