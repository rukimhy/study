package day6;

import java.util.Random;
import java.util.Scanner;

public class Q9_baseBallReRe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int cpu1, cpu2, cpu3;
		int strike, ball;
				
		System.out.println("숫자야구게임을 시작합니다.");
		System.out.println("1부터 9까지의 숫자만 입력이 가능합니다.");
				
		//cpu 3개 랜덤 숫자 구현
		cpu1 = r.nextInt(9)+1;
		while(true) 
		{
			cpu2 = r.nextInt(9)+1;
			if(cpu1 != cpu2) 
			{
				break;
			}
		}
		while(true) 
		{
			cpu3 = r.nextInt(9)+1;
			if(cpu1 != cpu3 && cpu2 != cpu3) 
				{
					break;
				}
		}
		System.out.println("cpu1 = "+cpu1+" cpu2 = "+cpu2+" cpu3 = "+cpu3);
				
				
		while(true) 
		{
			//user 3개 입력 구현		
			System.out.print("1번째 숫자를 입력해주세요 : ");
			int user1 = scan.nextInt();
			while(true) 
			{
				if(!(user1 >= 1 && user1 <=9)) 
				{
					System.out.println("잘못된 입력입니다.");
					System.out.print("다시 입력해주세요 : ");
					user1 = scan.nextInt();
				} 
				else 
				{
					break;
				}
			}

					
			System.out.print("2번째 숫자를 입력해주세요 : ");
			int user2 = scan.nextInt();
			
			while(true) 
			{
				if(user2 == user1) 
				{
					System.out.println("같은 숫자는 입력하면 안됩니다.");
					System.out.print("다시 입력해주세요 : ");
					user2 = scan.nextInt();
				} 
				else if(!(user2 >= 1 && user2 <=9)) 
				{
					System.out.println("잘못된 입력입니다.");
					System.out.print("다시 입력해주세요 : ");
					user2 = scan.nextInt();
				} 
				else 
				{
					break;
				}
			}

				
			System.out.print("3번째 숫자를 입력해주세요 : ");
			int user3 = scan.nextInt();
			
			while(true) 
			{
				if(user3 == user1 || user3 == user2) 
				{
					System.out.println("같은 숫자는 입력하면 안됩니다.");
					System.out.print("다시 입력해주세요 : ");
					user3 = scan.nextInt();
				} 
				else if(!(user3 >= 1 && user3 <=9)) 
				{
					System.out.println("잘못된 입력입니다.");
					System.out.print("다시 입력해주세요 : ");
					user3 = scan.nextInt();
				} 
				else 
				{
					break;
				}
			}
			
			//게임 구현
			strike = 0;
			ball = 0;
			
			if(user1 == cpu1)
			{
				strike++;
			}
			if(user2 == cpu2)
			{
				strike++;
			}
			if(user3 == cpu3)
			{
				strike++;
			}
			if(user1 == cpu2 || user1 == cpu3)
			{
				ball++;
			}
			if(user2 == cpu1 || user2 == cpu3)
			{
				ball++;
			}
			if(user3 == cpu1 || user3 == cpu2)
			{
				ball++;
			}
			
			if(strike == 3)
			{
				System.out.println("홈런입니다.");
				break;
			}
			else if(strike == 0 && ball == 0)
			{
				System.out.println("out입니다.");
			}
			else
			{
				System.out.println("Strike :"+strike+","+"Ball : "+ball+"입니다.");
			}
			
		}
	}
}
