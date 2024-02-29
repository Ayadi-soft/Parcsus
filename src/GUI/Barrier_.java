package GUI;

	import java.awt.GridBagLayout;
	import javax.swing.JPanel;

import java.awt.BorderLayout;
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
	import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

	
	public class Barrier_  extends JPanel {

		private static final long serialVersionUID = 1L;
		private JLabel Label_title = null;
		private JLabel lblBarrier;
		private JLabel Label_isbn = null;
		private JTextField ISBN = null;
		private JButton Button_reset = null;
		private JButton Button_remove = null;
		App_init strater;
		private JLabel jLabel = null;
		private JLabel lab_id = null;
		private JLabel state;
		private JLabel jLabel1 = null;
		private JLabel lab_name = null;
		private JLabel day;
		private JLabel jLabel2 = null;
		private JScrollPane jScrollPane = null;
		private JTable Table_borrows = null;
		private JLabel jLabel3 = null;
		private JTable table_v = null;
		private JButton btnActivatedesactivate =null;
		/**
		 * This is the default constructor
		 */
		public Barrier_ (App_init strater) {
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
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(29, 209, 168, 30));
			jLabel2.setText("list of vehicile alloed to entry : ");
			day = new JLabel();
			day.setText(strater.ss.getToday_string());
			day.setBounds(new Rectangle(528, 162, 53, 28));
			
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(477, 164, 53, 24));
			jLabel1.setText("Today  : ");
			state = new JLabel();
			state.setFont(new Font("Tahoma", Font.BOLD, 13));
			state.setForeground(Color.RED);
			state.setText(strater.ss.state());
			state.setBounds(new Rectangle(125, 159, 106, 25));
			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(40, 162, 118, 19));
			jLabel.setText("System State : ");
			lblBarrier = new JLabel();
			lblBarrier.setText("Barrier");
			lblBarrier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			lblBarrier.setBounds(new Rectangle(164, 88, 299, 39));
			this.setSize(686, 511);
			this.setLayout(null);
			this.add(lblBarrier, null);
			this.add(jLabel, null);
			this.add(state, null);
			this.add(jLabel1, null);
			this.add(day, null);
			this.add(jLabel2, null);
			this.add(getJScrollPane(), null);
			this.add(getbtnActivatedesactivate(),null);
			this.add(gettable_v(),null);
			
			
			
		
		
		}

		/**
		 * This method initializes jScrollPane	
		 * 	
		 * @return javax.swing.JScrollPane	
		 */
		private JScrollPane getJScrollPane() {
			if (jScrollPane == null) {
				jScrollPane = new JScrollPane();
				jScrollPane.setBounds(new Rectangle(28, 250, 613, 208));
				jScrollPane.setViewportView(getTable_borrows());
			}
			return jScrollPane;
		}

		/**
		 * This method initializes Table_borrows	
		 * 	
		 * @return javax.swing.JTable	
		 */
		private JTable getTable_borrows() {
			if (Table_borrows == null) {
			 
				//A string array containing the column names for the JTable. 
				String[] columnNames = {"Reg number","Model"," color"};
				
				//Create the JTable using the data array and column name array. 
				DefaultTableModel defTableModel = new DefaultTableModel(strater.permitlist.get_all_permited_vehicle(),columnNames);
				Table_borrows =  new JTable(defTableModel);
				 
				
			}
			return Table_borrows;
		}

		
		  /**
			 * This method initializes table_v	
			 * 	
			 * @return javax.swing.JTable	
			 */
		private JTable gettable_v() {
			if (table_v == null) {
				//A string array containing the column names for the JTable. 
				String[] columnNames = {"Reg number","Model"," color"};
				
				//Create the JTable using the data array and column name array. 
				DefaultTableModel defTableModel = new DefaultTableModel(strater.permitlist.get_all_permited_vehicle(),columnNames);
			    table_v =  new JTable(defTableModel);
			}
			return table_v;
		}

		 
		private JButton getbtnActivatedesactivate() {
			if (btnActivatedesactivate == null) {
				btnActivatedesactivate = new JButton();
				btnActivatedesactivate.setText("Activate/desactivate");
				btnActivatedesactivate.setBounds(new Rectangle(393, 310, 163, 38));
				btnActivatedesactivate.setBounds(229, 157, 157, 29);
				btnActivatedesactivate.setToolTipText("Click this button to ctivate or desactivate.");
				btnActivatedesactivate.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						 
						strater.ss.change_state();
						
						state.setText(strater.ss.state());
						if(strater.ss.state().equalsIgnoreCase("Active"))
							state.setForeground(Color.green);
						else
							state.setForeground(Color.RED);
					}
				});
			}
			return btnActivatedesactivate;
		}
	}   

