import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Main Method ...");

        System.out.print("Enter a String: ");
        String s = sc.next();

//        Creating an object
        NonRepeating chr1 = new NonRepeating();

        chr1.setStr(s);
        System.out.println("Non Repeating Character: " + chr1.Non());
//        System.out.println("Non Repeating character: " + chr1.nonRepeating());
    }
}