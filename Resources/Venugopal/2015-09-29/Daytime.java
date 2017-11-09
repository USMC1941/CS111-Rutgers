
public class Daytime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("You are about to enter sunrise time...");
		
		// am or pm?
		System.out.print("Enter yes for AM, no for PM: ");
		boolean sunriseIsAM = IO.readBoolean();
			
		int sunriseHour;
		if (sunriseIsAM) {
			System.out.print("Enter sunrise hour, value in range 0..11 : ");
			sunriseHour = IO.readInt();
			if (sunriseHour < 0 || sunriseHour > 11) {
				System.out.println("Error: sunrise hour must be in range 0..11");
				System.exit(1);
			}
		} else {
			System.out.print("Enter sunrise hour, value in range 1..12 : ");
			sunriseHour = IO.readInt();
			if (sunriseHour < 1 || sunriseHour > 12) {
				System.out.println("Error: sunrise hour must be in range 1..12");
				System.exit(1);
			}
		}
			
		System.out.print("Enter sunrise minute: ");
		int sunriseMinute = IO.readInt();
		
		System.out.print("Enter sunset hour: ");
		int sunsetHour = IO.readInt();
		
		// am or pm?
		System.out.print("Enter yes for AM, no for PM: ");
		boolean sunsetIsAM = IO.readBoolean();
				
		System.out.print("Enter sunset minute: ");
		int sunsetMinute = IO.readInt();
		
		if (!sunriseIsAM) {
			sunriseHour += 12;   // a += b is same as a = a + b
		}
		
		if (!sunsetIsAM) {
			sunsetHour += 12;   // a += b is same as a = a + b
		}
		
		// normalize to minutes since midnight
		int sunriseMinsSinceMidnight = sunriseHour*60 + sunriseMinute; 
		int sunsetMinsSinceMidnight = sunsetHour*60 + sunsetMinute;
		
		// daylight duration
		int daylightMinutes = sunsetMinsSinceMidnight - sunriseMinsSinceMidnight;
		
		// check if sunrise is after sunset, and print error
		if (daylightMinutes < 0) {
			System.out.println("Sunrise is AFTER sunset, error...");
			System.exit(1);
		}
		
		// hours and minutes
		int daylightHours = daylightMinutes / 60;   // integer division, gives quotient
		int daylightMins = daylightMinutes % 60;    // '%' is the "mod" or modulus function, gives remainder
		
		System.out.printf("daylight duration is %d hours and %d minutes%n", daylightHours, daylightMins);
		

	}

}
