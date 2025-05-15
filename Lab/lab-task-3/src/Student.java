import java.io.*;
import java.util.*;
public class Student {
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private BufferedWriter bw;
    private ArrayList<String> arr;
    private String name;
    private int ID;

    Student() {
        fr=null;
        fw=null;
        br=null;
        bw=null;
        arr=new ArrayList<String>();
        name=new String();
        ID=0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }

    public ArrayList<String> ReadfromFile()throws IOException
    {
        String line = br.readLine();

        while(line!=null)
        {
            arr.add(line);
            line=br.readLine();
        }
        return arr;
    }

    public void WriteinTheFile(String input)throws IOException
    {
        fw.write(input);
        fw.write("\n");

    }
    public void closeFile() throws IOException {
        if (br != null) {
            br.close();
        }
        if (bw != null) {
            bw.close();
        }
        if (fw != null) {
            fw.close();
        }
        if (fr != null) {
            fr.close();
        }
    }

    public void openFiletoRead(String filename) throws IOException
    {
        fr=new FileReader(filename);
        br=new BufferedReader(fr);
    }
    public void openFiletoWrite(String filename) throws IOException
    {
        fw=new FileWriter(filename);
        bw=new BufferedWriter(fw);
    }
}