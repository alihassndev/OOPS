import java.util.Scanner;

public class Student {
    private String name;
    private int id;
    private String[] courses;
    private char[] grades;

    private static int[] ids = new int[10];
    private static int idCount = 0;

    Scanner sc = new Scanner(System.in);

    Student(int para) {
        name = "";
        id = 0;
        courses = new String[para];
        grades = new char[para];
    }

    void setName(String n) {
        name = n;
    }

    boolean setId(int d) {
        for (int i = 0; i < idCount; i++) {
            if (ids[i] == d) {
                System.out.println("Duplicate ID not allowed.");
                return true;
            }
        }
        this.id = d;
        ids[idCount++] = d;
//        System.out.println("ID set to: " + d);
        return false;
    }

    void setCourses(String[] c) {
        courses = c;
    }

    void setGrade(char[] g) {
        grades = g;
    }

    String getName() {
        return name;
    }

    int getId() {
        return id;
    }

    String[] getCourses() {
        return courses;
    }

    char[] getGrades() {
        return grades;
    }

    void updateRecord(int d) {
        int choice = 0;
        if (d == this.id) {
            do {
                System.out.println("Select what you want to update:");
                System.out.print("1 -> Name, 2 -> Courses, 0 -> Exit: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    this.name = sc.nextLine();
                    System.out.println("Name updated successfully!");
                } else if (choice == 2) {
                    for (int i = 0; i < courses.length; i++) {
                        System.out.print("Enter new course " + (i + 1) + ": ");
                        this.courses[i] = sc.next();
                        System.out.print("Enter new grade: ");
                        this.grades[i] = sc.next().charAt(0);
                    }
                    System.out.println("Courses updated successfully!");
                }
            } while (choice != 0);
        } else {
            System.out.println("ID not matched.");
        }
    }

    void deleteCourse(int d) {
        if (d == this.id) {
            for (int i = 0; i < courses.length; i++) {
                System.out.println("Course: " + this.courses[i] + ", Grade: " + this.grades[i]);
            }

            String temp = "";
            do {
//                sc.nextLine();
                System.out.print("Enter name of course to delete || 0 -> Exit: ");
                temp = sc.nextLine();

                if (temp.equals("0")) break;

                boolean found = false;
                for (int i = 0; i < courses.length; i++) {
                    if (temp.equals(courses[i])) {
                        courses[i] = "null";
                        grades[i] = '0';
                        found = true;
                        System.out.println("Course deleted.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println(temp + " not found!");
                }

            } while (true);
        }
    }

    void deleteData(int d) {
        if (d == this.id) {
            this.id = 0;
            this.name = "Default";
            this.courses = new String[3];
            this.grades = new char[3];
            System.out.println("Student data deleted!");
        } else {
            System.out.println("ID not found!");
        }
    }

    void displayInfo() {
        if (this.id == 0) {
            System.out.println("Student record deleted.");
            return;
        }

        System.out.println("ID: " + this.id + ", Name: " + this.name);
        System.out.println("Courses and Grades:");
        for (int i = 0; i < courses.length; i++) {
            if (!courses[i].equals("null")) {
                System.out.println(courses[i] + " -> " + grades[i]);
            }
        }
        System.out.println();
    }
}
