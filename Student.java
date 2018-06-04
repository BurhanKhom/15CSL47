import java.util.*;
class Details 
{
	String usn, name, branch;
	long phone;
	
	public Details(String USN, String NAME, String BRANCH, long PHONE)
	{
			usn = USN;
			name = NAME;
			branch = BRANCH;
			phone = PHONE;
	}
	void display()
	{
		System.out.println("USN    : "+usn);
		System.out.println("Name   : "+name);
		System.out.println("Branch : "+branch);
		System.out.println("Phone  : "+phone);
	}
}
public class Student
{
	public static void main(String...strings)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no. of students : ");
		int n = sc.nextInt();
		Details st[] = new Details[n];
		for(int i=0; i<n; i++)
		{
			System.out.println("Student "+(i+1));
			System.out.print("Name : ");
			String name = sc.next();
			System.out.print("USN : ");
			String usn = sc.next();
			System.out.print("Branch : ");
			String branch = sc.next();
			System.out.print("Phone : ");
			long phone = sc.nextLong();
			st[i] = new Details(name, usn, branch, phone);
		}
		System.out.println("Student Details are : ");
		for(int i=0; i<n; i++)
			st[i].display();
		sc.close();
	}
}