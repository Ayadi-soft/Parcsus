	package GUI;
	import java.awt.GridBagLayout;
	import javax.swing.JPanel;
	import java.awt.Dimension;
	import javax.swing.JLabel;
	import java.awt.GridBagConstraints;
	import java.awt.Rectangle;
	import java.awt.Font;
	import java.util.Date;

	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;
	import javax.swing.JPopupMenu;
	import javax.swing.JRadioButton;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.JScrollPane;
	import javax.swing.table.DefaultTableModel;


	public class Show_vehicles extends JPanel {

		private static final long serialVersionUID = 1L;
		private JLabel Label_title = null;
		private JLabel lblVehiclesList;
		private JLabel Label_type = null;
		private JLabel lblSearchByReg;
		private JLabel Label_author = null;
		private JTextField TextField_key = null;
		private JLabel Label_key = null;
		private JScrollPane jScrollPane = null;
		private JTable table_vehicles = null;
		Object[][] data = new Object[100][3]; 
		App_init strater;
		/**
		 * This is the default constructor
		 */
		public Show_vehicles(App_init strater) {
			super();
			this.strater=strater;
			initialize();
		}

		/**
		 * This method initializes this
		 * 
		 * @return void
		 */
		private void initialize() {
			
			Label_key = new JLabel();
			Label_key.setBounds(new Rectangle(211, 142, 63, 25));
			Label_key.setText("keyword : ");
			lblSearchByReg = new JLabel();
			lblSearchByReg.setBounds(new Rectangle(61, 168, 144, 24));
			lblSearchByReg.setText("Search by Reg Number : ");
			lblVehiclesList = new JLabel();
			lblVehiclesList.setText("Vehicles List ");
			lblVehiclesList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			lblVehiclesList.setBounds(new Rectangle(193, 87, 221, 44));
			this.setSize(694, 500);
			this.setLayout(null);
			this.add(lblVehiclesList, null);
			this.add(lblSearchByReg, null);
			this.add(getTextField_key(), null);
			this.add(Label_key, null);
			this.add(getJScrollPane(), null);
			
		}

		/**
		 * This method initializes TextField_key	
		 * 	
		 * @return javax.swing.JTextField	
		 */
		private JTextField getTextField_key() {
			if (TextField_key == null) {
				TextField_key = new JTextField();
				TextField_key.setBounds(new Rectangle(211, 164, 298, 25));
				TextField_key.addKeyListener(new java.awt.event.KeyAdapter() {
					public void keyReleased(java.awt.event.KeyEvent e) {
						System.out.println("keeeeeyyyy "+TextField_key.getText());
						//A string array containing the column names for the JTable. 
						String[] columnNames = {"xxxxxReg number","Model"," Color","Description"}; 
						Object[][] data=strater.vehiclelist.get_all_vehicles_bynum(TextField_key.getText());
						//Create the JTable using the data array and column name array. 
						DefaultTableModel defTableModel = new DefaultTableModel(data,columnNames);
						table_vehicles =  new JTable(defTableModel);
						jScrollPane.setViewportView(table_vehicles);
						
					}
				});
			}
			return TextField_key;
		}

		/**
		 * This method initializes jScrollPane	
		 * 	
		 * @return javax.swing.JScrollPane	
		 */
		private JScrollPane getJScrollPane() {
			if (jScrollPane == null) {
				jScrollPane = new JScrollPane();
				jScrollPane.setBounds(new Rectangle(45, 200, 603, 270));
				jScrollPane.setViewportView(gettable_vehicles());
			}
			return jScrollPane;
		}

		/**
		 * This method initializes table_vehicles	
		 * 	
		 * @return javax.swing.JTable	
		 */
		private JTable gettable_vehicles() {
			if (table_vehicles == null) {
				
				//A string array containing the column names for the JTable. 
				String[] columnNames = {"Reg number","Model"," Color","Description"}; 
				
				//Create the JTable using the data array and column name array. 
				DefaultTableModel defTableModel = new DefaultTableModel(strater.vehiclelist.get_all_vehicles(),columnNames);
				table_vehicles =  new JTable(defTableModel);
				
			}
			return table_vehicles;
		}
		

		

	}  //  @jve:decl-index=0:visual-constraint="10,10"

