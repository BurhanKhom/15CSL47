import java.util.*;
public class Dijkstra
{
	static void solve(int a[][], int n, int s)
	{
		int i, u=-1, finalize[]=new int[n], min, dist[]=new int[n], parent[]=new int[n];
		
		for(i=0; i<n; i++)
		{
			dist[i]=999;
			finalize[i]=0;
		}
		dist[s]=0;
		
		while(true)
		{
			min = 999;
			
			for(i=0; i<n; i++)
			{
				if(finalize[i]==0 && min > dist[i])
				{
					min = dist[i];
					u = i;
				}
			}
			
			if(min==999)
				break;
			
			finalize[u]=1;
			for(i=0; i<n; i++)
				if(finalize[i]==0 && dist[i] > dist[u] + a[u][i])
				{
					dist[i] = dist[u] + a[u][i];
					parent[i] = u;
				}
		}
		
		System.out.println("Node\t\tDistance From "+s+"\t\t"+"Path");
		for(i=0; i<n; i++)
		{
			System.out.print(i+"\t\t"+dist[i]+"\t\t\t");
			int p = i;
			System.out.print(p+" <- ");
			while(parent[p]!=0)
			{
				System.out.print(parent[p]+" <- ");
				p = parent[p];
			}
			System.out.println(s);	
		}
	}
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				a[i][j] = sc.nextInt();
		int src = sc.nextInt();
		solve(a, n, src);
		sc.close();
	}
}
