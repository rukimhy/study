package day7;

import java.util.Random;
import java.util.Scanner;

public class Q12_1010random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 정수 10배열. 여기에 랜덤으로 0~10까지 값이 들어있다.
		 * 값은 중복도 가능. 그 이후에 유저가 숫자를 입력한다.
		 * -1을 입력하면 종료. 그렇지 않으면 무한 반복한다.
		 * 0~10까지의 값을 입력하지 않으면 잘못된 값이라고 출력한다.
		 * 올바른 0~10 까지의 값을 입력했으면 그 숫자가 배열 안에 총 몇개가 있는지 출력한다.
		 */

		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		int[] cpu = new int[10];

		while(true) 
		{
			int count = 0;

			//배열에 랜덤값 생성
			for(int i = 0; i < 10; i++) 
			{
				cpu[i] = r.nextInt(11);
				System.out.print(cpu[i]+" ");
			}
			System.out.println();

			// 유저가 숫자를 입력
			System.out.print("0~10 숫자 중 하나를 입력하시오(종료 : -1) : ");
			int user = scan.nextInt();

			//-1 입력 시 종료
			if(user == -1) 
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			} else 
			{
				//0~10 안의 숫자가 아닐 경우
				if(user<0 || user>10) System.out.println("잘못된 입력입니다.");
				//0~10 안의 숫자일 경우
				else 
				{
					for(int i = 0; i<10; i++) 
					{
						if(user == cpu[i]) count++;
					}
					System.out.println(user+"의 총 개수는 "+count+"개 입니다.");
				}
			}
			System.out.println("--------------------------------------");
		}
	}
}
