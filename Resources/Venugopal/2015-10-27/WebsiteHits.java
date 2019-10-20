public class WebsiteHits {

	// this is a global variable, does not appear inside a method
	// visible to all methods
	public static String[] days = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};

	public static int getPageIndex(String[] pageNames, String pageName) {
		for (int i = 0; i < pageNames.length; i++) {
			if (pageName.equalsIgnoreCase(pageNames[i])) {
				return i;
			}
		}
		return -1;
	}

	public static int getDayIndex(String day) {
		for (int i = 0; i < days.length; i++) {   // accesses global array days
			if (day.equalsIgnoreCase(days[i])) {
				return i;
			}
		}
		return -1;
	}

	public static void setPageHitsForDay(int[][] hits, int pageHitsForDay, String[] pageNames, String pageName, String day) {
		// find row index
		int row = getPageIndex(pageNames, pageName);
		if (row == -1) {
			return;
		}
		int col = getDayIndex(day);
		if (col == -1) {
			return;
		}
		hits[row][col] = pageHitsForDay;

	}

	public static int getPageHitsForWeek(int[][] hits, String[] pageNames, String pageName) {
		int row = getPageIndex(pageNames, pageName);
		if (row == -1) {
			return -1;
		}
		int total = 0;
		for (int c = 0; c < hits[row].length; c++) {
			total += hits[row][c];
		}
		return total;
	}

	public static int getSiteHitsForDay(int[][] hits, String day) {
		int col = getDayIndex(day);
		if (col == -1) {
			return -1;
		}
		int total = 0;
		for (int r = 0; r < hits.length; r++) {
			total += hits[r][col];
		}
		return total;
	}

	public static int getSiteHitsForWeek(int[][] hits) {
		int total = 0;
		for (int r = 0; r < hits.length; r++) {
			for (int c = 0; c < hits[0].length; c++) {
				total += hits[r][c];
			}
		}
		return total;
	}

	public static void printHitsData(int[][] hits, String[] pageNames) {
		// first print the day names for column headers
		// blank in day names column, fifteen spaces
		System.out.printf("%15s", " ");
		for (int c = 0; c < days.length; c++) {
			System.out.print("  " + days[c]);
		}
		System.out.println("\n");

		// now the hits for each page, each day
		for (int r = 0; r < hits.length; r++) {
			System.out.printf("%15s", pageNames[r]);
			for (int c = 0; c < hits[0].length; c++) {
				System.out.printf("%5d", hits[r][c]);
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// open hits file
		if (!IO.openFile("websitehits.txt")) {
			return;
		}

		String line;
		if ((line = IO.readLine()) == null) {
			return;
		}

		// first line is number of pages in site for which hits are being monitored
		int numPages = Integer.parseInt(line);

		// create hits array and page names array
		int[][] hits = new int[numPages][7];   // #rows = numPages, #cols = 7

		String[] pageNames = new String[numPages];

		// next block of lines in file has names of web pages in site
		for (int i = 0; i < numPages; i++) {
			pageNames[i] = IO.readLine();
		}

		// rest of the lines are hits, one line per page per day
		// in the format <page name>|<day>|<hits>
		while ((line = IO.readLine()) != null) {
			// separate on "|"
			int    pos      = line.indexOf('|');
			String pageName = line.substring(0, pos);

			int start = pos + 1;
			pos = line.indexOf('|', pos + 1);
			String day = line.substring(start, start + 3);  // only want first 3 chars

			int pageHits = Integer.parseInt(line.substring(pos + 1));

			// set page hits for day
			setPageHitsForDay(hits, pageHits, pageNames, pageName, day);
		}

		// print hits data
		printHitsData(hits, pageNames);

		// print hits for week
		System.out.println("\nTotal hits for all pages in week = " + getSiteHitsForWeek(hits));

		// respond to user queries for page hits for week or site hits for day
		doQueries(hits, pageNames);

	}

	private static void doQueries(int[][] hits, String[] pageNames) {
		char choice;
		while ((choice = getChoice()) != 'q') {
			if (choice == 'p') {
				System.out.print("Enter page name: ");
				String pageName = IO.readString();
				System.out.println("Hits in week for " + pageName + " = " + getPageHitsForWeek(hits, pageNames, pageName));
			}
			else { // only other choice is 's'
				System.out.print("Enter day: ");
				String day = IO.readString();
				System.out.println("Hits on " + day + " for site = " + getSiteHitsForDay(hits, day.substring(0, 3)));
			}
		}
	}

	public static char getChoice() {
		System.out.print("\n(p)age hits for week, or (s)ite hits for day? ('q' to quit): ");
		char ch = Character.toLowerCase(IO.readChar());
		while (!(ch == 'p' || ch == 's' || ch == 'q')) {
			System.out.print("You must enter 'p', or 's' or 'q': ");
			ch = Character.toLowerCase(IO.readChar());
		}
		return ch;
	}

}
