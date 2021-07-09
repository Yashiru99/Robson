package Instrukcje;

import java.util.TreeMap;

public class If extends Wyrazenie {

    private Wyrazenie warunek;

    private Blok blok_prawda;

    private Blok blok_falsz;

    @Override
    public double wykonaj(TreeMap<String, Double> zmienne) {
        if(warunek.wykonaj(zmienne) == 1d){
            if(blok_prawda == null)return 0d;
            return blok_prawda.wykonaj(zmienne);
        }
        if(blok_falsz == null)return 0d;
        return blok_falsz.wykonaj(zmienne);
    }

    @Override
    public void toJava(StringBuilder sb, TreeMap<String, Double> zmienne) {
        sb.append("if(");
        warunek.toJava(sb, zmienne);
        sb.append(")\n");
        blok_prawda.toJava(sb, zmienne);
        blok_falsz.toJava(sb, zmienne);
    }


}
