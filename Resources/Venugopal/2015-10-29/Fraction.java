
public class Fraction {
	
	// instance fields
	int num;
	int denom;
	
	// general constructor
	public Fraction(int num, int denom) {
		this.num = num;
		
		if (denom == 0) {
			denom=1;
		}
		
		this.denom = denom;
	}
	
	public Fraction(int num) {   // integer num
		/* ONE WAY TO DO THIS
		this.num = num;
		denom = 1;
		*/
		
		this(num, 1);  // call the general constructor
	}
	
	public Fraction() {   // integer 1
		this(1,1);    // call the general constructor
	}
	
	public void add(Fraction other) {
		num = num*other.denom + denom*other.num;
		denom *= other.denom;
	}
	
	public String toString() {
		return num + "/" + denom;
	}
}
