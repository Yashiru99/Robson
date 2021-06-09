import java.util.ArrayList;
import java.util.TreeMap;

public class Program {
    private String typ;
    private ArrayList<Program> instrukcje;

    private Warunek Warunek;
    private Program blok_prawda;
    private Program blok_falsz;

    private String nazwa;
    private Program Wartosc;
    private String wartosc;

    private Program argument;
    private Program argument1;
    private Program argument2;

    private Program blok;


    boolean sprawdzWarunek(Warunek Warunek, TreeMap<String, Double> zmienne) {
        double wartosc1 = Warunek.Argument1().Typ().equals("Zmienna") ? zmienne.get(Warunek.Argument1().Nazwa()) : Warunek.Argument1().Wartosc();
        double wartosc2 = Warunek.Argument2().Typ().equals("Zmienna") ? zmienne.get(Warunek.Argument2().Nazwa()) : Warunek.Argument2().Wartosc();
        if(Warunek.Typ().equals("<=")){
            return wartosc1 <= wartosc2;
        }
        else if(Warunek.Typ().equals("<")){
            return wartosc1 < wartosc2;
        }
        else if(Warunek.Typ().equals(">=")){
            return wartosc1 >= wartosc2;
        }
        else if(Warunek.Typ().equals(">")){
            return wartosc1 > wartosc2;
        }
        else if(Warunek.Typ().equals("==")){
            return wartosc1 == wartosc2;
        }
        else if(Warunek.Typ().equals("AND")){
            return wartosc1 != 0 && wartosc2 != 0;
        }
        else if(Warunek.Typ().equals("OR")){
            return wartosc1 != 0 || wartosc2 != 0;
        }
        return false;
    }


    // operacje arytmetyczne
    static double Plus(Program argument1, Program argument2, TreeMap<String, Double> zmienne){
        double wartosc1 = argument1.Typ().equals("Zmienna") ? zmienne.get(argument1.Nazwa()) : argument1.Wartosc();
        double wartosc2 = argument2.Typ().equals("Zmienna") ? zmienne.get(argument2.Nazwa()) : argument2.Wartosc();
        return wartosc1 + wartosc2;
    }

    static double Razy(Program argument1, Program argument2, TreeMap<String, Double> zmienne){
        double wartosc1 = argument1.Typ().equals("Zmienna") ? zmienne.get(argument1.Nazwa()) : argument1.Wartosc();
        double wartosc2 = argument2.Typ().equals("Zmienna") ? zmienne.get(argument2.Nazwa()) : argument2.Wartosc();
        return wartosc1 * wartosc2;
    }

    static double Dzielenie(Program argument1, Program argument2, TreeMap<String, Double> zmienne){
        double wartosc1 = argument1.Typ().equals("Zmienna") ? zmienne.get(argument1.Nazwa()) : argument1.Wartosc();
        double wartosc2 = argument2.Typ().equals("Zmienna") ? zmienne.get(argument2.Nazwa()) : argument2.Wartosc();
        return wartosc1 / wartosc2;
    }

    static double Minus(Program argument1, Program argument2, TreeMap<String, Double> zmienne){
        double wartosc1 = argument1.Typ().equals("Zmienna") ? zmienne.get(argument1.Nazwa()) : argument1.Wartosc();
        double wartosc2 = argument2.Typ().equals("Zmienna") ? zmienne.get(argument2.Nazwa()) : argument2.Wartosc();
        return wartosc1 - wartosc2;
    }

    double przypisz(TreeMap<String, Double> zmienne) throws BladWykonania {
        String nazwa = this.nazwa;
        Double wartosc = Wartosc.wykonajProgram(zmienne);
        zmienne.put(nazwa, wartosc);
        return wartosc;
    }

    double funkcjaIf(TreeMap<String, Double> zmienne) throws BladWykonania {
        if(sprawdzWarunek(Warunek, zmienne)){
            return blok_prawda.wykonajProgram(zmienne);
        }
        return blok_falsz.wykonajProgram(zmienne);
    }

    double funkcjaWhile(TreeMap<String, Double> zmienne) throws BladWykonania {
        double wynik = 0;
        while(sprawdzWarunek(Warunek, zmienne)){
            wynik = blok.wykonajProgram(zmienne);
        }
        return wynik;
    }

    public double wykonajProgram(TreeMap<String, Double> zmienne) throws BladWykonania{
        double wynik = 0;
        switch (typ){
            case "Blok":
                for(Program p : instrukcje){
                    wynik = p.wykonajProgram(zmienne);
                }
                break;
            case "If":
                return funkcjaIf(zmienne);
            case "While":
                return funkcjaWhile(zmienne);
            case "Przypisanie":
                return przypisz(zmienne);
            case "Plus":
                return Plus(argument1, argument2, zmienne);
            case "Minus":
                return Minus(argument1, argument2, zmienne);
            case "Razy":
                return Razy(argument1, argument2, zmienne);
            case "Dzielenie":
                return Dzielenie(argument1, argument2, zmienne);
            case "Liczba":
                return this.Wartosc();
            case "Zmienna":
                return zmienne.get(nazwa);
            case "True":
                return 1d;
            case "False":
                return 0;
            default:
                throw new BladWykonania("Nieprawidłowy blok");
        }
        return wynik;
    }

    public Program() {
    }


    public String Typ() {
        return typ;
    }
    public String Nazwa() {
        return nazwa;
    }
    public double Wartosc() {
        return Double.parseDouble(wartosc.toString());
    }

}
