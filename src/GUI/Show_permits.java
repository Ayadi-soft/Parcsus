	package GUI;
	import java.awt.GridBagLayout;
	import javax.swing.JPanel;
	import java.awt.Dimension;
	import javax.swing.JLabel;
	import java.awt.GridBagConstraints;
	import java.awt.Rectangle;
	import java.awt.Font;
	import java.text.SimpleDateFormat;
	import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
	import javax.swing.JRadioButton;
	import javax.swing.JTable;
	import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

	
	public class Show_permits extends JPanel {

		private static final long serialVersionUID = 1L;
		private JLabel Label_title = null;
		private JLabel lblPermitsList;
		private JScrollPane jScrollPane = null;
		private JTable Table_permit = null;
		App_init strater;
		private JLabel jLabel = null;
		 
		/**
		 * This is the default constructor
		 */
		public Show_permits(App_init strater) {
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
			lblPermitsList = new JLabel();
			lblPermitsList.setText("Permits list");
			lblPermitsList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			lblPermitsList.setBounds(new Rectangle(258, 106, 182, 42));
			this.setSize(695, 500);
			this.setLayout(null);
			this.add(lblPermitsList, null);
			this.add(getJScrollPane(), null);
			
		}

		/**
		 * This method initializes jScrollPane	
		 * 	
		 * @return javax.swing.JScrollPane	
		 */
		private JScrollPane getJScrollPane() {
			if (jScrollPane == null) {
				jScrollPane = new JScrollPane();
				jScrollPane.setBounds(new Rectangle(45, 170, 618, 274));
				jScrollPane.setViewportView(getTable_permit());
			}
			return jScrollPane;
		}

		
		
		/**
		 * This method initializes Table_permit	
		 * 	
		 * @return javax.swing.JTable	
		 */
		private JTable getTable_permit() {
			if (Table_permit == null) {
				String[] columnNames = {"Permit type","Permit holder"," host name","suspended","number of entry","day of entry","uesed v reg N","permited v reg N"};
				
				//Create the JTable using the data array and column name array. 
				DefaultTableModel defTableModel = new DefaultTableModel(strater.permitlist.get_all_permits(),columnNames);
				Table_permit =  new JTable(defTableModel);
	
				
				 
			}
			return Table_permit;
		}

	}  

