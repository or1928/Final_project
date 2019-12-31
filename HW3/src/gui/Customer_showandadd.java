package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.crypto.Mac;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Customer_showandadd extends JFrame {
	private int anaBobi;

	private static JPanel contentPane;
	private static JTextField textField_fnane;
	private static JTextField textField_lname;
	private static JTextField textField_id;
	private static JTextField textField_phone;
	private static JTextField textField_birthday;
	private static JTextField textField_email;
	private static JLabel lblNewLabel;
	private static JLabel lab123;
	private static JLabel Label_id;
	private static JLabel lLabel_phone;
	private static JLabel Label_birthday;
	private static JLabel Label_email;
	private static JLabel Label_fname;
	private static JLabel Label_lname;
	private static JLabel Label_show_id;
	private static JLabel Label_show_phone;
	private static JLabel Label_show_birthday;
	private static JLabel Label_show_email;
	private static JLabel Label_show_fname;
	private static JLabel Label_show_lname;
	private static JButton Button_add_new_cusromer;
	/**
	 * Launch the application.
	 */
	/*public static void Visible_co_t1() {
	for ( Customer customer : allCustomers) {
		
		//comboBox_show_cusromer.add(null, customer.getFirstName()+"");
	}
*/	
	
	public static void Visible_co_t() {
		Label_id.setVisible(true);
		lLabel_phone.setVisible(true);
		Label_birthday.setVisible(true);
		Label_email.setVisible(true);
		Label_fname.setVisible(true);
		Label_lname.setVisible(true);
		Label_show_lname.setVisible(true);
		Label_show_fname.setVisible(true);
		Label_show_phone.setVisible(true);
		Label_show_birthday.setVisible(true);
		Label_show_email.setVisible(true);
		Label_show_id.setVisible(true);
		Button_add_new_cusromer.setVisible(true);
	}
	public static void Visible_co_f() {
		
		Label_show_lname.setVisible(false);
		Label_show_fname.setVisible(false);
		Label_show_phone.setVisible(false);
		Label_show_birthday.setVisible(false);
		Label_show_email.setVisible(false);
		Label_show_id.setVisible(false);
	}
	public static void Visible_add_t() {
		Label_id.setVisible(true);
		lLabel_phone.setVisible(true);
		Label_birthday.setVisible(true);
		Label_email.setVisible(true);
		Label_fname.setVisible(true);
		Label_lname.setVisible(true);
		Button_add_new_cusromer.setVisible(true);
		textField_fnane.setVisible(true);
		textField_lname.setVisible(true);
		textField_id.setVisible(true);
		textField_phone.setVisible(true);
		textField_birthday.setVisible(true);
		textField_email.setVisible(true);
	}
	public static void Visible_add_f() {
		
		
		textField_fnane.setVisible(false);
		textField_lname.setVisible(false);
		textField_id.setVisible(false);
		textField_phone.setVisible(false);
		textField_birthday.setVisible(false);
		textField_email.setVisible(false);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_showandadd frame = new Customer_showandadd();
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
	public Customer_showandadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image img =new ImageIcon(this.getClass().getResource("/cellphone_background_x1.png")).getImage();
		Image newImage = img.getScaledInstance(480, 300,Image.SCALE_DEFAULT);
		Image img1 =new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64,Image.SCALE_DEFAULT);
		
		
		 JLabel lblNewLabel_1111 = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05DC\u05E7\u05D5\u05D7:");
		 lblNewLabel_1111.setVisible(false);
		 lblNewLabel_1111.setBounds(323, 154, 70, 13);
		 contentPane.add(lblNewLabel_1111);
		 
		 JComboBox comboBox1 = new JComboBox();
		 comboBox1.setVisible(false);
		 comboBox1.setBounds(227, 150, 86, 21);
		 contentPane.add(comboBox1);
		 
		 JButton btnNewButton_11 = new JButton("\u05DE\u05D7\u05E7");
		 btnNewButton_11.setVisible(false);
		 btnNewButton_11.setBounds(235, 232, 85, 21);
		 contentPane.add(btnNewButton_11);
		 
		 
		 
		 JButton btnNewButton11 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05DC\u05E7\u05D5\u05D7");
		 btnNewButton11.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		lblNewLabel_1111.setVisible(true);
				 comboBox1.setVisible(true);
				 btnNewButton_11.setVisible(true);
		 	}
		 });
		 btnNewButton11.setBounds(220, 83, 108, 21);
		 contentPane.add(btnNewButton11);
		
		
		 lblNewLabel = new JLabel(" \u05D1\u05D7\u05D9\u05E8\u05EA \u05DC\u05E7\u05D5\u05D7 \u05E7\u05D9\u05D9\u05DD:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(322, 60, 102, 13);
		contentPane.add(lblNewLabel);
		
		 lab123 = new JLabel("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		lab123.setFont(new Font("SansSerif", Font.BOLD, 30));
		lab123.setBounds(154, -20, 133, 68);
		contentPane.add(lab123);
		
		 Label_id = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D6\u05D4\u05D5\u05EA:");
		Label_id.setVisible(false);
		Label_id.setBounds(140, 121, 68, 13);
		contentPane.add(Label_id);
		
		 lLabel_phone = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lLabel_phone.setVisible(false);
		lLabel_phone.setBounds(137, 154, 71, 13);
		contentPane.add(lLabel_phone);
		
		 Label_birthday = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4:");
		Label_birthday.setVisible(false);
		Label_birthday.setBounds(138, 177, 71, 13);
		contentPane.add(Label_birthday);
		
		 Label_email = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC:");
		Label_email.setVisible(false);
		Label_email.setBounds(166, 200, 34, 13);
		contentPane.add(Label_email);
		
		 Label_fname = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		Label_fname.setVisible(false);
		Label_fname.setBounds(331, 154, 62, 13);
		contentPane.add(Label_fname);
		
		 Label_lname = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		Label_lname.setVisible(false);
		Label_lname.setBounds(331, 170, 71, 13);
		contentPane.add(Label_lname);
		
		 Label_show_id = new JLabel("New label");
		Label_show_id.setVisible(false);
		Label_show_id.setBounds(70, 121, 45, 13);
		contentPane.add(Label_show_id);
		
		 Label_show_phone = new JLabel("New label");
		Label_show_phone.setVisible(false);
		Label_show_phone.setBounds(70, 154, 45, 13);
		contentPane.add(Label_show_phone);
		
		 Label_show_birthday = new JLabel("New label");
		Label_show_birthday.setVisible(false);
		Label_show_birthday.setBounds(70, 177, 45, 13);
		contentPane.add(Label_show_birthday);
		
		 Label_show_email = new JLabel("New label");
		Label_show_email.setVisible(false);
		Label_show_email.setBounds(70, 200, 45, 13);
		contentPane.add(Label_show_email);
		
		 Button_add_new_cusromer = new JButton("\u05D4\u05D5\u05E1\u05E3");
		Button_add_new_cusromer.setVisible(false);
		Button_add_new_cusromer.setBounds(165, 232, 96, 21);
		contentPane.add(Button_add_new_cusromer);
		
		textField_fnane = new JTextField();
		textField_fnane.setVisible(false);
		textField_fnane.setBounds(235, 151, 96, 19);
		contentPane.add(textField_fnane);
		textField_fnane.setColumns(10);
		
		textField_lname = new JTextField();
		textField_lname.setVisible(false);
		textField_lname.setBounds(235, 174, 96, 19);
		contentPane.add(textField_lname);
		textField_lname.setColumns(10);
		
		textField_id = new JTextField();
		textField_id.setVisible(false);
		textField_id.setBounds(34, 118, 96, 19);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setVisible(false);
		textField_phone.setBounds(31, 151, 96, 19);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);
		
		textField_birthday = new JTextField();
		textField_birthday.setVisible(false);
		textField_birthday.setBounds(32, 174, 96, 19);
		contentPane.add(textField_birthday);
		textField_birthday.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setVisible(false);
		textField_email.setBounds(34, 197, 96, 19);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		 Label_show_fname = new JLabel("New label");
		Label_show_fname.setVisible(false);
		Label_show_fname.setBounds(261, 154, 45, 13);
		contentPane.add(Label_show_fname);
		
		 Label_show_lname = new JLabel("New label");
		Label_show_lname.setVisible(false);
		Label_show_lname.setBounds(261, 170, 45, 13);
		contentPane.add(Label_show_lname);
		
		JComboBox comboBox_show_cusromer = new JComboBox();
		
		//if(Main.allCustomers.isEmpty())
			comboBox_show_cusromer.addItem("");
		//else
			
		
			
		comboBox_show_cusromer.addItem("abc1");
		comboBox_show_cusromer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_show_cusromer.getSelectedItem().equals("abc1"))
				{
					Visible_co_t();
					Visible_add_f();
				}
				else {Visible_co_f();}
			}
		});
		
		comboBox_show_cusromer.setBounds(223, 58, 89, 21);
		contentPane.add(comboBox_show_cusromer);
		
		JButton Button_show_add = new JButton("\u05D4\u05D5\u05E4\u05E1\u05EA \u05DC\u05E7\u05D5\u05D7 \u05D7\u05D3\u05E9");
		Button_show_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_add_t();
				Visible_co_f();
				
			}
		});
		Button_show_add.setBounds(30, 58, 133, 21);
		contentPane.add(Button_show_add);
		
		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
		Button_return.setBounds(0, 0, 85, 21);
		contentPane.add(Button_return);
		
		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(375, 199, 91, 64);
		contentPane.add(Label_logo_yvc);
	
		JLabel lblNewLabel_111 = new JLabel("");
		lblNewLabel_111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_111.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_111.setIcon(new ImageIcon(newImage));
		lblNewLabel_111.setBounds(0, 0, 480, 300);
		contentPane.add(lblNewLabel_111);
		
		
	
		
		
		
		
	}
}
