package examples;

public class CountedSum_v2 {

    public static void main(String[] args) {
        System.out.println("How many numbers to sum:");
        int size = IO.readInt();
        if (size < 0) {
            System.out.println("Error");
            return;
        }
        int sum = 0;
        for (int count = 0; count < size; count++) {
            System.out.println("Enter next number:");
            int number = IO.readInt();
            sum = sum + number;
        }
        System.out.println("Sum is " + sum);
    }
}
