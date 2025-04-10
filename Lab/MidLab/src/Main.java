import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        Scanner sc = new Scanner(System.in);
        String[] courses = new String[3];
        char[] grades = new char[3];

        Student[] std = new Student[5];

        for (int i=0; i<std.length;i++) {
            System.out.print("Enter id : ");
            std[i].setId(sc.nextInt());
            System.out.print("Enter name : ");
            std[i].setName(sc.next());

            for (int j=0; j<courses.length; j++) {
                System.out.print("Enter course " + (j+1) + ": ");
                courses[j] = sc.next();
                System.out.print("Enter grade for this course: ");
                grades[j] = sc.next().charAt(0);
            }

            std[i].setCourses(courses);
            std[i].setGrade(grades);

            std[i].displayInfo();
        }
    }
}