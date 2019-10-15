package RootPackage;

public class ModifiedSecantMethod extends RootClass
{

	private static final double DELTA = 0.01;
	
	public ModifiedSecantMethod()
	{
		super();
	}
	
	public void findRoot(boolean function1)
	{
		for (int i = 0; i < size; i++)
		{
			double current = (range[i][0] + range[i][1]) / 2;
			double next = 0.0;
			System.out.println("Format:   Current   |   Next   |   error   ");
			
			for (int j = 0; j < MAX_ITERATIONS; j++)
			{
				next = current - ((func(current, function1) * (DELTA * current)) / 
						(func((current + (DELTA * current)), function1) - func(current, function1)));
				System.out.print("   " + current + "   |   " + next + "   |   ");
				 
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
				
				current = next;
			}
			
			root[i] = next;
		}
	}
}
