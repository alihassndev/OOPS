import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        Scanner sc = new Scanner(System.in);

        Student1[] std = new Student1[2];

        for (int i=0; i<std.length; i++) {
            std[i] = new Student1();
        }

        for (int i=0; i<std.length; i++) {
            System.out.print("Enter id for Student " + (i+1) + ": ");
            int id = sc.nextInt();
            std[i].setId(id);

            sc.nextLine();
            System.out.print("Enter name for Student " + (i+1) + ": ");
            String name = sc.nextLine();
            std[i].setName(name);

            List<String> courses = new ArrayList<>();
            List<Character> grades = new ArrayList<>();

            System.out.println("Enter Courses for Student " + (i+1) + ": ");
            for (int j=0; j<3; j++) {
                System.out.print("Enter course " + (j+1) + ": ");
                String tempCourse = sc.nextLine();
                courses.add(tempCourse);
                System.out.print("Enter grade for course " + courses.get(j) + ": ");
                char tempGrade = sc.nextLine().charAt(0);
                grades.add(tempGrade);
            }

            std[i].setCourses(courses);
            std[i].setGrades(grades);
        }

        int choice = 0;
        do {
            System.out.println("1 -> display || 0 -> exit");
            System.out.print("Enter your choice here: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter id : ");
                int id = sc.nextInt();

                for (int i=0; i<std.length; i++) {
                    if (id == std[i].getId()) {
                        std[i].displayInfo();
                    }
                }
            }
        } while (choice != 0);
    }
}
