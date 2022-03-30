package test;

import java.util.Random;
import java.util.Scanner;

public class Q2_baseBallex {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		int[] cpu = new int[3];
		int strike, ball;

		System.out.println("숫자야구게임을 시작합니다.");
		System.out.println("1부터 9까지의 숫자만 입력이 가능합니다.");

		while(true) 
		{
			for(int i=0; i<3; i++) 
			{
				cpu[i] = r.nextInt(9)+1;
			}
			if(cpu[0] != cpu[1] && cpu[0] != cpu[2] && cpu[1] != cpu[2]) break;
		}
		System.out.println("cpu[0] = "+cpu[0]+" // cpu[1] = "+cpu[1]+" // cpu[2] = "+cpu[2]);

		while(true) 
		{
			System.out.println();
			int[] user = new int[] {123, 124, 125};
			System.out.println("서로 다른 숫자 3개를 입력해주세요.");
			for(int i=0; i<3; i++) 
			{
				System.out.print(i+1+"번째 숫자를 입력해주세요 : ");
				user[i] = scan.nextInt();

				while(true) 
				{
					if(!(user[i] >= 1 && user[i] <=9)) 
					{
						System.out.println("잘못된 입력입니다.");
						System.out.print("다시 입력해주세요 : ");
						user[i] = scan.nextInt();
					} 
					else if(user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) 
					{
						System.out.println("같은 숫자는 입력하면 안됩니다.");
						System.out.print("다시 입력해주세요 : ");
						user[i] = scan.nextInt();
					} 
					else break;
				}
			}

			strike = 0;
			ball = 0;

			for(int i = 0; i < 3; i++) 
			{
				if(user[i] == cpu[i]) strike ++;
			}

			for(int i=0; i<3; i++) 
			{
				for(int j=0; j<3; j++) 
				{
					if(i == j) continue;
					else if(user[i] == cpu[j]) ball++;
				}
			}
			
			/*
			if(user[0] == cpu[1] || user[0] == cpu[2])
			{
				ball++;
			}
			if(user[1] == cpu[0] || user[1] == cpu[2])
			{
				ball++;
			}
			if(user[2] == cpu[0] || user[2] == cpu[1])
			{
				ball++;
			}
			*/

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
				System.out.println("Strike :"+strike+" // "+"Ball : "+ball+"입니다.");
			}

		}
	}
}