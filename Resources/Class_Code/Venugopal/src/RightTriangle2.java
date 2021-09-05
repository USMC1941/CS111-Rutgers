public class RightTriangle2 {

    public static void main(String[] args) {
        System.out.print("Enter x1: ");
        double x1 = IO.readDouble();
        System.out.print("Enter y1: ");
        double y1 = IO.readDouble();
        System.out.print("Enter x2: ");
        double x2 = IO.readDouble();
        System.out.print("Enter y2: ");
        double y2 = IO.readDouble();
        System.out.print("Enter x3: ");
        double x3 = IO.readDouble();
        System.out.print("Enter y3: ");
        double y3 = IO.readDouble();

        double asquare = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

        double csquare = Math.pow((x2 - x3), 2) + Math.pow(y2 - y3, 2);
        double bsquare = Math.pow((x1 - x3), 2) + Math.pow(y1 - y3, 2);

        System.out.printf("(a^2,b^2,c^2)=(%f,%f,%f)%n", asquare, bsquare, csquare);

        if (asquare + bsquare == csquare) {
            System.out.println("Yes!");
            System.out.println("Hypotenuse = (" + x2 + "," + y2 + ") -- (" + x3 + "," + y3 + ")");

            System.exit(0);
        }
        if (asquare + csquare == bsquare) {
            System.out.println("Yes!");
            System.out.println("Hypotenuse = (" + x1 + "," + y1 + ") -- (" + x3 + "," + y3 + ")");
            return;
        }
        if (csquare + bsquare == asquare) {
            System.out.println("Yes!");
            System.out.println("Hypotenuse = (" + x1 + "," + y1 + ") -- (" + x2 + "," + y2 + ")");
            return;
        }
        System.out.println("No");
    }
}
