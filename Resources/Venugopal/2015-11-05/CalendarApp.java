import java.util.StringTokenizer;


public class CalendarApp {

	private static String prompt = "(a)dd event" + ",(l)ist all events" + ",(d)elete event" + ",(x)elete all events for day" + ",(p)rint events for day" + ",(c)hange event" + ",(q)uit";

	private static Calendar cal;

	private static char getChoice() {
		System.out.println(prompt);
		System.out.print("Enter choice => ");
		char ch = IO.readChar();
		while (!(ch == 'a' || ch == 'l' || ch == 'd' || ch == 'x' || ch == 'p' || ch == 'c' || ch == 'q')) {
			System.out.print("Enter one of 'a', 'l', 'd', 'x', 'p', 'c' or 'q' => ");
			ch = IO.readChar();
		}
		return ch;
	}

	private static Date parseDateInput(String dateStr) {
		StringTokenizer st    = new StringTokenizer(dateStr, "/");
		int             month = Integer.parseInt(st.nextToken());
		int             day   = Integer.parseInt(st.nextToken());
		int             year  = Integer.parseInt(st.nextToken());
		return new Date(year, month, day);
	}

	private static Time parseTimeInput(String timeStr, String ampm) {
		StringTokenizer st   = new StringTokenizer(timeStr, ":");
		int             hour = Integer.parseInt(st.nextToken());
		int             min  = 0, sec = 0;
		if (st.hasMoreTokens()) {
			min = Integer.parseInt(st.nextToken());
			if (st.hasMoreTokens()) {
				sec = Integer.parseInt(st.nextToken());
			}
		}
		boolean am = true;
		if (ampm.equalsIgnoreCase("PM")) {
			am = false;
		}
		return new Time(hour, min, sec, am);
	}

	private static Event getEventInput() {
		System.out.print("Enter <dd/mm/yyyy> <hh[:mm[:ss]]> <AM|PM> <description> => ");
		String   evtStr = IO.readString();
		int      pos    = 0;
		String[] tokens = new String[4];
		for (int i = 0; i < 3; i++) {
			int nextPos = evtStr.indexOf(' ', pos);
			tokens[i] = evtStr.substring(pos, nextPos);
			pos = nextPos + 1;
		}
		tokens[3] = evtStr.substring(pos);

		Date   date  = parseDateInput(tokens[0]);
		Time   time  = parseTimeInput(tokens[1], tokens[2]);
		String descr = tokens[3];
		return new Event(date, time, descr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cal = new Calendar("sesh", 50);
		char ch;
		while ((ch = getChoice()) != 'q') {
			if (ch == 'a') {
				cal.addEvent(getEventInput());
				continue;
			}
			if (ch == 'l') {
				System.out.println(cal.events());
			}
			if (ch == 'p') {
				System.out.print("Enter <dd/mm/yyyy> => ");
				String dateStr = IO.readString();
				System.out.println(cal.eventsForDay(parseDateInput(dateStr)));
				continue;
			}
			if (ch == 'd') {
				//deleteEvent();
				continue;
			}
			if (ch == 'x') {
				System.out.print("Enter <dd/mm/yyyy> => ");
				String dateStr = IO.readString();
				cal.deleteAllEvents(parseDateInput(dateStr));
				continue;
			}
			// changeEvent();

		}
	}
}
