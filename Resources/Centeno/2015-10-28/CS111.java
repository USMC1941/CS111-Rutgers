package examples;

public class CS111 {

	public static void main(String[] args) {
		
		/* Declares a variable s1 of type Student and
		 * creates an Student object */
		Student s1 = new Student("Paul"); 
		
		/* Assign a value to s1 variable midterm1, midterm2 and finalExam */
		s1.midterm1 = 5.6; 
		s1.midterm2 = 7.8;
		s1.finalExam = 9.7;
		
		/* Invokes s1 getAverage method */
		double avg = s1.getAverage();
		System.out.println(s1.name + " " + avg);
		
		/* Declares a variable s2 of type Student and
		 * makes s2 point to the same object s1 is pointing to
		 */
		Student s2 = s1;
		/* Updates the value of midterm1 of the object s2 is pointing to */
		s2.midterm1 = 10.0; 
		
		/* s1 midterm1 is also changed because s1 and s2 point to the same object */
		System.out.println(s1.name + " " + s1.midterm1);
		
		/* Create another object */
	}
}
