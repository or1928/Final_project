package gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class customer_show extends JFrame {

	private Vector columnNames = new Vector();
	private Vector data = new Vector();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_show frame = new customer_show();
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
	public customer_show() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		try {

			Connection con = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=ShopDB;integratedSecurity=true;");

			String sql = "SELECT * FROM customer";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columns = metaData.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(metaData.getColumnName(i));
			}
			while (resultSet.next()) {
				Vector row = new Vector(columns);
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
		// contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 160, 436, 103);
		contentPane.add(scrollPane);
		contentPane.setSize(963, 600); // setting frame size
		contentPane.setVisible(true);

	}
}