package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField; 
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class StudentGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
	 * 
	 * @throws Exception
	 */
	public StudentGUI() throws Exception {
		StudentCollection s = new StudentCollection();
		s.readfromFile();
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
		textField_1.setBounds(208, 135, 143, 64);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(478, 128, 119, 21);
		contentPane.add(comboBox);
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = textField.getText();
					String name = textField_1.getText();
					boolean duplicate = false;
					for (int i = 0; i < StudentCollection.stu.size(); i++) {
						if (StudentCollection.stu.get(i).getId() == Integer.parseInt(id)) {
							duplicate = true;
							break;
						}
					}
					if (duplicate) {
						javax.swing.JOptionPane.showMessageDialog(null, "ID already exists! Please enter a unique ID.");
						return;
					}
					StudentCollection s = new StudentCollection();
					s.setId(Integer.parseInt(id));
					s.setName(name);
					StudentCollection.stu.add(s);
					s.writeintoFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(188, 221, 179, 85);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ReadFromFile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StudentCollection s = new StudentCollection();
					// ArrayList<StudentCollection> stu =StudentCollection.stu;

					for (int i = 0; i < StudentCollection.stu.size(); i++) {
						comboBox.addItem(StudentCollection.stu.get(i).getId());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(478, 340, 193, 76);
		contentPane.add(btnNewButton_1);

	}
}
		