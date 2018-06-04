import java.util.*;
public class SubsetSum 
{
	static int a[]=new int[100000], n, ss;
	static int x[]=new int[100000];
	static void solve(int curSum, int k, int remSum)
	{
		x[k] = 1;
		
		if(curSum+a[k] == ss)
		{
			System.out.print("Subset : ");
			for(int i=0; i<=k; i++)
				if(x[i]==1)
					System.out.print(a[i]+" ");
			System.out.println();
		}
		
		else if(curSum+a[k]+a[k+1]<=ss)
			solve(curSum+a[k], k+1, remSum-a[k]);
		if(curSum+remSum-a[k] >= ss && curSum+a[k]<=ss)
		{
			x[k]=0;
			solve(curSum, k+1, remSum-a[k]);
		}	
		
	}
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int sum=0;
		for(int i=0; i<n; i++)
		{
			a[i] = sc.nextInt();
			sum+=a[i];
		}
		ss = sc.nextInt();
		solve(0, 0, sum);
		sc.close();
	}
}
