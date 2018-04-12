package dataMunging.api;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pramraj on 3/4/18.
 */
public abstract class DataLoader {

    public List<Data> load(File file) {
        List<Data> dataList = new ArrayList<>();
        loadFile(file, dataList);

        return dataList;

    }

    private void loadFile(File file, List<Data> dataList) {
        BufferedReader br = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));

            String line = null;
            while ((line = br.readLine()) != null)
                addToList(dataList, line);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            close(br);
        }
    }

    private void addToList(List<Data> dataList, String line) {
        line = line.trim();
        Data data = toData(line);
        if( data != null )
            dataList.add(data);
    }

    private void close(BufferedReader br) {
        if( br != null ) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract Data toData(String line);

}
