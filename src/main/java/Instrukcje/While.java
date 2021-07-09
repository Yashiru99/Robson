package Instrukcje;


import java.util.TreeMap;

public class While extends Wyrazenie {

    private Wyrazenie warunek;

    private Blok blok;

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        double wynik = 0;
        while(warunek.wykonaj(zmienne) > 0d){
            wynik = blok.wykonaj(zmienne);
        }
        return wynik;
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append("while(");
        warunek.toJava(sb, zmienne);
        sb.append(")\n");
        blok.toJava(sb, zmienne);
    }


}
