// Defines an event/appointment object
public class Event {

	private Date   date;
	private Time   time;
	private String description;

	// general/full-fledged constructor
	public Event(Date date, Time time, String description) {
		this.date = date;
		this.time = time;
		this.description = description;
	}

	// constructor that sets a default time of 1pm
	public Event(Date date, String description) {
		this(date, new Time(1, false), description);
	}

	// constructor that sets description to empty string
	public Event(Date date, Time time) {
		this(date, time, "");
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public String getDescription() {
		return description;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean conflictsWith(Event other) {
		return date.equals(other.date) && time.overlaps(other.time);
		// other.date is ok, even though date is declared private, 
		// because other is an Event object as well
	}

	public boolean equals(Event other) {
		return date.equals(other.date) && time.equals(other.time) && description.equalsIgnoreCase(other.description);
	}

	public boolean before(Event other) {
		if (this.date.before(other.date)) {
			return true;
		}
		if (this.date.equals(other.date) && this.time.before(other.time)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return date + " " + time + " " + description;
	}
}
