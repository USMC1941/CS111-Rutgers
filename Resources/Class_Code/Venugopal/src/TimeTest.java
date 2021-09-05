public class TimeTest {

    public static void main(String[] args) {
        Time tm1 = new Time(2, 30, false);
        Time tm2 = new Time(4, 45, false);
        System.out.println(tm1 + " before " + tm2 + " ?: " + tm1.before(tm2));
        Time tm3 = new Time(2, 45, false);
        System.out.println(tm1 + " overlaps " + tm3 + " ?: " + tm1.overlaps(tm3));
    }
}
