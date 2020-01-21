package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.Main;

public class Manager_window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_window frame = new Manager_window();
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
	public Manager_window() {
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
		Image img3 = new ImageIcon(this.getClass().getResource("/brs.jpg")).getImage();
		Image newImage3 = img3.getScaledInstance(261, 176, Image.SCALE_DEFAULT);

		JLabel Label_manager_window = new JLabel("\u05DE\u05E1\u05DA \u05DE\u05E0\u05D4\u05DC");
		if ((Main.users).equals("customer")) {
			Label_manager_window.setText("מסך לקוח");

		} else if ((Main.users).equals("employee"))
			Label_manager_window.setText("מסך עובד");
		Label_manager_window.setFont(new Font("SansSerif", Font.BOLD, 42));
		Label_manager_window.setBounds(170, 11, 177, 59);
		contentPane.add(Label_manager_window);

		JButton btnsale_win = new JButton("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		if ((Main.users).equals("customer")) {
			btnsale_win.setVisible(false);

		}
		btnsale_win.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sale_showandadd sale_win = new Sale_showandadd();
				sale_win.setVisible(true);

			}
		});

		btnsale_win.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnsale_win.setBounds(224, 137, 85, 21);
		contentPane.add(btnsale_win);

		JButton btncustomer_win = new JButton("\u05E1\u05E4\u05E7\u05D9\u05DD");
		if (Main.users.equals("customer")) {
			btncustomer_win.setVisible(false);

		}
		btncustomer_win.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Provider_showandadd provider_win = new Provider_showandadd();
				provider_win.setVisible(true);
			}
		});
		
		JButton btn_pie = new JButton("\u05D4\u05EA\u05E4\u05DC\u05D2\u05D5\u05EA \u05DE\u05DB\u05E9\u05D9\u05E8\u05D9\u05DD");
		btn_pie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				PieChart_AWT.main(null);
			}
		});
		btn_pie.setBounds(193, 283, 139, 21);
		contentPane.add(btn_pie);
		btncustomer_win.setFont(new Font("SansSerif", Font.BOLD, 12));
		btncustomer_win.setBounds(319, 187, 85, 21);
		contentPane.add(btncustomer_win);

		JButton employees_btn = new JButton("\u05E2\u05D5\u05D1\u05D3\u05D9\u05DD");
		if (Main.users.equals("customer") || (Main.users).equals("employee")) {
			employees_btn.setVisible(false);

		}
		employees_btn.setFont(new Font("SansSerif", Font.BOLD, 12));
		employees_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Employee_showandadd Employee_win = new Employee_showandadd();
				Employee_win.setVisible(true);
			}
		});
		employees_btn.setBounds(134, 93, 85, 21);
		contentPane.add(employees_btn);

		JButton Button_Customer_window = new JButton("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		if ((Main.users).equals("customer")) {
			Button_Customer_window.setVisible(false);

		}
		Button_Customer_window.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Customer_showandadd Customer_win = new Customer_showandadd();
				Customer_win.setVisible(true);

			}
		});
		Button_Customer_window.setFont(new Font("SansSerif", Font.BOLD, 12));
		Button_Customer_window.setBounds(319, 93, 85, 21);
		contentPane.add(Button_Customer_window);

		JButton btnusdephone = new JButton("\u05DE\u05D7\u05E1\u05DF");
		if ((Main.users).equals("customer")) {
			btnusdephone.setVisible(false);

		}
		btnusdephone.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				Usedphone_showandadd Usedphone_win = new Usedphone_showandadd();
				Usedphone_win.setVisible(true);
			}
		});
		btnusdephone.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnusdephone.setBounds(134, 187, 85, 21);
		contentPane.add(btnusdephone);

		JButton Button_exit = new JButton("\u05D4\u05EA\u05E0\u05EA\u05E7");
		Button_exit.setFont(new Font("SansSerif", Font.BOLD, 12));
		Button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// contentPane.setVisible(false);
				dispose();
				App.main(null);

			}
		});
		Button_exit.setBounds(224, 326, 85, 21);
		contentPane.add(Button_exit);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(429, 283, 91, 64);
		contentPane.add(Label_logo_yvc);
		
		JButton btn_bar = new JButton("\u05D4\u05EA\u05E4\u05DC\u05D2\u05D5\u05EA \u05DE\u05DB\u05D9\u05E8\u05D5\u05EA");
		btn_bar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();
				BarChart_AWT.main(null);
				
			}
		});
		btn_bar.setBounds(193, 241, 139, 21);
		contentPane.add(btn_bar);

		JLabel Label_logo_background = new JLabel("");
		Label_logo_background.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_background.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_background.setIcon(new ImageIcon(newImage));
		Label_logo_background.setBounds(0, 0, 530, 357);
		contentPane.add(Label_logo_background);

	}
}
