import java.util.*;
public class Prims 
{
	static void solve(int a[][], int n)
	{
		int i, j, u=-1, v=-1, min=999, edges=0, cost=0;
		int visited[]=new int[n];
		visited[0]=1;
		while(edges < n-1)
		{
			min = 999;
			
			for(i=0; i<n; i++)
				if(visited[i]==1)
					for(j=0; j<n; j++)
						if(a[i][j]>0 && visited[j]==0 && min > a[i][j])
						{
							min = a[i][j];
							u = i;
							v = j;
						}
			
			System.out.println((u+1)+" - "+(v+1));
			visited[v] = 1;
			cost += a[u][v];
			a[u][v] = a[v][u] = 999; 
			edges++;
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
