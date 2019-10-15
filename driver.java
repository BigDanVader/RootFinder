package RootPackage;

import java.util.Scanner;

public class driver
{

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		double[] root = new double[10000];
		int size = 0;
		boolean choice;
		boolean more = true;
		
		while (more)
		{
			System.out.println("Chose function:");
			System.out.println("1.) f(x) = 2x^3 - 11.7x^2 + 17.7x - 5");
			System.out.println("2.) f(x) = x + 10 = xcosh(50/x)");
			if (in.nextInt() == 1)
				choice = true;
			else
				choice = false;
			
			System.out.println("Enter range to find roots in: ");
			int start = in.nextInt();
			int end = in.nextInt();
			
			System.out.println("Chose method: ");
			System.out.println("1.) Bisection");
			System.out.println("2.) False Position");
			System.out.println("3.) Newton");
			System.out.println("4.) Secant");
			System.out.println("5.) Modified Secant");
			int methodChoice = in.nextInt();
			
			switch (methodChoice)
			{
				case 1:
					BisectionMethod bm = new BisectionMethod();
					
					if (bm.rootRange(start, end, choice) == 0)	
					{
						System.out.println("No sign changes found in range.");
						break;
					}
					
					System.out.println(bm.getSize() + " root(s) found in range.");
					bm.findRoot(choice);
					
					for (int i = 0; i < bm.getSize(); i++)
					{
						root[i] = bm.getRoot(i);
					}
					
					size = bm.getSize();
					
					break;
					
				case 2:
					FalsePositionMethod fpm = new FalsePositionMethod();
					
					if (fpm.rootRange(start, end, choice) == 0)	
					{
						System.out.println("No sign changes found in range.");
						break;
					}
					
					System.out.println(fpm.getSize() + " root(s) found in range.");
					fpm.findRoot(choice);
					
					for (int i = 0; i < fpm.getSize(); i++)
					{
						root[i] = fpm.getRoot(i);
					}
					
					size = fpm.getSize();
					
					break;
					
				case 3:
					NewtonMethod nm = new NewtonMethod();
					
					if (nm.rootRange(start, end, choice) == 0)	
					{
						System.out.println("No sign changes found in range.");
						break;
					}
					
					System.out.println(nm.getSize() + " root(s) found in range.");
					nm.findRoot(choice);
					
					for (int i = 0; i < nm.getSize(); i++)
					{
						root[i] = nm.getRoot(i);
					}
					
					size = nm.getSize();
					
					break;
					
				case 4:
					SecantMethod sm = new SecantMethod();
					
					if (sm.rootRange(start, end, choice) == 0)	
					{
						System.out.println("No sign changes found in range.");
						break;
					}
					
					System.out.println(sm.getSize() + " root(s) found in range.");
					sm.findRoot(choice);
					
					for (int i = 0; i < sm.getSize(); i++)
					{
						root[i] = sm.getRoot(i);
					}
					
					size = sm.getSize();
					
					break;
					
				case 5:
					ModifiedSecantMethod msm = new ModifiedSecantMethod();
					
					if (msm.rootRange(start, end, choice) == 0)	
					{
						System.out.println("No sign changes found in range.");
						break;
					}
					
					System.out.println(msm.getSize() + " root(s) found in range.");
					msm.findRoot(choice);
					
					for (int i = 0; i < msm.getSize(); i++)
					{
						root[i] = msm.getRoot(i);
					}
					
					size = msm.getSize();
					
					break;
					
				default:
					break;
			}
			
			if (size != 0)
			{
				System.out.println("Value of root(s):");
				for (int i = 0; i < size; i ++)
				{
					System.out.println(root[i]);
				}
			}
			
			System.out.println("Continue (1. yes, 2. no)");
			int userChoice = in.nextInt();
			if (userChoice == 2)
				more = false;
		}
	}

}
