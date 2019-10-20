public class GradeV3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter integer score 0..100: ");
		int score = IO.readInt();

		if (score < 0 || score > 100) {
			System.out.println("score is not in the range 0..100");
			return;
		}

		if (score >= 90) {
			System.out.println("A");
			return;
		}
		if (score >= 80) {
			System.out.println("B+");
			return;
		}
		if (score >= 70) {
			System.out.println("B");
			return;
		}
		if (score >= 60) {
			System.out.println("C+");
			return;
		}
		if (score >= 50) {
			System.out.println("C");
			return;
		}

		System.out.println("F");

	}

}
