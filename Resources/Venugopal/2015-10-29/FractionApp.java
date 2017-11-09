
public class FractionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction f1 = new Fraction(3,5);   // 3/5
		System.out.println("f1=" + f1);   // f1.toString() automatically called
		
		Fraction f2 = new Fraction(7);   // want 7/1
		System.out.println("f2=" + f2);
		
		f1.add(f2);   // f1 = f1 + f2 (f1 is updated)
		System.out.println("f1="+f1);
		
		Fraction f3 = new Fraction(2,3);   // 2/3
		
		f1.add(f3);   // 3/5+2/3
		System.out.println("f1=" + f1);

	}

}
