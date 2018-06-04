import java.util.*;
public class TravellingSalesman 
{
	static int travel(int n, int cost[][], int path[], int start)
	{
		int min=999, temp[]=new int[n+1], minPath[]=new int[n+1], i, j;
		int curcost;
		if(start==n-1)
			return cost[path[n-1]][path[n]] + cost[path[n]][1];
		
		for(i=start+1; i<=n; i++)
		{
			for(j=1; j<=n; j++)
				temp[j] = path[j];
			temp[start+1] = path[i];
			temp[i] = path[start+1];
			
			if(cost[path[start]][i] + (curcost = travel(n, cost, temp, start+1)) < min)
			{
				min = curcost + cost[path[start]][i];
				for(j=1; j<=n; j++)
					minPath[j] = temp[j];
			}
		}
		for(i=1; i<=n; i++)
			path[i] = minPath[i];
		return min;
		
	}
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cost[][] = new int[n+1][n+1];
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				cost[i][j] = sc.nextInt();
		int path[]=new int[n+1];
		for(int i=1; i<=n; i++)
			path[i] = i;
		int min = travel(n, cost, path, 1);
		for(int i=1; i<=n; i++)
			System.out.print(path[i]+" -> ");
		System.out.println("1\nCost : "+min);
		sc.close();
	}
}
