package vault.supervisor.model;

import java.util.Calendar;

/**
 * 
 * @author Wei
 *
 */	
public class Vault {
	
	private VaultMonitor monitor;
	
	/**
	 * Constructor
	 */
	public Vault(){
		monitor = new VaultMonitor();
	}

	/**
	 * 
	 * @return
	 */
	public VaultMonitor getMonitor() {
		return monitor;
	}
	/**
	 * @param monitor the monitor to set
	 */
	public void setMonitor(VaultMonitor monitor) {
		this.monitor = monitor;
	}
	
	
	
}
