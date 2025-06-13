package test;

import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudentGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private FileInputStream fin;
	private FileOutputStream fout;
	private ObjectInputStream oin;
	private ObjectOutputStream oout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGUI frame = new StudentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentGUI() throws Exception{
		fout=new FileOutputStream("student.bcs");
		oout=new ObjectOutputStream(fout);
		fin = new FileInputStream("student.bcs");
		oin=new ObjectInputStream(fin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(115, 112, 98, 76);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(134, 38, 45, 64);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(208, 38, 149, 64);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setBounds(312, 139, 143, 64);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");

		btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String idText = textField.getText();
            String name = textField_1.getText();

            if (idText.isEmpty() || name.isEmpty()) {
                return;
            }

            int id = Integer.parseInt(idText);
            StudentCollection newStudent = new StudentCollection();
            newStudent.setId(id);
            newStudent.setName(name);

            File file = new File("student.bcs");
            ArrayList<StudentCollection> students = new ArrayList<>();

            // Read all existing students from file
            if (file.exists() && file.length() != 0) {
                FileInputStream fin = new FileInputStream(file);
                ObjectInputStream oin = new ObjectInputStream(fin);
                try {
                    while (true) {
                        StudentCollection s = (StudentCollection) oin.readObject();
                        students.add(s);
                    }
                } catch (EOFException ex) {
                    // Done reading
                } finally {
                    oin.close();
                }
            }

            // Check for duplicate ID
            for (StudentCollection s : students) {
                if (s.getId() == newStudent.getId()) {
                    System.out.println("Duplicate ID! Student not added.");
                    return; // prevent saving duplicate
                }
            }

            // Add new student and overwrite the file with all students
            students.add(newStudent);
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            for (StudentCollection s : students) {
                oout.writeObject(s);
            }
            oout.close();

            System.out.println("✅ Student added successfully.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});


		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(183, 280, 179, 85);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(449, 66, 227, 243);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("ReadfromFile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				
				ArrayList<StudentCollection> temp=new ArrayList<StudentCollection>();
				while(true)
				{
					try {
					StudentCollection temp2=(StudentCollection) oin.readObject();
					temp.add(temp2);
				}
					catch(EOFException f)
					{
						break;
					}		
			}

				for(int i=0;i<temp.size();i++)
				{
					textArea.append(temp.get(i).getId()+" "+temp.get(i).getName()+"\n");
				}
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(449, 343, 187, 76);
		contentPane.add(btnNewButton_1);
	}
}
