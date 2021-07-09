package Instrukcje;

import java.util.TreeMap;

public class True extends Wyrazenie {

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return 1d;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append("True");
    }


}
