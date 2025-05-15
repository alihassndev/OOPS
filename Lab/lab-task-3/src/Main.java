import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        Student stu=new Student();

//        for (int i=0; i<5; i++) {
            System.out.print("Enter id: ");
            int d = sc.nextInt();
            stu.setID(d);
            sc.nextLine();
            System.out.print("Enter name: ");
            String n = sc.nextLine();
            stu.setName(n);

            int tempID =stu.getID();
            String temp =stu.getName();

            stu.openFiletoWrite("test.txt");
            stu.WriteinTheFile("ID:" + tempID + " " + "Name:" +temp);
            stu.closeFile();
//        }

        stu.openFiletoRead("test.txt");
        ArrayList<String> data =stu.ReadfromFile();
        stu.closeFile();

        System.out.print("Enter id where you want to update name: ");
        String findID = sc.nextLine();

        System.out.print("Enter name you want to update: ");
        String updateName = sc.nextLine();

        for(int i=0;i<data.size();i++) {
            String tempData = data.get(i);
            int index=-1;
            String[] dataSplit = tempData.split(" ");
            for(int j=0;j<dataSplit.length;j++)
            {
                String tempSplit = dataSplit[j];
                String[] ts=tempSplit.split(":");
                for(int k=0;k<ts.length;k++)
                {
                    if(ts[0].equals("ID"))
                    {
                        if(ts[1].equals(findID))
                        {
                            index=i;
//                            System.out.println("index set");
                        }
                        else
                            index=-1;
                    }
                    if(ts[0].equals("Name") && index!=-1)
                    {
                        ts[1]=updateName;
                        data.set(index,"ID:" + findID + " Name:" + ts[1]);
//                        System.out.println("name set");
                        break;
                    }
                }
            }
        }

//        System.out.println(data);
        stu.openFiletoWrite("test.txt");
        for(int i=0;i<data.size();i++) {
            stu.WriteinTheFile(data.get(i));
            stu.WriteinTheFile("\n");
        }
        stu.closeFile();

        System.out.print("Enter id you want to delete: ");
        String deleteID = sc.nextLine();

        for(int i=0;i<data.size();i++) {
            String tempData = data.get(i);
            String[] dataSplit = tempData.split(" ");
            for(int j=0;j<dataSplit.length;j++)
            {
                String tempSplit = dataSplit[j];
                String[] ts=tempSplit.split(":");
                for(int k=0;k<ts.length;k++)
                {
                    if(ts[0].equals("ID"))
                    {
                        if(ts[1].equals(deleteID))
                        {
                            data.remove(i);
                            break;
//                            System.out.println("index set");
                        }
                    }

                }
            }
        }

//        System.out.println(data);
        stu.openFiletoWrite("test.txt");
        for(int i=0;i<data.size();i++) {
            stu.WriteinTheFile(data.get(i));
            stu.WriteinTheFile("\n");
        }
        stu.closeFile();
    }
}
