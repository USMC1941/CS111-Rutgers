public class VolumeSphere {

    public static void main(String[] args) {
        System.out.println("Enter sphere radius: ");
        double radius = IO.readDouble();

        if (radius < 0) {
            System.out.println("You dun goofed.");
        } else {
            double volume;
            volume = (double) 4 / 3 * Math.PI * Math.pow(radius, 3);
            System.out.println("The sphere volume is " + volume);
        }
    }
}
