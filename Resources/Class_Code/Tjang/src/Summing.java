public class Summing {

    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        int x;

        do {
            System.out.println("Enter number");
            x = IO.readInt();
            if (x > 0) {
                sum = sum + x;
                count = count + 1;
            }
        } while (x > 0);

        if (count > 0) {
            System.out.println((double) sum / count);
        } else {
            System.out.println("Error!");
        }
    }
}
