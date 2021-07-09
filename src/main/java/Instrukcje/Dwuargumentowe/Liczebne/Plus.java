package Instrukcje.Dwuargumentowe.Liczebne;


import Instrukcje.Dwuargumentowe.WyrazenieDwuargumentowe;

import java.util.TreeMap;

public class Plus extends WyrazenieDwuargumentowe {

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return argument1.wykonaj(zmienne) + argument2.wykonaj(zmienne);
    }


    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        argument1.toJava(sb, zmienne);
        sb.append(" + ");
        argument2.toJava(sb, zmienne);
    }
}
