package dataMunging.weather;

import dataMunging.api.Data;
import dataMunging.api.DataLoader;

public class WeatherDataLoader extends DataLoader {

    @Override
    protected Data toData(String line) {
        return parseLine(line);
    }

    private WeatherData parseLine(String line) {

        String[] columns = line.split("\\s+");
        try {
            Integer day = getDay(columns[0]);
            Float max = getFloat(columns[1]);
            Float min = getFloat(columns[2]);
            return new WeatherData(day, max, min);
        } catch( Exception e) {

        }
        return null;
    }

    private float getFloat(String column) {
        if( column.endsWith("*") )
            column = column.substring(0, column.length()-1);
        return Float.parseFloat(column);
    }

    private Integer getDay(String column) {
        if( column.equals("mo") )
            return 31;
        else
            return Integer.parseInt(column);
    }


}
