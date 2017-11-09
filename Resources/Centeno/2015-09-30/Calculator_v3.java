package examples;

public class Calculator_v3 {

	public static void main(String[] args) {
		System.out.println("Enter first number:");
		double op1 = IO.readDouble();

		System.out.println("Enter second number:");
		double op2 = IO.readDouble();
		System.out.println("Enter operation [1]-addition, [2]-subtraction, [3]-multiplication, [4]-division");
		int choice = IO.readInt();
		double result;
		
		switch (choice) {
		case 1:
			result = op1+op2;
			System.out.println(op1 + "+" + op2 + "=" + result);
			break;
		case 2:
			result = op1 - op2;
			System.out.println(op1 + "-" + op2 + "=" + result);
			break;
		case 3:
			result = op1 * op2;
			System.out.println(op1 + "*" + op2 + "=" + result);
			break;
		case 4:
			if (op2 != 0) {
				result = op1 / op2;
				System.out.println(op1 + "/" + op2 + "=" + result);
			} else {
				System.out.println("division by 0");
			}
			break;
		default :
			System.out.println("invalid operation");
		}
	}
}
