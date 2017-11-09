package examples;

/*
 * Using if...
 */
public class Calculator_v2 {

	public static void main(String[] args) {
		
		System.out.println("Enter first number:");
		double op1 = IO.readDouble();
		System.out.println("Enter second number:");
		double op2 = IO.readDouble();
		System.out.println("Enter operation [1]-addition, [2]-subtraction, [3]-multiplication, [4]-division");
		int choice = IO.readInt();
		
		if (choice == 1) {
			double result = op1 + op2;
			System.out.println(op1 + "+" + op2 + "=" + result);
			return; /* if we don't add this return here, the execution will continue to test all other ifs. 
			Even though they will never match. */
		} 
		
		if (choice == 2) {
			double result = op1 - op2;
			System.out.println(op1 + "-" + op2 + "=" + result);
			return; // same as return for choice == 1
		}
		
		if (choice == 3) {
			double result = op1 * op2;
			System.out.println(op1 + "*" + op2 + "=" + result);
			return; // same as return for choice == 2
		} 
		
		if (choice == 4) {
			if (op2 != 0) {
				double result = op1 / op2;
				System.out.println(op1 + "/" + op2 + "=" + result);
			} else {
				System.out.println("division by 0");
			}
			return; // same as return for choice == 1
		}
		
		if (choice > 4) {
			System.out.println("invalid operation");
		}
	}
}
