package RootPackage;

public class NewtonMethod extends RootClass
{

	public NewtonMethod()
	{
		super();
	}
	
	public void findRoot (boolean function1)
	{	
		for (int i = 0; i < size; i++)
		{
			double initial = (range[i][0] + range[i][1]) / 2;
			double next = 0.0;
			System.out.println("Format:   Current   |   Next   |   error   ");
			
			for (int j = 0; j < MAX_ITERATIONS; j++)
			{
				next = initial - (func(initial, function1) / funcDeriv(initial, function1));
				System.out.print("   " + initial + "   |   " + next + "   |   ");
				
				if (j == 0)
				{
					System.out.print("--");
					System.out.println();
				}
				else if (Math.abs((next - initial) / next) < EPSILON)
				{
					System.out.print(Math.abs((next - initial) / next));
					System.out.println();
					break;
				}
				else
				{
					System.out.print(Math.abs((next - initial) / next));
					System.out.println();
				}
				
				initial = next;
			}
			
			root[i] = next;
		}
	}
}
