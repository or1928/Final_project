package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;

import classes.Customer;
import classes.UsedPhone;
import main.Main;

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
import javax.swing.JComboBox;
import javax.swing.JTextField; 


public class BarChart_AWT extends ApplicationFrame {
	private static Vector<String> columnNames = new Vector<String>();
	private static Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	private static JFreeChart barChart;
   
   public BarChart_AWT( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JComboBox comboBox_namecusro_inTheshop = new JComboBox();
    		comboBox_namecusro_inTheshop.addItem("בחר עובד");
    		for (int i = 0 ; i < 5 ; i++) {
    			comboBox_namecusro_inTheshop.addItem("paul");
    		}
    		
    		comboBox_namecusro_inTheshop.setVisible(true);
    		comboBox_namecusro_inTheshop.setBounds(201, 202, 86, 21);
    		   
    		String employeeName = (String) comboBox_namecusro_inTheshop.getSelectedItem();
    		System.out.println("");
      barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Brand",            
         "Number of sells",            
         createDataset(employeeName),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel );
      chartPanel.add(comboBox_namecusro_inTheshop);
	     

   }
   private CategoryDataset createDataset(String name) {
	   
	 
	
	  final String fiat = "FIAT";        
      final String audi = "AUDI";        
      final String ford = "FORD";        
      final String speed = "Speed";        
      final String millage = "Millage";        
      final String userrating = "User Rating";        
      final String safety = "safety";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      
		try {

			Connection con = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=ShopDB;integratedSecurity=true;");

			String sql = "select us.brand,count(*) from sale s join employee e on s.employee_id = e.employee_id join usedPhone us on s.phoneSN = us.phoneSN where e.firstName like '"  
					+ name + "' group by us.brand";
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
		System.out.println(data);
		
		
		for(Vector<Object> v : data) {
			dataset.setValue( new Double((int)v.get(1)), name + " sell's" , (String)v.get(0));  
		}     
      return dataset; 
   }
   
   public static void main( String[ ] args ) {
	   
      BarChart_AWT chart = new BarChart_AWT("התפלגות מכירות עובד", 
         " ");
      
      JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
    		Button_return.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				chart.dispose();
    				Manager_window.main(null);
    			}
    		});
    		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
    	    Button_return.setBounds(0, 336, 2, 21);
    	    chart.add(Button_return);
    
		
      chart.pack( );   
      
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
    
   }
}