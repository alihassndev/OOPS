import java.util.ArrayList;
import java.util.List;

public class Student1 {
    private int id;
    private String name;
    private List <String> courses = new ArrayList<>();
    private List <Character> grades = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();

//    Setters
    boolean setId(int d) {
        if (ids.isEmpty() || !ids.contains(d)) {
            this.id = d;
            return false;
        } else {
            System.out.println("Duplicate id please another !");
            return true;
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
}
