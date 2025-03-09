public class Student {
    private String name;
    private int age;

//    Default Constructor
    Student() {
        name = "Default";
        age = 0;
    }

//    Setters
    void setName(String name) {
        this.name = name;
    }
    void setAge(int age) {
        this.age = age;
    }

//    Getters
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }
}
