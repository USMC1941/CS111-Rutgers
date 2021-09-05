import javax.swing.*;
import java.awt.*;

/**
 * An instance of this class is a window in which you can draw points, lines, circles, and other shapes.
 */
public class Drawing extends JFrame {
	private static class Canvas extends JPanel {
		int xsize, ysize;
		Color[] bitmap;

		public Canvas(int xsize, int ysize) {
			this.xsize = xsize;
			this.ysize = ysize;
			this.bitmap = new Color[xsize * ysize];
			this.setPreferredSize(new Dimension(xsize, ysize));
		}

		public void setPixel(double x, double y, Color color) {
			int ix, iy;

			ix = (int) Math.round(x);
			iy = (this.ysize - 1) - (int) Math.round(y);

			if (ix >= 0 && ix < this.xsize && iy >= 0 && iy < this.ysize) {
				this.bitmap[iy * this.xsize + ix] = color;
			}
		}

		public Color getPixel(double x, double y) {
			int   ix, iy;
			Color color;

			ix = (int) Math.round(x);
			iy = (this.ysize - 1) - (int) Math.round(y);

			if (ix >= 0 && ix < this.xsize && iy >= 0 && iy < this.ysize) {
				color = this.bitmap[iy * this.xsize + ix];
				return (color != null) ? color : this.getBackground();
			}
			else {
				return null;
			}
		}

		public void paint(Graphics g) {
			int i;

			super.paint(g);

			i = 0;
			for (int y = 0; y < this.ysize; y++) {
				for (int x = 0; x < this.xsize; x++) {
					if (this.bitmap[i] != null) {
						g.setColor(this.bitmap[i]);
						g.drawLine(x, y, x, y);
					}

					i++;
				}
			}
		}
	}

	private Canvas     canvas;
	private Color      currentColor;
	private PointQueue fillqueue;
	private Point      fillpoint;

	/**
	 * Creates a drawing window with a default size of 400 pixels horizontally and 300 pixels vertically.
	 */
	public Drawing() {
		this(400, 300);
	}

	/**
	 * Creates a drawing window of the given size.
	 *
	 * @param xsize Horizontal size, in pixels.
	 * @param ysize Vertical size, in pixels.
	 */
	public Drawing(int xsize, int ysize) {
		super("Drawing");

		this.canvas = new Canvas(xsize, ysize);
		this.canvas.setBackground(Color.WHITE);
		this.add(this.canvas);
		this.pack();
		//this.getContentPane().setBackground(Color.BLUE);
		//this.canvas.setForeground(currentColor);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.currentColor = Color.BLACK;
		this.fillqueue = new PointQueue(xsize * ysize * 4);
		this.fillpoint = new Point();
	}

	/**
	 * Sets the current drawing pen color.
	 *
	 * @param color Specified as a java.awt.Color object.
	 */
	public void setColor(Color color) {
		this.currentColor = color;
	}

	/**
	 * Draws a dot (on a single pixel) at the given location in the picture.
	 * Cartesian coordinates are used: (0,0) is the lower left corner of the window.
	 *
	 * @param x Horizontal location.
	 * @param y Vertical location.
	 */
	public void drawDot(double x, double y) {
		this.canvas.setPixel(x, y, this.currentColor);
		this.canvas.repaint();
	}

	/**
	 * Draws a straight line in the picture.
	 * Cartesian coordinates are used: (0,0) is the lower left corner of the window.
	 *
	 * @param startx Horizontal location of first endpoint of line.
	 * @param starty Vertical location of first endpoint of line.
	 * @param endx   Horizontal location of second endpoint of line.
	 * @param endy   Vertical location of second endpoint of line.
	 */
	public void drawLine(double startx, double starty, double endx, double endy) {
		double xdiff, ydiff, largerdiff, pct, x, y;
		int    numsteps;

		xdiff = endx - startx;
		ydiff = endy - starty;
		largerdiff = Math.max(Math.abs(xdiff), Math.abs(ydiff));
		numsteps = (int) Math.ceil(largerdiff);

		for (int i = 0; i <= numsteps; i++) {
			pct = (double) i / numsteps;
			x = startx + pct * xdiff;
			y = starty + pct * ydiff;
			this.canvas.setPixel(x, y, this.currentColor);
		}

		this.canvas.repaint();
	}

	/**
	 * Draws the outline of a circle in the picture.
	 * Cartesian coordinates are used: (0,0) is the lower left corner of the window.
	 *
	 * @param centerx Horizontal location of center of circle.
	 * @param centery Vertical location of center of circle.
	 * @param radius  Radius of circle.
	 */
	public void drawCircle(double centerx, double centery, double radius) {
		double diameter, pct, angle, xoffset, yoffset, x, y;
		int    numsteps;

		diameter = 2 * Math.PI * radius;
		numsteps = (int) Math.ceil(diameter);

		for (int i = 0; i < numsteps; i++) {
			pct = (double) i / numsteps;
			angle = 2 * Math.PI * pct;
			xoffset = Math.cos(angle) * radius;
			yoffset = Math.sin(angle) * radius;
			x = centerx + xoffset;
			y = centery + yoffset;
			this.canvas.setPixel(x, y, this.currentColor);
		}

		this.canvas.repaint();
	}

	/**
	 * Fills a contiguous area of the picture with the current drawing pen color.
	 * Cartesian coordinates are used: (0,0) is the lower left corner of the window.
	 *
	 * @param x Horizontal location of starting point of fill.
	 * @param y Vertical location of starting point of fill.
	 */
	public void fill(double x, double y) {
		Color bg;

		bg = this.canvas.getPixel(x, y);
		if (bg == null || bg.equals(currentColor)) {
			return;
		}

		fillqueue.clear();
		fillpoint.x = (int) Math.round(x);
		fillpoint.y = (int) Math.round(y);
		fillqueue.enqueue(fillpoint);

		while (!fillqueue.isEmpty()) {
			fillqueue.dequeue(fillpoint);

			if (this.canvas.getPixel(fillpoint.x, fillpoint.y).equals(bg)) {
				this.canvas.setPixel(fillpoint.x, fillpoint.y, currentColor);

				fillpoint.x--;
				fillqueue.enqueue(fillpoint);
				fillpoint.x++;

				fillpoint.x++;
				fillqueue.enqueue(fillpoint);
				fillpoint.x--;

				fillpoint.y--;
				fillqueue.enqueue(fillpoint);
				fillpoint.y++;

				fillpoint.y++;
				fillqueue.enqueue(fillpoint);
				fillpoint.y--;
			}
		}

		this.canvas.repaint();
	}
}

class PointQueue {
	private int[] xqueue;
	private int[] yqueue;
	private int   front, back, size;

	public PointQueue(int capacity) {
		xqueue = new int[capacity];
		yqueue = new int[capacity];
		clear();
	}

	public void enqueue(Point point) {
		if (isFull()) {
			throw new IllegalStateException("overflow");
		}

		xqueue[back] = point.x;
		yqueue[back] = point.y;
		back = (back + 1) % xqueue.length;
		size++;
	}

	public void dequeue(Point point) {
		if (isEmpty()) {
			throw new IllegalStateException("underflow");
		}

		point.x = xqueue[front];
		point.y = yqueue[front];
		front = (front + 1) % xqueue.length;
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == xqueue.length;
	}

	public void clear() {
		front = 0;
		back = 0;
		size = 0;
	}
}
