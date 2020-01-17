package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import classes.Employee;
import classes.Sale;
import classes.UsedPhone;
import db.DBconnect;
import exceptions.WrongInput;
import main.Main;

public class Sale_showandadd extends JFrame {

	private JPanel contentPane;
	private JTextField textField_date;
	private static JButton btn_Switch_show;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale_showandadd frame = new Sale_showandadd();
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
	public Sale_showandadd() {
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

		btn_Switch_show = new JButton("\u05D4\u05E6\u05D2\u05EA \u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		btn_Switch_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					DBconnect.updtaeDB();
				} catch (WrongInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				sale_show sale_win_show = new sale_show();
				sale_win_show.setVisible(true);
			}
		});
		btn_Switch_show.setBounds(0, 154, 103, 21);
		contentPane.add(btn_Switch_show);

		JLabel lblsaleselection = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05D4\u05D6\u05DE\u05E0\u05D4:");
		lblsaleselection.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblsaleselection.setVisible(false);
		lblsaleselection.setBounds(281, 185, 103, 13);
		contentPane.add(lblsaleselection);

		JComboBox comboBox_namesale_inTheshop = new JComboBox();

		for (Sale my : Main.myShop.getSales().values())
			comboBox_namesale_inTheshop.addItem(my.getSaleID());
		comboBox_namesale_inTheshop.setVisible(false);
		comboBox_namesale_inTheshop.setBounds(181, 183, 86, 21);
		contentPane.add(comboBox_namesale_inTheshop);

		JButton btn_del = new JButton("\u05DE\u05D7\u05E7");
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Sale my : Main.myShop.getSales().values())
					if (comboBox_namesale_inTheshop.getSelectedItem().equals(my.getSaleID())) {
						Main.myShop.cencelSale(my.getSellingDate(), my);
						break;
					}

				dispose();
				Manager_window.main(null);
			}
		});
		btn_del.setVisible(false);
		btn_del.setBounds(255, 241, 85, 21);
		contentPane.add(btn_del);

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

		JComboBox comboBox_Type = new JComboBox();
		for (UsedPhone my : Main.myShop.getPhones())
			if (my.isInShop == 1) {
				comboBox_Type.addItem(my.getModelNo());
			}

		comboBox_Type.setBounds(180, 105, 53, 21);
		comboBox_Type.setVisible(false);
		contentPane.add(comboBox_Type);

		JComboBox comboBox_emp = new JComboBox();

		for (Employee my : Main.myShop.getEmployess())
			comboBox_emp.addItem(my.getFirstName());
		comboBox_emp.setBounds(325, 105, 60, 21);
		comboBox_emp.setVisible(false);
		contentPane.add(comboBox_emp);

		JComboBox comboBox_cust = new JComboBox();
		for (Customer my : Main.myShop.getCustomer())
			comboBox_cust.addItem(my.getFirstName());
		comboBox_cust.setBounds(325, 154, 60, 21);
		comboBox_cust.setVisible(false);
		contentPane.add(comboBox_cust);

		textField_date = new JTextField();
		textField_date.setBounds(160, 155, 96, 19);
		textField_date.setVisible(false);
		contentPane.add(textField_date);
		textField_date.setColumns(10);

		JLabel lblttl = new JLabel("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		lblttl.setFont(new Font("SansSerif", Font.BOLD, 36));
		lblttl.setBounds(223, 0, 118, 64);
		contentPane.add(lblttl);

		JButton btnadd = new JButton("\u05D4\u05D5\u05E1\u05E3");

		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField_date.getText().isEmpty()) {
					for (Employee employee : Main.myShop.getEmployess()) {
						if (comboBox_emp.getSelectedItem().equals(employee.getFirstName())) {
							Main.e1 = employee;
						}
					}
					for (Customer customer : Main.myShop.getCustomer()) {
						if (comboBox_cust.getSelectedItem().equals(customer.getFirstName())) {
							Main.c1 = customer;
						}
					}
					for (UsedPhone usedPhone : Main.myShop.getPhones()) {
						if (comboBox_Type.getSelectedItem().equals(usedPhone.getModelNo())) {
							Main.ph1 = usedPhone;
						}
					}
					try {
						Main.myShop
								.addSale(new Sale(Main.e1, Main.c1, textField_date.getText(), Main.myShop, Main.ph1));
						JOptionPane.showMessageDialog(null, "מכירה נוספה בהצלחה");
					} catch (WrongInput c1) {
						JOptionPane.showMessageDialog(null, "שגיאה בהזנת נתוני מכירה");
						c1.printStackTrace();
					}
				}

				dispose();
				Manager_window.main(null);

			}
		});

		btnadd.setVisible(false);
		btnadd.setBounds(241, 241, 85, 21);
		contentPane.add(btnadd);

		JLabel lblcust = new JLabel(":\u05DC\u05E7\u05D5\u05D7");
		lblcust.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblcust.setVisible(false);
		lblcust.setBounds(408, 156, 72, 13);
		contentPane.add(lblcust);

		JLabel lbltype = new JLabel("\u05E1\u05D5\u05D2 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lbltype.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbltype.setVisible(false);
		lbltype.setBounds(243, 107, 72, 13);
		contentPane.add(lbltype);

		JLabel lbldate = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA:");
		lbldate.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbldate.setVisible(false);
		lbldate.setBounds(255, 156, 60, 13);
		contentPane.add(lbldate);

		JLabel lblNameemp = new JLabel("\u05E2\u05D5\u05D1\u05D3:");
		lblNameemp.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNameemp.setVisible(false);

		JLabel labelsale = new JLabel("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		labelsale.setHorizontalAlignment(SwingConstants.CENTER);
		labelsale.setForeground(Color.WHITE);
		labelsale.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		labelsale.setBorder(new LineBorder(Color.WHITE));
		labelsale.setBackground(Color.WHITE);
		labelsale.setBounds(0, 0, 103, 33);
		contentPane.add(labelsale);
		lblNameemp.setBounds(408, 105, 72, 13);
		contentPane.add(lblNameemp);

		JButton btndel = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05D4\u05D6\u05DE\u05E0\u05D4");
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblsaleselection.setVisible(true);
				comboBox_namesale_inTheshop.setVisible(true);
				btn_del.setVisible(true);
				btnadd.setVisible(false);
				comboBox_emp.setVisible(false);
				comboBox_cust.setVisible(false);
				comboBox_Type.setVisible(false);

				textField_date.setVisible(false);
				lblNameemp.setVisible(false);
				lblcust.setVisible(false);
				lbltype.setVisible(false);
				lbldate.setVisible(false);

			}
		});

		btndel.setBounds(0, 105, 103, 21);
		contentPane.add(btndel);

		JButton btnadd_new = new JButton(
				"\u05D4\u05D5\u05E1\u05E4\u05EA \u05D4\u05D6\u05DE\u05E0\u05D4 \u05D7\u05D3\u05E9\u05D4");
		btnadd_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblsaleselection.setVisible(false);
				comboBox_namesale_inTheshop.setVisible(false);
				btn_del.setVisible(false);

				btnadd.setVisible(true);
				comboBox_emp.setVisible(true);
				comboBox_cust.setVisible(true);
				comboBox_Type.setVisible(true);

				textField_date.setVisible(true);
				lblNameemp.setVisible(true);
				lblcust.setVisible(true);
				lbltype.setVisible(true);
				lbldate.setVisible(true);

			}
		});
		btnadd_new.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnadd_new.setBounds(0, 56, 103, 21);
		contentPane.add(btnadd_new);

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
