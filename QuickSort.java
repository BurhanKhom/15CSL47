import java.util.*;
public class QuickSort
{
	static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	static int partition(int a[], int l, int r)
	{
		int i = l+1;
		int pi = a[l];
		int j=r;
		while(true)
		{
			while(a[i] <= pi && i<r) i++;
			while(a[j] > pi)			j--;
			
			if(i<j)
				swap(a, i, j);
			else
			{
				swap(a, l, j);
				return j;
			}
		}
	}
	static void qsort(int a[], int l, int r)
	{
		if(l<r)
		{
			int pi = partition(a, l, r);
			qsort(a, l, pi-1);
			qsort(a, pi+1, r);
		}
	}
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		System.out.print("Unsorted : ");
		for(int i=0; i<n; i++)
		{
			a[i] = r.nextInt()%1000;
			b[i] = a[i];
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		long start = System.currentTimeMillis();
		qsort(a, 0, n-1);
		long end = System.currentTimeMillis();
		
		System.out.print("Sorted : ");
		for(int i=0; i<n; i++)
			System.out.print(a[i]+" ");
		System.out.println("\nMy Sorting time : "+(end-start)+"ms");
		//check
		start = System.currentTimeMillis();
		Arrays.sort(b);
		end = System.currentTimeMillis();
		int flag=0;
		for(int i=0; i<n; i++)
		{
			if(a[i]!=b[i])
				flag=1;
		}
		if(flag==1)
			System.out.println("My Sort Unsuccessful :(");
		
		System.out.println("Library Function Sorting time : "+(end-start)+"ms");
		sc.close();
		
	}
}
