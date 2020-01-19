package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
import java.awt.Color;
import javax.swing.border.LineBorder;

import classes.Username;

public class App {
	private JFrame frame;
	private JTextField textField_Username;
	private JPasswordField textField_password;
	private ArrayList<Username> users = new ArrayList<>();
	private HashMap<String,String> usersPasswords = new HashMap<>();


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
	 * 
	 */

	private void initUsers() {
		Username lior = new Username("lior", "lior","customer");
		Username or = new Username("or", "or","employee");
		Username shahaf = new Username("shahaf", "shahaf","employee");
		Username admin = new Username("admin", "admin","admin");

		users.add(lior);
		users.add(or);
		users.add(shahaf);
		users.add(admin);

		users.forEach((n) -> usersPasswords.put(n.getUserName(),n.getPassword()));

	}
	
	private void addUser(String userName , String password , String rank) {
		Username user = new Username(userName, password, rank);
		users.add(user);
		usersPasswords.put(user.getUserName(), user.getPassword());
	}
	private void initialize() {
		initUsers();
		frame = new JFrame();
		frame.setBounds(500, 250, 544, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/br.jpg")).getImage();
		Image newImage = img.getScaledInstance( 530, 357, Image.SCALE_DEFAULT);

		Image img1 = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64, Image.SCALE_DEFAULT);

		Image img2 = new ImageIcon(this.getClass().getResource("/applogo.png")).getImage();
		Image newImage2 = img2.getScaledInstance(300, 180, Image.SCALE_DEFAULT);

		Image img3 = new ImageIcon(this.getClass().getResource("/brs1.jpg")).getImage();
		Image newImage3 = img3.getScaledInstance( 103, 357, Image.SCALE_DEFAULT);

		textField_Username = new JTextField();
		textField_Username.setBounds(196, 132, 96, 19);
		frame.getContentPane().add(textField_Username);
		textField_Username.setColumns(10);

		JLabel Label_password = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4:");
		Label_password.setFont(new Font("SansSerif", Font.BOLD, 14));
		Label_password.setBounds(302, 159, 91, 19);
		frame.getContentPane().add(Label_password);

		JLabel label_username = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9:");
		label_username.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_username.setBounds(302, 135, 91, 19);
		frame.getContentPane().add(label_username);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(429, 283, 91, 64);
		frame.getContentPane().add(Label_logo_yvc);

		JButton Button_login = new JButton("\u05DB\u05E0\u05D9\u05E1\u05D4");
		Button_login.setFont(new Font("SansSerif", Font.BOLD, 16));
		Button_login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String uname, paname;
				uname = textField_Username.getText();
				paname = textField_password.getText();
				if (usersPasswords.containsKey(uname)) {
					if(usersPasswords.get(uname).equals(paname)) {
						Main.users = users.stream().filter(u -> u.getUserName().equals(paname)).findFirst().get().getRank();
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
			}});

		JLabel logo_secHandCell = new JLabel("");
		logo_secHandCell.setHorizontalAlignment(SwingConstants.CENTER);
		logo_secHandCell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logo_secHandCell.setIcon(new ImageIcon(newImage2));
		logo_secHandCell.setBounds(139, 31, 247, 61);
		frame.getContentPane().add(logo_secHandCell);

		Button_login.setBounds(196, 192, 96, 21);
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

		Button_exit.setBounds(196, 235, 96, 21);
		frame.getContentPane().add(Button_exit);

		textField_password = new JPasswordField();
		textField_password.setBounds(196, 161, 96, 19);
		frame.getContentPane().add(textField_password);

		JLabel lblNewpage = new JLabel("\u05DB\u05E0\u05D9\u05E1\u05D4");
		lblNewpage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewpage.setBorder(new LineBorder(Color.WHITE));
		lblNewpage.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblNewpage.setForeground(Color.WHITE);
		lblNewpage.setBackground(Color.WHITE);
		lblNewpage.setBounds(1, 155, 99, 33);
		frame.getContentPane().add(lblNewpage);

		JLabel side_logo = new JLabel("");
		side_logo.setHorizontalAlignment(SwingConstants.CENTER);
		side_logo.setBounds(0, 0, 103, 357);
		side_logo.setIcon(new ImageIcon(newImage3));
		frame.getContentPane().add(side_logo);

		JLabel Label_logo_background = new JLabel("");
		Label_logo_background.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_background.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_background.setIcon(new ImageIcon(newImage));
		Label_logo_background.setBounds(0, 0, 530, 357);
		frame.getContentPane().add(Label_logo_background);
	}
}
