public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

//        Creating Student class object
        Student std1 = new Student();

        std1.setName("Ahmad");
        std1.setRollno(112);

        System.out.println("RollNo: " + std1.getRollno() + ", Name: " + std1.getName());
    }
}