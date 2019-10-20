package examples;

public class DaylightTime {

	public static void main(String[] args) {

		System.out.println("Enter sunrise hour:");
		int riseHour = IO.readInt();
		if (riseHour < 0 || riseHour > 12) {
			System.out.println(riseHour + " invalid");
			return;
		}

		System.out.println("Enter sunrise minute:");
		int riseMinute = IO.readInt();
		if (riseMinute < 0 || riseMinute > 60) {
			System.out.println(riseMinute + " invalid");
			return;
		}

		System.out.println("Enter true for morning sunrise, false otherwise:");
		boolean riseAm = IO.readBoolean();

		System.out.println("Enter sunset hour:");
		int setHour = IO.readInt();
		if (setHour < 0 || setHour > 12) {
			System.out.println(setHour + " invalid");
			return;
		}

		System.out.println("Enter sunset minute:");
		int setMinute = IO.readInt();
		if (setMinute < 0 || setMinute > 60) {
			System.out.println(setMinute + " invalid");
			return;
		}

		System.out.println("Enter true for morning sunset, false otherwise:");
		boolean setAm = IO.readBoolean();

		if (riseAm == true && riseHour == 12) {
			/* 12am */
			riseHour = 0;
		}
		if (riseAm == false && riseHour != 12) {
			riseHour = riseHour + 12;
		}
		if (setAm == true && setHour == 12) {
			/* 12 am */
			setHour = 0;
		}
		if (setAm == false && setHour != 12) {
			setHour = setHour + 12;
		}

		if (setHour < riseHour || (setHour == riseHour && setMinute < riseMinute)) {
			System.out.println("Sunset cannot be before sunrise");
			return;
		}

		int dayHour   = setHour - riseHour;
		int dayMinute = setMinute - riseMinute;

		if (dayMinute < 0) {
			dayHour--;
			dayMinute = dayMinute + 60;
		}
		System.out.println("Amount of daylight is " + dayHour + " hours " + dayMinute + " minutes");
	}
}
