package vault.supervisor.view;

import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Wei
 *
 */
public class Supervisor implements Observer {
	private String name;
	
	/**
	 * Constructor
	 */
	public Supervisor(String name){
		this.name = name;
	}
	
	/**
	 * Update
	 */
	public void update(Observable obs, Object date) {
		if(date instanceof Calendar){
			notified(((Calendar)date));
		} else {
			notified(null);
		}
		
    }
	
	/**
	 * Log
	 */
	public void notified(Calendar date){
		String dataStr = "unknwon time";
		if(date != null){
			dataStr =  date.toString();
		}
		System.out.println(name + " -- Got it at " + dataStr);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
