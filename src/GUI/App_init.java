package GUI;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MODEL.*;




		public class App_init {
			private JPanel jPane_vide = null;
		
			public App main_form;
			public Permit_list permitlist;
			public Vehicle_list vehiclelist;
			public System_status ss;
			
			public  App_init(){
			
				permitlist = new Permit_list();

				permitlist.load();
				  
				 vehiclelist = new Vehicle_list();

				vehiclelist.load();
				
				 ss=new System_status();
				
			}	
		
			public JPanel getjpan() {
				
					jPane_vide = new JPanel();
					jPane_vide.setSize(650, 550);
					jPane_vide.setLayout(null);
					jPane_vide.add(main_form.jToolBar, BorderLayout.BEFORE_FIRST_LINE);
				
				return jPane_vide;
			}
			
			public void activate() {
				 Authentication form = new Authentication(this,main_form) ;
				// main_form.deactivate_menu();
				 form.add(main_form.jToolBar, BorderLayout.BEFORE_FIRST_LINE);
					main_form.jFrame.setContentPane(form);
					main_form.deactivate_menu();
				
			}

			public Permit_list getPermitlist() {
				return permitlist;
			}

			public Vehicle_list getVehiclelist() {
				return vehiclelist;
			}
			
			
			

		}
