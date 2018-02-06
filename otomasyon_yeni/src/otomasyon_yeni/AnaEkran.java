package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
@SuppressWarnings("unused")
public class AnaEkran extends JFrame implements ItemListener{

	private static  JPanel contentPane;
	private static JTextField textField;
    private ButtonGroup Grpbtn = new ButtonGroup() ; 
    JRadioButton rdbtnyazar;
    JRadioButton butonkitap;
	/**
	 * Launch the application.
	 */
	   static JLabel lblNewLabel_2 = new JLabel("");
	   public void CloseFrame(){
		    super.dispose();
		}
   
	public static void main(String[] args) {
		
				try {
					AnaEkran frame1 = new AnaEkran();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
/*				EventQueue.invokeLater(new Runnable() {
					public void run() {
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public AnaEkran() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnaEkran.class.getResource("/otomasyon_yeni/giris.png")));
		setFont(new Font("Charlemagne Std", Font.BOLD | Font.ITALIC, 12));
		setType(Type.POPUP);
		setTitle("K\u00FCt\u00FCphane Takip Otomasyonu");
		setBackground(Color.DARK_GRAY);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 363);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Personel i\u015Flemleri ");
		//btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/images.jpg")));

		btnNewButton.setFont(new Font("Myriad Pro Light", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setForeground(SystemColor.textHighlight);
	  btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(478, 117, 164, 92);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
				//GirisEkrani as = new GirisEkrani() ; 
				CloseFrame();
				GirisEkrani giris = new GirisEkrani(); 
				giris.setVisible(true);
			   
				
				
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(129, 192, -24, 17);
		contentPane.add(list);
		
		JLabel lblTmKaynaklardaelektronik = new JLabel("T\u00FCm kaynaklarda (elektronik ve bas\u0131l\u0131) aray\u0131n..");
		lblTmKaynaklardaelektronik.setForeground(new Color(255, 255, 0));
		lblTmKaynaklardaelektronik.setBounds(10, 71, 482, 63);
		lblTmKaynaklardaelektronik.setFont(new Font("Gisha", Font.BOLD | Font.ITALIC, 21));
		contentPane.add(lblTmKaynaklardaelektronik);
		
		textField = new JTextField();
		textField.setBounds(10, 133, 391, 42);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnara = new JButton("");
		btnara.setBounds(411, 133, 61, 42);
		btnara.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnara.setForeground(Color.BLUE);
		btnara.setBackground(SystemColor.inactiveCaptionBorder);
		btnara.setIcon(new ImageIcon(AnaEkran.class.getResource("/otomasyon_yeni/arama.png")));
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnyazar.isSelected()) {
					MysqlConnector(0);
				}
				else if(butonkitap.isSelected()) {
				MysqlConnector(1);
				}
				
			}
		});
		contentPane.add(btnara);
		
		 rdbtnyazar = new JRadioButton("Yazar Ad\u0131na G\u00F6re");
		 rdbtnyazar.setForeground(Color.BLUE);
		 rdbtnyazar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		 rdbtnyazar.setBackground(SystemColor.activeCaption);
		 rdbtnyazar.setBounds(176, 182, 145, 36);
		contentPane.add(rdbtnyazar);
		lblNewLabel_2.setBackground(new Color(176, 224, 230));
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(0, 208, 642, 116);
		//lblNewLabel_2.setl
		contentPane.add(lblNewLabel_2);
		 butonkitap = new JRadioButton("Kitap Ad\u0131na G\u00F6re");
		 butonkitap.setForeground(Color.BLUE);
		 butonkitap.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		 butonkitap.setBackground(SystemColor.activeCaption);
		 butonkitap.setBounds(10, 182, 152, 36);
		contentPane.add(butonkitap);
		Grpbtn.add(rdbtnyazar);
		Grpbtn.add(butonkitap);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(224, 196, -70, 43);
		contentPane.add(layeredPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(40, 17, 620, 43);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/anaustresim2.png")));
		
		JLabel arkaplan = new JLabel("New label");
		arkaplan.setBounds(0, 0, 660, 351);
		contentPane.add(arkaplan);
		arkaplan.setIcon(new ImageIcon("C:\\Users\\ASUS-PC\\Desktop\\background-2490186_960_720.jpg"));
		
		
       
		
		
	
	}
	
	public static void MysqlConnector(int tip) {
		try {  
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kutuphane", "root", "");
			   
			   //create statement 
			   Statement myStmt = (Statement) myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("select * from kitap");
			   PreparedStatement statement;
			   if(tip==0) {
				   statement = (PreparedStatement) myConn.prepareStatement("select * from kitap where kitapyazari = ?");
			   }
			   else {
				   statement = (PreparedStatement) myConn.prepareStatement("select * from kitap where kitapadi = ?");
			   }

			       
			   statement.setString(1, textField.getText());    
			   ResultSet resultSet = statement.executeQuery();
			   //results set
				
			   while (resultSet.next()) {
				   
				   int id = resultSet.getInt("id");
				   String kitap_adi = resultSet.getString("kitapadi");
				   String kitap_yeri = resultSet.getString("kitapyeri");
				   String kitap_yazari = resultSet.getString("kitapyazari");
				   String oduncal  = resultSet.getString("odunc")  ; 
					
						
				   String label_text = 
						   " Kitap Adi :" + kitap_adi+ 
						   " Yeri :" + kitap_yeri+  
						   " Yazarý : " + kitap_yazari+ " " +oduncal; 
							
				   lblNewLabel_2.setText(label_text);
				  
				
			   }
			 
			   
		        if(!resultSet.first() && !resultSet.next()){
		        lblNewLabel_2.setText("Kitap Bulunamadi ");
		        
		         }
			   
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
