public class Warunek {
    private String typ;
    private Program argument1;
    private Program argument2;
    public String Typ() {
        return typ;
    }
    public Program Argument1() {
        return argument1;
    }
    public Program Argument2() {
        return argument2;
    }

    @Override
    public String toString() {
        return argument1.toString() + typ + argument2.toString();
    }
}
