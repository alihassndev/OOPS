class Person {
    private String name;
    private int age;

//    Setters
    void setName(String name) {
        this.name = name;
    }
    void setAge(int age) {
        this.age = age;
    }

//    Default Constructor
    Person() {
        name = "Default";
        age = 0;
    }

//    Getters
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }

    void displayInfo() {
        System.out.println("Your name is: " + name + " , and age is: " + age);
    }
}

class Student extends Person {
    private int rollNumber;

    Student() {
        rollNumber = 0;
    }

//    Setters
    void setRollNumber(int rollno) {
        this.rollNumber = rollno;
    }

//    Getters
    int getRollNumber() {
        return rollNumber;
    }

    @Override
    void displayInfo() {
//        super.displayInfo();
        System.out.println("Your name: " + getName() + ", Age is: " + getAge() + ", and RollNo. is: " + getRollNumber());
    }
}


public class Practice1 {
    public static void main(String[] args) {
        Student std1 = new Student();
        std1.setName("Ali Hassan");
        std1.setAge(22);
        std1.setRollNumber(111);
        std1.displayInfo();
    }
}
