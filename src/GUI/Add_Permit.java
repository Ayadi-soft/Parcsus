	package GUI;

	import java.awt.GridBagLayout;
	import javax.swing.JPanel;
	import java.awt.Dimension;
	import javax.swing.JLabel;

	import java.awt.BorderLayout;
	import java.awt.GridBagConstraints;
	import java.awt.Font;
	import java.awt.Rectangle;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.util.Vector;

	import javax.swing.JOptionPane;
	import javax.swing.SwingConstants;

import MODEL.Day_visitor_permit;
import MODEL.Permanent_visitor_permit;
import MODEL.Permit;
import MODEL.Permit_list;
import MODEL.Regular_visitor_permit;

import javax.swing.JTextField;
	import java.awt.Label;
	import java.awt.Panel;
	import javax.swing.JButton;
	import java.awt.ComponentOrientation;
	import javax.swing.JSlider;
	import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
	import javax.swing.ImageIcon;
	import javax.swing.JList;
	import javax.swing.JScrollPane;



	public class Add_Permit  extends JPanel {

		private static final long serialVersionUID = 1L;
		private Panel panel = null;
		private JLabel title = null;
		private JLabel Label_ID_card_nb = null;
		private JLabel lblPermitHolder;
		private JTextField permit_holder = null;
		private JLabel Label_title = null;
		private JLabel lblHostName;
		private JTextField host_name = null;
		 
		private JLabel lblNumberOfEntry;
		private JTextField nb_entry = null;
		private JButton Button_validate = null;
		private JButton Button_reset = null;
		
		 
		private JLabel lblPermitedVehicle;
		private JLabel Label_dep = null;
		private JLabel lblDay;
		private JLabel Label_type = null;
		private JComboBox ComboBox_type = null;
		App_init starter;
		private JLabel lab_dest = null;
		private JLabel adrr = null;
		private JButton btnAdd = null;
		private JComboBox comboBox_day_1;
		private JComboBox v_used=null;
		private JComboBox v_permited=null;
		
		//String[] data_selected = {};
		//Vector data_selected ; 
		/**
		 * This is the default constructor
		 */
		public Add_Permit (App_init starter) {
			super();
			this.starter=starter;
			initialize();
		}
		
	

		/**
		 * This method initializes this
		 * 
		 * @return void
		 */
		private void initialize() {
			
			lab_dest = new JLabel();
			lab_dest.setBounds(new Rectangle(57, 345, 85, 24));
			lab_dest.setText("vehicle used :");
			Label_type = new JLabel();
			Label_type.setBounds(new Rectangle(63, 162, 64, 22));
			Label_type.setFont(new Font("Times New Roman", Font.BOLD, 12));
			Label_type.setText("Type : ");
			lblDay = new JLabel();
			lblDay.setBounds(new Rectangle(57, 303, 47, 24));
			lblDay.setText("Day :");
			lblPermitedVehicle = new JLabel();
			lblPermitedVehicle.setBounds(new Rectangle(57, 393, 135, 25));
			lblPermitedVehicle.setText("Permited vehicle : ");
			lblNumberOfEntry = new JLabel();
			lblNumberOfEntry.setBounds(new Rectangle(57, 267, 124, 25));
			lblNumberOfEntry.setText("Number Of Entry: ");
			lblHostName = new JLabel();
			lblHostName.setBounds(new Rectangle(57, 230, 96, 26));
			lblHostName.setText("Host Name : ");
			lblPermitHolder = new JLabel();
			lblPermitHolder.setBounds(new Rectangle(57, 194, 96, 24));
			lblPermitHolder.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			lblPermitHolder.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblPermitHolder.setText("Permit Holder :");
			title = new JLabel();
			title.setBounds(new Rectangle(215, 84, 182, 38));
			title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			title.setText("Add Permit");
			this.setSize(733, 530);
			this.setLayout(null);
			this.add(title, null);
			this.add(lblPermitHolder, null);
			this.add(getPermit_holder(), null);
			this.add(lblHostName, null);
			this.add(getcust_name(), null);
			this.add(lblNumberOfEntry, null);
			this.add(getemail(), null);
			this.add(getButton_validate(), null);
			this.add(getButton_reset(), null);
			this.add(lblPermitedVehicle, null);
			this.add(lblDay, null);
			this.add(Label_type, null);
			this.add(getComboBox_type(), null);
			this.add(lab_dest, null);
			this.add(getBtnAdd(), null);
			
			this.add(getComboBox_day_1(), null);
			this.add(getv_used(), null);
			this.add(getv_permited(), null);
			
			  
		}

		public void reinit(String x) {
			//  v_used=null;
			// v_permited=null;
			
				v_permited.addItem(x);
				v_used.addItem(x);
				 this.add(v_permited, null);
					this.add(v_permited, null);
		}
		
		/**
		 * This method initializes panel	
		 * 	
		 * @return java.awt.Panel	
		 */
		private Panel getPanel() {
			if (panel == null) {
				panel = new Panel();
				panel.setLayout(null);
			}
			return panel;
		}

		/**
		 * This method initializes ID_card_nb	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getPermit_holder() {
			if (permit_holder == null) {
				permit_holder = new JTextField();
				permit_holder.setBounds(new Rectangle(150, 195, 124, 23));
			}
			return permit_holder;
		}

		/**
		 * This method initializes cust_name	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getcust_name() {
			if (host_name == null) {
				host_name = new JTextField();
				host_name.setBounds(new Rectangle(132, 230, 111, 26));
			}
			return host_name;
		}

		/**
		 * This method initializes email	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getemail() {
			if (nb_entry == null) {
				nb_entry = new JTextField();
				nb_entry.setBounds(new Rectangle(176, 267, 36, 25));
			}
			return nb_entry;
		}

		/**
		 * This method initializes Button_validate	
		 * 	
		 * @return javax.swing.JButton	
		 */
		private JButton getButton_validate() {
			if (Button_validate == null) {
				Button_validate = new JButton();
				Button_validate.setBounds(new Rectangle(493, 443, 68, 56));
				Button_validate.setIcon(new ImageIcon(getClass().getResource("/Img/val.png")));
				Button_validate.setText("");
				Button_validate.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						
						add_permit();
						permit_holder.setText("");
						host_name.setText("");
						nb_entry.setText("");
					}
				});
			}
			return Button_validate;
		}
		
		
		/**
		 * 
		 */
		public void add_permit() {
			
			starter.permitlist.add_permit(new Permit(ComboBox_type.getSelectedItem().toString(), permit_holder.getText(), host_name.getText(), Integer.parseInt(nb_entry.getText() ), Integer.parseInt(comboBox_day_1.getSelectedItem().toString()), starter.vehiclelist.get_vehicle(v_used.getSelectedItem().toString()), starter.vehiclelist.get_vehicle(v_permited.getSelectedItem().toString())));
			JOptionPane jop1 = new JOptionPane();	
			jop1.showMessageDialog(null,"new permit seved","Information", JOptionPane.INFORMATION_MESSAGE);
			starter.permitlist.show_all_permit ();
			
		
		}
		
		

		/**
		 * This method initializes Button_reset	
		 * 	
		 * @return javax.swing.JButton	
		 */
		private JButton getButton_reset() {
			if (Button_reset == null) {
				Button_reset = new JButton();
				Button_reset.setBounds(new Rectangle(571, 445, 71, 54));
				Button_reset.setIcon(new ImageIcon(getClass().getResource("/Img/reset.png")));
				Button_reset.setText("");
				Button_reset.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						permit_holder.setText("");
						host_name.setText("");
						nb_entry.setText("");
						
					
						
					}
				});
			}
			return Button_reset;
		}

		/**
		 * This method initializes ComboBox_type	
		 * 	
		 * @return javax.swing.JComboBox	
		 */
		private JComboBox getComboBox_type() {
			if (ComboBox_type == null) {
				ComboBox_type = new JComboBox();
				ComboBox_type.setBounds(new Rectangle(132, 160, 119, 23));
				ComboBox_type.addItem("Day visitor");
				ComboBox_type.addItem("Regular visitor");
				ComboBox_type.addItem("Permanante visitor");
				ComboBox_type.addItem("University member");
				
			}
			return ComboBox_type;
		}
		
		
		private JComboBox getv_used() {
			if (v_used == null) {
				 v_used = new JComboBox(starter.vehiclelist.get_all_vehicle_num());
				v_used.setBounds(new Rectangle(127, 140, 119, 23));
				v_used.setBounds(150, 347, 178, 23);
								
			}
			return v_used;
		}
		
		
		
		private JComboBox getv_permited() {
			if (v_permited == null) {
				v_permited = new JComboBox(starter.vehiclelist.get_all_vehicle_num());
				v_permited.setBounds(new Rectangle(127, 140, 119, 23));
				v_permited.setBounds(172, 394, 178, 23);
				}
			return v_permited;
		}

		
		
		/**
		 * This method initializes Button_add_dest	
		 * 	
		 * @return javax.swing.JButton	
		 */
		private JButton getBtnAdd() {
			if (btnAdd == null) {
				btnAdd = new JButton();
				btnAdd.setBounds(new Rectangle(398, 338, 163, 38));
				btnAdd.setText("Add vehicle");
				btnAdd.setIcon(new ImageIcon(getClass().getResource("/Img/add.png")));
				btnAdd.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						 
					/*
					 * Add_vehicle form = new Add_vehicle(starter) ;
					 * form.add(starter.main_form.jToolBar, BorderLayout.BEFORE_FIRST_LINE);
					 * starter.main_form.jFrame.setContentPane(form);
					 */
						
						add_v();
					}
				});
			}
			return btnAdd;
		}
		
	public void add_v() {
		
		 JFrame frame = new JFrame();
		 Add_vehicle form = new Add_vehicle(starter,this,frame) ;
         frame.setContentPane(form);
         frame.setSize(650, 500);
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			frame.setLocation((screenSize.width-frame.getSize().width)/2,(screenSize.height-frame.getSize().height)/2);
			
			
			frame.setTitle("Add new vehicle");
         
         frame.setVisible(true);
	}	
		
		
		
		
		private JComboBox getComboBox_day_1() {
			if (comboBox_day_1 == null) {
				comboBox_day_1 = new JComboBox();
				comboBox_day_1.setBounds(new Rectangle(169, 140, 119, 23));
				comboBox_day_1.setBounds(106, 303, 47, 23);
				for(int i=1 ; i<366;i++)
				comboBox_day_1.addItem(i);
				 
			}
			return comboBox_day_1;
		}
	} 
