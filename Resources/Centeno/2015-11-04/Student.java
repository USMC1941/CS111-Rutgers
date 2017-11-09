package examples;

public class Student {

	private String name; // only visible inside the class
	public double midterm1, midterm2, finalExam;
	public static int studentCount; // static variable belongs to the class
	
	/*
	 * The constructor for the Student objects
	 * It provides a name for the Student
	 */
	public Student (String name) {
		this.name = name;
		midterm1 = midterm2 = finalExam = 0.0;
		studentCount++; // only incremented when a Student class is instantiated
	}
	
	/* Access method allows objects access to private name variable */
	public String getName() {
		return name;
	}
	
	public double getAverage() {
		double avg = (midterm1+midterm2+finalExam)/3;
		return avg;
	}
	
	/* Overrides equals method from the Object class */
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Student)) {
			return false;
		} else {
			Student other = (Student)o;
			return (name.equals(other.name) && 
					midterm1 == other.midterm1 && 
					midterm2 == other.midterm2 && 
					finalExam == other.finalExam);
		}
	}
	
	/* Overrides toString method from the Object class */
	public String toString() {
		return String.format("(%s, %f, %f, %f)", name, midterm1,midterm2,finalExam);
	}
}
