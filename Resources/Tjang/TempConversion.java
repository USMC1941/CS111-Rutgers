public class TempConversion{
	
	public static void main(String[] args){
		
		System.out.println("Enter temperature in Fahrenheit:");
		double fahrenheit = IO.readInt();
		
		double celsius;
		celsius = ((double)5/9)*(fahrenheit - 32.0);
		
		System.out.println("Celsius"+celsius);
		
	}
	
}