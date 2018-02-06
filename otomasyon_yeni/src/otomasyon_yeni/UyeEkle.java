package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class UyeEkle extends JFrame {

	protected static final String NULL = null;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;

	/**
	 * Launch the application.
	 */
	
	public void CloseFrame() {
		super.dispose();
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyeEkle frame = new UyeEkle();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UyeEkle() {
		setTitle("\u00DCYE KAYIT");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UyeEkle.class.getResource("/otomasyon_yeni/kullan\u0131c\u0131\u0131.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		textField = new JTextField();
		textField.setBounds(159, 70, 221, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 156, 221, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 199, 200, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 113, 221, 32);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("KULLANICI ADI : ");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 113, 168, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblKullancSoyad = new JLabel("KULLANICI SOYADI: ");
		lblKullancSoyad.setForeground(new Color(255, 255, 0));
		lblKullancSoyad.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblKullancSoyad.setBounds(10, 156, 168, 32);
		contentPane.add(lblKullancSoyad);
		
		JLabel lblKullancBorcu = new JLabel("KULLANICI MA\u0130L\u0130: ");
		lblKullancBorcu.setForeground(new Color(255, 255, 0));
		lblKullancBorcu.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblKullancBorcu.setBounds(10, 199, 168, 32);
		contentPane.add(lblKullancBorcu);
		
		JLabel lblKullancNo = new JLabel("KULLANICI NO : ");
		lblKullancNo.setForeground(new Color(255, 255, 0));
		lblKullancNo.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblKullancNo.setBounds(10, 70, 168, 32);
		contentPane.add(lblKullancNo);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		comboBox.setBounds(384, 198, 157, 34);
		comboBox.addItem("hotmail.com");
		comboBox.addItem("gmail.com");

		comboBox.addItem("outlook.com");

		JButton btnNewButton = new JButton("KAYDET");
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mail=NULL ;
				 Object selected = comboBox.getSelectedItem();
	                if(selected.toString().equals("hotmail.com"))
	                 mail = textField_2.getText() +"@"+"hotmail.com";
	                else if(selected.toString().equals("gmail.com"))
	                    mail = textField_2.getText() +"@"+"gmail.com"; 
	                else if(selected.toString().equals("outlook.com"))
	                    mail = textField_2.getText() +"@"+"outlook.com"; 
				 
	        		MysqlConnector(mail);
			        
				
				
				
				
			}
		});
		btnNewButton.setBounds(271, 242, 90, 40);
		contentPane.add(btnNewButton);
		
		contentPane.add(comboBox);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(58, 11, 517, 48);
		lblNewLabel_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/ÜYEKAYIT.png")));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(139, 69, 19));
		btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/backn.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
			CloseFrame() ; 	
			Admin admin = new Admin(); 
			admin.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(159, 242, 90, 40);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel_3 = new JLabel("@");
		lblNewLabel_3.setFont(new Font("Tekton Pro", Font.BOLD, 25));
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setBounds(360, 199, 71, 32);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 551, 324);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS-PC\\Desktop\\art-leather-579712_640.jpg"));
		contentPane.add(lblNewLabel_2);
	
	
		
	} 
	public static void MysqlConnector(String mail) {
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			  // ResultSet myRs = myStmt.executeQuery("");
			  
			  
			    PreparedStatement   statement = (PreparedStatement) myConn.prepareStatement("insert into kullanici (kullanicino,kullaniciadi,kullanicisoyadi,kullanicimail,kullaniciborcu) values (?,?,?,?,0)");
			    
			    		 int x = Integer.parseInt(textField.getText());
			    	     statement.setInt(1, x);		  
		                    statement.setString(2,textField_3.getText());			  
		                    statement.setString(3,textField_1.getText());	
		                    statement.setString(4,mail);	
		                    
		                    
		                    //statement.setString(5,"0 TL ");
					       
					
					   statement.execute();
					   JOptionPane.showMessageDialog(null, "Kayýt Baþarý ile yapýldý.");
					   textField.setText(NULL);
					   textField_1.setText(NULL);

					   textField_2.setText(NULL);

					   textField_3.setText(NULL);

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

