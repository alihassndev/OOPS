import java.util.Scanner;

public class TestStudentClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Main Method ...");

        StudentClass[] std = new StudentClass[2];

        for (int i=0; i<std.length; i++) {
            std[i] = new StudentClass(3);

            System.out.print("Enter student " + (i+1) + " id: ");
            std[i].setId(sc.nextInt());
            System.out.print("Enter student " + (i+1) + " name: ");
            std[i].setName(sc.next());

            String[] temp = new String[3];
            for (int j=0; j<std[i].getCourses().length; j++) {
                System.out.print("Enter " + (j+1) + " course: ");
                temp[j] = sc.next();
            }
            std[i].setCourses(temp);
        }

//        Display Data
        for (StudentClass s: std) {
            System.out.println("Id: " + s.getId() + ", name: " + s.getName());
            System.out.println("Courses");
            String[] temp = s.getCourses();
            for (int i=0; i<s.getCourses().length; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
        }

//        Testing
        std[1].updateInfo();
        System.out.println("Student 1 Details");
        System.out.println(std[1].getName());
        System.out.println("Student 1 Courses:");
        String[] temp = std[1].getCourses();
        for (int i=0; i<std[1].getCourses().length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
}
