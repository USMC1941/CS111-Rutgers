package examples;

public class Student {

	public String name;
	public double midterm1, midterm2, finalExam;

	/*
	 * The constructor for the Student objects
	 * It provides a name for the Student
	 */
	public Student(String name) {
		this.name = name;
		midterm1 = midterm2 = finalExam = 0.0;
	}

	public double getAverage() {
		double avg = (midterm1 + midterm2 + finalExam) / 3;
		return avg;
	}
}
