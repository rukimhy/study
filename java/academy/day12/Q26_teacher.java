package day12;

import java.util.Random;
import java.util.Scanner;

public class Q26_teacher {

	public static int comRan()
	{
		Random r = new Random();
		return r.nextInt(3);
	}
	
	public static String userInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("가위 바위 보를 입력 : ");
		return sc.next();
		
	}
	
	public static int changeUserValue(String str)
	{
		int user;
		if(!(str.equals("가위") ||str.equals("바위") || str.equals("보")))
		{
			System.out.println("잘못된입력입니다.");
			return -1;
		}
		else
		{
			//equals("가위") => 함수 String안에 있는 함수 int 기본형 함수 자체가 없습니다.
			if(str.equals("가위"))
			{
				user = 0;
			}
			else if(str.equals("바위"))
			{
				user = 1;
			}
			else
			{
				user = 2;
			}
		}
		
		return user;
	}
	
	
	public static void check(int user, int ran)
	{
		
		if(user != -1)
		{
			int value = user - ran ;
			
			if(value == 1 || value == -2)
			{
				System.out.println("유저승");
			}
			else
			{
				if(value == 0)
				{
					System.out.println("무승부");
				}
				else
				{
					System.out.println("컴퓨터 승");
				}
			}
		}
	
	}
		
	public static void main(String[] args) {
		check(changeUserValue(userInput()), comRan());
	}

}
