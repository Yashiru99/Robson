package Instrukcje.Dwuargumentowe;

import Instrukcje.Wyrazenie;

import java.util.TreeMap;

abstract public class WyrazenieDwuargumentowe extends Wyrazenie {

    protected Wyrazenie argument1;
    protected Wyrazenie argument2;

    abstract public double wykonaj(TreeMap<String, Double> zmienne);
}
