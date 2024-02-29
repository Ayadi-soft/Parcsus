
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
import javax.swing.JFrame;
import javax.swing.ImageIcon;

	
public class Add_vehicle extends JPanel {

		private static final long serialVersionUID = 1L;
		private Panel panel = null;
		private JLabel title = null;
		private JLabel Label_id_dest = null;
		private JTextField reg_number = null;
	 
		private JLabel Label_street = null;
		private JTextField v_mark = null;
		private JButton Button_validate = null;
		private JButton Button_reset = null;
		 
		private JLabel Label_model;
	 
		private JLabel Label_desc;
	 
		private JLabel Label_coleur;
		private JTextField v_model = null;
		private JTextField descc = null;
		private JTextField v_color = null;
		App_init starter;
		private Add_Permit p=null;
		private JFrame f=null;
		/**
		 * This is the default constructor
		 * @wbp.parser.constructor
		 */
		public Add_vehicle (App_init starter) {
			super();
			this.starter=starter;
			initialize();
		}
		
		public Add_vehicle (App_init starter , Add_Permit x , JFrame y ) {
			super();
			this.starter=starter;
			this.p=x;
			this.f=y;
			initialize();
		}

		/**
		 * This method initializes this
		 * 
		 * @return void
		 */
		private void initialize() {
			
			
			
			
			
			Label_coleur = new JLabel();
			Label_coleur.setBounds(new Rectangle(93, 277, 118, 24));
			Label_coleur.setText("Vehicule colour :");
			Label_desc = new JLabel();
			Label_desc.setBounds(new Rectangle(93, 319, 80, 25));
			Label_desc.setText("Description : ");
			Label_model = new JLabel();
			Label_model.setBounds(new Rectangle(93, 192, 106, 23));
			Label_model.setText("Vehicule model : ");
			Label_street = new JLabel();
			Label_street.setBounds(new Rectangle(93, 229, 117, 25));
			Label_street.setText("Vehicule make : ");
			Label_id_dest = new JLabel();
			Label_id_dest.setBounds(new Rectangle(93, 144, 174, 24));
			Label_id_dest.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			Label_id_dest.setFont(new Font("Times New Roman", Font.BOLD, 12));
			Label_id_dest.setText("Vehicule registration number :");
			title = new JLabel();
			title.setBounds(new Rectangle(195, 83, 211, 38));
			title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			title.setText("Add Vehicle");
			this.setSize(700, 510);
			this.setLayout(null);
			this.add(title, null);
			this.add(Label_id_dest, null);
			this.add(getid_dest(), null);
			this.add(Label_street, null);
			this.add(getstreet(), null);
			this.add(getButton_validate(), null);
			this.add(getButton_reset(), null);
			this.add(Label_model, null);
			this.add(Label_desc, null);
			this.add(Label_coleur, null);
			this.add(gettown(), null);
			this.add(getdescc(), null);
			this.add(get_color(), null);
			
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
		 * This method initializes id_dest	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getid_dest() {
			if (reg_number == null) {
				reg_number = new JTextField();
				reg_number.setBounds(new Rectangle(266, 145, 174, 23));
			}
			return reg_number;
		}

		/**
		 * This method initializes street	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getstreet() {
			if (v_mark == null) {
				v_mark = new JTextField();
				v_mark.setBounds(new Rectangle(182, 229, 187, 25));
			}
			return v_mark;
		}

		/**
		 * This method initializes Button_validate	
		 * 	
		 * @return javax.swing.JButton	
		 */
		private JButton getButton_validate() {
			if (Button_validate == null) {
				Button_validate = new JButton();
				Button_validate.setBounds(new Rectangle(423, 399, 68, 56));
				Button_validate.setIcon(new ImageIcon(getClass().getResource("/Img/val.png")));
				Button_validate.setText("");
				Button_validate.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
					if(p==null) {
						Vehicle_info v=new Vehicle_info(reg_number.getText(), v_model.getText(), v_color.getText(), descc.getText());
						starter.vehiclelist.add_vehicle(v);
						JOptionPane jop1 = new JOptionPane();	
						jop1.showMessageDialog(null,"vehicle inserted ","Information", JOptionPane.INFORMATION_MESSAGE);
						starter.getVehiclelist().save();
						reg_number.setText("");
						v_mark.setText("");
						descc.setText("");
						v_color.setText("");
						v_model.setText("");
					}else
					{
						Vehicle_info v=new Vehicle_info(reg_number.getText(), v_model.getText(), v_color.getText(), descc.getText());
						starter.vehiclelist.add_vehicle(v);
						JOptionPane jop1 = new JOptionPane();	
						jop1.showMessageDialog(null,"vehicle inserted ","Information", JOptionPane.INFORMATION_MESSAGE);
						starter.getVehiclelist().save();
						p.reinit(reg_number.getText());
						//p.initialize();
						f.setVisible(false);
						
					}
					
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
				Button_reset.setBounds(new Rectangle(503, 400, 71, 54));
				Button_reset.setIcon(new ImageIcon(getClass().getResource("/Img/reset.png")));
				Button_reset.setText("");
				Button_reset.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						reg_number.setText("");
						
						v_mark.setText("");
						descc.setText("");
						v_color.setText("");
						v_model.setText("");
					}
				});
			}
			return Button_reset;
		}

		/**
		 * This method initializes town	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField gettown() {
			if (v_model == null) {
				v_model = new JTextField();
				v_model.setBounds(new Rectangle(195, 189, 150, 26));
			}
			return v_model;
		}

		/**
		 * This method initializes descc	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getdescc() {
			if (descc == null) {
				descc = new JTextField();
				descc.setBounds(new Rectangle(177, 321, 367, 54));
			}
			return descc;
		}

		/**
		 * This method initializes zip_code	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField get_color() {
			if (v_color == null) {
				v_color = new JTextField();
				v_color.setBounds(new Rectangle(192, 276, 75, 26));
				v_color.setText("");
			}
			return v_color;
		}

		

	}  
