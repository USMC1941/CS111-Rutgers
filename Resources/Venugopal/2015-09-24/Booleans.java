
public class Booleans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter an integer value => ");
		int number = IO.readInt();
		
		boolean negative=false, positive=false, zero=false;
		
		System.out.println("INITIAL VALUES:");
		
		System.out.println("positive = " + positive);
		System.out.println("negative = " + negative);
		System.out.println("zero = " + zero);
		
		if (number < 0) {
			negative = true;
		}
		if (number > 0) {
			positive = true;
		}
		if (number == 0) {
			zero = true;
		}
		
		System.out.println();
		System.out.println("VALUES AFTER CHECKING INPUT");
		System.out.println("positive = " + positive);
		System.out.println("negative = " + negative);
		System.out.println("zero = " + zero);
		
		System.out.println();
		System.out.println("VALUES AFTER CHECKING INPUT, FOR negative and not zero");
		if (negative) {   // same as checking negative == true
			System.out.println("Number is negative");
		}
		if (!zero) {  // ! is the symbol for NOT
			System.out.println("Number is not zero");
		}
		
		// some compound conditions
		System.out.print("Enter value for a => ");
		int a = IO.readInt();
		System.out.print("Enter value for b => ");
		int b = IO.readInt();
		System.out.print("Enter value for c => ");
		int c = IO.readInt();
		
		boolean result = a > 3 && b > 3;
		System.out.println("a > 3 && b > 3 = " + result);
		result = a >= 3 || b < 3 && c > 10;
		System.out.println("a >= 3 || b < 3 && c > 10 " + result);
		result = ! (a >= 3 && b < 3) && c != 10;
		System.out.println("! (a >= 3 && b < 3) && c != 10 = " + result);

	}

}
