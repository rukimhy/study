package day4;

import java.util.Scanner;

public class Q8_diamond {

	public static void main(String[] args) {
		/* "*"로 마름모 찍기
		 * 홀수만 입력해서 출력
		 * 짝수 입력시 잘못된 입력입니다. 출력하고 다시
		 * -1 입력하면 프로그램 종료
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("마름모 만드는 프로그램입니다.");
		System.out.println("종료는 -1을 입력해주세요.");
		
		while(true) 
		{
			System.out.print("원하시는 홀수를 입력해주세요 : ");
			int num = scan.nextInt();
			
			if(num == -1) 
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
			else if(num % 2 == 0) 
			{
				System.out.println("잘못된 입력입니다. 홀수만 입력해주세요.");
			} 
			else 
			{
				//위를 향한 별산
				for(int i = 0; i < (num+1)/2; i++) 
				{
					for(int j = i; j < (num-1)/2; j++) 
					{
						System.out.print(" ");
					}
					for(int k = 0; k < (i*2)+1; k++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
				
				// 아래를 향한 별산
				for(int i = 0; i < (num-1)/2; i++) 
				{
					for(int j = 0; j < i+1; j++) 
					{
						System.out.print(" ");
					}
				
					for(int k = num-2-i; k > i; k--)
					{
						System.out.print("*");
					}
				
					System.out.println();
				}
			}
		}
	}
}
