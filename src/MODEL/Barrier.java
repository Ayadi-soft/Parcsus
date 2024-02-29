package MODEL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

/* Generated by Together */

/**
 * This class represents the access control barriers.
 * Information about the barrier functions is in the Barrier use case diagram (hyperlinked from this class).
 * Although in reality this class will be realised by (programmable) hardware with a moveable barrier, and a camera with a registration number recognition system, here the interface comprises one screen with the various functions present on it, all on view at once since there aren't many.
 * There will be a large word PASS or STOP on display at all times: PASS when the barrier is up because the system is inactive or temporarily when a permitted vehicle is being allowed through, and STOP when the barrier is down. There will be a text field to enter the registration number read by the camera, and a button to indicate that the number has been read and is ready for checking (and raising the barrier or not, as appropriate).
 * To simulate the passage of a vehicle through the raised barrier, there is another button to be clicked to simulate when a buried electronic sensor indicates that the vehicle is now clear - the barrier can then be lowered (unless, of course, the system has been deactivated by security staff in the interim...).
 * There could be many instances of this class: one at each entrance lane to the University.
 * The class implements Observer, and observes the system status so that it can keep its activated/deactivated status up to date.
 * @stereotype boundary
 * @url element://model:project::PACSUS/design:view:::fx37lgktya8k8hlywa1
 * @url element://model:project::PACSUS/design:node:::1lh49gkua8d3pjgcawx
 * @url element://model:project::PACSUS/design:view:::5mgzcgkty8w6e-xnp1xg
 * @url element://model:project::PACSUS/design:node:::cpf2mgkuaa1ff-mfhlzm
 */
public class Barrier extends JFrame implements Observer {
    /**
     * Each instance of Barrier has a navigable association to the permit list so that when a vehicle's registration number has been recognized by the camera, the barrier can check whether to raise itself or not by checking the status of that vehicle's permit.
     * @clientCardinality 1..*
     * @supplierCardinality 1
     * @label Access permits
     * @directed*/
    private Vehicle_list lnkVehicle_list;

    /**
     * Each instance of Barrier has a navigable association to the system status so that it can check whether the barrier system as a whole is active or inactive, and so that it can send event messages to be recorded in the log.
     * @clientCardinality 1..*
     * @supplierCardinality 1
     * @label Fetch system status info
     * @directed*/
    private System_status lnkSystem_status;

    /**
     * This attribute indicates the active/inactive state of the barrier system - as notified by the system status when it changes (Barrier Observes System status). If false then the barrier must be up. If true then the barrier position is determined by attribute raised. 
     */
    private boolean active = false;

    /**
     * If the barrier system is active, this attribute indicates whether the barrier is currently it its raised or lowered position. The position is controlled by the result of checking a registration number with the permitted vehicles list, and the "vehicle clear" button. 
     */
    private boolean raised = true;
    
    
    public Barrier(System_status x, Vehicle_list y){
		this.lnkSystem_status=x;
		this.lnkVehicle_list=y;
	}
    
    
    public void update(Observable obs, Object obj)
    {
      
    }
    
}
