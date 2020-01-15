package gui;

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

import classes.Provider;
import exceptions.ProvidersAlreadyExistsException;
import exceptions.WrongInput;
import main.Main;

public class Provider_showandadd extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_fnane;
	private static JTextField textField_lname;
	private static JTextField textField_id;
	private static JTextField textField_phone;
	private static JTextField textField_birthday;
	private static JLabel lblNewLabel;
	private static JLabel lab123;
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
	private static JLabel lblNewLabel_1;
	private static JComboBox comboBox;
	private static JButton btn_Switch_show;
	private static JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

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

		lblNewLabel_1.setVisible(true);
		comboBox.setVisible(true);
		btnNewButton_1.setVisible(true);
	}

	public static void Visible_dell_f() {

		lblNewLabel_1.setVisible(false);
		comboBox.setVisible(false);
		btnNewButton_1.setVisible(false);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Provider_showandadd frame = new Provider_showandadd();
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
	public Provider_showandadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 544, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image img = new ImageIcon(this.getClass().getResource("/cellphone_background_x1.png")).getImage();
		Image newImage = img.getScaledInstance(530, 357, Image.SCALE_DEFAULT);
		Image img1 = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64, Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		
		

		btn_Switch_show = new JButton("\u05D4\u05E6\u05D2\u05EA \u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		btn_Switch_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				dispose();
				provider_show provider_win_show = new provider_show();
				provider_win_show.setVisible(true);
			}
		});
		btn_Switch_show.setBounds(0, 27, 96, 21);
		contentPane.add(btn_Switch_show);
		

		lblNewLabel_1 = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05E1\u05E4\u05E7");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(261, 154, 70, 13);
		contentPane.add(lblNewLabel_1);

		comboBox = new JComboBox();
		comboBox.addItem("");
		for (Provider my : Main.myShop.getProviders())
			comboBox.addItem(my.getFirstName());
		comboBox.setVisible(false);
		comboBox.setBounds(165, 150, 86, 21);
		contentPane.add(comboBox);

		btnNewButton_1 = new JButton("\u05DE\u05D7\u05E7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Provider my : Main.myShop.getProviders())
					if (comboBox.getSelectedItem().equals(my.getFirstName())) {
						Main.myShop.removeProvider(my);
						break;
					}

				dispose();
				Manager_window.main(null);
			}
		});
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(166, 232, 85, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05E1\u05E4\u05E7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_dell_t();
				Visible_add_f();
				Visible_co_f();
				Label_id.setVisible(false);
				lLabel_phone.setVisible(false);
				Label_birthday.setVisible(false);
				Label_fname.setVisible(false);
				Label_lname.setVisible(false);
				Button_add_new_cusromer.setVisible(false);
			}
		});
		btnNewButton.setBounds(153, 89, 108, 21);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel(" \u05D1\u05D7\u05D9\u05E8\u05EA \u05E1\u05E4\u05E7 \u05E7\u05D9\u05D9\u05DD:");
		lblNewLabel.setBounds(322, 60, 102, 13);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		contentPane.add(lblNewLabel);

		lab123 = new JLabel("\u05E1\u05E4\u05E7\u05D9\u05DD");
		lab123.setBounds(154, -20, 133, 68);
		lab123.setFont(new Font("SansSerif", Font.BOLD, 30));
		contentPane.add(lab123);

		Label_id = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D6\u05D4\u05D5\u05EA:");
		Label_id.setBounds(140, 121, 68, 13);
		Label_id.setVisible(false);
		contentPane.add(Label_id);

		lLabel_phone = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lLabel_phone.setBounds(137, 154, 71, 13);
		lLabel_phone.setVisible(false);
		contentPane.add(lLabel_phone);

		Label_birthday = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4:");
		Label_birthday.setBounds(138, 177, 71, 13);
		Label_birthday.setVisible(false);
		contentPane.add(Label_birthday);

		Label_fname = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		Label_fname.setBounds(331, 154, 62, 13);
		Label_fname.setVisible(false);
		contentPane.add(Label_fname);

		Label_lname = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		Label_lname.setBounds(331, 170, 71, 13);
		Label_lname.setVisible(false);
		contentPane.add(Label_lname);

		Label_show_id = new JLabel("New label");
		Label_show_id.setBounds(70, 121, 45, 13);
		Label_show_id.setVisible(false);
		contentPane.add(Label_show_id);

		Label_show_phone = new JLabel("New label");
		Label_show_phone.setBounds(70, 154, 45, 13);
		Label_show_phone.setVisible(false);
		contentPane.add(Label_show_phone);

		Label_show_birthday = new JLabel("New label");
		Label_show_birthday.setBounds(70, 177, 45, 13);
		Label_show_birthday.setVisible(false);
		contentPane.add(Label_show_birthday);

		textField_fnane = new JTextField();
		textField_fnane.setBounds(235, 151, 96, 19);
		textField_fnane.setVisible(false);
		contentPane.add(textField_fnane);
		textField_fnane.setColumns(10);

		textField_lname = new JTextField();
		textField_lname.setBounds(235, 174, 96, 19);
		textField_lname.setVisible(false);
		contentPane.add(textField_lname);
		textField_lname.setColumns(10);

		textField_id = new JTextField();
		textField_id.setBounds(34, 118, 96, 19);
		textField_id.setVisible(false);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		textField_phone = new JTextField();
		textField_phone.setBounds(31, 151, 96, 19);
		textField_phone.setVisible(false);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);

		textField_birthday = new JTextField();
		textField_birthday.setBounds(32, 174, 96, 19);
		textField_birthday.setVisible(false);
		contentPane.add(textField_birthday);
		textField_birthday.setColumns(10);

		Label_show_fname = new JLabel("New label");
		Label_show_fname.setBounds(261, 154, 45, 13);
		Label_show_fname.setVisible(false);
		contentPane.add(Label_show_fname);

		Label_show_lname = new JLabel("New label");
		Label_show_lname.setBounds(261, 170, 45, 13);
		Label_show_lname.setVisible(false);
		contentPane.add(Label_show_lname);

		JComboBox comboBox_show_cusromer = new JComboBox();
		comboBox_show_cusromer.setBounds(223, 58, 89, 21);
		comboBox_show_cusromer.addItem("");
		for (Provider pro : Main.allProviders)
			comboBox_show_cusromer.addItem(pro.getFirstName());

		comboBox_show_cusromer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (Provider pro : Main.allProviders)
					if (comboBox_show_cusromer.getSelectedItem().equals(pro.getFirstName())) {
						Visible_co_t();
						Visible_add_f();
						Visible_dell_f();
						Label_show_lname.setText(pro.getLastName());
						Label_show_fname.setText(pro.getFirstName());
						Label_show_phone.setText(pro.getPhoneNumber());
						Label_show_birthday.setText(pro.getDateOfBirth());
						Label_show_id.setText(pro.getID());

						break;
					} else {
						Visible_co_f();
					}
			}
		});
		contentPane.add(comboBox_show_cusromer);

		Button_add_new_cusromer = new JButton("\u05D4\u05D5\u05E1\u05E3");
		Button_add_new_cusromer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Provider pro : Main.allProviders)
					if (comboBox_show_cusromer.getSelectedItem().equals(pro.getFirstName())) {

						try {
							Main.myShop.addProvider(pro);
						} catch (ProvidersAlreadyExistsException p1) {
							// TODO Auto-generated catch block
							p1.printStackTrace();
						}
						break;

					}
				if (!textField_id.getText().isEmpty()) {

					try {
						Main.myShop.addProvider(new Provider(textField_id.getText(), textField_fnane.getText(),
								textField_lname.getText(), textField_phone.getText(), textField_birthday.getText()));
						JOptionPane.showMessageDialog(null, "ברוך הבא ");
					} catch (ProvidersAlreadyExistsException p1) {
						// TODO Auto-generated catch block
						p1.printStackTrace();
					} catch (WrongInput p1) {
						// TODO Auto-generated catch block
						p1.printStackTrace();
					}
				}

				dispose();
				Manager_window.main(null);

			}
		});
		Button_add_new_cusromer.setBounds(165, 232, 96, 21);
		Button_add_new_cusromer.setVisible(false);
		contentPane.add(Button_add_new_cusromer);

		JButton Button_show_add = new JButton("\u05D4\u05D5\u05E4\u05E1\u05EA \u05E1\u05E4\u05E7 \u05D7\u05D3\u05E9");
		Button_show_add.setBounds(30, 58, 133, 21);
		Button_show_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_add_t();
				Visible_co_f();
				Visible_dell_f();

			}
		});
		contentPane.add(Button_show_add);

		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.setBounds(0, 0, 85, 21);
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
		contentPane.add(Button_return);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setBounds(365, 193, 91, 64);
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		contentPane.add(Label_logo_yvc);

		JLabel lblNewLabel_111 = new JLabel("");
		lblNewLabel_111.setBounds(5, 5, 530, 357);
		lblNewLabel_111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_111.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_111.setIcon(new ImageIcon(newImage));
		contentPane.add(lblNewLabel_111);

	}
}
