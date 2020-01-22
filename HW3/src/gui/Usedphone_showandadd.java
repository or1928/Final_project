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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classes.UsedPhone;
import db.DBconnect;
import enums.brand;
import enums.condition;
import exceptions.WrongInput;
import main.Main;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Usedphone_showandadd extends JFrame {

	private static JPanel contentPane;
	private static JTextField textField_year;
	private static JTextField textField_date;
	private static JLabel lbphonelection;
	private static JButton btn_dell;
	private static JComboBox comboBox_type;
	private static JTextField textField_namephon;
	private static JComboBox comboBox_company;
	private static JLabel lblcompany;
	private static JButton btnadd, btn_Switch_show;
	private static JLabel lblyear;
	private static JLabel lbltype;
	private static JLabel lblprice;
	private static JLabel lblNewname;
	private static JComboBox comboBox_phonelection;
	private static JLabel lblname;
	private static JLabel lblNewyear;
	private static JLabel lblNewtype;
	private static JLabel lblNewprice;
	private static JLabel lblNewcomp_13;
	private JLabel labelphon;

	/**
	 * Launch the application.
	 */
	public static void Visible_co_t() {
		lblname.setVisible(true);
		lblNewyear.setVisible(true);
		lblNewtype.setVisible(true);
		lblNewprice.setVisible(true);
		lblNewcomp_13.setVisible(true);
		textField_date.setVisible(true);
		lblNewname.setVisible(true);
		lblyear.setVisible(true);
		lblcompany.setVisible(true);
		lbltype.setVisible(true);
		lblprice.setVisible(true);
		lblcompany.setVisible(true);
		btnadd.setVisible(true);
	}

	public static void Visible_co_f() {

		lblname.setVisible(false);
		lblNewyear.setVisible(false);
		lblNewtype.setVisible(false);
		lblNewprice.setVisible(false);
		lblNewcomp_13.setVisible(false);
		textField_date.setVisible(false);
		lblNewname.setVisible(false);
		lblyear.setVisible(false);
		lblcompany.setVisible(false);
		lbltype.setVisible(false);
		lblprice.setVisible(false);
		lblcompany.setVisible(false);
		btnadd.setVisible(false);
	}

	// co
	public static void Visible_add_t() {
		btnadd.setVisible(true);
		comboBox_company.setVisible(true);
		comboBox_type.setVisible(true);
		textField_year.setVisible(true);
		textField_namephon.setVisible(true);
		textField_date.setVisible(true);
		lblNewname.setVisible(true);
		lblyear.setVisible(true);
		lblcompany.setVisible(true);
		lbltype.setVisible(true);
		lblprice.setVisible(true);
		lblcompany.setVisible(true);

	}

	public static void Visible_add_f() {

		btnadd.setVisible(false);
		comboBox_company.setVisible(false);
		comboBox_type.setVisible(false);
		textField_year.setVisible(false);
		textField_namephon.setVisible(false);
		textField_date.setVisible(false);
		lblNewname.setVisible(false);
		lblyear.setVisible(false);
		lblcompany.setVisible(false);
		lbltype.setVisible(false);
		lblprice.setVisible(false);
		lblcompany.setVisible(false);
	}

	// co
	public static void Visible_dell_t() {

		lbphonelection.setVisible(true);
		comboBox_phonelection.setVisible(true);
		btn_dell.setVisible(true);
	}

	public static void Visible_dell_f() {

		lbphonelection.setVisible(false);
		comboBox_phonelection.setVisible(false);
		btn_dell.setVisible(false);
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

		Image img = new ImageIcon(this.getClass().getResource("/br.jpg")).getImage();
		Image newImage = img.getScaledInstance(530, 357, Image.SCALE_DEFAULT);
		
		Image img1 = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64, Image.SCALE_DEFAULT);

		Image img3 = new ImageIcon(this.getClass().getResource("/brs1.jpg")).getImage();
		Image newImage3 = img3.getScaledInstance(103, 357, Image.SCALE_DEFAULT);

		btn_Switch_show = new JButton("\u05D4\u05E6\u05D2\u05EA \u05DE\u05D7\u05E1\u05DF");
		btn_Switch_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					DBconnect.updtaeDB();
				} catch (WrongInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				usedphone_show UsedPhone_win_show = new usedphone_show();
				UsedPhone_win_show.setVisible(true);
			}
		});
		btn_Switch_show.setBounds(0, 158, 103, 21);
		contentPane.add(btn_Switch_show);

		lbphonelection = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05E4\u05DC\u05D0:");
		lbphonelection.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lbphonelection.setVisible(false);
		lbphonelection.setBounds(442, 174, 76, 13);
		contentPane.add(lbphonelection);

		comboBox_phonelection = new JComboBox();
		comboBox_phonelection.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_phonelection.addItem("בחר פלאפון");
		for (UsedPhone my : Main.myShop.getPhones())
			if (my.isInShop == 1) {
				comboBox_phonelection.addItem(my.getModelNo());
			}

		comboBox_phonelection.setVisible(false);
		comboBox_phonelection.setBounds(358, 170, 86, 21);
		contentPane.add(comboBox_phonelection);

		btn_dell = new JButton("\u05DE\u05D7\u05E7");
		btn_dell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (UsedPhone my : Main.myShop.getPhones())
					if (comboBox_phonelection.getSelectedItem().equals(my.getModelNo())) {
						Main.myShop.removePhone(my);
						break;
					}

				dispose();
				Manager_window.main(null);
			}
		});
		btn_dell.setVisible(false);
		btn_dell.setBounds(284, 228, 85, 21);
		contentPane.add(btn_dell);

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

		comboBox_type = new JComboBox();
		comboBox_type.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		comboBox_type.addItem("");
		comboBox_type.addItem("Used");
		comboBox_type.addItem("New");
		comboBox_type.addItem("asNew");
		comboBox_type.setBounds(183, 95, 53, 21);
		comboBox_type.setVisible(false);

		contentPane.add(comboBox_type);

		lblcompany = new JLabel("\u05D7\u05D1\u05E8\u05D4:");
		lblcompany.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblcompany.setBounds(284, 174, 45, 13);
		lblcompany.setVisible(false);
		contentPane.add(lblcompany);

		textField_date = new JTextField();
		textField_date.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		textField_date.setBounds(178, 138, 96, 19);
		textField_date.setVisible(false);
		contentPane.add(textField_date);
		textField_date.setColumns(10);

		textField_year = new JTextField();
		textField_year.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		textField_year.setBounds(348, 138, 96, 19);
		textField_year.setVisible(false);
		contentPane.add(textField_year);
		textField_year.setColumns(10);

		comboBox_company = new JComboBox();
		comboBox_company.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));

		comboBox_company.setBounds(214, 170, 60, 21);
		comboBox_company.addItem("");
		comboBox_company.addItem("Apple");
		comboBox_company.addItem("Samsung");
		comboBox_company.addItem("LG");
		comboBox_company.addItem("Xiaomi");
		comboBox_company.setVisible(false);
		contentPane.add(comboBox_company);

		textField_namephon = new JTextField();
		textField_namephon.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		textField_namephon.setBounds(348, 95, 96, 19);
		textField_namephon.setVisible(false);
		contentPane.add(textField_namephon);
		textField_namephon.setColumns(10);

		JLabel lblttl = new JLabel("\u05DE\u05D7\u05E1\u05DF");
		lblttl.setFont(new Font("SansSerif", Font.BOLD, 36));
		lblttl.setBounds(251, -11, 118, 64);
		contentPane.add(lblttl);

		lblyear = new JLabel("\u05E9\u05E0\u05D4:");
		lblyear.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblyear.setVisible(false);

		JComboBox comboBox_show_phon = new JComboBox();
		comboBox_show_phon.addItem("בחר פלאפון");
		for (UsedPhone uphone : Main.allusedPhones)
			comboBox_show_phon.addItem(uphone.getModelNo());

		comboBox_show_phon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (UsedPhone uphone : Main.allusedPhones)
					if (comboBox_show_phon.getSelectedItem().equals(uphone.getModelNo())) {
						Visible_co_t();
						Visible_add_t();
						Visible_dell_f();
						textField_namephon.setVisible(false);
						textField_year.setVisible(false);
						textField_date.setVisible(false);
						comboBox_phonelection.setVisible(false);
						comboBox_company.setVisible(false);
						comboBox_type.setVisible(false);
						lblname.setText(uphone.getModelNo());
						lblNewyear.setText(String.valueOf(uphone.getManufactureYear()));
						lblNewtype.setText(String.valueOf(uphone.getPhoneCondition()));
						lblNewcomp_13.setText(String.valueOf(uphone.getPhoneBrand()));
						lblNewprice.setText(String.valueOf(uphone.getPrice()));

						break;
					} else {
						Visible_co_f();
					}
			}
		});

		comboBox_show_phon.setBounds(217, 59, 81, 21);
		contentPane.add(comboBox_show_phon);

		btnadd = new JButton("\u05D4\u05D5\u05E1\u05E3");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (UsedPhone uPhone : Main.allusedPhones)
					if (comboBox_show_phon.getSelectedItem().equals(uPhone.getModelNo())) {

						try {
							Main.myShop.addPhone(uPhone);

						} catch (AlreadyBoundException p1) {
							// TODO Auto-generated catch block
							p1.printStackTrace();
						}
						break;

					}
				if (!textField_namephon.getText().isEmpty()) {

					try {
						// condition.valueOf(comboBox_2.getSelectedItem())
						// brand.valueOf(comboBox_1.getSelectedItem())
						String em = (String) comboBox_type.getSelectedItem();
						String em1 = (String) comboBox_company.getSelectedItem();
						Main.myShop.addPhone(new UsedPhone(textField_namephon.getText(), Integer.parseInt(textField_year.getText()),
								condition.valueOf(em), Integer.parseInt(textField_date.getText()), brand.valueOf(em1)));
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

		btnadd.setVisible(false);
		btnadd.setBounds(284, 228, 85, 21);
		contentPane.add(btnadd);

		lblyear.setBounds(473, 142, 45, 13);
		contentPane.add(lblyear);

		lbltype = new JLabel("\u05DE\u05E6\u05D1 \u05D4\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lbltype.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lbltype.setVisible(false);
		lbltype.setBounds(253, 98, 86, 13);
		contentPane.add(lbltype);

		lblprice = new JLabel("\u05DE\u05D7\u05D9\u05E8:");
		lblprice.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblprice.setVisible(false);
		lblprice.setBounds(284, 141, 45, 13);
		contentPane.add(lblprice);

		lblNewname = new JLabel("\u05E9\u05DD \u05DE\u05DB\u05E9\u05D9\u05E8:");
		lblNewname.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblNewname.setVisible(false);

		lblname = new JLabel("New label");
		lblname.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblname.setVisible(false);
		lblname.setBounds(358, 98, 81, 13);
		contentPane.add(lblname);

		lblNewyear = new JLabel("New label");
		lblNewyear.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblNewyear.setVisible(false);
		lblNewyear.setBounds(379, 141, 60, 13);
		contentPane.add(lblNewyear);

		lblNewtype = new JLabel("New label");
		lblNewtype.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblNewtype.setVisible(false);
		lblNewtype.setBounds(178, 99, 65, 13);
		contentPane.add(lblNewtype);

		lblNewprice = new JLabel("New label");
		lblNewprice.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblNewprice.setVisible(false);
		lblNewprice.setBounds(183, 141, 91, 13);
		contentPane.add(lblNewprice);

		lblNewcomp_13 = new JLabel("New label");
		lblNewcomp_13.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewcomp_13.setVisible(false);
		
		labelphon = new JLabel("\u05DE\u05D7\u05E1\u05DF");
		labelphon.setHorizontalAlignment(SwingConstants.CENTER);
		labelphon.setForeground(Color.WHITE);
		labelphon.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		labelphon.setBorder(new LineBorder(Color.WHITE));
		labelphon.setBackground(Color.WHITE);
		labelphon.setBounds(0, 0, 103, 33);
		contentPane.add(labelphon);
		lblNewcomp_13.setBounds(199, 174, 88, 13);
		contentPane.add(lblNewcomp_13);

		JLabel lblusdephon_selection = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05E4\u05DC\u05D0:");
		lblusdephon_selection.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblusdephon_selection.setBounds(308, 64, 79, 13);
		contentPane.add(lblusdephon_selection);
		lblNewname.setBounds(444, 99, 86, 13);
		contentPane.add(lblNewname);

		JButton btnaddnew = new JButton(
				"\u05DE\u05DB\u05E9\u05D9\u05E8 \u05D7\u05D3\u05E9");
		btnaddnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visible_dell_f();
				Visible_co_f();
				Visible_add_t();

			}
		});
		btnaddnew.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnaddnew.setBounds(0, 59, 103, 21);
		contentPane.add(btnaddnew);

		JButton btndell = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05DE\u05DB\u05E9\u05D9\u05E8");
		btndell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visible_co_f();
				Visible_add_f();
				Visible_dell_t();
				lblname.setVisible(false);

			}
		});
		btndell.setBounds(0, 110, 103, 21);
		contentPane.add(btndell);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(427, 280, 91, 64);
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
