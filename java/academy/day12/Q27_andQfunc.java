package day12;

import java.util.Random;
import java.util.Scanner;

public class Q27_andQfunc {

	//유저 문자 입력
	public static int input() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("A~Z 중 문자를 하나 입력해주세요 : ");
		char a2z = scan.next().charAt(0);
		
		while(true) 
		{
			if(!((int)a2z >= 65 && (int)a2z <= 90)) 
			{
				System.out.println("잘못입력하셨습니다.");
				System.out.print("A~Z 중 문자를 하나 입력해주세요 : ");
				a2z = scan.next().charAt(0);
			} 
			else break;
		}

		return (int)a2z;
	}
	
	//컴퓨터 랜덤 문자열
	public static void cpuRandom(int input) 
	{
		Random r = new Random();

		int count = 0;

		while(true) 
		{
			int alphabet = 65;
			int random_a = r.nextInt(25);

			int sum = alphabet + random_a;

			if(sum == input) count++;

			if(sum == 81) break;

			System.out.print((char)sum);
		}
		System.out.println("\n"+(char)input+"의 개수는 "+count+"개 입니다.");

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5번 문제 최소 2개 이상의 함수로 구현

		cpuRandom(input());
	}
}
