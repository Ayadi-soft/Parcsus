package GUI;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Authentication extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JLabel Label_id = null;
	private JTextField id = null;
	private JButton ok = null;
	private JButton Button_reset = null;
	App a;
	App_init strater;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public Authentication(App_init strater,App a) {
		super();
		this.a=a;
		this.strater=strater;
		initialize();
		a.deactivate_menu();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(36, 394, 578, 22));
		jLabel.setText(" ** test info     Administration_office id =1     Campus_security id =2   ");
		Label_id = new JLabel();
		Label_id.setBounds(new Rectangle(204, 216, 107, 27));
		Label_id.setText("ID Card Number : ");
		Label_title = new JLabel();
		Label_title.setText("Authentication");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		Label_title.setBounds(new Rectangle(237, 145, 171, 34));
		this.setSize(650, 500);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(Label_id, null);
		this.add(getId(), null);
		this.add(getOk(), null);
		this.add(getButton_reset(), null);
		this.add(jLabel, null);
	}

	/**
	 * This method initializes id	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getId() {
		if (id == null) {
			id = new JTextField();
			id.setBounds(new Rectangle(325, 214, 124, 30));
		}
		return id;
	}

	/**
	 * This method initializes ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOk() {
		if (ok == null) {
			ok = new JButton();
			ok.setBounds(new Rectangle(275, 301, 50, 50));
			ok.setIcon(new ImageIcon(getClass().getResource("/Img/val.png")));
			ok.setText("");
			ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					verif_user(id.getText() );
				}
			});
		}
		return ok;
	}

	/**
	 * This method initializes Button_reset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_reset() {
		if (Button_reset == null) {
			Button_reset = new JButton();
			Button_reset.setBounds(new Rectangle(375, 301, 50, 50));
			Button_reset.setIcon(new ImageIcon(getClass().getResource("/Img/reset.png")));
			Button_reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					id.setText("");
				}
			});
		}
		return Button_reset;
	}
	
	public void verif_user(String id )
	{
		
		
		if(id.equalsIgnoreCase("1") )
		{
			strater.main_form.Activate_menu_super_user();
			strater.main_form.jFrame.setContentPane(strater.getjpan());
		}
		else if(id.equalsIgnoreCase("2") )
		{
			
			strater.main_form.Activate_menu_normal_user();
			strater.main_form.jFrame.setContentPane(strater.getjpan());
			}
			else
			{
					
				
				JOptionPane jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "this user does not exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
	}

	
} 
