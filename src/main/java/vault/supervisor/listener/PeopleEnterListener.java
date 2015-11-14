package vault.supervisor.listener;

import vault.supervisor.event.PeopleEnterEvent;

public interface PeopleEnterListener {
	public void peopleEnterReceived( PeopleEnterEvent event );
}

