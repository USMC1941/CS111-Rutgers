package examples;

public class DaylightTime_v2 {

public static void main (String[] args) {
		
		System.out.println("Enter sunrise hour:");
		int riseHour = IO.readInt();
		while (riseHour < 0 || riseHour > 12) {
			/* while condition is true, loop operations are executed */
			System.out.println(riseHour + " is invalid, enter sunrise hour again:");
			riseHour = IO.readInt();
		}
		
		/* TODO: Repeatedly ask for sunrise minute, sunset hour and minute */
		System.out.println("Enter sunrise minute:");
		int riseMinute = IO.readInt();
		while (riseMinute < 0 || riseMinute > 60) {
			System.out.println(riseMinute + " is invalid, enter sunrise minute again:");
			riseMinute = IO.readInt();
		}
		
		System.out.println("Enter true for morning sunrise, false otherwise:");
		boolean riseAm = IO.readBoolean();
		
		System.out.println("Enter sunset hour:");
		int setHour = IO.readInt();
		while (setHour < 0 || setHour > 12) {
			System.out.println(setHour + " invalid, enter sunset hour again:");
			setHour = IO.readInt();
		}
		
		System.out.println("Enter sunset minute:");
		int setMinute = IO.readInt();
		while (setMinute < 0 || setMinute > 60) {
			System.out.println(setMinute + " invalid, enter sunset minute again: ");
			setMinute = IO.readInt();
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
		
		int dayHour = setHour - riseHour;
		int dayMinute = setMinute - riseMinute;
		
		if (dayMinute < 0) {
			dayHour--;
			dayMinute = dayMinute + 60;
		}
		System.out.println("Amount of daylight is " + dayHour + " hours " + dayMinute + " minutes");
	}
}
