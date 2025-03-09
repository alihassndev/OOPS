import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, This is main Method !\n");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        Student std1 = new Student();

        std1.setName(name);
        std1.setAge(age);

//        Printing Info
        System.out.println("Your Name: \'" + std1.getName() + "\' and Age: " + std1.getAge());
    }
}