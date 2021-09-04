package examples;

public class CountedSum {

    public static void main(String[] args) {

        System.out.println("How many numbers to sum:");
        int size = IO.readInt();
        if (size < 0) {
            System.out.println("Error");
            return;
        }
        int sum = 0;
        int count = 0;
        while (count < size) {
            System.out.println("Enter next number:");
            int number = IO.readInt();
            sum += number;
            count = count + 1;
        }
        System.out.println("Sum is " + sum);
    }
}
