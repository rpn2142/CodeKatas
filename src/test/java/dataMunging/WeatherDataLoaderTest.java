package dataMunging;

import dataMunging.api.Data;
import org.junit.Test;
import dataMunging.weather.WeatherData;
import dataMunging.weather.WeatherDataLoader;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class WeatherDataLoaderTest {

    @Test
    public void weatherDataLoading() {
        WeatherDataLoader weatherDataLoader = new WeatherDataLoader();
        List<Data> weatherDataList = weatherDataLoader.load(new File(getClass().getClassLoader().getResource("weather_sample.txt").getFile()));

        assertTrue("1st record", weatherDataList.contains(new WeatherData(1, 88f, 59f)));
        assertTrue("2nd record", weatherDataList.contains(new WeatherData(31, 82.9f, 60.5f)));
        assertTrue("3rd record", weatherDataList.contains(new WeatherData(26, 97f, 64f)));
        assertEquals("size must be 3", 3, weatherDataList.size());
    }


    @Test
    public void footballDataLoading() {

    }


}
