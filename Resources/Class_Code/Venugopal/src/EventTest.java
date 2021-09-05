public class EventTest {

    public static void main(String[] args) {
        Event evt1 = new Event(new Date(3, 30), new Time(1, 0, false), "event 1");
        Event evt2 = new Event(new Date(3, 30), new Time(2, 0, false), "event 2");
        Event evt3 = new Event(new Date(3, 30), new Time(2, 30, false), "event 3");
        System.out.println(evt1 + "\n\tbefore\n" + evt2 + "?\n\t" + evt1.before(evt2));
        System.out.println();
        System.out.println(
                evt1 + "\n\tconflicts with\n" + evt2 + "?\n\t" + evt1.conflictsWith(evt2));
        System.out.println();
        System.out.println(evt2 + "\n\tbefore\n" + evt3 + "?\n\t" + evt2.before(evt3));
        System.out.println();
        System.out.println(
                evt2 + "\n\tconflicts with\n" + evt3 + "?\n\t" + evt2.conflictsWith(evt3));
    }
}
