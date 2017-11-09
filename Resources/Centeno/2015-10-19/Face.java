package examples;

import java.awt.*;
import javax.swing.*;

/**
 * An instance of this class is a depiction of a stick-figure human face.
 */
public class Face extends JFrame
{
	private static int offset = 0;

	private int xsize, ysize;
	private Insets insets;
	private String expression;
	MyJPanel cp;
	/**
	 * Create a Face with a default size of 200 by 200 pixels.
	 */
	public Face()
	{
		this(200, 200);
	}
	
	/**
	 * Create a Face of the given size.
	 * @param xsize Horizontal size, in pixels.
	 * @param ysize Vertical size, in pixels.
	 */
	public Face(int xsize, int ysize)
	{
		super();
		cp = new MyJPanel();
		this.setIgnoreRepaint(true);
		this.xsize = xsize;
		this.ysize = ysize;
		this.expression = "none";
		this.setContentPane(cp);
		this.setVisible(true);
		this.setLocation(100 + offset, 100);
		offset += 200;
		this.insets = this.getInsets();
		//System.out.println(insets);
		this.setSize(
			xsize + this.insets.left + this.insets.right,
			ysize + this.insets.top + this.insets.bottom);
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setForeground(Color.YELLOW);
		this.getContentPane().setIgnoreRepaint(true);
		cp.repaint(this.insets.left, this.insets.top, this.xsize, this.ysize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //WindowConstants.HIDE_ON_CLOSE);
		this.setResizable(false);
	}
	
	/**
	 * Set the expression to be displayed on the face.
	 * Valid expressions are "happy", "sad", and "mad".
	 * Any other expression will be displayed with a look of confusion.
	 * @param expression Textual name of desired expression.
	 */
	public void setExpression(String expression)
	{
		cp.expression = expression.toLowerCase();
		cp.repaint(this.insets.left, this.insets.top, this.xsize, this.ysize);
	}

	/**
	 * Retrieve the name of the expression currently on the face.
	 * @return Textual name of currently displayed expression.
	 */
	public String getExpression()
	{
		return this.expression;
	}

	/**
	 * Determine whether this face and another face look the same
	 * (are of the same size and have the same expression).
	 * @param other Another Face object with which to compare this Face.
	 * @return true if faces look the same, false if they look different.
	 */
	public boolean equals(Object other)
	{
		Face otherFace;

		if ( ! (other instanceof Face) )
		{
			return false;
		}

		otherFace = (Face) other;
		return this.xsize == otherFace.xsize  &&  this.ysize == otherFace.ysize  &&
			this.expression.equals(otherFace.expression);
	}

	//////////////////////////////////////////////////////////////////////////////////
	// internal code below
	//////////////////////////////////////////////////////////////////////////////////
	
	
}
class MyJPanel extends JPanel{
	
	/**
	 * This method is only for internal use by the GUI framework -
	 * you should not call it directly.
	 */
	public String expression="none";
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.YELLOW);
		Rectangle bounds = g.getClipBounds();
		//System.out.println(bounds);
		//System.out.println(getSize());
		int eyewidth = bounds.width / 5;
		int eyeheight = bounds.height / 5;
		int nosewidth = eyewidth / 2;
		int noseheight = eyeheight / 2;
		
		// draw eyes
		g.fillArc(bounds.x + eyewidth, bounds.y + eyeheight, eyewidth, eyeheight, 0, 360);
		g.fillArc(bounds.x + 3*eyewidth, bounds.y + eyeheight, eyewidth, eyeheight, 0, 360);
		
		// draw nose
		g.fillArc(bounds.x + 9*eyewidth/4, bounds.y + 9*eyeheight/4, nosewidth, noseheight, 0, 360);
		
		// draw mouth, eyelids
		if (expression.equals("none"))
		{
			g.drawLine(bounds.x + eyewidth, bounds.y + 7*eyewidth/2, bounds.x + 4*eyewidth, bounds.y + 7*eyewidth/2);
			g.drawLine(bounds.x + eyewidth, bounds.y + eyeheight - 2, bounds.x + 2*eyewidth, bounds.y + eyeheight - 2);
			g.drawLine(bounds.x + 3*eyewidth, bounds.y + eyeheight - 2, bounds.x + 4*eyewidth, bounds.y + eyeheight - 2);
		}
		else if (expression.equals("happy"))
		{
			g.drawLine(bounds.x + eyewidth, bounds.y + eyeheight - 2, bounds.x + 2*eyewidth, bounds.y + eyeheight/2);
			g.drawLine(bounds.x + 3*eyewidth, bounds.y + eyeheight/2, bounds.x + 4*eyewidth, bounds.y + eyeheight - 2);
			g.drawArc(bounds.x + eyewidth, bounds.y + 3*eyeheight, 3*eyewidth, eyeheight, 0, -180);
		}
		else if (expression.equals("sad"))
		{
			g.drawLine(bounds.x + eyewidth, bounds.y + eyeheight - 2, bounds.x + 2*eyewidth, bounds.y + eyeheight/2);
			g.drawLine(bounds.x + 3*eyewidth, bounds.y + eyeheight/2, bounds.x + 4*eyewidth, bounds.y + eyeheight - 2);
			g.drawArc(bounds.x + eyewidth, bounds.y + 3*eyeheight, 3*eyewidth, eyeheight, 0, 180);
		}
		else if (expression.equals("mad"))
		{
			g.drawLine(bounds.x + eyewidth, bounds.y + eyeheight/2, bounds.x + 2*eyewidth, bounds.y + eyeheight - 2);
			g.drawLine(bounds.x + 3*eyewidth, bounds.y + eyeheight - 2, bounds.x + 4*eyewidth, bounds.y + eyeheight/2);
			g.drawArc(bounds.x + eyewidth, bounds.y + 3*eyeheight, 3*eyewidth, eyeheight, 0, 180);
		}
		else
		{
			g.drawLine(bounds.x + eyewidth, bounds.y + eyeheight - 2, bounds.x + 2*eyewidth, bounds.y + eyeheight/2);
			g.drawLine(bounds.x + 3*eyewidth, bounds.y + eyeheight/2, bounds.x + 4*eyewidth, bounds.y + eyeheight - 2);
			g.drawString("What?", bounds.x + 2*eyewidth, bounds.y + 4*eyeheight);
		}
	}
}
