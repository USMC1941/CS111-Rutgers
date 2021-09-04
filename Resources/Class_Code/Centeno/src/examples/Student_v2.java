package examples;

public class Student_v2 {
    /** only visible inside the class */
    private String name;

    public double midterm1, midterm2, finalExam;

    /** static variable belongs to the class */
    public static int studentCount;

    /** The constructor for the Student objects It provides a name for the Student */
    public Student_v2(String name) {
        this.name = name;
        midterm1 = midterm2 = finalExam = 0.0;
        studentCount++; // only incremented when a Student class is instantiated
    }

    /** Access method allows objects access to private name variable */
    public String getName() {
        return name;
    }

    public double getAverage() {
        return (midterm1 + midterm2 + finalExam) / 3;
    }

    /* Override equals method from the Object class */
    public boolean equals(Object o) {
        if (!(o instanceof Student_v2)) {
            return false;
        } else {
            Student_v2 other = (Student_v2) o;
            return (name.equals(other.name)
                    && midterm1 == other.midterm1
                    && midterm2 == other.midterm2
                    && finalExam == other.finalExam);
        }
    }

    /** Overrides toString method from the Object class */
    public String toString() {
        return String.format("(%s, %f, %f, %f)", name, midterm1, midterm2, finalExam);
    }
}
