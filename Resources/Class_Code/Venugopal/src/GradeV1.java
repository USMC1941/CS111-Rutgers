public class GradeV1 {

    public static void main(String[] args) {
        System.out.println("Enter integer score 0..100: ");
        int score = IO.readInt();

        if (score < 0 || score > 100) {
            System.out.println("score is not in the range 0..100");
            return;
        }

        if (score >= 90) {
            System.out.println("A");
        }
        if (score >= 80 && score <= 89) {
            System.out.println("B+");
        }
        if (score >= 70 && score <= 79) {
            System.out.println("B");
        }
        if (score >= 60 && score <= 69) {
            System.out.println("C+");
        }
        if (score >= 50 && score <= 59) {
            System.out.println("C");
        }
        if (score <= 49) {
            System.out.println("F");
        }
    }
}
