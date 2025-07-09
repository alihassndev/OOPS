package student;

// This assignment helped me deeply understand the OOP concept of inheritance. I learned how a subclass can
// reuse fields and methods from a superclass and override them to add specific behavior. I also practiced
// how to use super() to call parent constructors and methods, showing the hierarchical structure of
// real-world systems.

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Student extends Person {
    int rollNumber;

    Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Roll Number: " + rollNumber);
    }
}
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}
class GraduateStudent extends Student {
    String thesisTopic;

    GraduateStudent(String name, int age, int rollNumber, String thesisTopic) {
        super(name, age, rollNumber);
        this.thesisTopic = thesisTopic;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Thesis Topic: " + thesisTopic);
    }
}
class HeadTeacher extends Teacher {
    int yearsOfExperience;

    HeadTeacher(String name, int age, String subject, int yearsOfExperience) {
        super(name, age, subject);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Years of Experience: " + yearsOfExperience);
    }
}
public class Assign4 {
    public static void main(String[] args) {
        Student s1 = new Student("Ali", 21, 123);
        Teacher t1 = new Teacher("Sara", 30, "Physics");
        GraduateStudent gs = new GraduateStudent("Ahmed", 24, 456, "Artificial Intelligence");
        HeadTeacher ht = new HeadTeacher("Mrs. Khan", 50, "Chemistry", 20);

        s1.displayInfo();
        System.out.println();
        t1.displayInfo();
        System.out.println();
        gs.displayInfo();
        System.out.println();
        ht.displayInfo();
    }
}
