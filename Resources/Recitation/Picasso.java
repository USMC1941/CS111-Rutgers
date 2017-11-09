import java.awt.*;
import javax.swing.*;

public class Picasso
{
	private static final int CANVAS_XSIZE = 560;
	private static final int CANVAS_YSIZE = 560;
	private static final int SCALE = 40;

	private static Drawing drawing;
	private static int penx, peny;

	static
	{
		drawing = new Drawing(CANVAS_XSIZE, CANVAS_YSIZE);
		penx = 0;
		peny = CANVAS_YSIZE;
	}

	public static void drawCircle(int diameter)
	{
		drawing.drawCircle(penx, peny, diameter*SCALE/2);
	}

	public static void drawLineDown(int length)
	{
		drawing.drawLine(
			penx,
			peny,
			penx,
			peny - length*SCALE);
	}

	public static void drawLineRight(int length)
	{
		drawing.drawLine(
			penx,
			peny,
			penx + length*SCALE,
			peny);
	}

	public static void moveRight(int length)
	{
		penx += length*SCALE;
	}

	public static void moveLeft(int length)
	{
		penx -= length*SCALE;
	}

	public static void moveUp(int length)
	{
		peny += length*SCALE;
	}

	public static void moveDown(int length)
	{
		peny -= length*SCALE;
	}
}

class Drawing extends JFrame
{
	public Drawing()
	{
		this(400, 300);
	}

	public Drawing(int xsize, int ysize)
	{
		super();

		bitmap = new Color[xsize][ysize];
		currentColor = Color.BLACK;

		setSize(xsize + 28, ysize + 54);
		getContentPane().setBackground(Color.RED);
		setTitle("Drawing");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Canvas canvas = new Canvas();
		canvas.setSize(xsize, ysize);
		canvas.setBackground(Color.WHITE);
		canvas.setForeground(Color.BLACK);
		add(canvas);
		canvas.setLocation(10, 10);

		setVisible(true);
	}

	public void setColor(Color c)
	{
		currentColor = c;
	}

	public void drawDot(int x, int y)
	{
		if (x >= 0  &&  x < bitmap.length  &&  y >= 0  &&  y < bitmap[0].length)
		{
			bitmap[x][bitmap[0].length-1 - y] = currentColor;
			repaint();
		}
	}

	public void drawDot(double x, double y)
	{
		drawDot((int) Math.round(x), (int) Math.round(y));
	}

	public void drawLine(int startx, int starty, int endx, int endy)
	{
		int x, y, xdiff, ydiff, largerdiff;
		double pct;

		xdiff = endx - startx;
		ydiff = endy - starty;
		largerdiff = Math.max(Math.abs(xdiff), Math.abs(ydiff));

		for (int i = 0 ; i <= largerdiff ; i++)
		{
			pct = (double)i / largerdiff;
			x = startx + (int)Math.round(pct * xdiff);
			y = starty + (int)Math.round(pct * ydiff);

			this.drawDot(x, y);
		}
	}

	public void drawLine(double startx, double starty, double endx, double endy)
	{
		drawLine(
			(int) Math.round(startx),
			(int) Math.round(starty),
			(int) Math.round(endx),
			(int) Math.round(endy));
	}

	public void drawCircle(int centerx, int centery, int radius)
	{
		int x1 = Math.max(centerx-radius, 0);
		int x2 = Math.min(centerx+radius, bitmap.length-1);
		int y1 = Math.max(centery-radius, 0);
		int y2 = Math.min(centery+radius, bitmap[0].length-1);
		double x, y;

		for (x = x1 ; x <= x2 ; x++)
		{
			y = centery + Math.sqrt(radius*radius - Math.pow(x-centerx,2));
			drawDot(x, y);
			y = centery - Math.sqrt(radius*radius - Math.pow(x-centerx,2));
			drawDot(x, y);
		}

		for (y = y1 ; y <= y2 ; y++)
		{
			x = centerx + Math.sqrt(radius*radius - Math.pow(y-centery,2));
			drawDot(x, y);
			x = centerx - Math.sqrt(radius*radius - Math.pow(y-centery,2));
			drawDot(x, y);
		}
	}

	public void drawSolidCircle(int centerx, int centery, int radius)
	{
		int x1 = Math.max(centerx-radius, 0);
		int x2 = Math.min(centerx+radius, bitmap.length-1);
		int y1 = Math.max(centery-radius, 0);
		int y2 = Math.min(centery+radius, bitmap[0].length-1);

		for (int x = x1 ; x <= x2 ; x++)
		{
			for (int y = y1 ; y <= y2 ; y++)
			{
				if (Math.sqrt(Math.pow(x-centerx, 2) + Math.pow(y-centery, 2)) <= radius)
				{
					bitmap[x][y] = currentColor;
				}
			}
		}

		repaint();
	}

	public void drawSolidCircle(double centerx, double centery, double radius)
	{
		drawSolidCircle(
			(int) Math.round(centerx),
			(int) Math.round(centery),
			(int) Math.round(radius));
	}

	public void sleep(long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException e)
		{
			// should not happen
		}
	}

//-----------------------------------------------------------------------------
// internal code below this line
//-----------------------------------------------------------------------------

	private Color[][] bitmap;
	private Color currentColor;

	private class Canvas extends JPanel
	{
		public void paint(Graphics g)
		{
			super.paint(g);

			for (int x = 0 ; x < bitmap.length ; x++) {
				for (int y = 0 ; y < bitmap[0].length ; y++) {
					if (bitmap[x][y] != null) {
						g.setColor(bitmap[x][y]);
						g.drawLine(x, y, x, y);
					}
				}
			}
		}
	}
}
