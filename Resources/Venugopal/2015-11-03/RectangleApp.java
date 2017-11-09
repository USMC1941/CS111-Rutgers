
public class RectangleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect1 = new Rectangle();   // default width and height
		rect1.draw();
		
		Rectangle rect2 = new Rectangle(10,4);   // width=10, height=10
		rect2.draw();

		Rectangle rect3 = new Rectangle(10,4,30,15);   // width=10, height=10, x=30, y=15
		rect3.draw();
		
		rect3.moveTo(5, 5);
		rect3.draw();
		
		Rectangle rect4 = new Rectangle(3,3);
		
		// get the default width
		System.out.println("default width = " + Rectangle.DEFAULT_WIDTH);   // use class name to access static field
		
		// can access static fields via instances, as well, but NOT recommended
		System.out.println("default width = " + rect1.DEFAULT_WIDTH);
	}

}
