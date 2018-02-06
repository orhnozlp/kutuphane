package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.Closeable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

public class KitapEkle extends JFrame {

	private JPanel contentPane;
	private static  JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	@SuppressWarnings("rawtypes")
	static JComboBox comboBox_1 = new JComboBox();

	/**
	 * Launch the application.
	 */
	public  void CloseFrame() {
		
		super.dispose();
	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KitapEkle frame = new KitapEkle();
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
	@SuppressWarnings("unchecked")
	public KitapEkle() {
		addWindowListener(new WindowAdapter() {
			@Override
		
			public void windowOpened(WindowEvent arg0) {
				ComboboxGuncelle();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(KitapEkle.class.getResource("/otomasyon_yeni/kullan\u0131c\u0131.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/backn.png")));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame(); 
				Admin admin = new Admin(); 
				admin.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(462, 11, 89, 39);
		contentPane.add(btnNewButton);
		JLabel lblKitapAdi = new JLabel("Kitap    Adi :");
		lblKitapAdi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblKitapAdi.setForeground(Color.YELLOW);
		lblKitapAdi.setBounds(0, 64, 105, 39);
		contentPane.add(lblKitapAdi);
		
		JLabel lblKitapYazari = new JLabel("Kitap Yazari : ");
		lblKitapYazari.setForeground(Color.YELLOW);
		lblKitapYazari.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKitapYazari.setBounds(0, 126, 105, 35);
		contentPane.add(lblKitapYazari);
		
		JLabel lblKitapYeri = new JLabel("Kitap  Yeri : ");
		lblKitapYeri.setForeground(Color.YELLOW);
		lblKitapYeri.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblKitapYeri.setBounds(0, 176, 115, 39);
		contentPane.add(lblKitapYeri);
		
		textField = new JTextField();
		textField.setBounds(117, 72, 159, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 132, 159, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 184, 159, 27);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("K\u0130TAP EKLE");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(40, 15, 236, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblDurum = new JLabel("Durum : ");
		lblDurum.setForeground(Color.YELLOW);
		lblDurum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblDurum.setBounds(0, 232, 115, 39);
		contentPane.add(lblDurum);
		
		

		 @SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(false);
		comboBox.addItem("Ödünç Alinabilir");
		comboBox.addItem("Ödünç Alinamaz");
        
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(117, 237, 159, 27);
		contentPane.add(comboBox);

		JLabel lblKitapSil = new JLabel("K\u0130TAP S\u0130L");
		lblKitapSil.setForeground(Color.YELLOW);
		lblKitapSil.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 35));
		lblKitapSil.setBounds(322, 91, 229, 62);
		contentPane.add(lblKitapSil);
		comboBox_1.setMaximumRowCount(16);
		comboBox_1.setBounds(292, 164, 259, 39);
		contentPane.add(comboBox_1);

		JButton btnNewButton_1 = new JButton("EKLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String odunc = null ; 
				 Object selected = comboBox.getSelectedItem();
	                if(selected.toString().equals("Ödünç Alinabilir"))
	                 odunc = "Ödünç Alinabilir";
	                else if(selected.toString().equals("Ödünç Alinamaz"))
	                    odunc = "Ödünç Alinamaz"; 
				
	        		MysqlConnector1(odunc);
	        		ComboboxGuncelle();
	        		
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBounds(133, 275, 97, 39);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnSil = new JButton("S\u0130L");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String odunc = (String) comboBox_1.getSelectedItem();
				 String sil = odunc.substring(0,odunc.indexOf("-")).trim();
				 	//CloseFrame() ;

				 
					//KitapEkle ekle = new KitapEkle(); 
					//KitapEkle.main(null);
				  int devam =
	JOptionPane.showConfirmDialog(null, sil+" kitabý silinecek emin misiniz ? ","sil",JOptionPane.YES_NO_CANCEL_OPTION);
				 if (devam==0)	idgetir(sil) ; 
				 else 
					 JOptionPane.showMessageDialog(null, "silme iþlemi baþarýsýz","",JOptionPane.ERROR_MESSAGE);
				 ComboboxGuncelle();

			//	MysqlConnectorsil(id) ; 
			}
		});
		btnSil.setForeground(Color.GREEN);
		btnSil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnSil.setBackground(new Color(255, 228, 181));
		btnSil.setBounds(389, 214, 97, 39);
		contentPane.add(btnSil);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 561, 366);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ASUS-PC\\Desktop\\art-leather-579712_640.jpg"));
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static void MysqlConnector() {
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("SELECT * FROM `kitap`");
			   PreparedStatement statement;
			  
				   statement = (PreparedStatement) myConn.prepareStatement("SELECT * FROM `kitap`  ");
			
			  
			  

			       
			
			   ResultSet resultSet = statement.executeQuery();
			   //results set
				
			   while (resultSet.next()) {
				   
				  
				   String kitap_adi = resultSet.getString("kitapadi");
				 
				   String kitap_yazari = resultSet.getString("kitapyazari");	  
						
				   String label_text =kitap_adi+ "-" + kitap_yazari ;
							
				   comboBox_1.addItem(label_text);				   
				
			   }
			 
			   
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
	}

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void MysqlConnector1(String odunc) {
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			  // ResultSet myRs = myStmt.executeQuery("");
			  
			  
			    PreparedStatement   statement = (PreparedStatement) myConn.prepareStatement("insert into kitap (kitapadi,kitapyazari,kitapyeri,odunc) values (?,?,?,?)");
			
                    statement.setString(1,textField.getText());			  
                    statement.setString(2,textField_1.getText());			  
                    statement.setString(3,textField_2.getText());	
                    statement.setString(4, odunc);
                         
			       
			
			   statement.execute();
			   JOptionPane.showMessageDialog(null, "Kayýt Baþarý ile yapýldý.");
			   
			   textField.setText(null);
			   textField_1.setText(null);
			   textField_2.setText(null);
               
			   //results set
			   statement.close();
				
			   
			   
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
	}

	public void itemStateChanged1(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
	public void ComboboxGuncelle()
	{
		try{ 
			 comboBox_1.removeAllItems();
			 Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			 PreparedStatement statement;
						 
							   statement = (PreparedStatement) myConn.prepareStatement("select * from kitap ");
			 ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next())
			 {
				String a=""+(String)resultSet.getString(2)+"-"+(String)resultSet.getString(3);
				comboBox_1.addItem(a);
			 }
			}
			catch (Exception exc) {
						   exc.printStackTrace();
				              }
	}
	public static void idgetir(String kitapadi) {
		int id = 0 ; 

		
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("select * from kitap");
			   PreparedStatement statement;
			 
				   statement = (PreparedStatement) myConn.prepareStatement("select * from kitap ");
			 
			       
			  // statement.setString(1, textField.getText());    
			   ResultSet resultSet = statement.executeQuery();
			   //results set
			   while (resultSet.next()) {
				    
				   if  (resultSet.getString("kitapadi").equals(kitapadi)) 
					   
				   {
					   id = resultSet.getInt("id"); ; 

					   MysqlConnectorsil(id);
				   }
					   
		
				 
				  
				
			   }
			 
			  
			   
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
		
	}

	public void itemStateChanged2(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void MysqlConnectorsil(int id) {
		try {  
			
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   Statement myStmt = (Statement) myConn.createStatement();
			   myStmt.executeUpdate("delete from kitap where id ="+id) ;
	            JOptionPane.showMessageDialog(null, "Silme iþlemi Baþarýlý..");
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
		
		
		
	}

	public void itemStateChanged11(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
	
	
	
	
	
	
}
