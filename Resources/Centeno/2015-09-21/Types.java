package examples;

public class Types {

	/*
	 * @param args arguments from the command line
	 */
	public static void main (String[] args) {
		
		double f = 65;
		System.out.println("f = " + f);
		float c = (float)f;              // explicit cast of f to type float
		System.out.println("c = " + c);
		
		int x = 50;
		int y = 15;
		float z = x/y;  // the result of an integer divided by integer is integer
		System.out.println("z = " + z); // implicit cast of z to type string
		z = x*1.0f  / y;
		System.out.println("new z = " + z);
		z = (float) x / y;  // casting x to float makes the result float
		System.out.println("yet new z = " + z);
		
		int quotient = x / y; // integer divided by integer gives the quotient
		int remainder = x % y; // % gives remainder of x/y or x modulus y
		System.out.println(x+"/"+y+" quotient=" + quotient + " remainder= " + remainder);
	
		IO.outputStringAnswer("quotient= "+quotient);
		
		char ch1 = 'a'; // to assign a character user single quotes ''
		char ch2 = 'b';
		IO.outputStringAnswer("ch1 = " + ch1 + " ch2 = " + ch2);
		
		boolean bool = true; // to assign a boolean value of true or false to a variable
		boolean bool2 = false;
		IO.outputStringAnswer("boolean values are: " + bool + " " +bool2);
		
		String st = "cs111"; // to assign a string user double quotes ""
		IO.outputStringAnswer("st = " + st + ", the length of st = " + st.length());
	
		// have user enter a first name and last name, then print 
		// last name comma first Ann Perl, program prints Perl,Ann
		System.out.println("Enter first name space lastname: ");
		String name = IO.readString();
		IO.outputStringAnswer("Name: " + name);
		
		int spacePos = name.indexOf(' '); // will get back 3 as index for "Ann Perl"
		String firstName = name.substring(0, spacePos);
		String lastName = name.substring(spacePos+1);
		IO.outputStringAnswer(lastName + "," + firstName);
		
		// floating roundoff error
		double a = 0.7;
		double b = 0.9;
		double k = a + 0.1;
		double l = b - 0.1;
		System.out.println("k=" + k + " l=" + l);
		System.out.println(k == l);
		System.out.println(Math.abs(k-l)<0.0001);
	}
}
