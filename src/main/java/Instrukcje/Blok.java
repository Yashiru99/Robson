package Instrukcje;

import Instrukcje.Dwuargumentowe.Liczebne.*;

import java.util.ArrayList;
import java.util.TreeMap;

public class Blok extends Wyrazenie {

    private final ArrayList<Wyrazenie> instrukcje = new ArrayList<>();

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        double wynik = 0;
        for(Wyrazenie w : instrukcje){
            wynik = w.wykonaj(zmienne);
        }
        return wynik;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append("{\n");
        for(Wyrazenie w : instrukcje){
            if(w instanceof Plus || w instanceof Minus || w instanceof Dzielenie || w instanceof Razy || w instanceof Liczba || w instanceof Zmienna){
                sb.append("return ");
                w.toJava(sb, zmienne);
                sb.append(";");
            }
            else{
                w.toJava(sb, zmienne);
            }
        }
        sb.append("}\n");
    }

    public ArrayList<Wyrazenie> getInstrukcje() {
        return instrukcje;
    }


}
