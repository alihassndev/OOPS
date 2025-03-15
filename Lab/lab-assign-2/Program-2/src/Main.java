public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

//        Creating Person Object with Default Values
        Person person1 = new Person();

//        Printing person1's details
        person1.printDetails();

//        Now initialize the values using setter methods
        person1.setName("Ali Hassan");
        person1.setAge(22);

        person1.printDetails();
    }
}