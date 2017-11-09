public class RightTriangle
{
	public static void main(String[] args)
	{
		System.out.println("Enter length of first side");
		double a = IO.readDouble();
		
		while (a <= 0)
		{
			System.out.println("Enter positive length:");
			a = IO.readDouble();
			
		}
		
		System.out.println("Enter length of second side");
		double b = IO.readDouble();
		if (b <= 0)
		{
			IO.reportBadInput();
			return;
		}

		System.out.println("Enter length of third side");
		double c = IO.readDouble();
		if (c <= 0)
		{
			IO.reportBadInput();
			return;
		}

		if ((a + b <= c)  ||  (a + c <= b)  ||  (b + c <= a))
		{
			IO.reportBadInput();
			return;
		}
		
		if (a > b  &&  a > c)
		{
			System.out.println("decided a is longest side");
			if (Math.abs(a*a - (c*c + b*b)) < 0.0000001 )
			{
				IO.outputBooleanAnswer(true);
				IO.outputDoubleAnswer(a);
			}
			else
			{
				IO.outputBooleanAnswer(false);
			}
		}
		else if (b > c  &&  b > a)
		{
			System.out.println("decided b is longest side");
			if (Math.abs(b*b - (a*a + c*c)) < 0.000001 )
			{
				IO.outputBooleanAnswer(true);
				IO.outputDoubleAnswer(b);
			}
			else
			{
				IO.outputBooleanAnswer(false);
			}
		}
		else if (c > a  &&  c > b)
		{
			System.out.println("decided c is longest side");
			System.out.println(a*a);
			System.out.println(b*b);
			System.out.println(c*c);
			System.out.println(a*a + b*b);
			if (Math.abs(c*c - (a*a + b*b)) < 0.000001 )
			{
				IO.outputBooleanAnswer(true);
				IO.outputDoubleAnswer(c);
			}
			else
			{
				IO.outputBooleanAnswer(false);
			}
		}
		else
		{
			IO.outputBooleanAnswer(false);
		}
	}
}

