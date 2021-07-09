package Instrukcje.Dwuargumentowe.Porównawcze;


import Instrukcje.Dwuargumentowe.WyrazenieDwuargumentowe;

import java.util.TreeMap;

public class Mniejsze extends WyrazenieDwuargumentowe {
    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return argument1.wykonaj(zmienne) < argument2.wykonaj(zmienne) ? 1d : 0d;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        argument1.toJava(sb, zmienne);
        sb.append(" < ");
        argument2.toJava(sb, zmienne);
    }
}
