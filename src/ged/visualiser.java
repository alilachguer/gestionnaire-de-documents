package ged;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ged.interfacetest;
import javax.swing.DefaultComboBoxModel;
public class visualiser extends JFrame {

	private JPanel contentPane;
	private JTextField valtype;
	private JTextField description;
	private JTextField meuble;
	private JTextField section;
	private JTextField classement;
	private JTextField espace_occupe;
	private JTextField date_creation;
	private JTextField date_extreme;

	/**
	 * Launch the application.
	 */
	public  void mn() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visualiser frame = new visualiser();
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
	public visualiser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(100, 100, 828, 511));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("num type");
		label.setBounds(292, 40, 73, 32);
		contentPane.add(label);
		
		JComboBox num_type = new JComboBox();
		num_type.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		num_type.setBounds(385, 41, 81, 30);
		contentPane.add(num_type);
		
		JLabel label_1 = new JLabel("type document");
		label_1.setBounds(265, 105, 96, 14);
		contentPane.add(label_1);
		
		valtype = new JTextField();
		valtype.setEditable(false);
		valtype.setColumns(10);
		valtype.setBounds(378, 89, 172, 30);
		contentPane.add(valtype);
		
		JLabel label_2 = new JLabel("description");
		label_2.setBounds(280, 146, 58, 50);
		contentPane.add(label_2);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(378, 141, 253, 61);
		contentPane.add(description);
		
		JLabel label_3 = new JLabel("Meuble");
		label_3.setBounds(304, 234, 37, 50);
		contentPane.add(label_3);
		
		meuble = new JTextField();
		meuble.setColumns(10);
		meuble.setBounds(381, 244, 230, 30);
		contentPane.add(meuble);
		
		JLabel label_4 = new JLabel("Section ");
		label_4.setBounds(304, 295, 46, 50);
		contentPane.add(label_4);
		
		section = new JTextField();
		section.setText("");
		section.setColumns(10);
		section.setBounds(381, 305, 230, 30);
		contentPane.add(section);
		
		JLabel label_5 = new JLabel("P ou S");
		label_5.setBounds(887, 251, 37, 50);
		contentPane.add(label_5);
		
		JComboBox p_s = new JComboBox();
		p_s.setModel(new DefaultComboBoxModel(new String[] {"p", "s"}));
		p_s.setBounds(972, 261, 144, 30);
		contentPane.add(p_s);
		
		JLabel label_6 = new JLabel("classement");
		label_6.setBounds(281, 426, 58, 50);
		contentPane.add(label_6);
		
		classement = new JTextField();
		classement.setColumns(10);
		classement.setBounds(375, 428, 230, 30);
		contentPane.add(classement);
		
		JLabel label_7 = new JLabel("espace occupe");
		label_7.setBounds(280, 497, 71, 50);
		contentPane.add(label_7);
		
		espace_occupe = new JTextField();
		espace_occupe.setColumns(10);
		espace_occupe.setBounds(375, 507, 230, 30);
		contentPane.add(espace_occupe);
		
		JLabel label_8 = new JLabel("Consultation");
		label_8.setBounds(280, 575, 71, 50);
		contentPane.add(label_8);
		
		JComboBox consultation = new JComboBox();
		consultation.setBounds(374, 585, 173, 30);
		contentPane.add(consultation);
		
		JLabel label_9 = new JLabel("date de creation");
		label_9.setBounds(867, 61, 81, 50);
		contentPane.add(label_9);
		
		date_creation = new JTextField();
		date_creation.setColumns(10);
		date_creation.setBounds(958, 71, 230, 30);
		contentPane.add(date_creation);
		
		JLabel label_10 = new JLabel("date extreme");
		label_10.setBounds(867, 122, 71, 50);
		contentPane.add(label_10);
		
		date_extreme = new JTextField();
		date_extreme.setColumns(10);
		date_extreme.setBounds(958, 132, 230, 30);
		contentPane.add(date_extreme);
		this.setTitle("rechercher un document");
		
		try {
			this.setIconImage(ImageIO.read(new File("C:\\Users\\pc_hp\\workspace\\demoged\\img\\document.png")));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
		Connection con;
		if(interfacetest.table.getSelectedColumn()==0){
		try {
			int selectedRowIndex = interfacetest.table.getSelectedRow();
			int selectedColumnIndex = interfacetest.table.getSelectedColumn();
			Object selectedObject = (Object) interfacetest.table.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
			
			con = DriverManager.getConnection(conUrl);
			java.sql.Statement stmt = con.createStatement();
			String Query = "select * from document where ref_document ='"+selectedObject+"'";
			
			
			
				
			
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
	
		}else{
			JOptionPane.showMessageDialog(null, "selectionnez le numero du document");
			
			

		}
	}
}
