package Instrukcje;


import java.util.TreeMap;

public class Zmienna extends Wyrazenie {

    private String nazwa;

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return zmienne.get(nazwa);
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append(nazwa);
    }

}
