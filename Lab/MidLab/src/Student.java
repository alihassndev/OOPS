import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String name;
    private int id;
    private String[] courses;
    private char[] grades;
    private List <Integer> lst = new ArrayList<>();

//    int size = courses.length;

    Scanner sc = new Scanner(System.in);

    Student(int para) {
        name = new String();
        id = 0;
        courses = new String[para];
        grades = new char[para];
    }

//    Setters
    void setName(String n) {
        name = n;
    }
//    Making sure ID do not duplicate here
    void setId(int d) {
        int temp = 0;
        do {
            if (!lst.contains(d) || lst.isEmpty()) {
                lst.add(d);
                id = d;
            } else {
                System.out.print("Enter another ID please: ");
                temp = sc.nextInt();
                lst.add(temp);
                id = temp;
            }
        } while (id <= 0);
    }
    void setCourses(String[] c) {
        courses = c;
    }
    void setGrade(char[] g) {
        grades = g;
    }

//    Getters
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

//    Method for updating the records
    void updateRecord(int d) {
        int choice = 0;
        if (d == this.id) {
            do {
                System.out.println("please select what do you want to update:");
                System.out.print("1 -> Name, 2 -> Courses, 0 -> exit: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter new name here: ");
                    this.name = sc.nextLine();
                    System.out.println("Name Updated Successfully !");
                } else if (choice == 2) {
                    int temp = choice;
                    for (int i=0; i<courses.length; i++) {
                        System.out.println("Enter new course " + (i+1) + " here: ");
                        this.courses[i] = sc.next();
                        System.out.println("Do you want to updated its grade ?");
                        System.out.print("Then press 1 otherwise press 0: ");
                        choice = sc.nextInt();

                        if (choice == 1) {
                            System.out.print("Enter new grade here: ");
                            this.grades[i] = sc.next().charAt(0);
                            System.out.println("Grade updated Successfully !");
                        } else if (choice == 0) {
                            break;
                        }
                    }
                    choice = temp;
                }
            } while (choice != 0);
        } else {
            System.out.println("Your required id does not exits !");
        }
    }

//    Method to delete a course
    int size = (this.courses == null ? 0 : this.courses.length);

    void deleteCourse(int d) {
        String temp = "";
        if (d == this.id) {
            System.out.print("Enter name of course you want to delete: ");
            temp = sc.next();

            for (int i=0; i<courses.length; i++) {
                if (temp == this.courses[i]) {
                    this.courses[i] = "null";
                    this.grades[i] = '0';
                    size--;
                } else {
                    System.out.println(temp + " not found !");
                }
            }

            int tempSize = courses.length;
            for (int i=0; i<this.size; i++) {
                if (courses[i] == "null") {
                    String tem = courses[i];
                    courses[i] = courses[tempSize-1];
                    courses[tempSize-1] = tem;
                    tempSize--;
                }
            }
        }
    }

//    Delete student Data
    void deleteData() {
        this.id = 0;
        this.name = "Default";
        this.courses = new String[3];
        this.grades = new char[3];
    }

//    Display info
    void displayInfo() {

        System.out.println("You id : " + this.id + ", name : " + this.name);

        System.out.println("Your courses are: ");
        for (int i=0; i<this.size; i++) {
            System.out.print(courses[i] + " ");
        }
    }
}
