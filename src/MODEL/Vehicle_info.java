package MODEL;
import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;



/**
 * Each instance of Vehicle_info models an actual physical vehicle, so no two instances may have the same registration number. There is no direct notation for this. Instead the Vehicle list object collecting the Vehicles must enforce it by checking new additions - the use of a HashTable in Vehicle_list with the registration number as key is helpful with this.
 * This class must contain at least the registration number, and may have any other attributes that the University may from time to time find useful (such as car make, model, colour...).

 */
public class Vehicle_info implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * The vehicle's registration number. 
     */
    private String v_reg_no;
    private String v_model;
    private String v_color;
    private String v_desc;
    
    private ArrayList<String> warning ;

  

	/**
     * Each vehicle (and so each registration number) is associated with exactly one permit, which describes its authorization to enter the campus (or not!). 
     * 
     * This attribute references the permit associated with this vehicle. It alows the permit status of any vehicle to be accessed via the Vehicle_list knowing only the registration number - for example for barrier checks, recording warnings, and so on.
     * 
     * Note that many vehicles may be associated with the same permit.
     * @supplierCardinality 1
     * @clientCardinality 1..*
     * @label Allowed entry by
     * @directed
     */
    private Permit lnkPermit;
    
    
    public Vehicle_info() {
    	   warning = new ArrayList<String>();
	}
    
public Vehicle_info(String num, String model, String color ,String desc) {
	v_reg_no = num;
      v_model =model;
      v_color = color;
      v_desc =desc;
      warning = new ArrayList<String>();
	}

public Vehicle_info(String num, String model, String color ,String desc,  Permit p) {
	v_reg_no = num;
    v_model =model;
    v_color = color;
    v_desc =desc;
    lnkPermit=p;
    warning = new ArrayList<String>();
}
    
    
    

	public String getV_reg_no() {
		return v_reg_no;
	}

	public void setV_reg_no(String v_reg_no) {
		this.v_reg_no = v_reg_no;
	}

	public String getV_model() {
		return v_model;
	}

	public void setV_model(String v_model) {
		this.v_model = v_model;
	}

	public String getV_color() {
		return v_color;
	}

	public void setV_color(String v_color) {
		this.v_color = v_color;
	}

	public String getV_desc() {
		return v_desc;
	}

	public void setV_desc(String v_desc) {
		this.v_desc = v_desc;
	}

	public Permit getLnkPermit() {
		return lnkPermit;
	}

	public void setLnkPermit(Permit lnkPermit) {
		this.lnkPermit = lnkPermit;
	}
	
	  public  ArrayList<String> getWarning() {
			return warning;
		}
	  
	  public void addWarning(String x) {
			 warning.add(x);
			
		}

		public void setWarning( ArrayList<String> warning) {
			this.warning = warning;
		}
    
    
}
