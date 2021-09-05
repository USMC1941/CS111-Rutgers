public class F2CIO {

    public static void main(String[] args) {
        double fahrenheit; // DECLARE fahrenheit to hold data of type double

        // ask fahrenheit value from user
        System.out.print("Enter fahrenheit value: ");
        fahrenheit = IO.readDouble();

        double celsius = (fahrenheit - 32) * 5 / 9;
        // System.out.println("celsius=" + celsius);
        System.out.printf("celsius=%.2f%n", celsius);
    }
}
