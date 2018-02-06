package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

@SuppressWarnings({ "serial", "unused" })
public class kitapliste extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kitapliste frame = new kitapliste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Closeframe() {
		   
		   super.dispose();
	   }
	/**
	 * Create the frame.
	 */
	public kitapliste() {
	

		setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		setTitle("Kitap Listesi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/backn.png")));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		table.setForeground(Color.YELLOW);
		table.setBounds(0, 85, 618, 374);
		contentPane.add(table);

		MysqlConnector();

		btnNewButton.setBounds(508, 5, 72, 43);
		contentPane.add(btnNewButton);
		JLabel lblTmKitaplar = new JLabel("T\u00FCm Kitaplar");
		lblTmKitaplar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblTmKitaplar.setForeground(Color.YELLOW);
		lblTmKitaplar.setBounds(179, 10, 213, 32);
		contentPane.add(lblTmKitaplar);
		
		JLabel lblNewLabel = new JLabel("\u0130D                            K\u0130TAP AD\u0130                 K\u0130TAP YAZAR\u0130            K\u0130TAP YER\u0130       \u00D6D\u00DCN\u00C7  ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(0, 41, 580, 43);
		contentPane.add(lblNewLabel);
		
		

		
		
		
	
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
				 
					   statement = (PreparedStatement) myConn.prepareStatement("SELECT * FROM `kitap`");
				        

				       
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

