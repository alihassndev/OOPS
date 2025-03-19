public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        StringOperation obj = new StringOperation();

        obj.setStr1("hello");
        obj.setStr2("olelh");

        System.out.println("Result: " + obj.check());
    }
}