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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import classes.Customer;
import db.DBconnect;
import exceptions.CustomerAlreadyExistsException;
import exceptions.WrongInput;
import main.Main;

public class Customer_showandadd extends JFrame {

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
	private static JButton btn_del;
	private static JComboBox comboBox_namecusro_inTheshop;
	private static JLabel lblNewLabel_1111;
	private JButton btn_Switch_show;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void Visible_co_t1() { for ( Customer customer : allCustomers)
	 * {
	 * 
	 * //comboBox_show_cusromer.add(null, customer.getFirstName()+""); }
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

	public static void Visible_dell_t() {

		lblNewLabel_1111.setVisible(true);
		comboBox_namecusro_inTheshop.setVisible(true);
		btn_del.setVisible(true);
	}

	public static void Visible_dell_f() {

		lblNewLabel_1111.setVisible(false);
		comboBox_namecusro_inTheshop.setVisible(false);
		btn_del.setVisible(false);
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

		lblNewLabel_1111 = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05DC\u05E7\u05D5\u05D7:");
		lblNewLabel_1111.setVisible(false);
		lblNewLabel_1111.setBounds(294, 205, 70, 13);
		contentPane.add(lblNewLabel_1111);

		btn_Switch_show = new JButton("\u05D4\u05E6\u05D2\u05EA \u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		btn_Switch_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					DBconnect.updtaeDB();
				} catch (WrongInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				customer_show Customer_win_show = new customer_show();
				Customer_win_show.setVisible(true);
			}
		});
		btn_Switch_show.setBounds(0, 178, 103, 21);
		contentPane.add(btn_Switch_show);

		comboBox_namecusro_inTheshop = new JComboBox();
		comboBox_namecusro_inTheshop.addItem("");
		for (Customer my : Main.myShop.getCustomer())
			comboBox_namecusro_inTheshop.addItem(my.getFirstName());

		comboBox_namecusro_inTheshop.setVisible(false);
		comboBox_namecusro_inTheshop.setBounds(201, 202, 86, 21);
		contentPane.add(comboBox_namecusro_inTheshop);

		btn_del = new JButton("\u05DE\u05D7\u05E7");
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Customer my : Main.myShop.getCustomer())
					if (comboBox_namecusro_inTheshop.getSelectedItem().equals(my.getFirstName())) {
						Main.myShop.removeCustomer(my);
						break;
					}

				dispose();
				Manager_window.main(null);
			}
		});

		btn_del.setVisible(false);
		btn_del.setBounds(208, 265, 85, 21);
		contentPane.add(btn_del);

		JButton btn_delcustomer = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05DC\u05E7\u05D5\u05D7");
		btn_delcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_dell_t();
				Visible_add_f();
				Visible_co_f();
				Label_id.setVisible(false);
				lLabel_phone.setVisible(false);
				Label_birthday.setVisible(false);
				Label_fname.setVisible(false);
				Label_lname.setVisible(false);
				Label_email.setVisible(false);
				Button_add_new_cusromer.setVisible(false);

			}
		});
		btn_delcustomer.setBounds(0, 63, 103, 21);
		contentPane.add(btn_delcustomer);

		lblNewLabel = new JLabel(" \u05D1\u05D7\u05D9\u05E8\u05EA \u05DC\u05E7\u05D5\u05D7 \u05E7\u05D9\u05D9\u05DD:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(305, 65, 102, 13);
		contentPane.add(lblNewLabel);

		lab123 = new JLabel("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		lab123.setFont(new Font("SansSerif", Font.BOLD, 30));
		lab123.setBounds(248, -13, 133, 68);
		contentPane.add(lab123);

		Label_id = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D6\u05D4\u05D5\u05EA:");
		Label_id.setVisible(false);
		Label_id.setBounds(216, 103, 68, 13);
		contentPane.add(Label_id);

		lLabel_phone = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lLabel_phone.setVisible(false);
		lLabel_phone.setBounds(213, 136, 71, 13);
		contentPane.add(lLabel_phone);

		Label_birthday = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4:");
		Label_birthday.setVisible(false);
		Label_birthday.setBounds(214, 159, 71, 13);
		contentPane.add(Label_birthday);

		Label_email = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC:");
		Label_email.setVisible(false);
		Label_email.setBounds(242, 182, 34, 13);
		contentPane.add(Label_email);

		Label_fname = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		Label_fname.setVisible(false);
		Label_fname.setBounds(407, 136, 62, 13);
		contentPane.add(Label_fname);

		Label_lname = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		Label_lname.setVisible(false);
		Label_lname.setBounds(407, 152, 71, 13);
		contentPane.add(Label_lname);

		Label_show_id = new JLabel("New label");
		Label_show_id.setVisible(false);
		Label_show_id.setBounds(146, 103, 45, 13);
		contentPane.add(Label_show_id);

		Label_show_phone = new JLabel("New label");
		Label_show_phone.setVisible(false);
		Label_show_phone.setBounds(146, 136, 45, 13);
		contentPane.add(Label_show_phone);

		Label_show_birthday = new JLabel("New label");
		Label_show_birthday.setVisible(false);
		Label_show_birthday.setBounds(146, 159, 45, 13);
		contentPane.add(Label_show_birthday);

		Label_show_email = new JLabel("New label");
		Label_show_email.setVisible(false);
		Label_show_email.setBounds(146, 182, 45, 13);
		contentPane.add(Label_show_email);

		textField_fnane = new JTextField();
		textField_fnane.setVisible(false);
		textField_fnane.setBounds(311, 133, 96, 19);
		contentPane.add(textField_fnane);
		textField_fnane.setColumns(10);

		textField_lname = new JTextField();
		textField_lname.setVisible(false);
		textField_lname.setBounds(311, 156, 96, 19);
		contentPane.add(textField_lname);
		textField_lname.setColumns(10);

		textField_id = new JTextField();
		textField_id.setVisible(false);
		textField_id.setBounds(110, 100, 96, 19);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		textField_phone = new JTextField();
		textField_phone.setVisible(false);
		textField_phone.setBounds(107, 133, 96, 19);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);

		textField_birthday = new JTextField();
		textField_birthday.setVisible(false);
		textField_birthday.setBounds(108, 156, 96, 19);
		contentPane.add(textField_birthday);
		textField_birthday.setColumns(10);

		textField_email = new JTextField();
		textField_email.setVisible(false);
		textField_email.setBounds(110, 179, 96, 19);
		contentPane.add(textField_email);
		textField_email.setColumns(10);

		Label_show_fname = new JLabel("New label");
		Label_show_fname.setVisible(false);
		Label_show_fname.setBounds(352, 136, 45, 13);
		contentPane.add(Label_show_fname);

		Label_show_lname = new JLabel("New label");
		Label_show_lname.setVisible(false);
		Label_show_lname.setBounds(362, 159, 45, 13);
		contentPane.add(Label_show_lname);

		JComboBox comboBox_show_cusromer = new JComboBox();

		comboBox_show_cusromer.addItem("");
		for (Customer cu : Main.allCustomers)
			comboBox_show_cusromer.addItem(cu.getFirstName());

		comboBox_show_cusromer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (Customer cu : Main.allCustomers)
					if (comboBox_show_cusromer.getSelectedItem().equals(cu.getFirstName())) {
						Visible_co_t();
						Visible_add_f();
						Visible_dell_f();
						Label_show_lname.setText(cu.getLastName());
						Label_show_fname.setText(cu.getFirstName());
						Label_show_phone.setText(cu.getPhoneNumber());
						Label_show_birthday.setText(cu.getDateOfBirth());
						Label_show_id.setText(cu.getID());
						Label_show_email.setText(cu.getEmail());
						break;
					} else {
						Visible_co_f();
					}
			}
		});

		Button_add_new_cusromer = new JButton("\u05D4\u05D5\u05E1\u05E3");

		Button_add_new_cusromer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Customer cus : Main.allCustomers)
					if (comboBox_show_cusromer.getSelectedItem().equals(cus.getFirstName())) {

						try {
							Main.myShop.addCustomer(cus);
						} catch (CustomerAlreadyExistsException c1) {
							// TODO Auto-generated catch block
							c1.printStackTrace();
						}
						break;

					}
				if (!textField_id.getText().isEmpty()) {

					try {
						Main.myShop.addCustomer(new Customer(textField_id.getText(), textField_fnane.getText(),
								textField_lname.getText(), textField_phone.getText(), textField_birthday.getText(),
								textField_email.getText()));
						JOptionPane.showMessageDialog(null, "ברוך הבא ");
					} catch (CustomerAlreadyExistsException c1) {
						// TODO Auto-generated catch block
						c1.printStackTrace();
					} catch (WrongInput c1) {
						// TODO Auto-generated catch block
						c1.printStackTrace();
					}
				}

				dispose();
				Manager_window.main(null);

			}
		});

		Button_add_new_cusromer.setVisible(false);
		Button_add_new_cusromer.setBounds(200, 237, 96, 21);
		contentPane.add(Button_add_new_cusromer);

		comboBox_show_cusromer.setBounds(173, 63, 89, 21);
		contentPane.add(comboBox_show_cusromer);

		JButton Button_show_add = new JButton(
				"\u05D4\u05D5\u05E4\u05E1\u05EA \u05DC\u05E7\u05D5\u05D7 \u05D7\u05D3\u05E9");
		Button_show_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_add_t();
				Visible_co_f();
				Visible_dell_f();

			}
		});
		Button_show_add.setBounds(0, 114, 103, 21);
		contentPane.add(Button_show_add);

		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
		Button_return.setBounds(0, 331, 106, 21);
		contentPane.add(Button_return);

		JLabel lblNewLabel_12 = new JLabel("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_12.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBackground(Color.WHITE);
		lblNewLabel_12.setBounds(0, 0, 103, 33);
		contentPane.add(lblNewLabel_12);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(433, 283, 91, 64);
		contentPane.add(Label_logo_yvc);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 103, 357);
		lblNewLabel.setIcon(new ImageIcon(newImage3));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_111 = new JLabel("");
		lblNewLabel_111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_111.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_111.setIcon(new ImageIcon(newImage));
		lblNewLabel_111.setBounds(0, 0, 530, 357);
		contentPane.add(lblNewLabel_111);

	}
}
