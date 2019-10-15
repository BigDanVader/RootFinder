package RootPackage;

public class SecantMethod extends RootClass
{

	public SecantMethod()
	{
		super();
	}
	
	public void findRoot (boolean function1)
	{
		for (int i = 0; i < size; i ++)
		{
			double previous = range[i][0];
			double current = range[i][1];
			double next = 0.0;
			System.out.println("Format:   prev   |   current   |   next   |   error   ");
			
			for (int j = 0; j < MAX_ITERATIONS; j++)
			{
				next = current - ((func(current, function1) * (current - previous)) / (func(current, function1)
						- func(previous, function1)));
				System.out.print("   " + previous + "   |   " + current + "   |   " + next + "   |   ");
				
				
				if (j == 0)
				{
					System.out.print("--");
					System.out.println();
				}
				else if (Math.abs((next - current) / next) < EPSILON)
				{
					System.out.print(Math.abs((next - current) / next));
					System.out.println();
					break;
				}
				else
				{
					System.out.print(Math.abs((next - current) / next));
					System.out.println();
				}
				
				previous = current;
				current = next;
			}
			
			root[i] = next;
		}
	}
}
