public class F2CIf2 {

    public static void main(String[] args) {
        double fahrenheit; // DECLARE fahrenheit to hold data of type double

        // ask fahrenheit value from user
        System.out.print("Enter fahrenheit value: ");
        fahrenheit = IO.readDouble();

        // check if fahrenheit is < -459.67
        if (fahrenheit < -459.67) {
            System.out.println("Invalid input, fahrenheit must be >= -459.67");
        } else {
            double celsius = (fahrenheit - 32) * 5 / 9;
            // System.out.println("celsius=" + celsius);
            System.out.printf("celsius=%.2f%n", celsius);
        }

        // alternatively
        boolean result = fahrenheit < -459.67;
        // or if (result == true)
        if (result) {
            System.out.println("Invalid input, fahrenheit must be >= -459.67");
        } else {
            double celsius = (fahrenheit - 32) * 5 / 9;
            // System.out.println("celsius=" + celsius);
            System.out.printf("celsius=%.2f%n", celsius);
        }
    }
}
