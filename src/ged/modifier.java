package ged;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.List;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.Position;
import javax.swing.DefaultComboBoxModel;

import java.sql.Date;

import javax.swing.JTextPane;

public class modifier extends JFrame {

	private JPanel contentPane;
	private JTextField meuble;
	private JTextField section;
	private JTextField espace_occupe;
	private JTextField description;
	private JTextField classement;
	private JTextField date_creation;
	private JTextField date_extreme;
	private JTextField valtype;
	private JTextField searchtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifier frame = new modifier();
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
	
	
	public modifier() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 814, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		this.setTitle("modifier un document");
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		try {
			this.setIconImage(ImageIO.read(new File("C:\\Users\\pc_hp\\workspace\\demoged\\img\\document.png")));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		JLabel label = new JLabel("Meuble");
		label.setBounds(425, 431, 37, 50);
		panel.add(label);
		
		meuble = new JTextField();
		meuble.setColumns(10);
		meuble.setBounds(532, 441, 163, 30);
		panel.add(meuble);
		
		JLabel label_1 = new JLabel("Section ");
		label_1.setBounds(425, 492, 46, 50);
		panel.add(label_1);
		
		section = new JTextField();
		section.setText("");
		section.setColumns(10);
		section.setBounds(532, 502, 163, 30);
		panel.add(section);
		
		JLabel label_2 = new JLabel("espace occupe");
		label_2.setBounds(770, 188, 71, 50);
		panel.add(label_2);
		
		espace_occupe = new JTextField();
		espace_occupe.setColumns(10);
		espace_occupe.setBounds(861, 198, 177, 30);
		panel.add(espace_occupe);
		
		JLabel label_3 = new JLabel("description");
		label_3.setBounds(431, 342, 58, 50);
		panel.add(label_3);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(530, 341, 220, 61);
		panel.add(description);
		
		JLabel label_4 = new JLabel("date de creation");
		label_4.setBounds(770, 431, 81, 50);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("date extreme");
		label_5.setBounds(770, 492, 71, 50);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("P ou S");
		label_6.setBounds(454, 224, 37, 50);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("classement");
		label_7.setBounds(434, 275, 58, 50);
		panel.add(label_7);
		
		classement = new JTextField();
		classement.setColumns(10);
		classement.setBounds(532, 285, 163, 30);
		panel.add(classement);
		
		JLabel label_8 = new JLabel("Consultation");
		label_8.setBounds(770, 246, 71, 50);
		panel.add(label_8);
		
		JComboBox p_s = new JComboBox();
		p_s.setModel(new DefaultComboBoxModel(new String[] {"p", "s"}));
		p_s.setBounds(531, 234, 134, 30);
		panel.add(p_s);
		
		JComboBox consultation = new JComboBox();
		consultation.setModel(new DefaultComboBoxModel(new String[] {"forte", "moyenne", "faible"}));
		consultation.setBounds(861, 254, 177, 30);
		panel.add(consultation);
		
		JLabel label_9 = new JLabel("num type");
		label_9.setBounds(454, 119, 73, 32);
		panel.add(label_9);
		
		JComboBox num_type = new JComboBox();
		num_type.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		num_type.setBounds(537, 120, 81, 30);
		panel.add(num_type);
		
		
	/////	 JFrame frame = new JFrame();
	/////	 frame.setSize(1080, 1000);
		 
	/////		    ImageIcon icon = new ImageIcon("C:\\Users\\pc_hp\\workspace\\demoged\\img\\document.png");
		  	 
	/////	    frame.setIconImage(icon.getImage());
	/////	    frame.setContentPane(panel);
	/////	    frame.setVisible(true);
	/////    panel.setVisible(true);   
		    
		
		
		
		
		JList liste1 = new JList();
		liste1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				////////
				String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
				Connection con;
				try {
					con = DriverManager.getConnection(conUrl);
					java.sql.Statement stmt = con.createStatement();
					String Query = "select * from document where description_doc ='"+liste1.getSelectedValue()+"'";
					ResultSet rs = stmt.executeQuery(Query);
					valtype.setEditable(false);
					while(rs.next()){
						num_type.setSelectedItem(rs.getString(3));
						meuble.setText(rs.getString(4));
						section.setText(rs.getString(5));
						espace_occupe.setText(rs.getString(6));
						date_creation.setText(rs.getString(7));
						date_extreme.setText(rs.getString(8)); 
						description.setText(rs.getString(9));
						classement.setText(rs.getString(10));
						consultation.setSelectedItem(rs.getString(11));
						p_s.setSelectedItem(rs.getString(16));
						if(num_type.getSelectedIndex()==0){valtype.setText("document general");}
						if(num_type.getSelectedIndex()==1){valtype.setText("legislation");}
						if(num_type.getSelectedIndex()==2){valtype.setText("reglementation");}
						if(num_type.getSelectedIndex()==3){valtype.setText("lois");}
						if(num_type.getSelectedIndex()==4){valtype.setText("reglement");}
						if(num_type.getSelectedIndex()==5){valtype.setText("rapport");}
						if(num_type.getSelectedIndex()==6){valtype.setText("pv");}
						if(num_type.getSelectedIndex()==7){valtype.setText("proces");}
						if(num_type.getSelectedIndex()==8){valtype.setText("tableaux de bord");}
						if(num_type.getSelectedIndex()==9){valtype.setText("gestion de ressources");}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.toString());
				}
				
			}
		});
		liste1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		liste1.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new BevelBorder(BevelBorder.LOWERED, new Color(109, 109, 109), null, null, null)));
		liste1.setBounds(10, 119, 239, 462);
		panel.add(liste1);
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
		Connection con;
		try {
			con = DriverManager.getConnection(conUrl);
			java.sql.Statement stmt = con.createStatement();
			String Query = "select * from document";
			ResultSet rs = stmt.executeQuery(Query);
			
			DefaultListModel dlm = new DefaultListModel();
			while(rs.next()){
				dlm.addElement(rs.getString(9));
				
			}
			liste1.setModel(dlm);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.toString());
		}
		
		////___________________________________________________________________________________------
			
				
		
		////___________________________________________________________________________________------
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton update = new JButton("Mettre \u00E0 jour");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
				Connection con;
				try {
					con = DriverManager.getConnection(conUrl);
					java.sql.Statement stmt = con.createStatement();
					String Query = "update document set id_type='"+num_type.getSelectedItem()+"',meuble='"+meuble.getText()+"',section_meuble='"+section.getText()+"',date_creation='"+date_creation.getText()+"',date_extreme='"+date_extreme.getText()+"',description_doc='"+description.getText()+"',classement='"+classement.getText()+"',consultation='"+consultation.getSelectedItem()+"',p_ou_s='"+p_s.getSelectedItem()+"' where description_doc='"+liste1.getSelectedValue()+"'";
					stmt.execute(Query);
					JOptionPane.showMessageDialog(null, "les donnees ont été mis à jour");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				///////actualiser la page_________________________________________________________________________________________________________________________________________________________
				try {
					con = DriverManager.getConnection(conUrl);
					java.sql.Statement stmt = con.createStatement();
					String Query = "select * from document";
					ResultSet rs = stmt.executeQuery(Query);
					
					DefaultListModel dlm = new DefaultListModel();
					while(rs.next()){
						dlm.addElement(rs.getString(9));
						
					}
					liste1.setModel(dlm);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.toString());
				}
				//_________________________________________________________________________________________________________________________________________________________________________________________
			}
		});
		update.setBounds(815, 577, 123, 41);
		panel.add(update);
		
		JButton delete = new JButton("Supprimer");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
				Connection con;
				int supprimer = JOptionPane.showConfirmDialog(null, "voulez vous vraiment supprimer ces donnees ?","supprimer",JOptionPane.YES_NO_OPTION);
				if(supprimer==0){
					try {
						con = DriverManager.getConnection(conUrl);
						java.sql.Statement stmt = con.createStatement();
						String Query="delete from document where description_doc ='"+liste1.getSelectedValue()+"'";
						stmt.execute(Query);
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try{
			    		
			    		File file = new File("C:\\Users\\pc_hp\\Desktop\\documents\\"+meuble.getText()+"\\"+section.getText()+"\\"+liste1.getSelectedValue()+".txt");
			        	
			    		if(file.delete()){
			    			JOptionPane.showMessageDialog(null, file.getName() + " is deleted!");
			    		}else{
			    			JOptionPane.showMessageDialog(null,"Delete operation is failed.");
			    		}
			    	   
			    	}catch(Exception e1){
			    		
			    		e1.printStackTrace();
			    		
			    	}
				}
			///////actualiser la page_________________________________________________________________________________________________________________________________________________________
							try {
								con = DriverManager.getConnection(conUrl);
								java.sql.Statement stmt = con.createStatement();
								String Query = "select * from document";
								ResultSet rs = stmt.executeQuery(Query);
								
								DefaultListModel dlm = new DefaultListModel();
								while(rs.next()){
									dlm.addElement(rs.getString(9));
									
								}
								liste1.setModel(dlm);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1.toString());
							}
			//_________________________________________________________________________________________________________________________________________________________________________________________
						
			}
		});
		delete.setBounds(617, 577, 133, 41);
		panel.add(delete);
		
		date_creation = new JTextField();
		date_creation.setBounds(861, 441, 193, 30);
		panel.add(date_creation);
		date_creation.setColumns(10);
		
		date_extreme = new JTextField();
		date_extreme.setColumns(10);
		date_extreme.setBounds(861, 502, 193, 30);
		panel.add(date_extreme);
		
		valtype = new JTextField();
		valtype.setColumns(10);
		valtype.setBounds(532, 172, 163, 30);
		panel.add(valtype);
		valtype.setEditable(false);
		
		JLabel lblTypeDocument = new JLabel("type document");
		lblTypeDocument.setBounds(419, 178, 96, 14);
		panel.add(lblTypeDocument);
		
		searchtext = new JTextField();
		searchtext.setBounds(10, 25, 239, 30);
		panel.add(searchtext);
		searchtext.setColumns(10);
		
		JButton searchbtn = new JButton("Rechercher");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = liste1.getNextMatch(searchtext.getText(), 0, Position.Bias.Forward);
				liste1.setSelectedIndex(res);
			}
		});
		searchbtn.setBounds(20, 69, 110, 41);
		panel.add(searchbtn);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
