package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Dimension;

public class App {

	public JFrame jFrame = null;   
	private JPanel jContentPane = null;
	public JToolBar jToolBar = null;
	private JButton Button_logout = null;
	private JButton Button_barrier = null;
	private JButton Button_warning = null;
	private JButton Button_add_vehicle = null;
	private JButton Button_add_Permit = null;
	private JButton Button_permit_list = null;
	private JButton Button_exit = null;
	public static App_init starter;
	private JButton Button_vehicle_liste = null;
	

	/**
	 * This method initializes Button_search	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_vehicle_liste() {
		if (Button_vehicle_liste == null) {
			Button_vehicle_liste = new JButton();
			Button_vehicle_liste.setIcon(new ImageIcon(getClass().getResource("/Img/recherche-icon.png")));
			Button_vehicle_liste.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Show_vehicles form = new Show_vehicles(starter);
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
					
				}
			});
		}
		return Button_vehicle_liste;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 starter = new App_init();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			
				App application = new App();
				application.getJFrame().setVisible(true);
				starter.main_form=application;
				starter.activate();
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setSize(750, 600);
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			jFrame.setLocation((screenSize.width-jFrame.getSize().width)/2,(screenSize.height-jFrame.getSize().height)/2);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("PACSUS V1.0 Parking Management");
		}
		return jFrame;
	}


	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jToolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.add(getButton_logout());
			jToolBar.add(getButton_barrier());
			jToolBar.add(getButton_warning());
			jToolBar.add(getButton_add_vehicle());
			jToolBar.add(getButton_vehicle_liste());
			jToolBar.add(getButton_permit_list());
			jToolBar.add(getButton_add_Permit());
			jToolBar.add(getButton_exit());
			
		}
		return jToolBar;
	}

	/**
	 * This method initializes Button_logout	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_logout() {
		if (Button_logout == null) {
			Button_logout = new JButton();
			Button_logout.setIcon(new ImageIcon(getClass().getResource("/Img/logout.png")));
			Button_logout.setToolTipText("Click this button to logout.");
			Button_logout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					 Authentication form = new Authentication(starter,starter.main_form) ;
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
					//deactivate_menu();
				}
			});
		}
		return Button_logout;
	}

	/**
	 * This method initializes Button_customer_info	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_barrier() {
		if (Button_barrier == null) {
			Button_barrier = new JButton();
			Button_barrier.setIcon(new ImageIcon(getClass().getResource("/Img/user_info.png")));
			Button_barrier.setToolTipText("Click this button to see the barrier state.");
			Button_barrier.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Barrier_ form = new Barrier_(starter);
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_barrier;
	}

	/**
	 * This method initializes Button_booking_shipment	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_warning() {
		if (Button_warning == null) {
			Button_warning = new JButton();
			Button_warning.setIcon(new ImageIcon(getClass().getResource("/Img/ship.png")));
			Button_warning.setToolTipText("Click this button to Add warning.");
			Button_warning.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {	
					Warning form = new Warning(starter) ;
 					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_warning;
	}

	/**
	 * This method initializes Button_add_dest	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_add_vehicle() {
		if (Button_add_vehicle == null) {
			Button_add_vehicle = new JButton();
			Button_add_vehicle.setIcon(new ImageIcon(getClass().getResource("/Img/dest.png")));
			Button_add_vehicle.setToolTipText("Click this button to Add vehicle.");
			Button_add_vehicle.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Add_vehicle form = new Add_vehicle(starter) ;
				form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
				jFrame.setContentPane(form);
				}
			});
		}
		return Button_add_vehicle;
	}

	/**
	 * This method initializes Button_add_customer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_add_Permit() {
		if (Button_add_Permit == null) {
			Button_add_Permit = new JButton();
			Button_add_Permit.setIcon(new ImageIcon(getClass().getResource("/Img/add_cust.png")));
			Button_add_Permit.setToolTipText("Click this button to Add Permit.");
			Button_add_Permit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					Add_Permit  form = new Add_Permit (starter) ;
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_add_Permit;
	}

	/**
	 * This method initializes Button_payment	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_permit_list() {
		if (Button_permit_list == null) {
			Button_permit_list = new JButton();
			Button_permit_list.setIcon(new ImageIcon(getClass().getResource("/Img/fines.png")));
			Button_permit_list.setToolTipText("Click this button to see the list of permit.");
			Button_permit_list.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					Show_permits form = new Show_permits(starter) ;
 					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
 					jFrame.setContentPane(form);
				}
			});
		}
		return Button_permit_list;
	}

	/**
	 * This method initializes Button_exit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_exit() {
		if (Button_exit == null) {
			Button_exit = new JButton();
			Button_exit.setIcon(new ImageIcon(getClass().getResource("/Img/arreter.png")));
			Button_exit.setToolTipText("Click this button to exit.");
			Button_exit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);}
			});
		}
		return Button_exit;
	}


	
	  public void deactivate_menu() { Button_logout.setEnabled(false);
	  Button_add_Permit.setEnabled(false);
	  Button_add_vehicle.setEnabled(false);
	  Button_barrier.setEnabled(false);
	  Button_vehicle_liste.setEnabled(false);
	  Button_warning.setEnabled(false);
	  Button_permit_list.setEnabled(false);
	  
	  }
	  
	  public void Activate_menu_super_user() { 
		  Button_logout.setEnabled(true);
		  Button_add_Permit.setEnabled(true);
		  Button_add_vehicle.setEnabled(true);
		  Button_barrier.setEnabled(true);
		  Button_vehicle_liste.setEnabled(true);
		  Button_warning.setEnabled(true);
		  Button_permit_list.setEnabled(true);
	  } 
	  
	  public void Activate_menu_normal_user() {
	  Button_logout.setEnabled(true); 
	  Button_warning.setEnabled(true);
	  Button_barrier.setEnabled(true);
	  
	  }
	 
}
