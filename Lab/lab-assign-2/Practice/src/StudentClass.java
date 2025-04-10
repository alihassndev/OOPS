import java.util.Scanner;

public class StudentClass {
    private String name;
    private int id;
    private String[] courses;
    Scanner sc = new Scanner(System.in);

//    Constructor
    public StudentClass(int numberofCourses) {
        name = new String();
        id = 0;
        courses = new String[numberofCourses];
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String[] getCourses() {
        return courses;
    }
    public void setCourses(String[] courses) {
        this.courses = courses;
    }

//    Update Details
    void updateInfo() {
        int choice = 0;
//        if (this.id == d) {
        do {
            System.out.println("What you want to update: ");
            System.out.println("Enter 1 -> Name OR 2 -> Courses:");
            choice = sc.nextInt();
            if (choice == 1) {
                sc.nextLine();
                System.out.println("Enter Name you want now: ");
                this.name = sc.nextLine();
            } else if (choice == 2) {
                for (int i = 0; i < courses.length; i++) {
                    System.out.print("Enter " + (i + 1) + " course: ");
                    courses[i] = sc.next();
                }
            }
        } while (choice != 0);
//        }
    }

//    delete Student Data Method
    void deleteStudentData() {
        new StudentClass(3);
    }

//    delete Student course Method
    void deleteCourse() {
//        int[] indeces = new int[courses.length];
        int removedIndex = courses.length;
        for (int i=0; i<courses.length; i++) {
            System.out.print("Enter course which you want to delete: ");
            String c = sc.next();
            if (c == courses[i]) {
                courses[i] = "null";
//                indeces[removedIndex] = i;
                removedIndex--;
            }
        }
        
    }
}