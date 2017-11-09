// Class that represents Time objects in a 12-hour clock e.g. 04:30:05 AM
public class Time {

	private int seconds; // seconds since midnight
	
	// no-arg constructor, for midnight
	public Time() {
		seconds = 0;   // midnight
	}
	
	// full-fledged constructor
	public Time(int hour, int min, int sec, boolean am) {
		if (hour < 0 || hour > 12 || min < 0 || min > 59 || sec < 0 || sec > 59
				|| (hour == 12 && am)) {
			// default to midnight
			hour=0;
			min=0;
			sec=0;
			am=true;
		}
		seconds = hour*3600 + min*60 + sec;
		if (!am) {
			seconds += 12*3600;
		}
	}
	
	// constructor to set time to some hour, am or pm
	public Time(int hour, boolean am) {
		this(hour, 0, 0, am);    // call general constructor
	}
	
	// constructor to set time to some hour and min, am or pm
	public Time(int hour, int min, boolean am) {
		this(hour, min, 0, am);    // call general constructor
	}
	
	// getter/accessor method to get hours since midnight
	public int getHour() {
		return seconds/3600;
	}
	
	// getter/accessor method to get minutes after hour mark
	public int getMin() {
		return (seconds - seconds/3600*3600)/60;
	}
	
	// getter/accessor method to get seconds after minute mark
	public int getSec() {
		return seconds % 60;
	}
	
	// getter/accessor method to tell if am or not
	public boolean am() {
		return seconds < 12*3600;
	}
	
	// setter/mutator method to set time to given hour, am/pm - minute and second will not change
	public void setHour(int hour, boolean am) {
		if (hour < 0 || hour > 12 || (hour == 12 && am) || (hour == 0 && !am)) {
			// default to midnight
			hour = 0;
			am = true;
		}
		int thour = seconds/3600;
		seconds = seconds - thour*3600 + hour*3600; 
		if (!am) {
			seconds += 12*3600;
		}
	}
	
	// setter/mutator method to set minutes of time, hour and second will not change
	public void setMin(int min) {
		if (min < 0 || min > 59) {
			System.out.println("incorrect min");
			System.exit(1);
		}
		int tmin = (seconds - seconds/3600*3600)/60;
		seconds = seconds - tmin*60 + min*60;
	}
	
	// setter/mutator method to set seconds of time, hour and minute will not change
	public void setSec(int sec) {
		if (sec < 0 || sec > 59) {
			System.out.println("incorrect sec");
			System.exit(1);
		}
		int tsec = seconds % 60;
		seconds = seconds - tsec + sec;
	}
	
	// tells if this time is equal to other time
	public boolean equals(Time other) {
		return seconds == other.seconds;
	}
	
	// tells if this Time overlaps other Time
	// two times overlap if they fall within the same hour
	public boolean overlaps(Time other) {
		return Math.abs(this.seconds - other.seconds) < 3600;
	}
	
	// tells if this time is before another time (but not overlapping)
	public boolean before(Time other) {
		if (this.overlaps(other)) {
			return false;
		}
		return seconds < other.seconds;
	}
	
	// string representation of the time in format hh:mm:ss AM/PM
	public String toString() {
		int hour = seconds/3600;
		int min = (seconds - seconds/3600*3600)/60;
		int sec = seconds % 60;
		boolean am = true;
		if (seconds >= 12*3600) {
			am = false;
			hour -= 12;
		}
		String tm = "";
		if (hour < 10) {
			tm += "0";
		}
		tm += hour + ":";
		if (min < 10) {
			tm += "0";
		}
		tm += min + ":";
		if (sec < 10) {
			tm += "0";
		}
		tm += sec + " ";
		if (am) {
			tm += "AM";
		} else {
			tm += "PM";
		}
		return tm;
	}
 }
