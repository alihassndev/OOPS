import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Main Method ...");
        Scanner sc = new Scanner(System.in);

        StudentExample std = new StudentExample();
        std.openFileReader("test.txt");
        ArrayList<String> data = std.readFile();
        std.fileClose();

        System.out.print("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        std.setId(id);
        std.setName(name);

        data.add("ID:"+std.getId()+" Name:"+ std.getName());
        std.openFileWrite("test.txt");
        for (int i=0; i<data.size(); i++) {
            std.writeFile(data.get(i));
        }
        std.fileClose();
    }
}
