package vault.supervisor.model;

import java.lang.annotation.Inherited;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import vault.supervisor.event.PeopleEnterEvent;
import vault.supervisor.listener.PeopleEnterListener;
import vault.supervisor.util.ChanelKeyConverter;
import vault.supervisor.view.Supervisor;

/**
 * 
 * @author Wei
 *
 */
public class VaultMonitor implements PeopleEnterListener {
	private Map<String, MonitorChanel> chanels;

	/**
	 * Constructor
	 */
	public VaultMonitor() {
		chanels = new HashMap<String, MonitorChanel>();
	}

	/**
	 * 
	 * @param chanelKey
	 * @param who
	 */
	public void subscribeAChanel(String chanelKey, Supervisor who) {
		MonitorChanel chanel = chanels.get(chanelKey);
		if (chanel == null) {
			chanel = new MonitorChanel();
			chanels.put(chanelKey, chanel);
		}
		chanel.addObserver(who);
	}

	/**
	 * 
	 * @param PeopleEnterEvent
	 */
	public void peopleEnterReceived( PeopleEnterEvent event ) {
		Calendar date = event.getEnterTime();
		String chanelKey = ChanelKeyConverter.converteDateToChanelKey(date);
		MonitorChanel chanel = chanels.get(chanelKey);
		if (chanel != null) {
			chanel.notifySubscriber(date);
		}
	}

	
}
