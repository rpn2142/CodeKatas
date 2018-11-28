package dataMunging.api;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by pramraj on 3/4/18.
 */
public abstract class DataLoader {

    public List<Data> load(File file) {
        try {
            return FileUtils.readLines(file, "utf-8")
                    .stream()
                    .map(line -> toData(line.trim()))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }

    protected abstract Data toData(String line);

}
