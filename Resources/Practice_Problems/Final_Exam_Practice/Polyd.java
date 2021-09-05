public class Polyd {
	public static void main(String[] args) {
		Polygon poly = new Polygon(4);

		Point p0 = new Point(0, 0);
		Point p1 = new Point(4, 0);
		Point p2 = new Point(4, 3);
		Point p3 = new Point(0, 3);

		poly.setVertex(0, p0);
		poly.setVertex(1, p1);
		poly.setVertex(2, p2);
		System.out.println(poly.getPerimeter()); // should print -1.0
		System.out.println(poly.getArea()); // should print -1.0

		poly.setVertex(3, p3);
		System.out.println(poly.getPerimeter()); // should print about 14.0
		System.out.println(poly.getArea()); // should print about 12.0
	}
}
