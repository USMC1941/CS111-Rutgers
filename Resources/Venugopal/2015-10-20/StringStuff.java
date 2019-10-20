public class StringStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Jane";
		String s2 = s1;  // s2 and s1 REFER to the same object

		int c = s1.compareTo(s2);
		System.out.println(c);

		s1 = "Jack";
		System.out.println("s2 = " + s2);

		c = s1.compareTo(s2);
		System.out.println(c);

		c = s2.compareTo(s1);
		System.out.println(c);

		// new creates a new String object
		String s3 = new String("John");   // exactly same as s3 = "John"

		// you can NEVER change the contents of a string
		// you can only create new strings that reflect the change
		// In other words Strings are IMMUTABLE (unchanging)
		String s4 = "cs111";
		String s5 = s4.replaceAll("1", "2");
		System.out.println("s4 = " + s4);
		System.out.println("s5 = " + s5);

		// method composition
		String s6 = "Computer Science 111".toLowerCase().replaceAll("1", "2");
		System.out.println(s6);

		// String s7;  => this is just declaring s7 as the name for a string, but 
		// the actual string is not there yet
		String s7 = null;  // this is same as String s7;
		System.out.println(s7.length());  // ?
	}

}
