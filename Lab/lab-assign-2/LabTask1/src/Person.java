public class Person {
    private String name;
    private int age;

//    Constructor to initialize the values
    Person(String n, int a) {
        name = n;
        age = a;
    }

//    Method to display the info
    void display() {
        System.out.println("Name: " + name + ", age: " + age);
    }
}
