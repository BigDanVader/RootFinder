package RootPackage;

public class RootClass 
{
	protected int size;
	protected double[][] range;
	protected double[] root;
	protected static final double EPSILON = 0.01;
	protected static final int MAX_ITERATIONS = 100;
	
	public RootClass()
	{
		range = new double[10000][2];
		root = new double[10000];
		size = 0;
	}
	
	public int rootRange(double start, double end, boolean function1)
	{
		double pivot = start + 0.5;
		
		while (pivot <= end)
		{

			if (func(start, function1) * func(pivot, function1) <= 0)
			{
				range[size][0] = start;
				range[size][1] = pivot;
				size++;
			}
			
			start = pivot;
			pivot += 0.5;
		}
		
		
		return size;
	}

	protected double func(double x, boolean function1) 
	{
		if (function1)
			return (2 * (x * x * x)) - (11.7 * (x * x)) + (17.7 * x) - 5;
		else
			return x + 10 - (x * Math.cosh(50 / x));
		
	}
	
	protected double funcDeriv(double x, boolean function1)
	{
		if (function1)
			return (6 * (x * x)) - (23.4 * x) + 17.7;
		else
			return 1 -  Math.cosh(50 / x) + ((50* Math.sinh(50 / x)) / x);
	}
	
	public double getRoot (int index)
	{
		return root[index];
	}
	
	public int getSize()
	{
		return size;
	}

}
