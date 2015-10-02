package ged;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

public class rechercher extends JFrame {

	private JPanel contentPane;
	private JComboBox selection1;
	private JComboBox selection2;
	private JTextField valtype;
	private JTextField classement;
	private JTextField description;
	private JTextField espace_occupe;
	private JTextField meuble;
	private JTextField section;
	private JTextField date_creation;
	private JTextField date_extreme;
	private JTextField searchtext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rechercher frame = new rechercher();
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
	public rechercher() {	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 891, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("rechercher un document");
		
		try {
			this.setIconImage(ImageIO.read(new File("C:\\Users\\pc_hp\\workspace\\demoged\\img\\document.png")));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JLabel lblRechercher = new JLabel("Rechercher");
		lblRechercher.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRechercher.setBounds(259, 45, 117, 31);
		contentPane.add(lblRechercher);
		
		JLabel label = new JLabel("num type");
		label.setBounds(265, 223, 73, 32);
		contentPane.add(label);
		
		JComboBox num_type = new JComboBox();
		num_type.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		num_type.setBounds(358, 224, 81, 30);
		contentPane.add(num_type);
		
		JLabel label_1 = new JLabel("type document");
		label_1.setBounds(243, 314, 96, 14);
		contentPane.add(label_1);
		
		valtype = new JTextField();
		valtype.setEditable(false);
		valtype.setColumns(10);
		valtype.setBounds(358, 306, 164, 30);
		contentPane.add(valtype);
		
		JLabel label_2 = new JLabel("P ou S");
		label_2.setBounds(717, 223, 37, 50);
		contentPane.add(label_2);
		
		JComboBox p_s = new JComboBox();
		p_s.setModel(new DefaultComboBoxModel(new String[] {"p", "s"}));
		p_s.setBounds(802, 233, 104, 30);
		contentPane.add(p_s);
		
		JLabel label_3 = new JLabel("classement");
		label_3.setBounds(707, 299, 58, 50);
		contentPane.add(label_3);
		
		classement = new JTextField();
		classement.setColumns(10);
		classement.setBounds(801, 301, 174, 30);
		contentPane.add(classement);
		
		JLabel label_4 = new JLabel("description");
		label_4.setBounds(243, 369, 78, 50);
		contentPane.add(label_4);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(361, 369, 200, 61);
		contentPane.add(description);
		
		JLabel label_5 = new JLabel("espace occupe");
		label_5.setBounds(707, 346, 71, 50);
		contentPane.add(label_5);
		
		espace_occupe = new JTextField();
		espace_occupe.setColumns(10);
		espace_occupe.setBounds(802, 356, 173, 30);
		contentPane.add(espace_occupe);
		
		JLabel label_6 = new JLabel("Consultation");
		label_6.setBounds(707, 407, 71, 50);
		contentPane.add(label_6);
		
		JComboBox consultation = new JComboBox();
		consultation.setModel(new DefaultComboBoxModel(new String[] {"forte", "moyenne", "faible"}));
		consultation.setBounds(802, 417, 133, 30);
		contentPane.add(consultation);
		
		JLabel label_7 = new JLabel("Meuble");
		label_7.setBounds(289, 468, 37, 50);
		contentPane.add(label_7);
		
		meuble = new JTextField();
		meuble.setColumns(10);
		meuble.setBounds(366, 478, 156, 30);
		contentPane.add(meuble);
		
		JLabel label_8 = new JLabel("Section ");
		label_8.setBounds(289, 529, 46, 50);
		contentPane.add(label_8);
		
		section = new JTextField();
		section.setText("");
		section.setColumns(10);
		section.setBounds(366, 539, 156, 30);
		contentPane.add(section);
		
		JLabel label_9 = new JLabel("date de creation");
		label_9.setBounds(688, 468, 103, 50);
		contentPane.add(label_9);
		
		date_creation = new JTextField();
		date_creation.setColumns(10);
		date_creation.setBounds(801, 478, 174, 30);
		contentPane.add(date_creation);
		
		JLabel label_10 = new JLabel("date extreme");
		label_10.setBounds(698, 529, 93, 50);
		contentPane.add(label_10);
		
		date_extreme = new JTextField();
		date_extreme.setColumns(10);
		date_extreme.setBounds(801, 539, 174, 30);
		contentPane.add(date_extreme);
		
		JLabel lblNewLabel = new JLabel("________________________________________________________________________________________________________________________\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(218, 148, 850, 14);
		contentPane.add(lblNewLabel);
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
		Connection con;
		selection1 = new JComboBox();
		selection1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con;
					con = DriverManager.getConnection(conUrl);
					String query1 = "select * from document";
					java.sql.Statement st = (java.sql.Statement) con.createStatement();
					ResultSet rs= st.executeQuery(query1);
					//DefaultComboBoxModel model = (DefaultComboBoxModel) selection2.getModel();
					while (rs.next()) {
						
						if(selection1.getSelectedIndex()==0){selection2.addItem(rs.getString(1));  selection2.removeItem(rs.getString(4)); selection2.removeItem(rs.getString(5));selection2.removeItem(rs.getString(9));selection2.removeItem(rs.getString(7));}
						if(selection1.getSelectedIndex()==1){selection2.addItem(rs.getString(4));  selection2.removeItem(rs.getString(1)); selection2.removeItem(rs.getString(5));selection2.removeItem(rs.getString(9));selection2.removeItem(rs.getString(7));  }
						if(selection1.getSelectedIndex()==2){selection2.addItem(rs.getString(5));  selection2.removeItem(rs.getString(4)); selection2.removeItem(rs.getString(1));selection2.removeItem(rs.getString(9));selection2.removeItem(rs.getString(7));  }
						if(selection1.getSelectedIndex()==3){selection2.addItem(rs.getString(9));  selection2.removeItem(rs.getString(4)); selection2.removeItem(rs.getString(5));selection2.removeItem(rs.getString(1));selection2.removeItem(rs.getString(7));   }
						
						
		            }
					 rs= st.executeQuery(query1);
					/*

					con = DriverManager.getConnection(conUrl);
					String Query1 = "select * from document where ref_document = "+selection2.getSelectedItem()+" or meuble ='"+selection2.getSelectedItem()+"' or section_meuble ='"+selection2.getSelectedItem()+"' or description_doc ='"+selection2.getSelectedItem()+"' or date_creation ='"+selection2.getSelectedItem()+"'";
					PreparedStatement pstmt = con.prepareStatement(Query1);
					
					ResultSet prs = pstmt.executeQuery();
					
		
					
					while(prs.next()){
						num_type.setSelectedItem(rs.getString(3));
						meuble.setText(prs.getString(4));
						section.setText(prs.getString(5));
						espace_occupe.setText(prs.getString(6));
						date_creation.setText(prs.getString(7));
						date_extreme.setText(prs.getString(8)); 
						description.setText(prs.getString(9));
						classement.setText(prs.getString(10));
						consultation.setSelectedItem(prs.getString(11));
						p_s.setSelectedItem(prs.getString(16));
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
					
					
					*/
					
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		selection1.setModel(new DefaultComboBoxModel(new String[] {"", "meuble", "section_meuble", "description_doc"}));
		selection1.setBounds(249, 81, 164, 33);
		contentPane.add(selection1);
		
		selection2 = new JComboBox();
		selection2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
				Connection con;
				try {
				con = DriverManager.getConnection(conUrl);
				String selected = (String) selection2.getSelectedItem();
				//String q1="select * from document where ref_document = '"+selected+"';";
				String q2="select * from document where meuble = '"+selected+"';";
				String q3="select * from document where section_meuble = '"+selected+"';";
				String q4="select * from document where description_doc ='"+selected+"';";
				
				//java.sql.Statement pstmt1 = con.createStatement();
				java.sql.Statement pstmt2 = con.createStatement();
				java.sql.Statement pstmt3 = con.createStatement();
				java.sql.Statement pstmt4 = con.createStatement();
									
				
				
				

				
				
				int i;
				for(i=0;i<selection2.getItemCount();i++){
					if(selection2.getSelectedIndex()==i){
					/*	ResultSet prs1 = pstmt1.executeQuery(q1);
						while(prs1.next()){
											num_type.setSelectedItem(prs1.getString(3));
											meuble.setText(prs1.getString(4));
											section.setText(prs1.getString(5));
											espace_occupe.setText(prs1.getString(6));
											date_creation.setText(prs1.getString(7));
											date_extreme.setText(prs1.getString(8)); 
											description.setText(prs1.getString(9));
											classement.setText(prs1.getString(10));
											consultation.setSelectedItem(prs1.getString(11));
											p_s.setSelectedItem(prs1.getString(16));
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
					}*/
					ResultSet prs2 = pstmt2.executeQuery(q2);
					while(prs2.next()){
											num_type.setSelectedItem(prs2.getString(3));
											meuble.setText(prs2.getString(4));
											section.setText(prs2.getString(5));
											espace_occupe.setText(prs2.getString(6));
											date_creation.setText(prs2.getString(7));
											date_extreme.setText(prs2.getString(8)); 
											description.setText(prs2.getString(9));
											classement.setText(prs2.getString(10));
											consultation.setSelectedItem(prs2.getString(11));
											p_s.setSelectedItem(prs2.getString(16));
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
					ResultSet prs3 = pstmt3.executeQuery(q3);
					while(prs3.next()){
											num_type.setSelectedItem(prs3.getString(3));
											meuble.setText(prs3.getString(4));
											section.setText(prs3.getString(5));
											espace_occupe.setText(prs3.getString(6));
											date_creation.setText(prs3.getString(7));
											date_extreme.setText(prs3.getString(8)); 
											description.setText(prs3.getString(9));
											classement.setText(prs3.getString(10));
											consultation.setSelectedItem(prs3.getString(11));
											p_s.setSelectedItem(prs3.getString(16));
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
					ResultSet prs4 = pstmt4.executeQuery(q4);
					while(prs4.next()){
											num_type.setSelectedItem(prs4.getString(3));
											meuble.setText(prs4.getString(4));
											section.setText(prs4.getString(5));
											espace_occupe.setText(prs4.getString(6));
											date_creation.setText(prs4.getString(7));
											date_extreme.setText(prs4.getString(8)); 
											description.setText(prs4.getString(9));
											classement.setText(prs4.getString(10));
											consultation.setSelectedItem(prs4.getString(11));
											p_s.setSelectedItem(prs4.getString(16));
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

					}
				}

				
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
		});
		selection2.setBounds(477, 81, 174, 33);
		contentPane.add(selection2);
		
		searchtext = new JTextField();
		searchtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		searchtext.setBounds(790, 81, 92, 33);
		contentPane.add(searchtext);
		searchtext.setColumns(10);
		
		JLabel lblRefdocument = new JLabel("ref_document :");
		lblRefdocument.setBounds(688, 85, 92, 24);
		contentPane.add(lblRefdocument);
		ImageIcon search = new ImageIcon("C:\\Users\\pc_hp\\Desktop\\search.png");
		JButton searchbtn = new JButton(search);
		searchbtn.setText("Rechercher");
		searchbtn.setIcon(new ImageIcon("search.png"));
		
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
				Connection con;
				try {
					con = DriverManager.getConnection(conUrl);
					String Query = "select * from document where ref_document = "+searchtext.getText();
					java.sql.Statement st = con.createStatement();
					if(searchtext == null){JOptionPane.showMessageDialog(null, "la case est vide");}
					
					ResultSet rs = st.executeQuery(Query);
					
					
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
					JOptionPane.showMessageDialog(null, "la valeur entrée n'existe pas");
				}
				
			}
		});
		searchbtn.setBounds(964, 81, 104, 33);
		contentPane.add(searchbtn);
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	}
}
