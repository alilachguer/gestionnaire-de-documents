package ged;
import ged.jdbcConnect;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.Statement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import ged.interfacetest;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
public class nouveau extends JFrame {

	private JPanel contentPane;
	private JTextField meuble;
	private JTextField section;
	private JTextField espace_occupe;
	private JTextField description;
	private JTextField classement;
	private JButton btnAjouter;
	private JTextField valtype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nouveau frame = new nouveau();
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
	public nouveau() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("Ajouter un nouveau document");
		try {
			this.setIconImage(ImageIO.read(new File("C:\\Users\\pc_hp\\workspace\\demoged\\img\\document.png")));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblMeuble = new JLabel("Meuble");
		lblMeuble.setBounds(167, 108, 58, 50);
		contentPane.add(lblMeuble);
		
		meuble = new JTextField();
		meuble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		meuble.setBounds(248, 118, 211, 30);
		contentPane.add(meuble);
		meuble.setColumns(10);
		
		JLabel lblSection = new JLabel("Section ");
		lblSection.setBounds(167, 169, 58, 50);
		contentPane.add(lblSection);
		
		section = new JTextField();
		section.setText("");
		section.setBounds(248, 179, 211, 30);
		contentPane.add(section);
		section.setColumns(10);
		
		JLabel lblEspaceOccupe = new JLabel("espace occupe");
		lblEspaceOccupe.setBounds(145, 241, 93, 50);
		contentPane.add(lblEspaceOccupe);
		
		espace_occupe = new JTextField();
		espace_occupe.setBounds(248, 251, 211, 30);
		contentPane.add(espace_occupe);
		espace_occupe.setColumns(10);
		
		JLabel lblDescription = new JLabel("description");
		lblDescription.setBounds(156, 338, 70, 50);
		contentPane.add(lblDescription);
		
		description = new JTextField();
		description.setBounds(247, 333, 319, 61);
		contentPane.add(description);
		description.setColumns(10);
		
		JLabel lblDescription_1 = new JLabel("date de creation");
		lblDescription_1.setBounds(134, 443, 104, 50);
		contentPane.add(lblDescription_1);
		
		JLabel lblDateExtreme = new JLabel("date extreme");
		lblDateExtreme.setBounds(779, 443, 97, 50);
		contentPane.add(lblDateExtreme);
		
		JLabel lblPouS = new JLabel("P ou S");
		lblPouS.setBounds(798, 171, 58, 50);
		contentPane.add(lblPouS);
		
		JLabel lblClassement = new JLabel("classement");
		lblClassement.setBounds(787, 232, 58, 50);
		contentPane.add(lblClassement);
		
		classement = new JTextField();
		classement.setBounds(888, 242, 186, 30);
		contentPane.add(classement);
		classement.setColumns(10);
		
		JLabel lblConsultation = new JLabel("Consultation");
		lblConsultation.setBounds(779, 333, 71, 50);
		contentPane.add(lblConsultation);
		
		JComboBox p_s = new JComboBox();
		p_s.setModel(new DefaultComboBoxModel(new String[] {"p", "s"}));
		p_s.setBounds(888, 181, 186, 30);
		contentPane.add(p_s);
		
		JComboBox consultation = new JComboBox();
		consultation.setModel(new DefaultComboBoxModel(new String[] {"forte", "moyenne", "faible"}));
		consultation.setBounds(888, 337, 186, 30);
		contentPane.add(consultation);
		
		JLabel lblNumType = new JLabel("num type");
		lblNumType.setBounds(785, 69, 71, 22);
		contentPane.add(lblNumType);
		
		JComboBox num_type = new JComboBox();
		num_type.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		num_type.setBounds(888, 65, 104, 30);
		contentPane.add(num_type);
		
		JComboBox anneec = new JComboBox();
		anneec.setBounds(250, 458, 100, 30);
		contentPane.add(anneec);
		
		JComboBox moisc = new JComboBox();
		moisc.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		moisc.setBounds(372, 458, 60, 30);
		contentPane.add(moisc);
		
		JComboBox jourc = new JComboBox();
		jourc.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jourc.setBounds(462, 458, 60, 30);
		contentPane.add(jourc);
		
		JComboBox anneee = new JComboBox();
		anneee.setBounds(886, 458, 100, 30);
		contentPane.add(anneee);
		
		JComboBox moise = new JComboBox();
		moise.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		moise.setBounds(1007, 458, 60, 30);
		contentPane.add(moise);
		
		JComboBox joure = new JComboBox();
		joure.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		joure.setBounds(1092, 458, 60, 30);
		contentPane.add(joure);
		
		
		
		
		
//////////////////////////////////////
		for (int i = 2015 ; i >= 1960; i--) {
			anneec.addItem(i);
			anneee.addItem(i);
			
		}
		
		
//////////////////////////////////:////
		
		
		////////////////////////////////////////////////////////////////////////
		btnAjouter = new JButton("ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
				
				try {
					String date_creation = anneec.getSelectedItem()+"/"+moisc.getSelectedItem()+"/"+jourc.getSelectedItem();
					String date_extreme = anneee.getSelectedItem()+"/"+moise.getSelectedItem()+"/"+joure.getSelectedItem();
					String Query = "insert into document(id_type,meuble,section_meuble,espace_occupe,date_creation,date_extreme,description_doc,classement,consultation,p_ou_s) values("
							+ ""+num_type.getSelectedItem()+",'"+meuble.getText()+"','"+section.getText()+"','"+espace_occupe.getText()+"','"+date_creation+"','"+date_extreme+"','"+description.getText()+"','"+classement.getText()+"','"+consultation.getSelectedItem()+"','"+p_s.getSelectedItem()+"');";
					Connection con = DriverManager.getConnection(conUrl);
					java.sql.Statement stmt = con.createStatement();
					if(meuble.getText()!=null || section.getText()!=null || num_type.getSelectedItem()!=null) {
					stmt.execute(Query);
					JOptionPane.showMessageDialog(null, "les données ont été ajoutés avec succes");}
			//	} catch (SQLException e1) {
				// TODO Auto-generated catch block
			//		e1.printStackTrace();
				//}
				
			//	try {
				Connection con1 = DriverManager.getConnection(conUrl);
					java.sql.Statement stmt1 = con1.createStatement();
					String query="select * from type_document";
					ResultSet rs=stmt1.executeQuery(query);
					while(rs.next()){
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
					
					
					String content = "meuble :"+meuble.getText()+" |section:"+section.getText()+" |espace_occupe:"+espace_occupe.getText()+" |consultation:"+consultation.getSelectedItem()+" |num_type:"+num_type.getSelectedItem()+" |ref_document:"+valtype.getText()+" |"+p_s.getSelectedItem()+"|classement:"+classement.getText()+" |description:"+description.getText()+" |date de creation:"+date_creation+" |date extreme:"+date_extreme+" ";
					
					File files = new File("C:\\Users\\pc_hp\\workspace\\demoged\\documents\\"+meuble.getText()+"\\"+section.getText());
					if (!files.exists()) {
						if (files.mkdirs()) {
							JOptionPane.showMessageDialog(null, "Multiple repertoires sont créés!");
						} else {
							JOptionPane.showMessageDialog(null,"la creation des repertoire a echoué!");
						}
					}
					
					
					File file = new File("C:\\Users\\pc_hp\\Desktop\\documents\\"+meuble.getText()+"\\"+section.getText()+"\\"+description.getText()+".txt");
					 
					// if file doesn't exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}
		 
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(content);
					bw.close();
					
					
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnAjouter.setBounds(638, 565, 166, 106);
		contentPane.add(btnAjouter);
		
		valtype = new JTextField();
		valtype.setBounds(888, 126, 181, 30);
		contentPane.add(valtype);
		valtype.setColumns(10);
		valtype.setEditable(false);
		
		JLabel lblTypeDocument = new JLabel("type document");
		lblTypeDocument.setBounds(779, 121, 86, 30);
		contentPane.add(lblTypeDocument);
		
		JLabel lblNewLabel = new JLabel("Ajouter un nouveau document");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(133, 24, 369, 50);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
	}
}
