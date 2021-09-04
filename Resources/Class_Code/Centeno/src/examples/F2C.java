package examples;

public class F2C {

    public static void main(String[] args) {

        System.out.println("Enter a fahrenheit temperature: ");
        double tempF = IO.readDouble();

        if (tempF < -459.67) {
            System.out.println("Not a valid temperature");
            return; // terminates the program
        }
        double tempC = (tempF - 32) * 5 / 9;
        System.out.println("Celsius: " + tempC);
    }
}
