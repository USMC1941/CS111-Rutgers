package examples;

/** Enter grades for a number of students */
public class LetterGrade_v3 {

    public static void main(String[] args) {

        System.out.println("Enter number of students:");
        int students = IO.readInt();

        while (students > 0) {

            System.out.println("Enter student grade:");
            double grade = IO.readDouble();

            if (grade < 0 || grade > 100) {
                System.out.println("Grade should be between 0 - 100");
                return;
            }

            if (grade >= 90) {
                /* 90 - 100 */
                System.out.println("A");
            } else if (grade >= 80) {
                /* 80 - 89 */
                /* Execution only gets in here only if grade is not >= 90 AND >= 80 */
                System.out.println("B");
            } else if (grade >= 70) {
                /* 70 - 79 */
                System.out.println("C");
            } else if (grade >= 60) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
            students--;
        }
    }
}
