package MODEL;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;



/**
 * Vehicle list manages the collection of vehicles currently associated with permits. It handles checks of whether vehicles are allowed through the barriers, records warnings, and various other functions. Note that each Vehicle_info object must have a unique registration number, to allow sensible checking and recording of entries onto the campus (so a HashTable is probably a good implementation of the collection, with registration number as key).
 * There will only be one instance of this class.
 * @url element://model:project::PACSUS/design:node:::hb9ongkua8d7b-6jddv3
 * @url element://model:project::PACSUS/design:node:::eizwpgkua8d716ey0zc
 */
public class Vehicle_list {
    /** The Vehicle list maintains a collection of the known Vehicle_infos associated with all permits. This association must be implemented by an attribute holding a collection data structure (for example: array, hash table - the latter is recommended). 
     * 
     * Note that no two Vehicle_infos may have the same registration number (this information is not represented diagrammatically) - this is to guarantee consistency with the constraint that no vehicle is associated with more than one permit.
     * 
     * Note that, given a registration number, the Vehicle_list can look up the appropriate Vehicle_info instance, and via that it can obtain the vehicle's permit information.
     * @associates Vehicle_info 
     * @label Contains
     * @clientCardinality 1
     * @supplierCardinality 0..*
     * @directed*/
    private Vector<Vehicle_info> lnkVehicle;
    
    
    public Vehicle_list() {
    	lnkVehicle = new  Vector<Vehicle_info>();
	}
    
    public void add_vehicle (Vehicle_info x) {
    	
    	lnkVehicle.add( x) ;
	}
    
   public  String[]  get_all_vehicle_num () {
    	
	   String[] data =new String[lnkVehicle.size()];
	   for(int i=0; i<lnkVehicle.size();i++)
		   data[i]=lnkVehicle.get(i).getV_reg_no();
	   return data;
	}
   
   
   

   public  Vehicle_info  get_vehicle (String x) {
    	
	  	   for(int i=0; i<lnkVehicle.size();i++)
		 if(x.equals(lnkVehicle.get(i).getV_reg_no()))
		   	   return lnkVehicle.get(i);
	   
	   return null;
	   
	}
   
   
    
    public void  load() {
    	try { 
    	      FileInputStream fileIn = new FileInputStream("v_l.ser"); 
    	      ObjectInputStream in = new ObjectInputStream(fileIn); 
    	      Vector v = (Vector)in.readObject( ); 
    	      System.out.println(v.toString( )); 
    	      lnkVehicle= v;
    	      System.out.println("vehicle loded ko"); 
    	    } 
    	    catch (Exception e) { 
    	      System.out.println(e); 
    	    } 
    	 
    	  } 
    	
    	
    	
    public void save() {
    	 try { 
    	      FileOutputStream fileOut = new FileOutputStream("v_l.ser"); 
    	      ObjectOutputStream out = new ObjectOutputStream(fileOut); 
    	      out.writeObject(lnkVehicle); 
    	      System.out.println("vehicle saved ok"); 
    	    } 
    	    catch (Exception e) { 
    	      System.out.println(e); 
    	    } 
	}  
    
    
    public Object[][] get_all_vehicles( )
	{
		
		Object[][] data = new Object[100][4]; 
		for(int i=0;i<lnkVehicle.size();i++)
        {
			Vehicle_info x =(Vehicle_info) lnkVehicle.get(i);
				
				data[i][0]=new String(x.getV_reg_no());
				data[i][1]=new String(x.getV_model());
				data[i][2]=new String(x.getV_color());
				data[i][3]=new String(x.getV_desc());

	   	}
	    
	 	return data;
	     }
    
    public Object[][] get_all_vehicles_bynum( String num )
	{
		int j=0;
		Object[][] data = new Object[100][4]; 
		for(int i=0;i<lnkVehicle.size();i++)
        {
			Vehicle_info x =(Vehicle_info) lnkVehicle.get(i);
			if(x.getV_reg_no().indexOf(num)!=-1)
	     	{	
				data[j][0]=new String(x.getV_reg_no());
				data[j][1]=new String(x.getV_model());
				data[j][2]=new String(x.getV_color());
				data[j][3]=new String(x.getV_desc());
				j++;
	   	}
        }
	 	return data;
	     }
    
    
    
}
