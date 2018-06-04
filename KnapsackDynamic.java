import java.util.*;
public class KnapsackDynamic
{
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p[]=new int[n+1], w[]=new int[n+1], c;
		for(int i=1; i<=n; i++)
			p[i] = sc.nextInt();
		for(int i=1; i<=n; i++)
			w[i] = sc.nextInt();
		c = sc.nextInt();
		
		int help[][] = new int[n+1][c+1];
		
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=c; j++)
			{
				if(i==0 || j==0)
					help[i][j] = 0;
				else if(j - w[i] < 0)
					help[i][j] = help[i-1][j];
				else
					help[i][j] = Math.max(help[i-1][j], p[i]+help[i-1][j-w[i]]);
			}
		}
		int pro = help[n][c], flag=0;
		System.out.print("Item(s) selected : ");
		while(pro!=0)
		{
			for(int i=0; i<=n; i++)
			{
				flag=0;
				for(int j=0; j<=c; j++)
					if(help[i][j] == pro)
					{
						flag=1;
						System.out.print(i+" ");
						pro -= p[i];
						break;
					}
				if(flag==1)
					break;
			}
		}
		System.out.println("\nTotal Profit = "+help[n][c]);
		sc.close();
		
		
		
	}
}
