package dataMunging.stats;

import dataMunging.api.Data;

import java.util.List;

public class StatsUtil {


    public String getMinSpreadDay(List<Data> dataList) {

        if( dataList == null || dataList.isEmpty())
            return "";

        return dataList.stream()
                                .min((w1, w2) -> Float.compare(w1.getSpread(), w2.getSpread()))
                                .get().getId();


    }
}
