import wyjatki.BladWykonania;
import org.junit.jupiter.api.Test;
import wyjatki.NieprawidlowyProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    void TestWczytywanie() throws BladWykonania {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test1.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        wynik = p.wykonaj();
        assertEquals(15.0, wynik);
    }

    @Test
    void TestFib1() throws BladWykonania {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test2.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        wynik = p.wykonaj();
        assertEquals(55.0, wynik);
    }

    @Test
    void TestFib2() throws BladWykonania {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test3.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        wynik = p.wykonaj();
        assertEquals(2.0, wynik);
    }

    @Test
    void TestFib3() throws BladWykonania {
        Robson p = new Robson();
        double wynik = 0;
        try {
            p.fromJSON("src/test/test4.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        wynik = p.wykonaj();
        assertEquals(4181.0, wynik);
    }


    @Test
    void TestJava1() throws IOException {
        Robson p = new Robson();
        try {
            p.fromJSON("src/test/test2.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        p.toJava("robson1.java");

        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("java robson1.java");

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(pr.getInputStream()));

        String s = stdInput.readLine();
        double wynik = Double.parseDouble(s);
        assertEquals(55.0, wynik);
    }

    @Test
    void TestJava2() throws IOException {
        Robson p = new Robson();
        try {
            p.fromJSON("src/test/test2.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        p.toJava("robson2.java");

        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("java robson2.java");

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(pr.getInputStream()));

        String s = stdInput.readLine();
        double wynik = Double.parseDouble(s);
        assertEquals(55.0, wynik);
    }
}
