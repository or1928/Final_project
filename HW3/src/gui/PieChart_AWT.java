package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChart_AWT extends ApplicationFrame {


	private static Vector<String> columnNames = new Vector<String>();
	private static Vector<Vector<Object>> data = new Vector<Vector<Object>>();

	public PieChart_AWT( String title ) {
		super( title ); 
		setContentPane(createDemoPanel( ));



	}

	private static PieDataset createDataset( ) {
	
		try {

			Connection con = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=ShopDB;integratedSecurity=true;");

			String sql = "select us.brand , count(*) as 'Number of sells' from sale s join usedPhone us on s.phoneSN = us.phoneSN group by us.brand";
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
	
		DefaultPieDataset dataset = new DefaultPieDataset( );
		for(Vector<Object> v : data) {
			dataset.setValue( (String)v.get(0) , new Double((int)v.get(1)));  
			
		}

		return dataset;         
	}

	private static JFreeChart createChart( PieDataset dataset ) {
		JFreeChart chart = ChartFactory.createPieChart(      
				"",   // chart title 
				dataset,          // data    
				true,             // include legend   
				true, 
				false);

		return chart;
	}

	public static JPanel createDemoPanel( ) {
		JFreeChart chart = createChart(createDataset( ) );  
		return new ChartPanel( chart ); 
	}


	public static void main( String[ ] args ) {
		PieChart_AWT demo = new PieChart_AWT( "התפלגות מותגים " );  
		demo.setSize( 560 , 367 );    
		RefineryUtilities.centerFrameOnScreen( demo );    
		demo.setVisible( true ); 
	
		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demo.dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 10));
	    Button_return.setBounds(0, 336, 2, 21);
		demo.add(Button_return);
		
	}
}

