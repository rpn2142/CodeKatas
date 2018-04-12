package dataMunging.football;

import dataMunging.api.Data;
import com.google.common.base.Objects;

/**
 * Created by pramraj on 3/4/18.
 */
public class FootballData implements Data {

    private String name;
    private Integer forGoals;
    private Integer againstGoals;

    public FootballData(String name, Integer forGoals, Integer againstGoals) {
        this.name = name;
        this.forGoals = forGoals;
        this.againstGoals = againstGoals;
    }

    public String getName() {
        return name;
    }

    public Integer getForGoals() {
        return forGoals;
    }

    public Integer getAgainstGoals() {
        return againstGoals;
    }

    @Override
    public Float getSpread() {
        return (float)Math.abs(getForGoals()-getAgainstGoals());
    }

    @Override
    public String getId() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballData that = (FootballData) o;
        return Objects.equal(getName(), that.getName()) &&
                Objects.equal(getForGoals(), that.getForGoals()) &&
                Objects.equal(getAgainstGoals(), that.getAgainstGoals());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getForGoals(), getAgainstGoals());
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("forGoals", forGoals)
                .add("againstGoals", againstGoals)
                .toString();
    }
}
