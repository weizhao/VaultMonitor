package vault.supervisor.model;

import java.util.Calendar;
import java.util.Observable;

/**
 * 
 * @author Wei
 * 
 */
public class MonitorChanel extends Observable {
	
	/**
	 * 
	 * @param date
	 */
    public void notifySubscriber(Calendar date) {
        // Notify observers of change
        setChanged();
        notifyObservers(date);
      }
}
