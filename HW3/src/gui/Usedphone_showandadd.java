package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.channels.AlreadyBoundException;

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

import classes.UsedPhone;
import enums.brand;
import enums.condition;
import main.Main;

public class Usedphone_showandadd extends JFrame {

	private static JPanel contentPane;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JLabel lblNewLabel_11;
	private static JButton btnNewButton_111;
	private static JComboBox comboBox_2;
	private static JTextField textField;
	private static JComboBox comboBox_1;
	private static JLabel lblNewLabel_4;
	private static JButton btnNewButton_1,btn_Switch_show;
	private static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_6;
	private static JLabel lblNewLabel_2;
	private static JComboBox comboBox1;
	private static JLabel lblNewLabel_8;
	private static JLabel lblNewLabel_9;
	private static JLabel lblNewLabel_10;
	private static JLabel lblNewLabel_12;
	private static JLabel lblNewLabel_13;

	/**
	 * Launch the application.
	 */
	public static void Visible_co_t() {
		lblNewLabel_8.setVisible(true);
		lblNewLabel_9.setVisible(true);
		lblNewLabel_10.setVisible(true);
		lblNewLabel_12.setVisible(true);
		lblNewLabel_13.setVisible(true);
		textField_2.setVisible(true);
		lblNewLabel_2.setVisible(true);
		lblNewLabel_3.setVisible(true);
		lblNewLabel_4.setVisible(true);
		lblNewLabel_5.setVisible(true);
		lblNewLabel_6.setVisible(true);
		lblNewLabel_4.setVisible(true);
		btnNewButton_1.setVisible(true);
	}

	public static void Visible_co_f() {

		lblNewLabel_8.setVisible(false);
		lblNewLabel_9.setVisible(false);
		lblNewLabel_10.setVisible(false);
		lblNewLabel_12.setVisible(false);
		lblNewLabel_13.setVisible(false);
		textField_2.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_6.setVisible(false);
		lblNewLabel_4.setVisible(false);
		btnNewButton_1.setVisible(false);
	}

	// co
	public static void Visible_add_t() {
		btnNewButton_1.setVisible(true);
		comboBox_1.setVisible(true);
		comboBox_2.setVisible(true);
		textField_1.setVisible(true);
		textField.setVisible(true);
		textField_2.setVisible(true);
		lblNewLabel_2.setVisible(true);
		lblNewLabel_3.setVisible(true);
		lblNewLabel_4.setVisible(true);
		lblNewLabel_5.setVisible(true);
		lblNewLabel_6.setVisible(true);
		lblNewLabel_4.setVisible(true);

	}

	public static void Visible_add_f() {

		btnNewButton_1.setVisible(false);
		comboBox_1.setVisible(false);
		comboBox_2.setVisible(false);
		textField_1.setVisible(false);
		textField.setVisible(false);
		textField_2.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_6.setVisible(false);
		lblNewLabel_4.setVisible(false);
	}

	// co
	public static void Visible_dell_t() {

		lblNewLabel_11.setVisible(true);
		comboBox1.setVisible(true);
		btnNewButton_111.setVisible(true);
	}

	public static void Visible_dell_f() {

		lblNewLabel_11.setVisible(false);
		comboBox1.setVisible(false);
		btnNewButton_111.setVisible(false);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usedphone_showandadd frame = new Usedphone_showandadd();
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
	public Usedphone_showandadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 544, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		Image img = new ImageIcon(this.getClass().getResource("/cellphone_background_x1.png")).getImage();
		Image newImage = img.getScaledInstance(530, 357, Image.SCALE_DEFAULT);
		Image img1 = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64, Image.SCALE_DEFAULT);

		

		btn_Switch_show = new JButton("\u05D4\u05E6\u05D2\u05EA \u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		btn_Switch_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				dispose();
				customer_show Customer_win_show = new customer_show();
				Customer_win_show.setVisible(true);
			}
		});
		btn_Switch_show.setBounds(0, 27, 96, 21);
		contentPane.add(btn_Switch_show);
		
		
		lblNewLabel_11 = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05E4\u05DC\u05D0");
		lblNewLabel_11.setVisible(false);
		lblNewLabel_11.setBounds(263, 118, 126, 13);
		contentPane.add(lblNewLabel_11);

		comboBox1 = new JComboBox();
		comboBox1.addItem("");
		for (UsedPhone my : Main.myShop.getPhones())
			comboBox1.addItem(my.getModelNo());

		comboBox1.setVisible(false);
		comboBox1.setBounds(151, 126, 86, 21);
		contentPane.add(comboBox1);

		btnNewButton_111 = new JButton("\u05DE\u05D7\u05E7");
		btnNewButton_111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (UsedPhone my : Main.myShop.getPhones())
					if (comboBox1.getSelectedItem().equals(my.getModelNo())) {
						Main.myShop.removePhone(my);
						break;
					}

				dispose();
				Manager_window.main(null);
			}
		});
		btnNewButton_111.setVisible(false);
		btnNewButton_111.setBounds(209, 170, 85, 21);
		contentPane.add(btnNewButton_111);

		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
		Button_return.setBounds(5, 6, 85, 21);
		contentPane.add(Button_return);

		comboBox_2 = new JComboBox();
		comboBox_2.addItem("");
		comboBox_2.addItem("Used");
		comboBox_2.addItem("New");
		comboBox_2.addItem("asNew");
		comboBox_2.setBounds(151, 75, 53, 21);
		comboBox_2.setVisible(false);

		contentPane.add(comboBox_2);

		lblNewLabel_4 = new JLabel("\u05D7\u05D1\u05E8\u05D4:");
		lblNewLabel_4.setBounds(208, 130, 45, 13);
		lblNewLabel_4.setVisible(false);
		contentPane.add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setBounds(108, 99, 96, 19);
		textField_2.setVisible(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(284, 119, 96, 19);
		textField_1.setVisible(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		comboBox_1 = new JComboBox();

		comboBox_1.setBounds(144, 126, 60, 21);
		comboBox_1.addItem("");
		comboBox_1.addItem("Apple");
		comboBox_1.addItem("Samsung");
		comboBox_1.addItem("LG");
		comboBox_1.addItem("Xiaomi");
		comboBox_1.setVisible(false);
		contentPane.add(comboBox_1);

		textField = new JTextField();
		textField.setBounds(284, 76, 96, 19);
		textField.setVisible(false);
		contentPane.add(textField);
		textField.setColumns(10);

		JTable table = new JTable();
		table.setBounds(106, 199, 259, 54);
		contentPane.add(table);

		JLabel lblNewLabel = new JLabel("\u05DE\u05D7\u05E1\u05DF");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
		lblNewLabel.setBounds(202, -23, 118, 64);
		contentPane.add(lblNewLabel);

		lblNewLabel_3 = new JLabel("\u05E9\u05E0\u05D4:");
		lblNewLabel_3.setVisible(false);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		for (UsedPhone uphone : Main.allusedPhones)
			comboBox.addItem(uphone.getModelNo());

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (UsedPhone uphone : Main.allusedPhones)
					if (comboBox.getSelectedItem().equals(uphone.getModelNo())) {
						Visible_co_t();
						Visible_add_t();
						Visible_dell_f();
						textField.setVisible(false);
						textField_1.setVisible(false);
						textField_2.setVisible(false);
						comboBox1.setVisible(false);
						comboBox_1.setVisible(false);
						comboBox_2.setVisible(false);
						lblNewLabel_8.setText(uphone.getModelNo());
						lblNewLabel_9.setText(String.valueOf(uphone.getManufactureYear()));
						lblNewLabel_10.setText(String.valueOf(uphone.getPhoneCondition()));
						lblNewLabel_13.setText(String.valueOf(uphone.getPhoneBrand()));
						lblNewLabel_12.setText(String.valueOf(uphone.getPrice()));

						break;
					} else {
						Visible_co_f();
					}
			}
		});

		comboBox.setBounds(299, 33, 81, 21);
		contentPane.add(comboBox);

		btnNewButton_1 = new JButton("\u05D4\u05D5\u05E1\u05E3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (UsedPhone uPhone : Main.allusedPhones)
					if (comboBox.getSelectedItem().equals(uPhone.getModelNo())) {

						try {
							Main.myShop.addPhone(uPhone);

						} catch (AlreadyBoundException p1) {
							// TODO Auto-generated catch block
							p1.printStackTrace();
						}
						break;

					}
				if (!textField.getText().isEmpty()) {

					try {
						// condition.valueOf(comboBox_2.getSelectedItem())
						// brand.valueOf(comboBox_1.getSelectedItem())
						String em = (String) comboBox_2.getSelectedItem();
						String em1 = (String) comboBox_1.getSelectedItem();
						Main.myShop.addPhone(new UsedPhone(textField.getText(), Integer.parseInt(textField_1.getText()),
								condition.valueOf(em), Integer.parseInt(textField_2.getText()), brand.valueOf(em1)));
						JOptionPane.showMessageDialog(null, "ברוך הבא ");
					} catch (AlreadyBoundException p1) {
						// TODO Auto-generated catch block
						p1.printStackTrace();
					}
				}

				dispose();
				Manager_window.main(null);

			}
		});

		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(209, 170, 85, 21);
		contentPane.add(btnNewButton_1);

		lblNewLabel_3.setBounds(411, 122, 45, 13);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_5 = new JLabel("\u05DE\u05E6\u05D1 \u05D4\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setBounds(208, 79, 76, 13);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("\u05DE\u05D7\u05D9\u05E8:");
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setBounds(208, 102, 45, 13);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_2 = new JLabel("\u05E9\u05DD \u05DE\u05DB\u05E9\u05D9\u05E8:");
		lblNewLabel_2.setVisible(false);

		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setVisible(false);
		lblNewLabel_8.setBounds(335, 79, 45, 13);
		contentPane.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setVisible(false);
		lblNewLabel_9.setBounds(335, 122, 45, 13);
		contentPane.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setVisible(false);
		lblNewLabel_10.setBounds(159, 79, 45, 13);
		contentPane.add(lblNewLabel_10);

		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setVisible(false);
		lblNewLabel_12.setBounds(151, 102, 45, 13);
		contentPane.add(lblNewLabel_12);

		lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setVisible(false);
		lblNewLabel_13.setBounds(177, 130, 45, 13);
		contentPane.add(lblNewLabel_13);

		JLabel lblNewLabel_7 = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05E4\u05DC\u05D0:");
		lblNewLabel_7.setBounds(379, 37, 60, 13);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_2.setBounds(390, 77, 66, 13);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton(
				"\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05DB\u05E9\u05D9\u05E8 \u05D7\u05D3\u05E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visible_dell_f();
				Visible_co_f();
				Visible_add_t();

			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton.setBounds(67, 31, 155, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton11 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05DE\u05DB\u05E9\u05D9\u05E8");
		btnNewButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visible_co_f();
				Visible_add_f();
				Visible_dell_t();
				lblNewLabel_8.setVisible(false);

			}
		});
		btnNewButton11.setBounds(186, 52, 108, 21);
		contentPane.add(btnNewButton11);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(375, 199, 91, 64);
		contentPane.add(Label_logo_yvc);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		lblNewLabel_1.setBounds(5, 5, 530, 357);
		contentPane.add(lblNewLabel_1);
	}
}
