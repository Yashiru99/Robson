package Instrukcje;

import java.util.TreeMap;

public class Wartosc extends Wyrazenie {

    private double wartosc;

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return wartosc;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append(wartosc);
    }


}
