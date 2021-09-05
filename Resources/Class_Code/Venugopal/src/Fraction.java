public class Fraction {

    // instance fields. private => cannot be accessed outside this class
    private int num;
    private int denom;

    // general constructor
    public Fraction(int num, int denom) {
        this.num = num;

        if (denom == 0) {
            denom = 1;
        }

        this.denom = denom;
    }

    // integer num
    public Fraction(int num) {
        /* ONE WAY TO DO THIS
        this.num = num;
        denom = 1;
        */

        this(num, 1); // call the general constructor
    }

    public Fraction() { // integer 1
        this(1, 1); // call the general constructor
    }

    // getter method
    public int getNumerator() {
        return num;
    }

    // getter method
    public int getDenominator() {
        return denom;
    }

    /* SETTERS NOT IMPLEMENTED, WANT FRACTION TO BE IMMUTABLE */
    /*
    // setter method
    public void setNumerator(int num) {
    	this.num = num;
    }

    // setter method
    public void setDenominator(int denom) {
    	if (denom == 0) {
    		denom = 1;
    	}
    	this.denom = denom;
    }
    */

    // adds other fraction to this fraction; this fraction is updated with the sum
    public void add(Fraction other) {
        num = num * other.denom + denom * other.num;
        denom *= other.denom;
    }

    // static method, doesn't apply ON an instance
    public static Fraction add(Fraction f1, Fraction f2) {
        // System.out.println(num); => can't access num (instance field) in a static method
        int num = f1.num * f2.denom + f1.denom * f2.num;
        int denom = f1.denom * f2.denom;
        return new Fraction(num, denom);
    }

    public String toString() {
        return num + "/" + denom;
    }
}
