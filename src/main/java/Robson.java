import Instrukcje.AbstractElementAdapter;
import Instrukcje.Wyrazenie;
import com.google.gson.GsonBuilder;
import wyjatki.BladWykonania;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import wyjatki.NieprawidlowyProgram;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

public class Robson {
    private Wyrazenie program;
    private String json;

    public void fromJSON(String filename) throws NieprawidlowyProgram {
        File f = new File(filename);
        json = null;
        try{
            InputStream fis = new FileInputStream(f);
            json = IOUtils.toString(fis, StandardCharsets.UTF_8.name());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(Wyrazenie.class, new AbstractElementAdapter());
        Gson gson = gb.create();
        program = gson.fromJson(json, Wyrazenie.class);

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
        TreeMap<String, Double> zmienne = new TreeMap<>();
        return program.wykonaj(zmienne);
    }


    public void toJava(String filename) {
        try {
            File f = new File(filename);
            FileWriter wr = new FileWriter(f);
            TreeMap<String, Double> zmienne = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            sb.append("public class Main{\npublic static double robson()");
            program.toJava(sb, zmienne);
            sb.append("public static void main(String[] args){ System.out.println(robson()); }\n}");
            wr.write(sb.toString());
            wr.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
