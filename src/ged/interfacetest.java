package ged;
import ged.jdbcConnect;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;

import net.proteanit.sql.DbUtils;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.xml.transform.Source;

import java.awt.print.*;
import java.io.*;
import javax.imageio.*;

public class interfacetest {

	private JFrame frame;
	public static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfacetest window = new interfacetest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfacetest() {
		initialize();
	}
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Fenetre d'acceuil");
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 828, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Component tree = null;
		Component btnNewButton_1 = null;
		Component btnNewButton = null;
		Component btnSupprimer = null;
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane(), btnNewButton, btnSupprimer, btnNewButton_1, tree}));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 92, 252, 587);
		panel.setBorder(new TitledBorder(null, "Dossiers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
		Connection con;
		
		
		
		JTree tree1 = new JTree();
		tree1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2){
                    TreePath tp = ((JTree) tree1)
                            .getClosestPathForLocation(e.getX(), e.getY());
                    File file = (File)tp.getLastPathComponent();
                    // open the file here
                    if(file.isFile() && file.exists()){
                        //System.out.format("You double clicked %s", file.toString());
                        try {
                            Desktop.getDesktop().open(file);
                        } catch (IOException ex) {
                            System.out.println("File Error: Unable to open");
                            Logger.getLogger(TreeSet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
				Connection conn;
				
				if(e.getClickCount()==1){
					 TreePath tp = ((JTree) tree1)
	                            .getClosestPathForLocation(e.getX(), e.getY());
	                    File file = (File)tp.getLastPathComponent();
						try {
							conn = DriverManager.getConnection(conUrl);
							String Query="select ref_document,meuble,section_meuble as section,espace_occupe,date_creation,date_extreme,description_doc as description,classement,consultation,p_ou_s from document where meuble='"+file+"'or section_meuble='"+file+"'";
							PreparedStatement pstmt = conn.prepareStatement(Query);
							ResultSet rs = pstmt.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
				}
				
			}
		});
		tree1.setBounds(0, 23, 242, 553);
		panel.add(tree1);
		tree1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		tree1.setShowsRootHandles(true);
		tree1.setEditable(true);
		
		
		tree1.setModel(new FileSystemModel(new File("C:\\Users\\pc_hp\\Desktop\\documents")));
		
		try {
		    frame.setIconImage(ImageIO.read(new File("C:\\Users\\pc_hp\\workspace\\demoged\\img\\document.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		JButton visualiser = new JButton("visualiser");
		visualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualiser vs = new visualiser();
				if(interfacetest.table.getSelectedColumn()==0)
				vs.mn();
			}
		});
		visualiser.setBounds(723, 67, 89, 23);
		frame.getContentPane().add(visualiser);
		visualiser.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Nouveau");
		btnNewButton_2.setBounds(0, 0, 103, 90);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					nouveau nw = new nouveau();
					nw.setVisible(true);

			}

		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("modifier");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier edit = new modifier();
				edit.main(null);
				
			}
		});
		btnNewButton_3.setBounds(113, 0, 103, 90);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Rechercher");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercher search = new rechercher();
				search.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(226, 0, 103, 90);
		frame.getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 107, 943, 572);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() > -1) visualiser.setVisible(true);
			}
		});
		
		//-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
		
		try {
			con = DriverManager.getConnection(conUrl);
			String Query="select ref_document,meuble,section_meuble as section,espace_occupe,date_creation,date_extreme,description_doc as description,classement,consultation,p_ou_s from document";
			PreparedStatement pstmt = con.prepareStatement(Query);
			ResultSet rs = pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton actualiser = new JButton("Actualiser");
			actualiser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
					Connection con;
					try {
						con = DriverManager.getConnection(conUrl);
						String Query="select ref_document,meuble,section_meuble as section,espace_occupe,date_creation,date_extreme,description_doc as description,classement,consultation,p_ou_s from document";
						PreparedStatement pstmt = con.prepareStatement(Query);
						ResultSet rs = pstmt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			actualiser.setBounds(1195, 30, 112, 43);
			frame.getContentPane().add(actualiser);
			
			JButton btnNewButton_5 = new JButton("scanner");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							          
					          
				}
			});
			btnNewButton_5.setBounds(337, 0, 103, 90);
			frame.getContentPane().add(btnNewButton_5);
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
		
	}

	protected void createFile() {
		// TODO Auto-generated method stub
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
