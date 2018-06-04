import java.util.*;
public class Hamiltonian 
{
	static int x[]=new int[1000], a[][]=new int[1000][1000], n;
	static void next(int k)
	{
		while(true)
		{
			x[k] = (x[k]+1)%n;
			if(x[k]==0)
				return;
			
			int i=0;
			if(a[x[k-1]][x[k]]==1)
				for(i=0; i<k; i++)
					if(x[i]==x[k])
						break;
			if(i==k)
				if(k<n-1 || a[x[k]][0]==1)
					return;
		}
	}	
	static void getCycle(int k)
	{
		while(true)
		{
			next(k);
			if(x[k]==0)
				return;
			if(k==n-1)
			{
				System.out.print("Solution : ");
				for(int i=0; i<=k; i++)
					System.out.print(x[i]+1+" ");
				System.out.println(1);
			}
			else
				getCycle(k+1);
		}		
	}	
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				a[i][j] = sc.nextInt();
		
		getCycle(1);
		sc.close();
		
	}
}
