package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class GirisEkrani extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static int rando;
	private JTextField textkullaniciadi;
	
	
	
	private JLabel kullaniciicon;
	private JLabel sifreicon;
	private JLabel lblNewLabel_4;
	JLabel lblNewLabel = new JLabel("");
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
   public void Closeframe() {
	   
	   super.dispose();
   }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Random ra = new Random();
					rando = ra.nextInt(100);

					GirisEkrani frame = new GirisEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GirisEkrani() {
		setTitle("G\u0130R\u0130\u015E EKRANI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GirisEkrani.class.getResource("/otomasyon_yeni/kilit.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(55, 316, 134, 55);
		contentPane.add(lblNewLabel_1);
		textkullaniciadi = new JTextField();
		textkullaniciadi.setBounds(154, 119, 236, 25);
		contentPane.add(textkullaniciadi);
		textkullaniciadi.setColumns(10);
	
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(105, 316, 328, 55);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 194, 236, 25);
		contentPane.add(passwordField);
		/*
         * btnara.addActionListener(new ActionListener() {
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
         *  
         *  
         *  */
		
		JButton butongiris = new JButton("G\u0130R\u0130\u015E");
		butongiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String kullaniciadi = textkullaniciadi.getText(); 
				
				@SuppressWarnings("deprecation")
				String sifre = passwordField.getText(); 
				if(kullaniciadi.equals("admin")&&sifre.equals("admin")) {
					
					Closeframe();
					Admin admin = new Admin();  
					admin.setVisible(true);
					
					
					
					
				}
				 
				
				else {
					
					lblNewLabel_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/cancel.png")));
					lblNewLabel.setText("Kullanici adi ya da sifre yanlýþ,Tekrar Dene!!");
					textkullaniciadi.setText("");
					passwordField.setText("");
				}
				
				
				
				
			}
		});
		butongiris.setForeground(new Color(0, 0, 139));
		butongiris.setBackground(new Color(240, 230, 140));
		butongiris.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		butongiris.setBounds(154, 252, 113, 37);
		contentPane.add(butongiris);
		
		kullaniciicon = new JLabel("Kullanici Adi: ");
		kullaniciicon.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 20));
		kullaniciicon.setForeground(new Color(255, 255, 0));
		kullaniciicon.setBounds(10, 111, 134, 37);
		contentPane.add(kullaniciicon);
		JButton btnGeri = new JButton("\u00C7IKI\u015E");
		btnGeri.setForeground(new Color(0, 0, 139));
		btnGeri.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		btnGeri.setBackground(new Color(220, 20, 60));
		btnGeri.setBounds(277, 252, 113, 37);
		contentPane.add(btnGeri);
		sifreicon = new JLabel("\u015Eifre :");
		sifreicon.setForeground(new Color(255, 255, 0));
		sifreicon.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 20));
		sifreicon.setBounds(10, 191, 104, 25);
		contentPane.add(sifreicon);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 255, 0));
		lblNewLabel_4.setBounds(0, 0, 456, 393);
		contentPane.add(lblNewLabel_4);
		
		
		lblNewLabel_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otomasyon_yeni/giphy.gif")));
		
		
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   Closeframe(); 
			   AnaEkran ekran = new AnaEkran();
			   ekran.setVisible(true);
				
			}
		});
		
		
		
		
		
		
		


		
		
	}
}
