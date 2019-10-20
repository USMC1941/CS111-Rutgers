// Definition of calendar object. A calendar keeps a chronological list of events/appointments,
// and allows adds, deletes, and modifications of events
public class Calendar {
	private String  username;
	private Event[] events;
	private int     size;   // number of actual events in the array

	public Calendar(String username, int maxEvents) {
		this.username = username;
		events = new Event[maxEvents];
		size = 0;
	}

	public String getUsername() {
		return username;
	}

	public int getSize() {
		return size;
	}

	// adds a new event in chronological order
	// if this conflicts with an existing event, a warning message is 
	// printed, and the user has the option to go ahead with the add or cancel it
	// method returns true if the event was added, false if not
	public boolean addEvent(Event event) {
		if (size == events.length) {  // full house, can't add
			return false;
		}
		// loop as long as events in list are before the new event
		int i = 0;
		while (i < size) {
			if (events[i].before(event)) {
				i++;
			}
			else {
				break;
			}
		}
		if (i == size) { // add new event to end 
			events[i] = event;
			size++;
			return true;
		}

		// check if there is a conflict
		if (!events[i].conflictsWith(event)) {
			// add at i after moving everything from i to size-1 one spot over to the right
			for (int j = size - 1; j >= i; j--) {
				events[j + 1] = events[j];
			}
			events[i] = event;
			size++;
			return true;
		}

		// conflict, resolve it
		return resolveConflict(i, event);
	}

	private boolean resolveConflict(int i, Event event) {
		System.out.println(event + " conflicts with one or more existing events");
		System.out.print("Do you want to (a)dd or (c)ancel? ");
		char ch = Character.toLowerCase(IO.readChar());
		while (ch != 'a' && ch != 'c') {
			System.out.print("You must type 'a' or 'c': ");
			ch = Character.toLowerCase(IO.readChar());
		}
		if (ch == 'c') {  // return without adding
			return false;
		}
		// plug this event in the correct chronological place, checking minutes and seconds
		int eventSeconds = event.getTime().getMin() * 60 + event.getTime().getSec();
		while (i < size) {
			Time tm       = events[i].getTime();
			int  iSeconds = tm.getMin() * 60 + tm.getSec();
			if (eventSeconds <= iSeconds) {  // insert at i after moving stuff over
				for (int j = size - 1; j >= i; j--) {
					events[j + 1] = events[j];
				}
				events[i] = event;
				size++;
				return true;
			}
			i++;
		}
		// reached the end, add to end
		events[i] = event;
		size++;
		return true;
	}

	// deletes the given event
	// if event does not exist, returns false, otherwise true
	public boolean deleteEvent(Event event) {
		int i = 0;
		while (i < size) {
			if (events[i].equals(event)) {
				break;
			}
			i++;
		}
		if (i == size) {  // no match
			return false;
		}
		for (int j = i + 1; j < size; j++) {
			events[j - 1] = events[j];
		}
		size--;
		return true;
	}

	// deletes all events for given date
	public void deleteAllEvents(Date date) {
		int i = 0;
		while (i < size) {
			if (events[i].getDate().equals(date)) {
				break;
			}
			i++;
		}
		if (i == size) {  // no matches
			return;
		}
		// loop through this and all subsequent matches with same date
		int j = i;
		while ((j + 1) < size) {
			if (events[j + 1].getDate().equals(date)) {
				j++;
			}
			else {
				break;
			}
		}
		// leap frog over all intervening matches
		int jump = j - i;
		for (int k = j + 1; k < size; k++) {
			events[j - jump] = events[k];
		}
		size -= (jump + 1);
	}

	// changes original event to new event
	// if original event is not found, returns false, otherwise true
	public boolean modifyEvent(Event originalEvent, Event newEvent) {
		for (int i = 0; i < size; i++) {
			if (events[i].equals(originalEvent)) {
				events[i] = newEvent;
				return true;
			}
		}
		return false;
	}

	// returns all events in calendar
	public String events() {
		if (size == 0) {  // no events
			return "\n";
		}

		// loop through all events in calendar and build string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(events[i]);
			sb.append("\n");
		}
		return sb + "";
	}

	// returns all events for a day, one per line
	public String eventsForDay(Date date) {
		int i = 0;
		while (i < size) {
			if (events[i].getDate().equals(date)) {
				break;
			}
			i++;
		}
		if (i == size) {  // no matches
			return "\n";
		}

		// loop through this and all subsequent matches with same date
		StringBuilder sb = new StringBuilder();
		while (i < size) {
			if (events[i].getDate().equals(date)) {
				sb.append(events[i]);
				sb.append("\n");
				i++;
			}
			else {
				break;
			}
		}
		return sb.toString();  // or sb + ""
	}

	// returns string representation of entire calendar
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(events[i]);
			sb.append("\n");
		}
		return sb.toString();  // or sb + ""
	}
}
