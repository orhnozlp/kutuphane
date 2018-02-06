package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class Duzenle extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private JLabel lblNewLabel_1;
	private static JTextField  textField_1;
	private static JTextField  textField_2;
	private static JTextField  textField_3;
	private static JTextField  textField_4;
	private static JTextField  textField_5;
	private JLabel lblKullaniciAdi;
	private JLabel lblKullaniciAd;
	private JLabel lblKullaniciSoyad;
	private JLabel lblKullaniciMail;
	private JLabel lblKullaniciBorcu;
	private JButton btnNewButton_1;
	private JButton btnIptal;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	 public  void CloseFrame(){
		    super.dispose();
		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Duzenle frame = new Duzenle();
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
	public Duzenle() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Duzenle.class.getResource("/otomasyon_yeni/giris.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 51, 318, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sorgula");
		btnNewButton.setBackground(new Color(240, 230, 140));
		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				MysqlConnector() ;
			}
		});
		btnNewButton.setBounds(338, 51, 89, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(163, 96, 196, 34);
		contentPane.add(lblNewLabel);
		// 	  CloseFrame() ;
		
		
		lblNewLabel_1 = new JLabel("Devam etmek i\u00E7in \u00FCye numarasini giriniz.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(10, 11, 331, 29);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 118, 191, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 174, 191, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(149, 219, 191, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(149, 264, 191, 34);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(149, 321, 191, 34);
		contentPane.add(textField_5);
		
		lblKullaniciAdi = new JLabel("Kullanici NO : ");
		lblKullaniciAdi.setForeground(Color.BLACK);
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKullaniciAdi.setBounds(0, 121, 121, 24);
		contentPane.add(lblKullaniciAdi);
		
		lblKullaniciAd = new JLabel("Kullanici ADI: ");
		lblKullaniciAd.setForeground(Color.BLACK);
		lblKullaniciAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKullaniciAd.setBounds(0, 177, 121, 24);
		contentPane.add(lblKullaniciAd);
		
		lblKullaniciSoyad = new JLabel("Kullanici SOYADI: ");
		lblKullaniciSoyad.setForeground(Color.BLACK);
		lblKullaniciSoyad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKullaniciSoyad.setBounds(0, 222, 153, 24);
		contentPane.add(lblKullaniciSoyad);
		
		lblKullaniciMail = new JLabel("Kullanici MA\u0130L: ");
		lblKullaniciMail.setForeground(Color.BLACK);
		lblKullaniciMail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKullaniciMail.setBounds(0, 267, 121, 24);
		contentPane.add(lblKullaniciMail);
		
		lblKullaniciBorcu = new JLabel("Kullanici BORCU: ");
		lblKullaniciBorcu.setForeground(Color.BLACK);
		lblKullaniciBorcu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblKullaniciBorcu.setBounds(0, 324, 138, 24);
		contentPane.add(lblKullaniciBorcu);
		
		btnNewButton_1 = new JButton("D\u00DCZENLE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBackground(new Color(238, 232, 170));
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			MysqlConnectorsil(Integer.parseInt(textField.getText()));
			MysqlConnectorekle() ;
				
			}
		});
		btnNewButton_1.setBounds(149, 366, 87, 34);
		contentPane.add(btnNewButton_1);
		
		btnIptal = new JButton("GER\u0130");
		btnIptal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnIptal.setBackground(new Color(240, 230, 140));
		btnIptal.setForeground(Color.RED);
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Admin admin = new Admin();
				admin.setVisible(true);
				CloseFrame();
				
				
			}
		});
		btnIptal.setBounds(251, 366, 90, 34);
		contentPane.add(btnIptal);
		
		lblNewLabel_2 = new JLabel(".TL");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(350, 321, 66, 27);
		contentPane.add(lblNewLabel_2);
	}
	public static void MysqlConnector() {
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("select * from kullanici");
			   PreparedStatement statement;
			  
				   statement = (PreparedStatement) myConn.prepareStatement("select * from kullanici where kullanicino = ? ");
			   
			       
				   statement.setString(1, textField.getText());    

			   ResultSet resultSet = statement.executeQuery();
			   //results set
				 boolean bulundu = false  ; 

			   while (resultSet.next()) {
				   
			
			// String kullanicino = resultSet.getString("kullanicino");
				  
				//  if (kullanicino.equals(tip)) {
					  
				   Mysqlist(textField.getText());
					 bulundu = true ; 
					  
				
			   }
			 
			    if (bulundu==false) {
			    	JOptionPane.showMessageDialog(null, "Kullanici Bulunamadi","HATA",JOptionPane.WARNING_MESSAGE);
			    	textField.setText("");
				   
			   }
		        
			   
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
	
	}

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void Mysqlist(String id) {
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("select * from kullanici");
			   PreparedStatement statement;
			  
				   statement = (PreparedStatement) myConn.prepareStatement("select * from kullanici  ");
			   
			       
				  

			   ResultSet resultSet = statement.executeQuery();
			   //results set
				

			   while (resultSet.next()) {
				 if  (id.equals(resultSet.getString("kullanicino"))) {
					 
					 textField_1.setText(resultSet.getString("kullanicino"));
					   textField_2.setText(resultSet.getString("kullaniciadi"));
					   textField_3.setText(resultSet.getString("kullanicisoyadi"));
					   textField_4.setText(resultSet.getString("kullanicimail"));
					   textField_5.setText(resultSet.getString("kullaniciborcu"));
				 }
				  
				  
				
			   }
			 
			  
			   
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
	
	}

	public void itemStateChanged111(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void MysqlConnectorsil(int id) {
		try {  
			
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   Statement myStmt = (Statement) myConn.createStatement();
			   myStmt.executeUpdate("delete from kullanici  where kullanicino="+id) ;
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
		
		
		
	}

	public void itemStateChanged11(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
	public static void MysqlConnectorekle() {
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			  // ResultSet myRs = myStmt.executeQuery("");
			  
			  
			    PreparedStatement   statement = (PreparedStatement) myConn.prepareStatement("insert into kullanici (kullanicino,kullaniciadi,kullanicisoyadi,kullanicimail,kullaniciborcu) values (?,?,?,?,?)");
			        int no = Integer.parseInt(textField_1.getText());
                    statement.setInt(1, no);		  
                    statement.setString(2,textField_2.getText());			  
                    statement.setString(3,textField_3.getText());	
                    statement.setString(4,textField_4.getText());	
                    statement.setString(5,textField_5.getText());	

                         
			       JOptionPane.showMessageDialog(null, "Düzenleme iþlemi tamamlandý","",JOptionPane.INFORMATION_MESSAGE);
			       textField.setText(null);
			       textField_1.setText(null);
			       textField_2.setText(null);
			       textField_3.setText(null);
			       textField_4.setText(null);
			       textField_5.setText(null);

			   statement.execute();
			 
			   
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

}
