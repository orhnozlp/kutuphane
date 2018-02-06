package otomasyon_yeni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;




public class Admin extends JFrame {

	
	public void CloseFrame() {
		super.dispose();
		
		
	}
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setFont(new Font("Aldhabi", Font.BOLD, 29));
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/otomasyon_yeni/kullan\u0131c\u0131.png")));
		setTitle("    ADM\u0130N\u0130STRATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* 
		 * 
		 *   JButton btnNewButton = new JButton("Personel i\u015Flemleri ");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setForeground(Color.ORANGE);
	   btnNewButton.setBackground(SystemColor.textHighlight);
		 * 
		 * 
		 * */
		
		
		
		
		JButton btnNewButton = new JButton("K\u0130TAP EKLE/S\u0130L");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame() ;
				KitapEkle ekle = new KitapEkle(); 
				ekle.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(148, 0, 211));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBounds(259, 120, 182, 52);
		contentPane.add(btnNewButton);
		
		JButton btnyeEkle = new JButton("\u00DCYE KAYIT");
		btnyeEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame(); 
				UyeEkle ekle = new UyeEkle() ; 
			    ekle.setVisible(true);
				
				
				
			}
		});
		btnyeEkle.setForeground(Color.YELLOW);
		btnyeEkle.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnyeEkle.setBackground(new Color(148, 0, 211));
		btnyeEkle.setBounds(28, 120, 193, 52);
		contentPane.add(btnyeEkle);
		
		JButton btnyeListesi = new JButton("\u00DCYE L\u0130STES\u0130");
		btnyeListesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
		         uyeliste liste = new uyeliste() ; 
		         
		         liste.setVisible(true);	
			}
		});
		btnyeListesi.setForeground(Color.YELLOW);
		btnyeListesi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnyeListesi.setBackground(new Color(139, 69, 19));
		btnyeListesi.setBounds(28, 183, 193, 52);
		contentPane.add(btnyeListesi);
		
		JButton btnKitapListesi = new JButton("K\u0130TAP L\u0130STES\u0130");
		btnKitapListesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 CloseFrame();
         kitapliste liste = new kitapliste(); 
         liste.setVisible(true);				
				
				
			}
		});
		btnKitapListesi.setForeground(Color.YELLOW);
		btnKitapListesi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnKitapListesi.setBackground(new Color(139, 69, 19));
		btnKitapListesi.setBounds(259, 183, 182, 52);
		contentPane.add(btnKitapListesi);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			System.exit(1);	
			
				
				
			}
		});
		btnk.setForeground(Color.YELLOW);
		btnk.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnk.setBackground(Color.RED);
		btnk.setBounds(259, 246, 182, 52);
		contentPane.add(btnk);
		JButton btnyeBilgileriDzenle = new JButton("\u00DCYE D\u00DCZENLE");
		btnyeBilgileriDzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			 Duzenle duzenle = new  Duzenle () ; 
			 duzenle.setVisible(true);
				
				
			}
		});
		btnyeBilgileriDzenle.setForeground(Color.YELLOW);
		btnyeBilgileriDzenle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnyeBilgileriDzenle.setBackground(Color.RED);
		btnyeBilgileriDzenle.setBounds(28, 246, 193, 52);
		contentPane.add(btnyeBilgileriDzenle);
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setBackground(Color.GREEN);
			lblNewLabel.setBounds(0, 0, 482, 458);
			contentPane.add(lblNewLabel);
			lblNewLabel.setIcon(new javax.swing.ImageIcon (getClass().getResource("/otomasyon_yeni/imgresize.jpg"))); 
			lblNewLabel.setIcon(new javax.swing.ImageIcon (getClass().getResource("/otomasyon_yeni/giphy (3).gif"))); 
			
		

	}
}
