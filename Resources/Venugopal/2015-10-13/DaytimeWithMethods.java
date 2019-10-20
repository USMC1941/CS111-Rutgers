public class DaytimeWithMethods {

	private static int sunriseOrSunsetHour(boolean sunrise) {

		if (sunrise) {
			System.out.println("You are about to enter sunrise time...");
		}
		else {
			System.out.println("You are about to enter sunset time...");
		}

		// am or pm?
		System.out.print("Enter yes for AM, no for PM: ");
		boolean hourIsAM = IO.readBoolean();

		int hour;
		if (hourIsAM) {
			do {
				System.out.print("Enter hour, value in range 0..11 : ");
				hour = IO.readInt();
			}
			while (hour < 0 || hour > 11);
		}
		else {
			do {
				System.out.print("Enter hour, value in range 1..12 : ");
				hour = IO.readInt();
			}
			while (hour < 1 || hour > 12);
		}

		if (!hourIsAM && hour != 12) {
			hour += 12;
		}
		return hour;
	}

	private static int minute() {
		int minute;
		do {
			System.out.print("Enter minute, in range 0..59 : ");
			minute = IO.readInt();
		}
		while (minute < 0 || minute > 59);
		return minute;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// most extreme situation
		System.out.print("Did the sun rise at all today?: ");
		boolean sunRose = IO.readBoolean();
		if (!sunRose) {
			System.out.print("Is it light (yes) or dark (no)?: ");
			boolean light = IO.readBoolean();
			if (light) {
				System.out.printf("daylight duration is 24 hours");
			}
			else {
				System.out.printf("daylight duration is 0 hours");
			}
			return;
		}

		int daylightMinutes;
		do {
			int sunriseHour   = sunriseOrSunsetHour(true);
			int sunriseMinute = minute();

			int sunsetHour   = sunriseOrSunsetHour(false);
			int sunsetMinute = minute();


			// normalize to minutes since midnight
			int sunriseMinsSinceMidnight = sunriseHour * 60 + sunriseMinute;
			int sunsetMinsSinceMidnight  = sunsetHour * 60 + sunsetMinute;

			// daylight duration
			daylightMinutes = sunsetMinsSinceMidnight - sunriseMinsSinceMidnight;

			// check if sunrise is after sunset, and print error
			if (daylightMinutes < 0) {
				System.out.println("Sunrise is AFTER sunset, enter data again...");
			}

		}
		while (daylightMinutes < 0);

		// hours and minutes
		int daylightHours = daylightMinutes / 60;   // integer division, gives quotient
		int daylightMins  = daylightMinutes % 60;    // '%' is the "mod" or modulus function, gives remainder

		System.out.printf("daylight duration is %d hours and %d minutes%n", daylightHours, daylightMins);


	}

}
