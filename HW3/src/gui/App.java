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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.DBconnect;
import exceptions.WrongInput;
import main.Main;

public class App {
	private JFrame frame;
	private JTextField textField_Username;
	private JPasswordField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 480, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/cellphone_background_x1.png")).getImage();
		Image newImage = img.getScaledInstance(480, 300, Image.SCALE_DEFAULT);

		Image img1 = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64, Image.SCALE_DEFAULT);

		Image img2 = new ImageIcon(this.getClass().getResource("/applogo.png")).getImage();
		Image newImage2 = img2.getScaledInstance(300, 180, Image.SCALE_DEFAULT);

		textField_Username = new JTextField();
		textField_Username.setBounds(187, 81, 96, 19);
		frame.getContentPane().add(textField_Username);
		textField_Username.setColumns(10);

		JLabel Label_password = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4:");
		Label_password.setFont(new Font("SansSerif", Font.BOLD, 14));
		Label_password.setBounds(293, 108, 91, 19);
		frame.getContentPane().add(Label_password);

		JLabel label_username = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9:");
		label_username.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_username.setBounds(293, 84, 91, 19);
		frame.getContentPane().add(label_username);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(375, 199, 91, 64);
		frame.getContentPane().add(Label_logo_yvc);

		JButton Button_login = new JButton("\u05DB\u05E0\u05D9\u05E1\u05D4");
		Button_login.setFont(new Font("SansSerif", Font.BOLD, 16));
		Button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname, paname;
				uname = textField_Username.getText();
				paname = textField_password.getText();
				if (uname.equals("admin") && paname.equals("admin")) {
					Main.users = "admin";
					JOptionPane.showMessageDialog(frame, "ברוך הבא " + uname);
					frame.dispose();
					Manager_window manager_win = new Manager_window();
					manager_win.setVisible(true);
				} else if (uname.equals("lior") && paname.equals("lior")) {
					Main.users = "customer";
					JOptionPane.showMessageDialog(frame, "ברוך הבא " + uname);
					frame.dispose();
					Manager_window manager_win = new Manager_window();
					manager_win.setVisible(true);
				} else if (uname.equals("or") && paname.equals("or")) {
					Main.users = "employee";
					JOptionPane.showMessageDialog(frame, "ברוך הבא " + uname);
					frame.dispose();
					Manager_window manager_win = new Manager_window();
					manager_win.setVisible(true);
				} else if (uname.equals("Shahaf") && paname.equals("Shahaf")) {
					Main.users = "employee";
					JOptionPane.showMessageDialog(frame, "ברוך הבא " + uname);
					frame.dispose();
					Manager_window manager_win = new Manager_window();
					manager_win.setVisible(true);
				}

				else {
					JOptionPane.showMessageDialog(frame, "שם המשתמש או  הסיסמא לא נמצאו במערכת");
					textField_Username.setText("");
					textField_password.setText("");
				}
			}
		});

		JLabel logo_secHandCell = new JLabel("");
		logo_secHandCell.setHorizontalAlignment(SwingConstants.CENTER);
		logo_secHandCell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logo_secHandCell.setIcon(new ImageIcon(newImage2));
		logo_secHandCell.setBounds(154, 12, 247, 61);
		frame.getContentPane().add(logo_secHandCell);

		Button_login.setBounds(187, 141, 96, 21);
		frame.getContentPane().add(Button_login);

		JButton Button_exit = new JButton("\u05D9\u05E6\u05D9\u05D0\u05D4");
		Button_exit.setFont(new Font("SansSerif", Font.BOLD, 16));
		Button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// save shop to ser - for use in next session
				// Main.sw.writeSer(Main.myShop);
				try {
					DBconnect.updtaeDB();
				} catch (WrongInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DBconnect.closeDB();
				System.exit(0);
			}
		});

		Button_exit.setBounds(187, 184, 96, 21);
		frame.getContentPane().add(Button_exit);

		textField_password = new JPasswordField();
		textField_password.setBounds(187, 110, 96, 19);
		frame.getContentPane().add(textField_password);

		JLabel Label_logo_background = new JLabel("");
		Label_logo_background.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_background.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_background.setIcon(new ImageIcon(newImage));
		Label_logo_background.setBounds(0, 0, 466, 263);
		frame.getContentPane().add(Label_logo_background);
	}
}
