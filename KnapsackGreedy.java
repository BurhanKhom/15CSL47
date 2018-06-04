import java.util.*;
public class KnapsackGreedy
{
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int p[][]=new int[n][2], w[]=new int[n], c;
		for(int i=0; i<n; i++)
		{
			p[i][0] = sc.nextInt();
			p[i][1] = i;
		}
		for(int i=0; i<n; i++)
			w[i] = sc.nextInt();
		c = sc.nextInt();
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n-i-1; j++)
			{
				if((double)p[j][0]/w[p[j][1]] < (double)p[j+1][0]/(double)w[p[j+1][1]])
				{
					int temp = p[j][0];
					p[j][0] = p[j+1][0];
					p[j+1][0] = temp;
					temp = p[j][1];
					p[j][1] = p[j+1][1];
					p[j+1][1] = temp;
				}
			}
		}
		System.out.println("Item\t\tProfit\t\tWeight\t\tPi/Wi");
		for(int i=0; i<n; i++)
		{
			System.out.println(p[i][1]+"\t\t"+p[i][0]+"\t\t"+w[p[i][1]]+"\t\t"+((double)p[i][0]/(double)w[p[i][1]]));
		}
		
		double pro=0;
		int size = c, i=0;
		while(size > w[p[i][1]])
		{
			System.out.println("Whole part of Item "+p[i][1]+" selected");
			size -= w[p[i][1]];
			pro += p[i][0];
			i++;
		}
		if(i<n)
		{
			System.out.println(size+"/"+w[p[i][1]]+" part of Item "+p[i][1]+" selected");
			double fraction = (double)size / (double)w[p[i][1]];
			pro += fraction*p[i][0];
		}
		System.out.println("Total Profit : "+pro);
		sc.close();
	}
}
