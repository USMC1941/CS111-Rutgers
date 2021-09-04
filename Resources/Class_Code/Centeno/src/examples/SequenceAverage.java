package examples;

public class SequenceAverage {

    public static void main(String[] args) {
        System.out.println("Enter terminator value");
        int terminator = IO.readInt();
        int count = 0;
        int sum = 0;
        int number;
        do {
            System.out.println("Enter next number:");
            number = IO.readInt();
            if (number != terminator) {
                sum = sum + number; // same sum+=number;
                count = count + 1; // same count+=1; OR count++;
            }
        } while (number != terminator);
        if (count == 0) {
            System.out.println("Invalid sequence");
            return;
        }
        double average = (double) sum / count;
        System.out.println("Average is: " + average);
    }
}
