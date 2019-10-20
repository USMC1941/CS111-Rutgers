package examples;

public class MakeFace {

	public static void main(String[] args) {

		Face face1 = new Face(); /* creates an object of type Face */
		face1.setExpression("mad");
		System.out.println("Enter new expression: ");
		String newExpression = IO.readString();
		face1.setExpression(newExpression);

		Face face2 = new Face(); /* creates ANOTHER object of type Face */
		face2.setExpression("happy");

	}

}
