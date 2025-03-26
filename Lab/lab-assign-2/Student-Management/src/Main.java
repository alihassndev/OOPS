public class Main {
    public static void main(String[] args) {
        System.out.println("Student Management System");

        Student std1 = new Student();
        std1.setName("ali hassan");
        std1.setId(111);
        int[] arr = {89, 78, 80, 85, 82, 79};
        std1.setScore(arr);

        System.out.println("Your Id id: " + std1.getId());
        System.out.println("Your Name is: " + std1.getName());
        char grade = std1.gradeCal();
        System.out.println("Your Grade is: " + grade);

        System.out.println("After manipulation Name is: " + std1.strManipulation());
    }
}