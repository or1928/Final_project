package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

import classes.Provider;
import db.DBconnect;
import exceptions.CustomerAlreadyExistsException;
import exceptions.IllegalDateException;
import exceptions.IllegalEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPhoneNumberException;
import exceptions.ProvidersAlreadyExistsException;
import exceptions.WrongInput;
import main.Main;

public class Provider_showandadd extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_fnane;
	private static JTextField textField_lname;
	private static JTextField textField_id;
	private static JTextField textField_phone;
	private static JTextField textField_birthday;
	private static JLabel lblprov_selection;
	private static JLabel labttl;
	private static JLabel Label_id;
	private static JLabel lLabel_phone;
	private static JLabel Label_birthday;
	private static JLabel Label_fname;
	private static JLabel Label_lname;
	private static JLabel Label_show_id;
	private static JLabel Label_show_phone;
	private static JLabel Label_show_birthday;
	private static JLabel Label_show_fname;
	private static JLabel Label_show_lname;
	private static JButton Button_add_new_cusromer;
	private static JLabel lblpro_selection;
	private static JLabel Label_provider_photo;
	private static JComboBox comboBox_namepro_inTheshop;
	private static JButton btn_Switch_show;
	private static JButton btndel;
	private JLabel lblNewpage;
	private static Image ProviderPhotoName;
	private static Image ProviderPhoto;

	/**
	 * Launch the application.
	 */

	public static void Visible_co_t() {
		Label_id.setVisible(true);
		lLabel_phone.setVisible(true);
		Label_birthday.setVisible(true);

		Label_fname.setVisible(true);
		Label_lname.setVisible(true);
		Label_show_lname.setVisible(true);
		Label_show_fname.setVisible(true);
		Label_show_phone.setVisible(true);
		Label_show_birthday.setVisible(true);

		Label_show_id.setVisible(true);
		Button_add_new_cusromer.setVisible(true);
		Label_provider_photo.setVisible(true);

	}

	public static void Visible_co_f() {

		Label_show_lname.setVisible(false);
		Label_show_fname.setVisible(false);
		Label_show_phone.setVisible(false);
		Label_show_birthday.setVisible(false);
		Label_show_id.setVisible(false);
		Label_provider_photo.setVisible(false);

	}

	public static void Visible_add_t() {
		Label_id.setVisible(true);
		lLabel_phone.setVisible(true);
		Label_birthday.setVisible(true);
		Label_fname.setVisible(true);
		Label_lname.setVisible(true);
		Button_add_new_cusromer.setVisible(true);
		textField_fnane.setVisible(true);
		textField_lname.setVisible(true);
		textField_id.setVisible(true);
		textField_phone.setVisible(true);
		textField_birthday.setVisible(true);

	}

	public static void Visible_add_f() {

		textField_fnane.setVisible(false);
		textField_lname.setVisible(false);
		textField_id.setVisible(false);
		textField_phone.setVisible(false);
		textField_birthday.setVisible(false);

	}

	public static void Visible_dell_t() {

		lblpro_selection.setVisible(true);
		comboBox_namepro_inTheshop.setVisible(true);
		btndel.setVisible(true);
	}

	public static void Visible_dell_f() {

		lblpro_selection.setVisible(false);
		comboBox_namepro_inTheshop.setVisible(false);
		btndel.setVisible(false);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Provider_showandadd frame = new Provider_showandadd();
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
	public Provider_showandadd() {
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

		btn_Switch_show = new JButton("\u05D4\u05E6\u05D2\u05EA \u05E1\u05E4\u05E7\u05D9\u05DD");
		btn_Switch_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					DBconnect.updtaeDB();
				} catch (WrongInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				provider_show provider_win_show = new provider_show();
				provider_win_show.setVisible(true);
			}
		});
		btn_Switch_show.setBounds(0, 70, 103, 21);
		contentPane.add(btn_Switch_show);

		lblpro_selection = new JLabel("\u05D1\u05D7\u05D9\u05E8\u05EA \u05E1\u05E4\u05E7");
		lblpro_selection.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblpro_selection.setVisible(false);
		lblpro_selection.setBounds(293, 207, 70, 13);
		contentPane.add(lblpro_selection);

		comboBox_namepro_inTheshop = new JComboBox();
		comboBox_namepro_inTheshop.addItem("בחר ספק");
		for (Provider my : Main.myShop.getProviders())
			comboBox_namepro_inTheshop.addItem(my.getFirstName());
		comboBox_namepro_inTheshop.setVisible(false);
		comboBox_namepro_inTheshop.setBounds(188, 205, 86, 21);
		contentPane.add(comboBox_namepro_inTheshop);

		btndel = new JButton("\u05DE\u05D7\u05E7");
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Provider my : Main.myShop.getProviders())
					if (comboBox_namepro_inTheshop.getSelectedItem().equals(my.getFirstName())) {
						Main.myShop.removeProvider(my);
						break;
					}

				dispose();
				Manager_window.main(null);
			}
		});
		btndel.setVisible(false);
		btndel.setBounds(248, 252, 85, 21);
		contentPane.add(btndel);

		JButton del = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05E1\u05E4\u05E7");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_dell_t();
				Visible_add_f();
				Visible_co_f();
				Label_id.setVisible(false);
				lLabel_phone.setVisible(false);
				Label_birthday.setVisible(false);
				Label_fname.setVisible(false);
				Label_lname.setVisible(false);
				Button_add_new_cusromer.setVisible(false);
			}
		});
		del.setBounds(-5, 166, 108, 21);
		contentPane.add(del);

		lblprov_selection = new JLabel(" \u05D1\u05D7\u05D9\u05E8\u05EA \u05E1\u05E4\u05E7 \u05E7\u05D9\u05D9\u05DD:");
		lblprov_selection.setBounds(298, 72, 126, 13);
		lblprov_selection.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(lblprov_selection);

		labttl = new JLabel("\u05E1\u05E4\u05E7\u05D9\u05DD");
		labttl.setBounds(260, -10, 133, 68);
		labttl.setFont(new Font("SansSerif", Font.BOLD, 30));
		contentPane.add(labttl);

		Label_id = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D6\u05D4\u05D5\u05EA:");
		Label_id.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_id.setBounds(322, 126, 85, 13);
		Label_id.setVisible(false);
		contentPane.add(Label_id);

		lLabel_phone = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lLabel_phone.setFont(new Font("SansSerif", Font.BOLD, 16));
		lLabel_phone.setBounds(322, 149, 93, 13);
		lLabel_phone.setVisible(false);
		contentPane.add(lLabel_phone);

		Label_birthday = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4:");
		Label_birthday.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_birthday.setBounds(322, 176, 85, 13);
		Label_birthday.setVisible(false);
		contentPane.add(Label_birthday);

		Label_fname = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		Label_fname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_fname.setBounds(427, 94, 62, 13);
		Label_fname.setVisible(false);
		contentPane.add(Label_fname);

		Label_lname = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		Label_lname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_lname.setBounds(243, 94, 86, 13);
		Label_lname.setVisible(false);
		contentPane.add(Label_lname);

		Label_show_id = new JLabel("New label");
		Label_show_id.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_id.setBounds(216, 126, 96, 13);
		Label_show_id.setVisible(false);
		contentPane.add(Label_show_id);

		Label_show_phone = new JLabel("New label");
		Label_show_phone.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_phone.setBounds(216, 149, 96, 13);
		Label_show_phone.setVisible(false);
		contentPane.add(Label_show_phone);

		Label_show_birthday = new JLabel("New label");
		Label_show_birthday.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_birthday.setBounds(216, 171, 96, 13);
		Label_show_birthday.setVisible(false);
		contentPane.add(Label_show_birthday);

		textField_fnane = new JTextField();
		textField_fnane.setBounds(329, 91, 96, 19);
		textField_fnane.setVisible(false);
		contentPane.add(textField_fnane);
		textField_fnane.setColumns(10);

		textField_lname = new JTextField();
		textField_lname.setBounds(142, 93, 96, 19);
		textField_lname.setVisible(false);
		contentPane.add(textField_lname);
		textField_lname.setColumns(10);

		textField_id = new JTextField();
		textField_id.setBounds(216, 120, 96, 19);
		textField_id.setVisible(false);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		textField_phone = new JTextField();
		textField_phone.setBounds(216, 146, 96, 19);
		textField_phone.setVisible(false);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);

		textField_birthday = new JTextField();
		textField_birthday.setBounds(216, 168, 96, 19);
		textField_birthday.setVisible(false);
		contentPane.add(textField_birthday);
		textField_birthday.setColumns(10);

		Label_show_fname = new JLabel("New label");
		Label_show_fname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_fname.setBounds(148, 94, 85, 13);
		Label_show_fname.setVisible(false);
		contentPane.add(Label_show_fname);

		Label_show_lname = new JLabel("New label");
		Label_show_lname.setFont(new Font("SansSerif", Font.BOLD, 16));
		Label_show_lname.setBounds(338, 95, 86, 13);
		Label_show_lname.setVisible(false);
		contentPane.add(Label_show_lname);
		
		Label_provider_photo = new JLabel("");
		Label_provider_photo.setHorizontalAlignment(SwingConstants.CENTER);
		Label_provider_photo.setVisible(true);
		Label_provider_photo.setBounds(412, 121, 107, 149);
		contentPane.add(Label_provider_photo);		


		JComboBox comboBox_show_cusromer = new JComboBox();
		comboBox_show_cusromer.setBounds(199, 70, 89, 21);
		comboBox_show_cusromer.addItem("");
		for (Provider pro : Main.allProviders) {
			comboBox_show_cusromer.addItem(pro.getFirstName());
		}
		comboBox_show_cusromer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (Provider pro : Main.allProviders)
					if (comboBox_show_cusromer.getSelectedItem().equals(pro.getFirstName())) {
						Visible_co_t();
						Visible_add_f();
						Visible_dell_f();
						Label_show_lname.setText(pro.getLastName());
						Label_show_fname.setText(pro.getFirstName());
						Label_show_phone.setText(pro.getPhoneNumber());
						Label_show_birthday.setText(pro.getDateOfBirth());
						Label_show_id.setText(pro.getID());
						
						String photoName = "/" + pro.getFirstName().toLowerCase() + ".jpg";
						try {
							ProviderPhotoName = new ImageIcon(this.getClass().getResource(photoName)).getImage();
							ProviderPhoto = ProviderPhotoName.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
							Label_provider_photo.setIcon(new ImageIcon(ProviderPhoto));
							
						}
						
						catch(NullPointerException e2){
							ProviderPhotoName = new ImageIcon(this.getClass().getResource("/unknown.png")).getImage();
							ProviderPhoto = ProviderPhotoName.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
							Label_provider_photo.setIcon(new ImageIcon(ProviderPhoto));
							
							
						}
						
						

						break;
					} else {
						Visible_co_f();
					}
			}
		});
		contentPane.add(comboBox_show_cusromer);

		Button_add_new_cusromer = new JButton("\u05D4\u05D5\u05E1\u05E3");
		Button_add_new_cusromer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Provider pro : Main.allProviders)
					if (comboBox_show_cusromer.getSelectedItem().equals(pro.getFirstName())) {

						try {
							Main.myShop.addProvider(pro);
						} catch (ProvidersAlreadyExistsException p1) {
							JOptionPane.showMessageDialog(null, "ספק קיים במערכת");
							p1.printStackTrace();
						}
						break;

					}
				if (!textField_id.getText().isEmpty()) {

					try {
						Main.myShop.addProvider(new Provider(textField_id.getText(), textField_fnane.getText(),
								textField_lname.getText(), textField_phone.getText(), textField_birthday.getText()));
						JOptionPane.showMessageDialog(null, "ספק נוסף בהצלחה");
					} catch (ProvidersAlreadyExistsException p1) {
						JOptionPane.showMessageDialog(null, "ספק כבר קיים במערכת");
						p1.printStackTrace();
					} catch (IllegalEmailException c1) {
						JOptionPane.showMessageDialog(null, "שגיאה בהזנת מייל");
					} catch (InvalidPhoneNumberException c1) {
						JOptionPane.showMessageDialog(null, "שגיאה בהזנת מספר פלאפון ");
					} catch (IllegalDateException c1) {
						JOptionPane.showMessageDialog(null, "שגיאה בהזנת תאריך לידה ");
					} catch (InvalidNameException c1) {
						JOptionPane.showMessageDialog(null, "שגיאה בהזנת שם ספק");
					} catch (WrongInput e1) {
						JOptionPane.showMessageDialog(null, "שגיאה בהזנת פרטי ספק");
						e1.printStackTrace();
					}




				}

				dispose();
				Manager_window.main(null);

			}
		});
		Button_add_new_cusromer.setBounds(247, 252, 96, 21);
		Button_add_new_cusromer.setVisible(false);
		contentPane.add(Button_add_new_cusromer);

		JButton Button_show_add = new JButton("\u05E1\u05E4\u05E7 \u05D7\u05D3\u05E9");
		Button_show_add.setBounds(0, 118, 103, 21);
		Button_show_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visible_add_t();
				Visible_co_f();
				Visible_dell_f();

			}
		});

		lblNewpage = new JLabel("\u05E1\u05E4\u05E7\u05D9\u05DD");
		lblNewpage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewpage.setForeground(Color.WHITE);
		lblNewpage.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblNewpage.setBorder(new LineBorder(Color.WHITE));
		lblNewpage.setBackground(Color.WHITE);
		lblNewpage.setBounds(0, 0, 103, 33);
		contentPane.add(lblNewpage);
		contentPane.add(Button_show_add);

		JButton Button_return = new JButton("\u05D7\u05D6\u05D5\u05E8");
		Button_return.setBounds(0, 336, 103, 21);
		Button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager_window.main(null);
			}
		});
		Button_return.setFont(new Font("SansSerif", Font.BOLD, 14));
		contentPane.add(Button_return);

		JLabel Label_logo_yvc = new JLabel("");
		Label_logo_yvc.setBounds(429, 283, 91, 64);
		Label_logo_yvc.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_yvc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_yvc.setIcon(new ImageIcon(newImage1));
		contentPane.add(Label_logo_yvc);

		JLabel lblside = new JLabel("");
		lblside.setHorizontalAlignment(SwingConstants.CENTER);
		lblside.setBounds(0, 0, 103, 357);
		lblside.setIcon(new ImageIcon(newImage3));
		contentPane.add(lblside);

		JLabel Label_logo_background = new JLabel("");
		Label_logo_background.setBounds(0, -10, 530, 357);
		Label_logo_background.setHorizontalAlignment(SwingConstants.CENTER);
		Label_logo_background.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_logo_background.setIcon(new ImageIcon(newImage));
		contentPane.add(Label_logo_background);

	}
}
