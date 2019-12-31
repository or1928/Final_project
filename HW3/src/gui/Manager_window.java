package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manager_window extends JFrame {
	private int anaBobi;

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
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image img =new ImageIcon(this.getClass().getResource("/cellphone_background_x1.png")).getImage();
		Image newImage = img.getScaledInstance(480, 300,Image.SCALE_DEFAULT);
		Image img1 =new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64,Image.SCALE_DEFAULT);
		
		JLabel Label_manager_window = new JLabel("\u05DE\u05E1\u05DA \u05DE\u05E0\u05D4\u05DC");
		Label_manager_window.setFont(new Font("SansSerif", Font.BOLD, 42));
		Label_manager_window.setBounds(213, 0, 177, 59);
		contentPane.add(Label_manager_window);
		
		JButton btnNewButton = new JButton("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sale_showandadd sale_win=new Sale_showandadd();
				sale_win.setVisible(true);
				
				
			}
		});
		
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setBounds(161, 90, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u05E1\u05E4\u05E7\u05D9\u05DD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Provider_showandadd provider_win=new Provider_showandadd();
				provider_win.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setBounds(161, 168, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton employees_btn = new JButton("\u05E2\u05D5\u05D1\u05D3\u05D9\u05DD");
		employees_btn.setFont(new Font("SansSerif", Font.BOLD, 12));
		employees_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Employee_showandadd Employee_win=new Employee_showandadd();
				Employee_win.setVisible(true);
			}
		});
		employees_btn.setBounds(337, 90, 85, 21);
		contentPane.add(employees_btn);
		
		JButton Button_Customer_window = new JButton("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		Button_Customer_window.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Customer_showandadd Customer_win=new Customer_showandadd();
				Customer_win.setVisible(true);
				
				
			}
		});
		Button_Customer_window.setFont(new Font("SansSerif", Font.BOLD, 12));
		Button_Customer_window.setBounds(337, 168, 85, 21);
		contentPane.add(Button_Customer_window);
		
		
		JButton btnNewButton_4 = new JButton("\u05DE\u05D7\u05E1\u05DF");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Usedphone_showandadd Usedphone_win=new Usedphone_showandadd();
				Usedphone_win.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_4.setBounds(247, 132, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton Button_exit = new JButton("\u05E0\u05D9\u05EA\u05D5\u05E7");
		Button_exit.setFont(new Font("SansSerif", Font.BOLD, 12));
		Button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//contentPane.setVisible(false);
				dispose();
				 App.main(null);
				 
			}
		});
		Button_exit.setBounds(247, 216, 85, 21);
		contentPane.add(Button_exit);
		
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
		lblNewLabel_1.setBounds(0, 0, 480, 300);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
