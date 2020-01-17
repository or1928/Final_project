package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import classes.Employee;
import db.DBconnect;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.WrongInput;
import main.Main;

public class Employee_showandadd extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_fnane;
	private static JTextField textField_lname;
	private static JTextField textField_id;
	private static JTextField textField_phone;
	private static JTextField textField_birthday;
	private static JLabel lblCustomer_selection;
	private static JLabel labttl;
	private static JLabel Label_id;
	private static JLabel lLabel_phone;
	private static JLabel Label_birthday;
	private static JLabel Label_fname;
	private static JLabel Label_lname;
	private static JLabel Label_show_id;
	private static JLabel Label_show_phone;
	private static JLabel Label_show_birthday;
	private static JLabel Label_show_fname;
	private static JLabel Label_show_lname;
	private static JButton Button_add_new_cusromer;
	private JTable table;
	private static JLabel lblempselection;
	private static JComboBox comboBox_showEmplo_inMYshop_Dell;
	private static JButton btndell, btn_Switch_show;
	private static boolean flag = false;

	public static void Visible_co_t() {
		Label_id.setVisible(true);
		lLabel_phone.setVisible(true);
		Label_birthday.setVisible(true);

		Label_fname.setVisible(true);
		Label_lname.setVisible(true);
		Label_show_lname.setVisible(true);
		Label_show_fname.setVisible(true);
		Label_show_phone.setVisible(true);
		Label_show_birthday.setVisible(true);

		Label_show_id.setVisible(true);
		Button_add_new_cusromer.setVisible(true);
	}

	public static void Visible_co_f() {

		Label_show_lname.setVisible(false);
		Label_show_fname.setVisible(false);
		Label_show_phone.setVisible(false);
		Label_show_birthday.setVisible(false);

		Label_show_id.setVisible(false);
	}

	public static void Visible_add_t() {
		Label_id.setVisible(true);
		lLabel_phone.setVisible(true);
		Label_birthday.setVisible(true);

		Label_fname.setVisible(true);
		Label_lname.setVisible(true);
		Button_add_new_cusromer.setVisible(true);
		textField_fnane.setVisible(true);
		textField_lname.setVisible(true);
		textField_id.setVisible(true);
		textField_phone.setVisible(true);
		textField_birthday.setVisible(true);

	}

	public static void Visible_add_f() {

		textField_fnane.setVisible(false);
		textField_lname.setVisible(false);
		textField_id.setVisible(false);
		textField_phone.setVisible(false);
		textField_birthday.setVisible(false);

	}

	public static void Visible_dell_t() {

		lblempselection.setVisible(true);
		comboBox_showEmplo_inMYshop_Dell.setVisible(true);
		btndell.setVisible(true);
	}

	public static void Visible_dell_f() {

		lblempselection.setVisible(false);
		comboBox_showEmplo_inMYshop_Dell.setVisible(false);
		btndell.setVisible(false);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_showandadd frame = new Employee_showandadd();
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
	public Employee_showandadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 544, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image img = new ImageIcon(this.getClass().getResource("/br.jpg")).getImage();
		Image newImage = img.getScaledInstance(530, 357, Image.SCALE_DEFAULT);
		Image img1 = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64, Image.SCALE_DEFAULT);

		Image img3 = new ImageIcon(this.getClass().getResource("/brs1.jpg")).getImage();
		Image newImage3 = img3.getScaledInstance(103, 357, Image.SCALE_DEFAULT);

		lblempselection = new JLabel(":\u05D1\u05D7\u05D9\u05E8\u05EA \u05E2\u05D5\u05D1\u05D3");
		lblempselection.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblempselection.setVisible(false);
		lblempselection.setBounds(313, 216, 80, 13);
		contentPane.add(lblempselection);

		btn_Switch_show = new JButton("\u05D4\u05E6\u05D2\u05EA \u05E2\u05D5\u05D1\u05D3\u05D9\u05DD");
		btn_Switch_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				try {
					DBconnect.updtaeDB();
				} catch (WrongInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				employee_show employee_win_show = new employee_show();
				employee_win_show.setVisible(true);
			}
		});
		btn_Switch_show.setBounds(0, 58, 103, 21);
		contentPane.add(btn_Switch_show);

		comboBox_showEmplo_inMYshop_Dell = new JComboBox();
		comboBox_showEmplo_inMYshop_Dell.addItem("");
		for (Employee my : Main.myShop.getEmployess())
			comboBox_showEmplo_inMYshop_Dell.addItem(my.getFirstName());
		comboBox_showEmplo_inMYshop_Dell.setVisible(false);
		comboBox_showEmplo_inMYshop_Dell.setBounds(223, 214, 86, 21);
		contentPane.add(comboBox_showEmplo_inMYshop_Dell);

		btndell = new JButton("\u05DE\u05D7\u05E7");
		btndell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Employee my : Main.myShop.getEmployess())
					if (comboBox_showEmplo_inMYshop_Dell.getSelectedItem().equals(my.getFirstName())) {
						Main.myShop.removeEmployee(my);
						break;
					}

				dispose();
				Manager_window.main(null);
			}
		});

		btndell.setVisible(false);
		btndell.setBounds(238, 266, 85, 21);
		contentPane.add(btndell);

		JButton btndel = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05E2\u05D5\u05D1\u05D3");
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_dell_t();
				Visible_co_f();
				Visible_add_f();

				Label_id.setVisible(false);
				lLabel_phone.setVisible(false);
				Label_birthday.setVisible(false);
				Label_fname.setVisible(false);
				Label_lname.setVisible(false);
				Button_add_new_cusromer.setVisible(false);

			}
		});

		btndel.setBounds(0, 153, 103, 21);
		contentPane.add(btndel);

		lblCustomer_selection = new JLabel(
				" \u05D1\u05D7\u05D9\u05E8\u05EA \u05E2\u05D5\u05D1\u05D3\u05D9\u05DD \u05E7\u05D9\u05D9\u05DD:");
		lblCustomer_selection.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCustomer_selection.setBounds(322, 60, 133, 13);
		contentPane.add(lblCustomer_selection);

		labttl = new JLabel("\u05E2\u05D5\u05D1\u05D3\u05D9\u05DD");
		labttl.setFont(new Font("SansSerif", Font.BOLD, 30));
		labttl.setBounds(250, -20, 133, 68);
		contentPane.add(labttl);

		Label_id = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D6\u05D4\u05D5\u05EA:");
		Label_id.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_id.setVisible(false);
		Label_id.setBounds(301, 125, 82, 13);
		contentPane.add(Label_id);

		lLabel_phone = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lLabel_phone.setFont(new Font("SansSerif", Font.BOLD, 16));
		lLabel_phone.setVisible(false);
		lLabel_phone.setBounds(293, 156, 100, 13);
		contentPane.add(lLabel_phone);

		Label_birthday = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4:");
		Label_birthday.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_birthday.setVisible(false);
		Label_birthday.setBounds(298, 179, 95, 13);
		contentPane.add(Label_birthday);

		Label_fname = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		Label_fname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_fname.setVisible(false);
		Label_fname.setBounds(422, 99, 62, 13);
		contentPane.add(Label_fname);

		Label_lname = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		Label_lname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_lname.setVisible(false);
		Label_lname.setBounds(223, 99, 87, 13);
		contentPane.add(Label_lname);

		Label_show_id = new JLabel("New label");
		Label_show_id.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_id.setVisible(false);
		Label_show_id.setBounds(205, 125, 86, 13);
		contentPane.add(Label_show_id);

		Label_show_phone = new JLabel("New label");
		Label_show_phone.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_phone.setVisible(false);
		Label_show_phone.setBounds(205, 156, 78, 13);
		contentPane.add(Label_show_phone);

		Label_show_birthday = new JLabel("New label");
		Label_show_birthday.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_birthday.setVisible(false);
		Label_show_birthday.setBounds(195, 182, 80, 13);
		contentPane.add(Label_show_birthday);

		textField_fnane = new JTextField();
		textField_fnane.setVisible(false);
		textField_fnane.setBounds(316, 96, 96, 19);
		contentPane.add(textField_fnane);
		textField_fnane.setColumns(10);

		textField_lname = new JTextField();
		textField_lname.setVisible(false);
		textField_lname.setBounds(133, 96, 96, 19);
		contentPane.add(textField_lname);
		textField_lname.setColumns(10);

		textField_id = new JTextField();
		textField_id.setVisible(false);
		textField_id.setBounds(195, 122, 96, 19);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		textField_phone = new JTextField();
		textField_phone.setVisible(false);
		textField_phone.setBounds(201, 153, 96, 19);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);

		textField_birthday = new JTextField();
		textField_birthday.setVisible(false);
		textField_birthday.setBounds(192, 179, 96, 19);
		contentPane.add(textField_birthday);
		textField_birthday.setColumns(10);

		Label_show_fname = new JLabel("New label");
		Label_show_fname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_fname.setVisible(false);
		Label_show_fname.setBounds(331, 99, 77, 13);
		contentPane.add(Label_show_fname);

		Label_show_lname = new JLabel("New label");
		Label_show_lname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_lname.setVisible(false);
		Label_show_lname.setBounds(133, 99, 99, 13);
		contentPane.add(Label_show_lname);

		JComboBox comboBox_show_cusromer = new JComboBox();
		comboBox_show_cusromer.addItem("");
		for (Employee emp : Main.allEmployees)
			comboBox_show_cusromer.addItem(emp.getFirstName());

		comboBox_show_cusromer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (Employee emp : Main.allEmployees)
					if (comboBox_show_cusromer.getSelectedItem().equals(emp.getFirstName())) {
						flag = true;
						Visible_co_t();
						Visible_add_f();
						Visible_dell_f();
						Label_show_lname.setText(emp.getLastName());
						Label_show_fname.setText(emp.getFirstName());
						Label_show_phone.setText(emp.getPhoneNumber());
						Label_show_birthday.setText(emp.getDateOfBirth());
						Label_show_id.setText(emp.getID());
						break;
					} else {
						Visible_co_f();
					}
			}
		});

		Button_add_new_cusromer = new JButton("\u05D4\u05D5\u05E1\u05E3");
		Button_add_new_cusromer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Employee emp : Main.allEmployees)
					if (comboBox_show_cusromer.getSelectedItem().equals(emp.getFirstName())) {

						try {
							Main.myShop.addEmployee(emp);
						} catch (EmployeeAlreadyExistsException e1) {
							JOptionPane.showMessageDialog(null, "עובד כבר קיים במערכת");
							e1.printStackTrace();
						}
						break;

					}

				if (!textField_id.getText().isEmpty()) {
					try {
						Main.myShop.addEmployee(new Employee(textField_id.getText(), textField_fnane.getText(),
								textField_lname.getText(), textField_phone.getText(), textField_birthday.getText()));
						JOptionPane.showMessageDialog(null, "עובד נוסף בהצלחה");
					} catch (EmployeeAlreadyExistsException e1) {
						JOptionPane.showMessageDialog(null, "עובד כבר קיים במערכת");
						e1.printStackTrace();
					} catch (WrongInput e1) {
						JOptionPane.showMessageDialog(null, "שגיאה בפרטי העובד. אנא בדוק ונסה שנית", "Invalid input",
								JOptionPane.PLAIN_MESSAGE);
						e1.printStackTrace();
					}

				}

				dispose();
				Manager_window.main(null);

			}
		});
		Button_add_new_cusromer.setVisible(false);
		Button_add_new_cusromer.setBounds(237, 266, 96, 21);
		contentPane.add(Button_add_new_cusromer);

		comboBox_show_cusromer.setBounds(223, 58, 89, 21);
		contentPane.add(comboBox_show_cusromer);

		JButton Button_show_add = new JButton(
				"\u05D4\u05D5\u05E4\u05E1\u05EA \u05E2\u05D5\u05D1\u05D3 \u05D7\u05D3\u05E9");
		Button_show_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = false;
				Visible_add_t();
				Visible_co_f();
				Visible_dell_f();

			}
		});

		JLabel lblNewpage = new JLabel("\u05E2\u05D5\u05D1\u05D3\u05D9\u05DD");
		lblNewpage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewpage.setForeground(Color.WHITE);
		lblNewpage.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblNewpage.setBorder(new LineBorder(Color.WHITE));
		lblNewpage.setBackground(Color.WHITE);
		lblNewpage.setBounds(0, 0, 103, 33);
		contentPane.add(lblNewpage);
		Button_show_add.setBounds(0, 108, 103, 21);
		contentPane.add(Button_show_add);

		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
		Button_return.setBounds(0, 336, 103, 21);
		contentPane.add(Button_return);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(429, 283, 91, 64);
		contentPane.add(Label_logo_yvc);

		JLabel lblside = new JLabel("");
		lblside.setHorizontalAlignment(SwingConstants.CENTER);
		lblside.setBounds(0, 0, 103, 357);
		lblside.setIcon(new ImageIcon(newImage3));
		contentPane.add(lblside);

		JLabel Label_logo_background = new JLabel("");
		Label_logo_background.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_background.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_background.setIcon(new ImageIcon(newImage));
		Label_logo_background.setBounds(0, 0, 530, 357);
		contentPane.add(Label_logo_background);

	}
}