package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class employee_show extends JFrame {

	private Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee_show frame = new employee_show();
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
	public employee_show() {
		setTitle("SecHandCell");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 544, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		Image img = new ImageIcon(this.getClass().getResource("/br.jpg")).getImage();
		Image newImage = img.getScaledInstance(530, 357, Image.SCALE_DEFAULT);
		Image img1 = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		Image newImage1 = img1.getScaledInstance(91, 64, Image.SCALE_DEFAULT);

		Image img3 = new ImageIcon(this.getClass().getResource("/brs1.jpg")).getImage();
		Image newImage3 = img3.getScaledInstance(103, 357, Image.SCALE_DEFAULT);

		try {

			Connection con = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=ShopDB;integratedSecurity=true;");

			String sql = "SELECT * FROM employee";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columns = metaData.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(metaData.getColumnName(i));
			}
			while (resultSet.next()) {
				Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(resultSet.getObject(i));
				}
				data.addElement(row);
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		JTable table = new JTable(data, columnNames);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);

		TableColumn column;
		for (int i = 0; i < table.getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			column.setMaxWidth(250);
		}
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		// contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 90, 530, 126);
		contentPane.add(scrollPane);
		contentPane.setSize(963, 600); // setting frame size

		JButton btn_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Employee_showandadd Employee_win = new Employee_showandadd();
				Employee_win.setVisible(true);
			}
		});
		btn_return.setBounds(0, 326, 103, 31);
		contentPane.add(btn_return);
		contentPane.setVisible(true);
		
		
		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		Label_logo_yvc.setBounds(433, 283, 91, 64);
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
