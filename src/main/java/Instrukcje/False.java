package Instrukcje;

import java.util.TreeMap;

public class False extends Wyrazenie{
    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        return 0d;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append("False");
    }}
