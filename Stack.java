import java.util.*;
public class Stack 
{
	static final int MAX = 5;
	static int top = -1;
	static int s[] = new int[MAX];
	static void push(int e)
	{
		if(top==MAX-1)
		{
			System.out.println("Stack Overflow!");
			return;
		}
		s[++top]=e;
	}
	static void pop()
	{
		if(top==-1)
			System.out.println("Stack Empty!");
		else
				System.out.println("Element popped : "+(s[top--]));
	}	
	
	static void display()
	{
		if(top==-1)
		{
			System.out.println("Stack Empty!");
			return;
		}
		for(int i=top; i>=0; i--)
			System.out.println(s[i]);
	}
	
	
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String type = sc.next();
			if(type.equalsIgnoreCase("push"))
				push(sc.nextInt());
			else if(type.equalsIgnoreCase("pop"))
				pop();
			else if(type.equalsIgnoreCase("display"))
				display();
			else
			{
				sc.close();
				System.exit(0);
			}
		}
	}
}
