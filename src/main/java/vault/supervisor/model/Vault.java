package vault.supervisor.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import vault.supervisor.event.PeopleEnterEvent;
import vault.supervisor.listener.PeopleEnterListener;

/**
 * 
 * @author Wei
 *
 */
public class Vault {

	private List<PeopleEnterListener> monitors;
	private Calendar enterTime;

	/**
	 * Constructor
	 */
	public Vault() {
		monitors = new ArrayList<PeopleEnterListener>();
	}

	/**
	 * Default constructor
	 */
	public void peopleEntered() {
		peopleEntered(Calendar.getInstance());
	}

	/**
	 * 
	 * @param enterTime
	 */
	public synchronized void peopleEntered(Calendar enterTime) {
		this.enterTime = enterTime;
		firePeopleEnterEvent();

	}

	/**
	 * 
	 * @param l
	 */
	public synchronized void addPeopleEnterListener(PeopleEnterListener l) {
		monitors.add(l);
	}

	/**
	 * 
	 * @param l
	 */
	public synchronized void removePeopleEnterListener(PeopleEnterListener l) {
		monitors.remove(l);
	}

	/**
	 * Fire event
	 */
	private synchronized void firePeopleEnterEvent() {
		PeopleEnterEvent event = new PeopleEnterEvent(this, enterTime);
		Iterator<PeopleEnterListener> listeners = monitors.iterator();
		while (listeners.hasNext()) {
			listeners.next().peopleEnterReceived(event);
		}
	}
}
