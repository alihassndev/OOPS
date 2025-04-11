import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        Scanner sc = new Scanner(System.in);
        String[] courses = new String[3];
        char[] grades = new char[3];

        Student[] std = new Student[2];

        for (int i=0; i<std.length; i++) {
            std[i] = new Student(3);
        }

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
        }

        int choice = 1;
        while (choice != 0) {
            System.out.println("Enter your choice: ");
            System.out.print("1 -> update info || 2 -> delete course\n3 -> delete student data || 4 -> display info || 0 -> exit: ");
            choice = sc.nextInt();
            System.out.println("Enter id here: ");
            int id = sc.nextInt();

            if (choice == 1) {
                for (int k=0; k<std.length; k++) {
                    if (std[k].getId() == id) {
                        std[k].updateRecord(id);
                    }
                }
            } else if (choice == 2) {
                for (int k=0; k<std.length; k++) {
                    if (std[k].getId() == id) {
                        std[k].deleteCourse(id);
                    }
                }
            } else if (choice == 3) {
                for (int k=0; k<std.length; k++) {
                    if (std[k].getId() == id) {
                        std[k].deleteData(id);
                    }
                }
            } else if (choice == 4) {
                for (int k=0; k<std.length; k++) {
                    if (std[k].getId() == id) {
                        std[k].displayInfo();
                    }
                }
            } else {
                System.out.println("Wrong input. Please try again !");
            }
        }
    }
}