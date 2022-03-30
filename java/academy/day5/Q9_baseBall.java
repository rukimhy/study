package day5;

import java.util.Random;
import java.util.Scanner;

public class Q9_baseBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 숫자야구게임
		 * cpu가 1~9 중 3개의 숫자를 랜덤으로 받습니다. (단, 랜덤 숫자가 다 달라야 함)
		 * user가 1~9 중 3개의 숫자를 입력합니다. (똑같은 입력이면 잘못된 입력이라고 알려주고 다시 입력 받는다.)
		 * cpu 3 2 1 user 2 7 9 => 1ball
		 * cpu 3 2 1 user 1 3 2 => 3ball
		 * cpu 3 2 1 user 3 9 6 => 1strike
		 * cpu 3 2 1 user 4 5 6 => out
		 * cpu 3 2 1 user 3 2 1 => 홈런입니다. => 프로그램 종료 됩니다.
		 */
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int cpu1, cpu2, cpu3;
		
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

		if(user1 == cpu1 && user2 == cpu2 && user3 == cpu3) 
		{
			System.out.println("홈런입니다.");
			System.out.println("프로그램을 종료합니다.");
			break;
		} 
		else 
		{
			//2s일 경우
			if((user1 == cpu1 && user2 == cpu2) || (user1 == cpu1 && user3 == cpu3) || (user2 == cpu2 && user3 == cpu3)) 
			{
				System.out.println("2strike 입니다.");
			} 
			else 
			{
				//1s일 경우
				if(user1 == cpu1) 
				{
					if(user2 == cpu3 && user3 == cpu2) 
					{
						System.out.println("1strike 2ball 입니다.");
					} 
					else if(user2 == cpu3 || user3 == cpu2) 
					{
						System.out.println("1strike 1ball 입니다.");
					} 
					else 
					{
						System.out.println("1strike 0ball 입니다.");
					}					
				} 
				else if(user2 == cpu2) 
				{
					if(user1 == cpu3 && user3 == cpu1) 
					{
						System.out.println("1strike 2ball 입니다.");
					} 
					else if(user1 == cpu3 || user3 == cpu1) 
					{
						System.out.println("1strike 1ball 입니다.");
					} 
					else 
					{
						System.out.println("1strike 0ball 입니다.");
					}
				} 
				else if(user3 == cpu3) 
				{
					if(user1 == cpu2 && user2 == cpu1) 
					{
						System.out.println("1strike 2ball 입니다.");
					} 
					else if(user1 == cpu2 || user2 == cpu1) 
					{
						System.out.println("1strike 1ball 입니다.");
					} 
					else 
					{
						System.out.println("1strike 0ball 입니다.");
					}
				} 
				else 
				{
					//0s 3b일 경우
					if((user1 == cpu3 && user2 == cpu1 && user3 == cpu2) || (user1 == cpu2 && user2 == cpu3 && user3 == cpu1)) 
					{
						System.out.println("0strike 3ball 입니다.");
					} 
					else 
					{
						//0s 2b일 경우
						if(user2 == cpu3) 
						{
							if(user1 == cpu2) 
							{
								System.out.println("0strike 2ball 입니다.");
							} 
							else if(user3 == cpu2) 
							{
								System.out.println("0strike 2ball 입니다.");
							} 
							else if(user3 == cpu1)
							{
								System.out.println("0strike 2ball 입니다.");
							}
						} 
						else if(user1 == cpu3) 
						{
							if(user2 == cpu1) 
							{
								System.out.println("0strike 2ball 입니다.");
							} 
							else if(user3 == cpu2)
							{
								System.out.println("0strike 2ball 입니다.");
							} else {
								System.out.println("0strike 1ball 입니다.");
							}
						} 
						else if(user1 == cpu2) 
						{
							if(user3 == cpu1) 
							{
								System.out.println("0strike 2ball 입니다.");
							} 
							else if(user2 == cpu1) 
							{
								System.out.println("0strike 2ball 입니다.");
							}
						} 
						else if(user2 == cpu1 && user3 == cpu2) 
						{
							System.out.println("0strike 2ball 입니다.");
						} 
						else if(user1 == cpu2 || user1 == cpu3 || user2 == cpu1 || user2 == cpu3 || user3 == cpu1 || user3 == cpu2) 
						{
							System.out.println("0strike 1ball 입니다.");
						} 
						else 
						{
							System.out.println("OUT 입니다.");
						}
					}
				}
			}
		}
		}
	}
}
