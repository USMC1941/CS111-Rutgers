public class Max {

    public static void main(String[] args) {

        System.out.print("Enter termination value (int): ");
        int terminator = IO.readInt();

        System.out.print("Enter next value, or terminator: ");
        int number = IO.readInt();

        if (number == terminator) {
            System.out.println("No inputs!");
            System.exit(0);
        }

        // at least one number, so set max to the first
        int max = number;

        while (number != terminator) {
            if (number > max) {
                max = number; // if next number is > max, set max to that
            }
            System.out.print("Enter next value, or terminator: ");
            number = IO.readInt();
        }
        System.out.println("Max = " + max);
    }
}
