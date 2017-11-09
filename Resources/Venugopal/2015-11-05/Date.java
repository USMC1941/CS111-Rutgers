// Date class definition
public class Date {
	
	// the default date is Jan 1, 2015
	// static fields are a property of the class, not of any specific
	// instance, so all instances (objects) of the class share a static
	// field
	public static final int DEFAULT_YEAR = 2015;
	public static final int DEFAULT_MONTH = 1;
	public static final int DEFAULT_DAY = 1;
	
	private int year;
	private int month;
	private int day;
	
	// full-fledged (and only) constructor
	// only dates on or after Jan 1, 2015 are allowed
	public Date(int year, int month, int day) {
		boolean valid=true;
		//DEFAULT_YEAR = 2016; // WON'T WORK - cannot change a final field value
		if (year < DEFAULT_YEAR || month < 1 || month > 12 || day < 1) {
			valid=false;
		}
		if (valid) {
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day > 30) {
					valid = false;
				}
			} else {
				if (month == 2) {
					if (isLeapYear(year) && day > 29) {
						valid = false;
					} else if (day > 28) {
						valid = false;
					}
				} else {
					if (day > 31) {
						valid = false;
					}
				}
			}
		}
		if (!valid) {
			year = DEFAULT_YEAR;
			month = DEFAULT_MONTH;
			day = DEFAULT_DAY;
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// constructor that sets year to default year
	public Date(int month, int day) {
		this(DEFAULT_YEAR, month, day);
	}
	
	// getter
	public int getYear() {
		return year;
	}
	
	// getter
	public int getMonth() {
		return month;
	}
	
	// getter
	public int getDay() {
		return day;
	}
	
	// setter
	public void setYear(int year) {
		// FILL IN THIS METHOD, DO APPROPRIATE CHECKS ON YEAR
	}
	
	public void setMonth(int month) {
		// FILL IN THIS METHOD, DO APPROPRIATE CHECKS ON MONTH
	}
	
	// setter
	public void setDay(int day) {
		// FILL IN THIS METHOD, DO APPROPRIATE CHECKS ON DAY
	}
	
	// checks if this date is equal to other date
	public boolean equals(Date other) {
		return this.year == other.year && this.month == other.month && this.day == other.day;
	}
	
	// tells if this date is before another
	public boolean before(Date other) {
		if (year < other.year) {
			return true;
		}
		if (year > other.year) {
			return false;
		}
		// years are same, check month
		if (month < other.month) {
			return true;
		} 
		if (month > other.month) {
			return false;
		}
		// months are same, check day
		return day < other.day;
	}
	
	// returns string representation of this date in mm/dd/yyyy format
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (month < 10) {
			sb.append('0');
		}
		sb.append(month);
		sb.append('/');
		if (day < 10) {
			sb.append('0');
		}
		sb.append(day);
		sb.append('/');
		sb.append(year);
		return sb.toString();
	}
	
	// helper (private) method to check if a given year is a leap year
	// static because it does not refer to any attributes of the object
	private static boolean isLeapYear(int year) {
		
		if (year%4 != 0) {
			return false;
		}
		if (year%100 != 0) {
			return true;
		}
		if (year%400 == 0) {
			return true;
		}
		
		// try to access instance field month
		//month = 2;  => CANNOT access instance field from this static method
		return false;
	}
}
