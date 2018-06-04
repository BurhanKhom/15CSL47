import java.util.*;
class tokens
{
	String modified="";
	public tokens(String userEntered)
	{
		StringTokenizer st = new StringTokenizer(userEntered, "/");
		while(st.hasMoreElements())
		{
			modified = modified + ", " + st.nextElement();
		}
	}
}
public class Tokenizer
{
	
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tokens[] t = new tokens[n];
		String names[] = new String[n];
		for(int i=0; i<n; i++)
		{
			names[i] = sc.next();
			t[i] = new tokens(sc.next());
		}
		for(int i=0; i<n; i++)
		{
			System.out.print(names[i]);
			System.out.println(t[i].modified);
		}
		sc.close();
		
	}
}
