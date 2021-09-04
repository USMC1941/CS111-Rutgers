package examples;

public class CS111_v2 {
    /** constant variable */
    public static final int NBR_STUDENTS = 100;

    /** array holding the students of CS111 */
    public Student_v2[] array;

    /** Default constructor, no arguments Creates an array of NBR_STUDENTS Students */
    public CS111_v2() {
        array = new Student_v2[NBR_STUDENTS];
    }

    /** Additional constructor provides a way to choose the array size */
    public CS111_v2(int nbrStudents) {
        array = new Student_v2[nbrStudents];
    }

    public void printStudents() {
        for (int i = 0; i < Student_v2.studentCount; i++) {
            System.out.println(array[i]);
        }
    }

    /** Adds a new Student_v2 to the array Keeps the array in alphabetical order */
    public void add(String name) {
        for (int i = 0; i < Student_v2.studentCount; i++) {
            Student_v2 stu = array[i];
            int c = stu.getName().compareToIgnoreCase(name);
            if (c == 0) {
                System.out.println("Student already in the array");
                return;
            }
            if (c < 0) {
                continue; // keep going
            }
            // Insert new student at position i. But before
            // must make space at position i by shifting all
            // elements to the right by one position
            for (int k = Student_v2.studentCount - 1; k >= i; k--) {
                array[k + 1] = array[k];
            }
            array[i] = new Student_v2(name);
            return;
        }
        array[Student_v2.studentCount] = new Student_v2(name);
    }

    public static void main(String[] args) {
        // Used to test CS111_v2 class
        CS111_v2 fall15 = new CS111_v2(6); // instance of class CS111_v2
        fall15.add("Paul");
        fall15.add("Mary");
        fall15.add("Ann");
        fall15.printStudents();
    }
}
