package GUI;
	import java.awt.GridBagLayout;
	import javax.swing.JPanel;
	import java.awt.Dimension;
	import javax.swing.JLabel;
	import java.awt.GridBagConstraints;
	import java.awt.Font;
	import java.awt.Rectangle;

	import javax.swing.JOptionPane;
	import javax.swing.SwingConstants;

import MODEL.Vehicle_info;

import javax.swing.JTextField;
	import java.awt.Label;
	import java.awt.Panel;
	import javax.swing.JButton;
	import java.awt.ComponentOrientation;
	import javax.swing.JSlider;
	import javax.swing.JComboBox;


	import javax.swing.ImageIcon;
	import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;



import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JTextPane;

	public class Warning extends JPanel {

		private static final long serialVersionUID = 1L;
		private Panel panel = null;
		private JLabel title = null;
		private JLabel Label_ship_number = null;
		private JLabel lblRegNumber;
		private JButton Button_validate = null;
		private JButton Button_reset = null;
		private JButton Button_close = null;
		private JLabel Label_type = null;
		private JLabel lblWarningDescription;
		 
		App_init starter;
 
		private JLabel adrr = null;
		private JLabel lab_cout = null;
		private JLabel cost = null;
		private JTextField w_desc;
		JComboBox vehicle =null;
		/**
		 * This is the default constructor
		 */
		public Warning(App_init starter) {
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
			lblWarningDescription = new JLabel();
			lblWarningDescription.setBounds(new Rectangle(65, 206, 126, 22));
			lblWarningDescription.setText("Warning Description : ");
			lblRegNumber = new JLabel();
			lblRegNumber.setBounds(new Rectangle(64, 162, 111, 24));
			lblRegNumber.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			lblRegNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblRegNumber.setText("Reg Number :");
			title = new JLabel();
			title.setBounds(new Rectangle(196, 99, 247, 38));
			title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			title.setText("Record Warning");
			this.setSize(704, 500);
			this.setLayout(null);
			this.add(title, null);
			this.add(lblRegNumber, null);
			this.add(getButton_validate(), null);
			this.add(getButton_reset(), null);
			this.add(lblWarningDescription, null);
			this.add(get_vehcle(), null);
			
			w_desc = new JTextField();
			w_desc.setBounds(new Rectangle(189, 317, 367, 54));
			w_desc.setBounds(195, 211, 367, 54);
			add(w_desc);
			
			
			
			
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
		 * This method initializes Button_validate	
		 * 	
		 * @return javax.swing.JButton	
		 */
		private JButton getButton_validate() {
			if (Button_validate == null) {
				Button_validate = new JButton();
				Button_validate.setBounds(new Rectangle(511, 433, 68, 56));
				Button_validate.setIcon(new ImageIcon(getClass().getResource("/Img/val.png")));
				Button_validate.setText("");
				Button_validate.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						
					Vehicle_info v=	starter.vehiclelist.get_vehicle(vehicle.getSelectedItem().toString());
						v.addWarning(w_desc.getText());
						starter.getVehiclelist().save();
						JOptionPane jop1 = new JOptionPane();	
						jop1.showMessageDialog(null,"warning registred","Information", JOptionPane.INFORMATION_MESSAGE);
						
					}
				});
			}
			return Button_validate;
		}

		/**
		 * This method initializes Button_reset	
		 * 	
		 * @return javax.swing.JButton	
		 */
		private JButton getButton_reset() {
			if (Button_reset == null) {
				Button_reset = new JButton();
				Button_reset.setBounds(new Rectangle(591, 434, 71, 54));
				Button_reset.setIcon(new ImageIcon(getClass().getResource("/Img/reset.png")));
				Button_reset.setText("");
				Button_reset.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						w_desc.setText("");
						//reg_num.setText("");
					}
				});
			}
			return Button_reset;
		}
		
		
		private JComboBox get_vehcle() {
			if (vehicle == null) {
				vehicle =   new JComboBox(starter.vehiclelist.get_all_vehicle_num());
				vehicle.setBounds(new Rectangle(127, 140, 119, 23));
				vehicle.setBounds(177, 163, 178, 23);
								
			}
			return vehicle;
		}
		
	}   


