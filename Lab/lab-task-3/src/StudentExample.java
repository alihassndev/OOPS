import java.io.*;
import java.util.*;

public class StudentExample {
    private String name;
    private int id;

    private FileReader fr;
    private FileWriter fw;
    private BufferedWriter bw;
    private BufferedReader br;

    ArrayList<String> data;

    StudentExample() {
        name = new String();
        id = 0;

        fr = null;
        fw = null;
        br = null;
        bw = null;

        data = new ArrayList<String>();
    }

    void setName(String n) {
        name = n;
    }
    String getName() {
        return name;
    }
    void setId(int i) {
        id = i;
    }
    int getId() {
        return id;
    }

    void openFileReader(String filename) throws IOException {
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
    }
    ArrayList<String> readFile() throws IOException {
        String line = br.readLine();

        while (line != null) {
            data.add(line);
            line = br.readLine();
        }
        return data;
    }

    void openFileWrite(String filename) throws IOException {
        fw = new FileWriter(filename);
        bw = new BufferedWriter(fw);
    }

    void writeFile(String text) throws IOException {
        fw.write(text);
        fw.write("\n");
    }

    void fileClose() throws IOException {
        if (br!=null) {
            br.close();
        }
        if (bw!=null) {
            bw.close();
        }
        if (fr!=null) {
            fr.close();
        }
        if (fw!=null) {
            fw.close();
        }
    }
}
