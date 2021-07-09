package Instrukcje;

import java.util.TreeMap;

public class Liczba extends Wyrazenie {

    private String wartosc;

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return Double.parseDouble(wartosc);
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append(wartosc);
    }


}
