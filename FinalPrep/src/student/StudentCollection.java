package student;

import java.io.*;
import java.util.*;
public class StudentCollection implements Serializable,Comparable{
	private int id;
	private String name;
	
	static ArrayList<StudentCollection> stu=new ArrayList<StudentCollection>();
	
	public StudentCollection()throws Exception {
		id=0;
		name="";		
	}
	public void writeintoFile() throws Exception
	{
		
		FileOutputStream fout=new FileOutputStream("student.bcs");
		ObjectOutputStream oout=new ObjectOutputStream(fout);
		
			oout.writeObject(stu);
		
	}
public void readfromFile() throws Exception
	{
		FileInputStream fin=new FileInputStream("student.bcs");
		ObjectInputStream oin=new ObjectInputStream(fin);

			stu=(ArrayList<StudentCollection>) oin.readObject();	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Object o) {
		StudentCollection temp1 =this;
		StudentCollection temp2=(StudentCollection)o;
		String name1=temp1.getName();
		String name2=temp2.getName();
	
		int id1 = temp1.getId();
		int id2 = temp2.getId();
		// TODO Auto-generated method stub
	return name1.compareTo(name2);
		
	}
	
}
