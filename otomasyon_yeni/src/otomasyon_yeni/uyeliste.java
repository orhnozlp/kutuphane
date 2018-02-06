package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;

public class uyeliste extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private static JTable table;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public void Closeframe() {
		   
		   super.dispose();
	   }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uyeliste frame = new uyeliste();
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
	public uyeliste() {
		setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		setTitle("Kitap Listesi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00DCYE L\u0130STES\u0130");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(188, 5, 176, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Closeframe();
				Admin admin = new Admin();  
				admin.setVisible(true);
			}
		});
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setBackground(new Color(0, 0, 128));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, null, null, null));
		table.setColumnSelectionAllowed(true);
		//table.setSelectionModel(new javax.swing.ImageIcon(getClass().getResource("/Otomasyon/backn.png")));
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		table.setForeground(new Color(255, 255, 0));
		table.setBounds(0, 84, 640, 360);
		contentPane.add(table);

		MysqlConnector();

		btnNewButton.setBounds(508, 5, 72, 34);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/backn.png")));
		
		
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBackground(new Color(0, 128, 0));
		table.setBounds(10, 399, 570, -326);
		contentPane.add(table);
		
		table_2 = new JTable();
		table_2.setBounds(20, 72, 1, 1);
		contentPane.add(table_2);
		
		JLabel lblNewLabel_1 = new JLabel("KULLAN\u0130C\u0130 NO");
		lblNewLabel_1.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(10, 44, 114, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblKullaniciAdi = new JLabel("KULLAN\u0130C\u0130 AD\u0130");
		lblKullaniciAdi.setForeground(Color.YELLOW);
		lblKullaniciAdi.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 12));
		lblKullaniciAdi.setBounds(122, 44, 114, 34);
		contentPane.add(lblKullaniciAdi);
		
		JLabel lblyeSoyadi = new JLabel("  KULLAN\u0130C\u0130 SOYAD\u0130");
		lblyeSoyadi.setForeground(Color.YELLOW);
		lblyeSoyadi.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 12));
		lblyeSoyadi.setBounds(237, 47, 146, 29);
		contentPane.add(lblyeSoyadi);
		
		JLabel lblyeBorcutl = new JLabel(" BORCU (TL)");
		lblyeBorcutl.setForeground(Color.YELLOW);
		lblyeBorcutl.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 12));
		lblyeBorcutl.setBounds(531, 44, 131, 34);
		contentPane.add(lblyeBorcutl);
		
		JLabel lblyeMail = new JLabel("KULLAN\u0130C\u0130 MA\u0130L");
		lblyeMail.setForeground(Color.YELLOW);
		lblyeMail.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 12));
		lblyeMail.setBounds(393, 47, 114, 29);
		contentPane.add(lblyeMail);
		MysqlConnector();

		
		
	}
	public static void MysqlConnector() {
		try {
			
			
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("SELECT * FROM `kitap` ");
			   PreparedStatement statement;
			 
				   statement = (PreparedStatement) myConn.prepareStatement("SELECT * FROM `kullanici`");
			        

			       
			  // statement.setString(1, "kitapadi");    
	  ResultSet resultSet = statement.executeQuery();
			   //results set
	  table.setModel(DbUtils.resultSetToTableModel(resultSet));
	  
	  
		}
			 
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
		
	}
	
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
