import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        Scanner sc = new Scanner(System.in);

        Student[] std = new Student[10];

        for (int i=0; i<std.length; i++) {
            std[i] = new Student();
        }

//        Setting values
        for (int i=0; i<std.length; i++) {
            System.out.print("Enter id here: ");
            int id = sc.nextInt();
            std[i].setId(id);
            System.out.print("Enter name here: ");
            String name = sc.nextLine();
            std[i].setName(name);
        }

//        Printing
        for (Student s: std) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName());
        }
    }
}
