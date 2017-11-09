package examples;

public class CS111 {

	public static final int NBR_STUDENTS = 100; //constant variable
	public Student[] array; // array holding the students of CS111
	
	/* Default constructor, no arguments 
	 * Creates an array of NBR_STUDENTS Students */
	public CS111() {
		array = new Student[NBR_STUDENTS];
	}
	/* Additional constructor provides a way to choose the array size */
	public CS111(int nbrStudents) {
		array = new Student[nbrStudents];
	}
	public void printStudents() {
		for (int i = 0; i < Student.studentCount; i++) {
			System.out.println(array[i]);
		}
	}
	/* Adds a new Student to the array 
	 * Keeps the array in alphabetical order */
	public void add(String name) {
		for (int i=0; i<Student.studentCount;i++) {
			Student stu = array[i];
			int c = stu.getName().compareToIgnoreCase(name);
			if (c == 0) {
				System.out.println("Student already in the array");
				return;
			}
			if (c < 0) {
				continue; //keep going
			}
			if (c > 0) {
				// Insert new student at position i. But before 
				// must make space at position i by shifting all 
				// elements to the right by one position
				for (int k = Student.studentCount-1; k >= i; k--){
					array[k+1] = array[k];
				}
				array[i] = new Student(name);
				return;
			}
		}
		array[Student.studentCount] = new Student(name);
	}
	
	public static void main(String[] args) {
		/* Used to test CS111 class */
		CS111 fall15 = new CS111(6); // instance of class CS111
		fall15.add("Paul");
		fall15.add("Mary");
		fall15.add("Ann");
		fall15.printStudents();
	}
}