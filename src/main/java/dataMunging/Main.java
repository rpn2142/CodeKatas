package dataMunging;

import dataMunging.api.Data;
import dataMunging.api.DataLoader;
import dataMunging.football.FootballDataLoader;
import dataMunging.stats.StatsUtil;
import dataMunging.weather.WeatherDataLoader;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        printMinSpreadDay("football.dat", new FootballDataLoader());
        printMinSpreadDay("weather.dat", new WeatherDataLoader());
    }

    private static void printMinSpreadDay(String file, DataLoader dataLoader) {
        List<Data> dataList = dataLoader.load(new File(Main.class.getClassLoader().getResource(file).getFile()));
        StatsUtil util = new StatsUtil();
        System.out.println(util.getMinSpreadDay(dataList));
    }
}
