package MODEL;
import java.util.Observable;


/**
 * This class holds key control information for the operation of the barrier system.
 * It extends Observable, and notifies its observers whenever either the date changes (caused by the Timer class), or the barrier system activity status changes (caused by an instance of the Campus security class), or the barrier event log changes (caused by an instance of the Barrier class).
 * There will only be one instance of this class.

 */
public class System_status extends Observable {
    /**
     * This attribute is the central indication of the activity status of the whole barrier system. It is set/unset by messages from instances of the Campus security class.
     */
    private boolean systemActive = false;

    /**
     * An array of strings showing recent attempts to pass through the barriers (both successful and unsuccessful). The last 20 should be enough? These are intended for display on the Campus_security screens.
     */
    private String[] log;

    /**
     * This attribute is kept up to date by the Timer.
     * @clientCardinality 1
     * @supplierCardinality 1 
     * @link aggregation
     * @label Contains
     * @directed
     */
    private Date_ today;
    
    public System_status() {
    	today =new Date_();
	}
    
    
    public String state() {
		if(systemActive)
    	return "Active";
		return "inactive";
	}
    
    public void change_state() {
		if(systemActive)
			systemActive=false;
		else
		systemActive=true;
	}
    

	public boolean isSystemActive() {
		return systemActive;
	}

	public void setSystemActive(boolean systemActive) {
		this.systemActive = systemActive;
		setChanged(); 
        notifyObservers(); 
	}

	public String[] getLog() {
		return log;
	}

	public void setLog(String[] log) {
		this.log = log;
		setChanged(); 
        notifyObservers(); 
	}

	public Date_ getToday() {
		return today;
	}
	
	public String getToday_string() {
		int x = today.getDayNumber();
		return Integer.toString(x);
	}

	public void setToday(Date_ today) {
		this.today = today;
		setChanged(); 
        notifyObservers(); 
	}
    
    
    
    
}
