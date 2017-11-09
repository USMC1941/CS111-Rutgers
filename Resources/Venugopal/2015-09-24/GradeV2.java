
public class GradeV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter integer score 0..100: ");
		int score = IO.readInt();
		
		if (score >= 90 && score <= 100) {
			System.out.println("A");
		} else if (score >= 80 && score <= 89) {
			System.out.println("B+");
		} else if (score >= 70 && score <= 79) {
			System.out.println("B");
		} else if (score >= 60 && score <= 69) {
			System.out.println("C+");
		} else if (score >= 50 && score <= 59) {
			System.out.println("C");
		} else if (score >= 0 && score <= 49) {
			System.out.println("F");
		} else {
			System.out.println("score is not in the range 0..100");
			return;
		}

	}

}
