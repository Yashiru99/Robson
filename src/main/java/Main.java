import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    @Test
    void TestWczytywanie() {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test1.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }

        try {
            wynik = p.wykonaj();
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
        assertEquals(55.0, wynik);
    }

    @Test
    void TestFib1() {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test1.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            wynik = p.wykonaj();
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
        assertEquals(55.0, wynik);
    }

    @Test
    void TestFib2() {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test2.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            wynik = p.wykonaj();
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
        assertEquals(2.0, wynik);
    }

    @Test
    void TestFib3() {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test3.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            wynik = p.wykonaj();
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
        assertEquals(4181.0, wynik);
    }

    @Test
    void TestFib4() {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test4.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            wynik = p.wykonaj();
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
        assertEquals(610.0, wynik);
    }

    @Test
    void SimpleProgram() {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test5.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            wynik = p.wykonaj();
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
        assertEquals(15.0, wynik);
    }

}
