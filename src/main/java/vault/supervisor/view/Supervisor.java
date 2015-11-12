package vault.supervisor.view;

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
	public void update(Observable obs, Object meObj) {
		notified();
    }
	
	/**
	 * Log
	 */
	public void notified(){
		System.out.println(name + " -- Got it");
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
