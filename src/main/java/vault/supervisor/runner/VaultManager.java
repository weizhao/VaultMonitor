package vault.supervisor.runner;

import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_1;
import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_2;
import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_3;
import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_4;

import java.util.Calendar;

import vault.supervisor.model.Vault;
import vault.supervisor.model.VaultMonitor;
import vault.supervisor.view.Supervisor;

/**
 * 
 * @author Wei
 *
 */
public class VaultManager {

	Supervisor supervisor1;
	Supervisor supervisor2;
	Supervisor supervisor3;
	Supervisor supervisor4;

	Vault vault;
	
	VaultMonitor monitor;
	/**
	 * Constructor
	 */
	public VaultManager() {
	}

	/**
	 * main method
	 * @param av
	 */
	public static void main(String[] av) {
		VaultManager manager = new VaultManager();
		manager.manage();
	}

	/**
	 * Runner
	 */
	public void manage() {
		supervisor1 = new Supervisor(CHANEL_SUPERVISOR_1);
		supervisor2 = new Supervisor(CHANEL_SUPERVISOR_2);
		supervisor3 = new Supervisor(CHANEL_SUPERVISOR_3);
		supervisor4 = new Supervisor(CHANEL_SUPERVISOR_4);

		vault = new Vault();
		monitor = new VaultMonitor();
		vault.addPeopleEnterListener(monitor);
		monitor.subscribeAChanel(CHANEL_SUPERVISOR_1, supervisor1);
		monitor.subscribeAChanel(CHANEL_SUPERVISOR_2, supervisor2);
		monitor.subscribeAChanel(CHANEL_SUPERVISOR_3, supervisor3);
		monitor.subscribeAChanel(CHANEL_SUPERVISOR_4, supervisor4);
		
		Calendar now = Calendar.getInstance();
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		Calendar date3 = Calendar.getInstance();
		Calendar date4 = Calendar.getInstance();
		
		date1.set(Calendar.HOUR_OF_DAY, 3);
		date2.set(Calendar.HOUR_OF_DAY, 9);
		date3.set(Calendar.HOUR_OF_DAY, 15);
		date4.set(Calendar.HOUR_OF_DAY, 21);
		
		vault.peopleEntered();
		vault.peopleEntered(date1);
		vault.peopleEntered(date2);
		vault.peopleEntered(date3);
		vault.peopleEntered(date4);
		vault.peopleEntered(now);
		vault.removePeopleEnterListener(monitor);
		
	}
}
