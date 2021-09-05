public class F2C {

    public static void main(String[] args) {
        double fahrenheit; // DECLARE fahrenheit to hold data of type double

        fahrenheit = 80; // ASSIGN 80 to fahrenheit

        /*  COMMENT BLOCK
           double fahrenheit=80;  // COMBINES DECLARATION WITH INITIALIZATION
        */

        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println(celsius);

        // double fahrenheit=-40;  => WON'T WORK because we have already declared fahrenheit earlier

        fahrenheit = -40;
        celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("celsius = " + celsius); // '+' stands for concatenation

        // System.out.println((fahrenheit-32)*5/9); => WORKS THE SAME WAY

        // int x=5;
    }
}
