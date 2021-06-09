import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

public class Robson {
    private Program wykonywalny = new Program();
    private String json;

    public void fromJSON(String filename) throws NieprawidlowyProgram{
        File f = new File(filename);
        json = null;
        try{
            InputStream fis = new FileInputStream(f);
            json = IOUtils.toString(fis, StandardCharsets.UTF_8.name());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        wykonywalny = gson.fromJson(json, Program.class);

    }

    // z javy do JSON'a
    public void toJSON(String filename){
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(json);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public double wykonaj() throws BladWykonania{
        TreeMap<String, Double> zmienne = new TreeMap();
        return wykonywalny.wykonajProgram(zmienne);
    }
}
