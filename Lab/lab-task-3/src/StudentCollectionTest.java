import java.io.*;
import java.util.*;
public class StudentCollectionTest {
    public static void main(String[] args) throws Exception {
//        ArrayList<String> arr = new ArrayList<String>();
//        arr.add("hello");
//        arr.add("test");
//        arr.add("ali");
//        arr.add("world");
//
//        Collections.sort(arr);
//        System.out.println(arr);

//        Arraylist implement comparable interface
//        int compareTo(Object o);

        ArrayList<StudentCollection> std = new ArrayList<StudentCollection>();

        for (int i=0; i<3; i++) {
            std.add(new StudentCollection());
        }

        Scanner sc = new Scanner(System.in);

        for (int i=0; i<std.size(); i++) {
            System.out.print("Enter id: ");
            std.get(i).setId(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter name: ");
            std.get(i).setName(sc.nextLine());
        }

        Collections.sort(std);

        FileOutputStream fs = new FileOutputStream("Student.bcs");
        ObjectOutputStream os = new ObjectOutputStream(fs);

        for (int i=0; i<std.size(); i++) {
//            System.out.println(std.get(i).getId() + ": " + std.get(i).getName());
            os.writeObject(std.get(i));
        }

        FileInputStream fi = new FileInputStream("Student.bcs");
        ObjectInputStream oi = new ObjectInputStream(fi);

        while (true) {
            try {
                StudentCollection temp = (StudentCollection) oi.readObject();

                System.out.println(temp.getId() + ": " + temp.getName());
            } catch (EOFException e) {
                break;
            }
        }
    }
}
