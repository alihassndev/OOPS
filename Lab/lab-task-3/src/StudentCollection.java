import java.io.Serializable;
import java.util.*;
public class StudentCollection implements Comparable, Serializable {
    private int id;
    private String name;

    StudentCollection(){
        id = 0;
        name = new String();
    }

    void setName(String n) {
        name = n;
    } void setId(int i) {
        id = i;
    }
    int getId() {
        return id;
    }
    String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        StudentCollection o1 = (StudentCollection) o;
        StudentCollection o2 = this;

//        int firstId = o2.getId();
//        int secondId = o1.getId();
//
//        return firstId-secondId;

        String firstName = o2.getName();
        String secondName = o1.getName();

        return firstName.compareTo(secondName);
    }
}
