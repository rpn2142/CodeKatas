package dataMunging.football;

import dataMunging.api.Data;
import dataMunging.api.DataLoader;

/**
 * Created by pramraj on 3/4/18.
 */
public class FootballDataLoader extends DataLoader {
    @Override
    protected Data toData(String line) {
        String[] tokens = line.split("\\s+");
        try {
            String name = tokens[1];
            Integer forGoals = Integer.parseInt(tokens[6]);
            Integer againstGoals = Integer.parseInt(tokens[8]);
            return new FootballData(name, forGoals, againstGoals);
        } catch(Exception e) {

        }
        return null;

    }
}
