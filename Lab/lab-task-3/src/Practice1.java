import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Practice1 {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton submitButton;
    private ArrayList<StudentCollection> std;

    public Practice1() {
        std = new ArrayList<StudentCollection>();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String name = textField2.getText();
                StudentCollection temp = new StudentCollection();
                temp.setId(Integer.parseInt(id));
                temp.setName(name);

                std.add(temp);

                try {
                    FileOutputStream fs = new FileOutputStream("Student.bcs");
                    ObjectOutputStream os = new ObjectOutputStream(fs);

                    for (int i=0; i<std.size(); i++) {
//            System.out.println(std.get(i).getId() + ": " + std.get(i).getName());
                        os.writeObject(std.get(i));
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
