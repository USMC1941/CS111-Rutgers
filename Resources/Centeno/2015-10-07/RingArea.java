package examples;

public class RingArea {

	public static void main(String[] args) {
		System.out.println("Enter ring outer radius:");
		double radius1 = IO.readDouble();
		if (!checkRadius(radius1)) {
			IO.reportBadInput();
			return;
		}
		else {
			System.out.println("Enter ring inner radius:");
			double radius2 = IO.readDouble();
			if (!checkRadius(radius2)) {
				IO.reportBadInput();
				return;
			}
			else if (radius1 < radius2) {
				IO.outputDoubleAnswer(ringArea(radius2, radius1));
			}
			else {
				IO.outputDoubleAnswer(ringArea(radius1, radius2));
			}
		}
	}

	public static boolean checkRadius(double radius) {
		return radius >= 0;
	}

	public static double ringArea(double outerRadius, double innerRadius) {
		return circleArea(outerRadius) - circleArea(innerRadius);
	}

	public static double circleArea(double radius) {
		double radiusSq = radius * radius;
		return radiusSq * Math.PI;
	}
}
