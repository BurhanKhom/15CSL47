import java.util.*;
class First extends Thread
{
	Random r = new Random();
	public void run()
	{
		for(int i=0; i<5; i++)
		{
			int n = r.nextInt()%10;
			System.out.println(n);
			Thread q = new Thread(new Second(n));
			q.start();
			Thread r = new Thread(new Third(n));
			r.start();
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				//do nothing
			}
		}
	}
}
class Second extends Thread
{
	int x;
	Second(int x)
	{
		this.x = x*x;
	}
	public void run()
	{
		System.out.println(x);
	}
}
class Third extends Thread
{
	int x;
	Third(int x)
	{
		this.x = x*x*x;
	}
	public void run()
	{
		System.out.println(x);
	}
}
public class MultiThreading
{
	public static void main(String...strings)
	{
		Thread p = new Thread(new First());
		p.start();
	}
}
