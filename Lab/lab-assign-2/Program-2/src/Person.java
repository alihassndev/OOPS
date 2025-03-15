public class Person {
    private String name;
    private int age;

    Person() {
        name = "Default";
        age = 0;
    }

//    Setters
    void setName(String n) {
        name = n;
    }
    void setAge(int a) {
        age = a;
    }

//    Getters
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }

    void printDetails() {
        System.out.println("Name: " + name + ", age: " + age);
    }
}
