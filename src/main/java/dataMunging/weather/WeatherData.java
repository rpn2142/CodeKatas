package dataMunging.weather;

import dataMunging.api.Data;
import com.google.common.base.Objects;

public class WeatherData implements Data {
    private Integer day;
    private Float min;
    private Float max;

    public WeatherData(int day, Float min, Float max) {
        this.day = day;
        this.min = min;
        this.max = max;
    }

    public Integer getDay() {
        return day;
    }

    public Float getMin() {
        return min;
    }

    public Float getMax() {
        return max;
    }


    public Float getSpread() {
        return max-min;
    }

    @Override
    public String getId() {
        return getDay()+"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Objects.equal(getDay(), that.getDay()) &&
                Objects.equal(getMin(), that.getMin()) &&
                Objects.equal(getMax(), that.getMax());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDay(), getMin(), getMax());
    }
}
