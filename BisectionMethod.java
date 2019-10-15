package RootPackage;

public class BisectionMethod extends RootClass
{
	public BisectionMethod()
	{
		super();
	}
	
	public void findRoot (boolean function1)
	{
		for (int i = 0; i < size; i ++)
		{
			double a = range[i][0];
			double b = range[i][1];
			double c = 0.0;
			double prevEstimate = 0.0;
			System.out.println("Format:   a   |   b   |   c   |   error   ");
			
			for (int j = 0; j < MAX_ITERATIONS; j++)
			{
				c = (a + b) / 2;
				System.out.print("   " + a + "   |   " + b + "   |   " + c + "   |   ");
				
				if (func(c, function1) == 0.0)
					break;
				else if (func(c, function1) * func(a, function1) < 0)
					b = c;
				else
					a = c;
				
				if (j == 0)
				{
					System.out.print("--");
					System.out.println();
				}
				else if (Math.abs((c - prevEstimate) / c) < EPSILON)
				{
					System.out.print(Math.abs((c - prevEstimate) / c));
					System.out.println();
					break;
				}
				else
				{
					System.out.print(Math.abs((c - prevEstimate) / c));
					System.out.println();
				}
				
				prevEstimate = c;
			}
			
			root[i] = c;
		}
	}
	
}
