public class Rectangle {

	// static fields are a property of the class
	// they apply to ALL instances (same copy shared by all instances)
	public static final int DEFAULT_WIDTH  = 5;
	public static final int DEFAULT_HEIGHT = 5;
	public static final int DEFAULT_X      = 10;
	public static final int DEFAULT_Y      = 5;

	private int width;
	private int height;
	private int x;
	private int y;

	public Rectangle(int width, int height, int x, int y) {
		if (width < 3 || height < 3 || x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;

	}

	public Rectangle(int width, int height) {
		this(width, height, DEFAULT_X, DEFAULT_Y);
	}

	public Rectangle() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_X, DEFAULT_Y);
	}

	// setter
	public void setWidth(int width) {
		if (width < 3) {
			throw new IllegalArgumentException();
		}
		this.width = width;
	}

	// getter
	public int getWidth() {
		return width;
	}

	// write out other setters and getters, for the other attributes

	public void draw() {
		for (int j = 0; j < y; j++) {
			System.out.println();
		}

		// top of rectangle
		for (int i = 0; i < x; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < width; i++) {
			System.out.print("* ");
		}
		System.out.println();

		// all except bottom
		for (int j = 1; j < height - 1; j++) {
			for (int i = 0; i < x; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int i = 1; i < width - 1; i++) {
				System.out.print("  ");
			}
			System.out.println(" *");
		}

		// bottom
		for (int i = 0; i < x; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < width; i++) {
			System.out.print("* ");
		}
		System.out.println();
	}

	public void moveTo(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		this.x = x;
		this.y = y;
	}

	public void setSize(int width, int height) {
		if (width < 3 || height < 3) {
			throw new IllegalArgumentException();
		}
		this.width = width;
		this.height = height;
	}

	public int perimeter() {
		return 2 * width + 2 * height;
	}

	public int area() {
		return width * height;
	}

}
