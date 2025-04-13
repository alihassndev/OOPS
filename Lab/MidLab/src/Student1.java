import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student1 {
    private int id;
    private String name;
    private List <String> courses;
    private List <Character> grades;

    // Shared across all instances
    private static List<Integer> ids = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

//    Parameterized Constructor
    Student1() {
        id = 0;
        name = "Default";
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }

//    Setters
    void setId(int d) {
        if (ids.isEmpty() || !ids.contains(d)) {
            this.id = d;
            ids.add(d);
        } else {
            int newId;
            do {
                System.out.print("Duplicate ID, please enter another: ");
                newId = sc.nextInt();
            } while (ids.contains(newId));
            this.id = newId;
            ids.add(newId);
        }
    }
    void setName(String n) {
        this.name = n;
    }
    void setCourses(List<String> c) {
        this.courses = c;
    }
    void setGrades(List<Character> g) {
        grades = g;
    }

//    Getters
    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    List<String> getCourses() {
        return courses;
    }
    List<Character> getGrades() {
        return grades;
    }

//    Update info
    void updateInfo(int d) {
//        logic here
    }

//    Display info
    void displayInfo() {
        System.out.println("Your id: " + this.id + ", Name: " + this.name);
        System.out.println("Your Course are: ");

        for (int i=0; i<courses.size(); i++) {
            System.out.println(courses.get(i) + " -> " + grades.get(i));
        }
    }
}
