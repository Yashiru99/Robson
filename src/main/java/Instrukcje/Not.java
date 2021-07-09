package Instrukcje;

import java.util.TreeMap;

public class Not extends Wyrazenie {

    protected Wyrazenie argument;

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return argument.wykonaj(zmienne) == 1d ? 0d : 1d;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append("!");
        argument.toJava(sb, zmienne);
    }


}
