public class Student {
    private String name;
    private int rollno;

//    Default Constructor
    Student() {
        name = "Default";
        rollno = 0;
    }

//    Setters
    void setName(String n) {
        name = n;
    }
    void setRollno(int r) {
        rollno = r;
    }

//    Getters
    String getName() {
        return name;
    }
    int getRollno() {
        return rollno;
    }

//    Display info
    void info() {
        System.out.println("RollNo: " + rollno + ", Name: " + name);
    }
}
