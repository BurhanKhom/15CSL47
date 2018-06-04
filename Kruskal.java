import java.util.*;
public class Kruskal
{
	static void solve(int a[][], int n)
	{
		int i, j, parent[]=new int[n], edges=0, cost=0, min=999, u=-1, v=-1, p;
		
		while(edges < n-1)
		{
			min = 999;
			
			for(i=0; i<n; i++)
				for(j=0; j<n; j++)
					if(a[i][j] < min)
					{
						min = a[i][j];
						u = i;
						v = j;
					}
			p = u;
			while(parent[p]!=0) p = parent[p]; i=p;
			p = v;
			while(parent[p]!=0) p = parent[p]; j=p;
			
			if(i!=j)
			{
				if(i<j)
					parent[i] = j;
				else
					parent[j] = i;
				
				System.out.println((u+1)+" - "+(v+1));
				cost += a[u][v];
				edges++;
			}
			a[u][v] = a[v][u] = 999;		
		}
		System.out.println(cost);
		
	}
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				a[i][j] = sc.nextInt();
		solve(a, n);
		sc.close();
	}
}
