package MODEL;
import java.io.*;
import java.util.*;


/**
 * Permit list manages the collection of permits currently issued and not yet cancelled (or expired). It handles most of the use cases in the Administration section. Note that each Permit must have a unique permit holder name (so a HashTable is probably a good implementation of the collection, with permit holder name as key).
 * There will only be one instance of this class.
 * @url element://model:project::PACSUS/design:node:::do5vzgkua8d4jdr1bhg
 * @url element://model:project::PACSUS/design:node:::cn91cgkua8d5ntyb7jy
 */
public class Permit_list {
    /** The Permit list maintains a collection of the Permits currently issued. 
     * 
     * This association must be implemented by an attribute holding a collection data structure (for example: array, hash table - the latter is recommended). 
     * 
     * Note that no two Permits may have the same permit holder name (this information is not represented diagrammatically).
     * @associates Permit
     * @label Contains
     * @clientCardinality 1
     * @supplierCardinality 0..*
     * @directed*/
    private Vector<Permit> lnkPermit;
    
    public Permit_list() {
    	lnkPermit = new  Vector<Permit>();
	}
    
	
	  public void add_permit (Permit x) { lnkPermit.add(  x) ;  this.save(); }
	 
    
    public void  load() {
    	try { 
    	      FileInputStream fileIn = new FileInputStream("p_l.ser"); 
    	      ObjectInputStream in = new ObjectInputStream(fileIn); 
    	      Vector v = (Vector)in.readObject( ); 
    	      System.out.println(v.toString( )); 
    	      lnkPermit= v;
    	      System.out.println("ko"); 
    	    } 
    	    catch (Exception e) { 
    	      System.out.println(e); 
    	    } 
    	 
    	  } 
    	
    	
    	
    public void save() {
    	 try { 
    	      FileOutputStream fileOut = new FileOutputStream("p_l.ser"); 
    	      ObjectOutputStream out = new ObjectOutputStream(fileOut); 
    	      out.writeObject(lnkPermit); 
    	      System.out.println("ok"); 
    	    } 
    	    catch (Exception e) { 
    	      System.out.println(e); 
    	    } 
	}  
    
    
    public  void  show_all_permit () {
    	
 	    	   for(int i=0; i<lnkPermit.size();i++)
 	    		 System.out.println( lnkPermit.get(i).getPermitHolder());
 	  
 	}
    
    public Object[][] get_all_permits( )
	{
		
		Object[][] data = new Object[100][8]; 
		for(int i=0;i<lnkPermit.size();i++)
        {
			Permit x =(Permit) lnkPermit.get(i);
				
				data[i][0]=new String(x.getPermittype());
				data[i][1]=new String(x.getPermitHolder());
				data[i][2]=new String(x.getHost_name());
				data[i][3]=new String( x.isSuspended());
				data[i][4]=x.getNoOfEntries();
				data[i][5]=x.getStart_day().getDayNumber();
				data[i][6]=new String(x.getVehicleUsedToday().getV_reg_no());
				data[i][7]=new String(x.getPermittedVehicles().getV_reg_no());
	   	}
	    
	 	return data;
	     }
    
    
    public Object[][] get_all_permited_vehicle( )
  	{
  		
  		Object[][] data = new Object[100][3]; 
  		for(int i=0;i<lnkPermit.size();i++)
          {
  			Permit x =(Permit) lnkPermit.get(i);
  				
  				data[i][0]=new String(x.getVehicleUsedToday().getV_reg_no());
  				data[i][1]=new String(x.getVehicleUsedToday().getV_model());
  				data[i][2]=new String(x.getVehicleUsedToday().getV_color());
  				//data[i][3]=new String(x.getVehicleUsedToday().getV_reg_no());
  				
  	   	}
  	    
  	 	return data;
  	     }
    
    
    
    
}
