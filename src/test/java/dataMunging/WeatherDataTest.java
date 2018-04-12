package dataMunging;

import dataMunging.api.Data;
import org.junit.Test;
import dataMunging.stats.StatsUtil;
import dataMunging.weather.WeatherData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class WeatherDataTest {


    @Test
    public void getMinimumSpread() {

        List<Data> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData(1, 5.33f, 6.33f));
        weatherDataList.add(new WeatherData(2, 5.33f, 10.33f));
        weatherDataList.add(new WeatherData(3, 5.33f, 15.33f));

        StatsUtil statsUtil = new StatsUtil();
        assertEquals("min spread", "1", statsUtil.getMinSpreadDay(weatherDataList));
    }


    @Test
    public void getMinimumSpreadForEmptyList() {

        StatsUtil statsUtil = new StatsUtil();
        assertEquals("min spread", "", statsUtil.getMinSpreadDay(Collections.EMPTY_LIST));
        assertEquals("min spread", "", statsUtil.getMinSpreadDay(null));
    }

    @Test
    public void equalsWeatherData() {
        WeatherData weatherData = new WeatherData(1, 2f, 3f);
        WeatherData weatherData1 = new WeatherData(1, 2f, 3f);
        assertTrue("equals", weatherData.equals(weatherData1));
    }

}
