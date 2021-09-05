public class DateTest {

    public static void main(String[] args) {
        // access static field of Date class directly on
        // class name Date, without creating a Date object
        Date date = new Date(Date.DEFAULT_YEAR, 3, 30);
        System.out.println(date);
    }
}
