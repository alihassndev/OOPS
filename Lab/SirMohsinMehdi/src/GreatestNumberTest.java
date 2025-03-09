import java.util.Scanner;

public class GreatestNumberTest {
    public static void main(String[] args) {
        System.out.println("This is main ...");
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];

//        Taking input from the user
        System.out.print("Enter 10 values : ");
        for (int i=0; i<array.length; i++) {
            array[i] = sc.nextInt();
        }

//        Creating objects
        GreatestNumber gn = new GreatestNumber();
        gn.setArr(array);
        System.out.print("Printing values of Array: ");
        gn.print();
        int max = gn.max();
        System.out.println("\nMax number of Array is: " + max);
    }
}
