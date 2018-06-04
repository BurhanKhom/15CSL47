import java.util.*;
public class Floyd 
{
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				a[i][j] = sc.nextInt();
		int i, j, k;
		for(i=0; i<n; i++)
			for(j=0; j<n; j++)
				for(k=0; k<n; k++)
					a[j][k] = Math.min(a[j][k], a[j][i]+a[i][k]);
		for(i=0; i<n; i++)
		{
			for(j=0; j<n; j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		sc.close();
	}
}
