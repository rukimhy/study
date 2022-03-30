package day4;

import java.util.Random;
import java.util.Scanner;

public class Q7_stringGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 문자열 변수에 "인천직업능력개발원" 
		 * 랜덤 이용해서 문자 하나 추출해서 컴퓨터가 가지고 있는다.
		 * 유저가 글자를 입력해서 맞출 때까지 게임을 합니다.
		 * 게임이 끝나면 컴퓨터가 가지고 있는 문자와 몇 번의 시도만에 맞춰지는지 출력
		 * 인천직업능력개발원 문자가 아니면 시도 횟수에 포함되지 않음
		 */
		
		String str = "인천직업능력개발원";
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		int cpu_r = r.nextInt(9); // 0~8
		char cpu_char = str.charAt(cpu_r);
		int usr_count = 0;
		
		System.out.println("----------------------------------------");
		System.out.println("컴퓨터와 하는 문자 맞추기 게임입니다.");
		System.out.println("[인.천.직.업.능.력.개.발.원] 중 정답을 맞추세요.");
		System.out.println("----------------------------------------");
		
		while(true) 
		{
			System.out.print("생각하는 답을 입력해주세요 : ");
			char choice = scan.next().charAt(0);
			
			if(!(choice == '인' || choice == '천' || choice == '직' || choice == '업' || choice == '능' || choice == '력' || choice == '개' || choice == '발' || choice == '원')) 
			{
				System.out.println("잘못된 입력입니다.");
			} 
			else 
			{
				if(choice != cpu_char) 
				{
					System.out.println("정답이 아닙니다!");
					usr_count++;
				} 
				else 
				{
					System.out.println("축하드립니다. 정답입니다!");
					System.out.println("정답 : "+ cpu_char);
					System.out.println("틀린 횟수 : "+ usr_count);
					break;
				}
			}
		}
	}
}
