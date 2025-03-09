import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        System.out.println("This is main ...");
        Scanner sc = new Scanner(System.in);
        String[] str = new String[5];

        for (int i=0; i<str.length; i++) {
            System.out.print("Enter value for " + i + ": ");
            str[i] = sc.next();
        }

        StringLength strlen = new StringLength();
        strlen.setArr(str);
        System.out.println("Object Printing : ");
        strlen.print();
        System.out.println("\nPrinting Object values length : ");
        strlen.printLength();

        String[] temp = strlen.getArr();
        System.out.println("Printing temp Array : ");

        for (String s: temp) {
            System.out.print(s + " ");
        }
    }
}
