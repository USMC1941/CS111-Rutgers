package examples;

public class TVGuide {

	public static void add(String[] guide, String name, int index) {
		guide[index] = name;
	}

	public static void print(String[] guide) {
		for (int i = 0; i < guide.length; i++) {
			if (guide[i] != null) {
				System.out.println(i + " " + guide[i]);
			}
		}
	}

	public static void lookupNumber(String[] guide, int index) {
		if (guide[index] != null) {
			System.out.println(index + " " + guide[index]);
		}
		else {
			System.out.println(index + "");
		}
	}

	public static void lookupName(String[] guide, String name) {
		for (int i = 0; i < guide.length; i++) {
			if (guide[i] != null && guide[i].equals(name)) {
				System.out.println(i + " " + guide[i]);
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Enter the maximum # of channels:");
		int      nbrChannels = IO.readInt();
		boolean  exit        = false;
		String[] tvGuide     = new String[nbrChannels];

		do {
			System.out.println("Options [1]-add, [2]-look up by number, [3]-print channels, [4]-look up by name, [5]-quit");
			int option = IO.readInt();
			switch (option) {
				case 1:
					System.out.println("Channel name: ");
					String name = IO.readString();
					System.out.println("Channel number: ");
					int number = IO.readInt();
					if (number >= 0 && number < nbrChannels) {
						add(tvGuide, name, number);
					}
					break;
				case 2:
					System.out.println("Channel number: ");
					number = IO.readInt();
					lookupNumber(tvGuide, number);
					break;
				case 3:
					print(tvGuide);
					break;
				case 4:
					System.out.println("Channel name: ");
					name = IO.readString();
					lookupName(tvGuide, name);
					break;
				case 5:
					exit = true;
					break;
				default:
					System.out.println("Invalid");
			}
		}
		while (exit == false);
		System.out.println("Exit");
	}
}
