import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("This is main ...");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        System.out.print("Enter five values: ");
        for (int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayExample obj = new ArrayExample();
        obj.setArr(arr);

        obj.print();

        int[] temp = obj.getArr();
        temp[0] = 9;
        System.out.println("\nPrinting temp Array:");
//        Printing temp Array
        for (int i=0; i<temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println("\nObject Printing:");
        obj.print();
    }
}
