package day12;

import java.util.Random;
import java.util.Scanner;

public class Q24_teacher {

	//3번
	static int ranbum()
	{
		Random r = new Random();
		return r.nextInt(5)+1;
	}
	
	static int userSel()
	{
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	static boolean check(int bum, int sel)
	{
		if(sel<1 || sel >5)
		{
			System.out.println("잘못된 입력입니다.");
			return true;
		}
		else if(sel == bum)
		{
			System.out.println("범인을 잡았습니다.");
			return false;
		}
		else
		{
			System.out.println("범인을 잡지 못했습니다.");
			return true;
		}
	}
	
	public static void main(String[] args)
	{
		
		int bum = ranbum();
		boolean check = true;
		
		while(check)
		{
			System.out.print("범인 입력(1~5) : ");
			int sel = userSel();
			check=check(bum, sel);
		}
	}
	
}
