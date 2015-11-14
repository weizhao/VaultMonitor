package vault.supervisor.event;

import java.util.Calendar;
import java.util.EventObject;

public class PeopleEnterEvent extends EventObject {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3343164488158444733L;
	
	

	private Calendar enterTime;
	public PeopleEnterEvent(Object source, Calendar enterTime){
		super( source );
		this.enterTime = enterTime;
		
	}
	/**
	 * @return the enterTime
	 */
	public Calendar getEnterTime() {
		return enterTime;
	}
}
