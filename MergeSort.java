import java.util.*;
public class MergeSort
{
	
	static int b[] = new int[100000];
	static void merge(int a[], int mid, int l, int r)
	{
		int i=l, j=mid+1, k=0;
		while(i<=mid && j<=r)
		{
			if(a[i]<=a[j])	b[k++] = a[i++];
			else				b[k++] = a[j++];
		}
		while(i<=mid)	b[k++] = a[i++];
		while(j<=r)		b[k++] = a[j++];
		int x=0;
		i=l;
		while(x<k)
			a[i++] = b[x++];
	}
	static void msort(int a[], int l, int r)
	{
		if(l<r)
		{
			int mid = (l+r)/2;
			msort(a, l, mid);
			msort(a, mid+1, r);
			merge(a, mid, l, r);
		}
	}
	
	
	
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int n = sc.nextInt();
		int a[] = new int[n], b[]=new int[n];
		System.out.print("Unsorted : ");
		for(int i=0; i<n; i++)
		{
			a[i] = r.nextInt()%10;
			b[i] = a[i];
			System.out.print(a[i]+" ");
		}
		
		long start = System.currentTimeMillis();
		msort(a, 0, n-1);
		long end = System.currentTimeMillis();
		
		System.out.println("\nSorted : ");
		for(int i=0; i<n; i++)
			System.out.print(a[i]+" ");
		System.out.println("\nTime : "+(end-start)+"ms");
		
		Arrays.sort(b);
		int flag=0;
		for(int i=0; i<n; i++)
		{
			if(a[i]!=b[i])
				flag=1;
		}
		if(flag==1)
			System.out.println("FAILED!");
		sc.close();
		
		
	}
}
