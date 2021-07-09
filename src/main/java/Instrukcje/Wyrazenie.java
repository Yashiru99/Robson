package Instrukcje;


import java.util.TreeMap;

abstract public class Wyrazenie {

    abstract public double wykonaj(TreeMap<String, Double> zmienne);

    abstract public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne);
}

