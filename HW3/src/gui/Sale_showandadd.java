package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Sale_showandadd extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	
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
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image img =new ImageIcon(this.getClass().getResource("/cellphone_background_x1.png")).getImage();
		Image newImage = img.getScaledInstance(480, 300,Image.SCALE_DEFAULT);
		Image img1 =new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64,Image.SCALE_DEFAULT);
		
		 JLabel lblNewLabel_11 = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05D4\u05D6\u05DE\u05E0\u05D4");
		 lblNewLabel_11.setVisible(false);
		 lblNewLabel_11.setBounds(273, 154, 70, 13);
		 contentPane.add(lblNewLabel_11);
		 
		 
		 JComboBox comboBox1 = new JComboBox();
		 comboBox1.setVisible(false);
		 comboBox1.setBounds(177, 150, 86, 21);
		 contentPane.add(comboBox1);
		 
		 JButton btnNewButton_11 = new JButton("\u05DE\u05D7\u05E7");
		 btnNewButton_11.setVisible(false);
		 btnNewButton_11.setBounds(220, 232, 85, 21);
		 contentPane.add(btnNewButton_11);
		 
		
		
		
		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
		Button_return.setBounds(0, 0, 85, 21);
		contentPane.add(Button_return);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(177, 75, 53, 21);
		comboBox_2.setVisible(false);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(325, 75, 60, 21);
		comboBox.setVisible(false);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(325, 118, 60, 21);
		comboBox_1.setVisible(false);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(136, 106, 96, 19);
		textField.setVisible(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(177, 126, 53, 21);
		comboBox_3.setVisible(false);
		contentPane.add(comboBox_3);
	
		table = new JTable();
		table.setBounds(106, 199, 259, 54);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
		lblNewLabel.setBounds(190, -22, 118, 64);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton_1 = new JButton("\u05D4\u05D5\u05E1\u05E3");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(221, 163, 85, 21);
		contentPane.add(btnNewButton_1); 
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("\u05DC\u05E7\u05D5\u05D7");
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setBounds(411, 122, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u05E1\u05D5\u05D2 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF");
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setBounds(240, 79, 60, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA:");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setBounds(236, 108, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("\u05D7\u05E0\u05D5\u05EA:");
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setBounds(241, 130, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2 = new JLabel("\u05E2\u05D5\u05D1\u05D3:");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setBounds(411, 77, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		
		
		 JButton btnNewButton11 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05D4\u05D6\u05DE\u05E0\u05D4");
		 btnNewButton11.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		lblNewLabel_11.setVisible(true);
				 comboBox1.setVisible(true);
				 btnNewButton_11.setVisible(true);
				 btnNewButton_1.setVisible(false);
					comboBox.setVisible(false);
					comboBox_1.setVisible(false);
					comboBox_2.setVisible(false);
					comboBox_3.setVisible(false);
					textField.setVisible(false);
					lblNewLabel_2.setVisible(false);
					lblNewLabel_3.setVisible(false);
					lblNewLabel_4.setVisible(false);
					lblNewLabel_5.setVisible(false);
					lblNewLabel_6.setVisible(false);
				 
		 	}
		 });
		 
		 btnNewButton11.setBounds(200, 44, 108, 21);
		 contentPane.add(btnNewButton11);
		 
		
		JButton btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D4\u05D6\u05DE\u05E0\u05D4 \u05D7\u05D3\u05E9\u05D4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel_11.setVisible(false);
				 comboBox1.setVisible(false);
				 btnNewButton_11.setVisible(false);
				
				btnNewButton_1.setVisible(true);
				comboBox.setVisible(true);
				comboBox_1.setVisible(true);
				comboBox_2.setVisible(true);
				comboBox_3.setVisible(true);
				textField.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblNewLabel_3.setVisible(true);
				lblNewLabel_4.setVisible(true);
				lblNewLabel_5.setVisible(true);
				lblNewLabel_6.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton.setBounds(166, 23, 155, 21);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
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
