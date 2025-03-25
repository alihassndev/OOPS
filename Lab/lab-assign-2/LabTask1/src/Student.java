public class Student {
    private String name;
    private int id;

    Student() {
        name = "default";
        id = 0;
    }

//    Setters
    void setName(String n) {
        name = n;
    }
    void setId(int i) {
        id = i;
    }

//    Getters
    String getName() {
        return name;
    }
    int getId() {
        return id;
    }
}
