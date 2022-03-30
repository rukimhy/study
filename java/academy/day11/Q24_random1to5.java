package day11;

import java.util.Random;
import java.util.Scanner;

public class Q24_random1to5 {

	//cpu 랜덤값 받는 함수 (3번)
	public static int randomCpu() 
	{
		Random r = new Random();
		int cpu = r.nextInt(5)+1;
		return cpu;
	}

	//user 입력 받는 함수 (3번)
	public static int input() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("1~5 중 숫자를 입력해주세요 : ");
		int user = scan.nextInt();
		return user;
	}

	//결과값 리턴하는 함수 (1번)
	public static int output(int cpu, int user) 
	{
		int result = 0;
		if(cpu == user) result = 1;
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 랜덤으로 1~5까지 입력 받고 그 번호는 범인
		 * 유저는 1~5까지 계속 입력해서 범인을 찾는 게임. 범인을 찾을 때까지 반복
		 * 범인이 아닌 값을 입력하면 범인을 잡지 못했습니다.
		 * 범인번호를 입력하면 범인을 잡았습니다 출력 후에 프로그램 종료
		 * 함수 3개, 1번(주고 받고)과 3번(주고 안받고)만 사용
		 */
		
		int cpu = randomCpu();
		
		System.out.println(cpu);
		
		while(true) {
			int user = input();

			if(output(cpu, user) == 1) 
			{
				System.out.println("범인을 잡았습니다.");
				break;
			} 
			else System.out.println("범인을 잡지 못했습니다.");
		}
	}

}
