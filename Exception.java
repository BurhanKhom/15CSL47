import java.util.*;
public class Exception
{
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = a/b;
			System.out.println(c);
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
		finally
		{
			sc.close();
		}
		
	}
	
}
