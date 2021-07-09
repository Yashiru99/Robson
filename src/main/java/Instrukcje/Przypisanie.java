package Instrukcje;

import java.util.TreeMap;

public class Przypisanie extends Wyrazenie {

    private String nazwa;

    private Wyrazenie wartosc;

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        zmienne.put(nazwa, wartosc.wykonaj(zmienne));
        return 0d;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        if(!zmienne.containsKey(nazwa))sb.append("double ");
        zmienne.put(nazwa, 0d);
        sb.append(nazwa);
        sb.append("=");
        wartosc.toJava(sb, zmienne);
        sb.append(";\n");
    }


}
