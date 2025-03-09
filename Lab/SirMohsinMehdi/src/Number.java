public class Number {
    private int a;
    private int b;

    public Number() {
        a=0;
        b=0;
    }

//    Getters and Setters
    void setA(int x) {
        a=x;
    }
    void setB(int x) {
        b=x;
    }

    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }

    public int sum() {
        return a+b;
    }
}
