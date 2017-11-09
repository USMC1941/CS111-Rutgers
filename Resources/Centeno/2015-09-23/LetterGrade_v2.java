package examples;

/*
 * If you want to use if... instead of if... else if...
 */
public class LetterGrade_v2 {

	public static void main(String[] args) {
		
		System.out.println("Enter student grade:");
		double grade = IO.readDouble();
		
		if (grade < 0 || grade > 100) {
			System.out.println("Grade should be between 0 - 100");
			return;
		}
		
		if (grade >= 90) {
			/* 90 - 100 */
			System.out.println("A");
			return; /* if we don't add this return here, the execution will continue to test all other ifs. 
			The grade will have all letters from the correct letter to down to F
		    For 90 we'll get A, B, C, D and F) 
		    Check it by taking out all of the return statements */
		}  
		
		if (grade >= 80) {
			/* 80 - 89 */
			System.out.println("B");
			return; /* same as grade >= 90 */
		}
		
		if (grade >= 70) {
			/* 70 - 79 */
			System.out.println("C");
			return; /* same as grade >= 90 */
		}
		
		if (grade >= 60) {
			System.out.println("D");
			return; /* same as grade >= 90 */
		}
		
		if (grade >= 50) {
			System.out.println("F");
		}
	}
}
