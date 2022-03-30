package day6;

import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class Q9_teacher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//스캐너 객체 생성
		Random r = new Random(); //랜덤 객체생성

		int com1 = r.nextInt(9)+1; //컴퓨터의 랜덤값
		int com2 = r.nextInt(9)+1;//두번째 랜덤값
		
		int strike = 0;
		int ball = 0;
		
		while(com1 == com2) //랜덤값 중복 방지를 위한 식
		{
			com1 = r.nextInt(9)+1; 
		}
		
		int com3 = r.nextInt(9)+1;//세번째 랜덤값
		while(com1 == com3 || com2 == com3) //세번째 랜덤값도 중복 방지를 위한 식
		{
			com3 = r.nextInt(9)+1; 
		}
		System.out.println(com1 + " " + com2 +" " + com3); // 정해진 랜덤값 출력
		
		
		while(true)
		{
			
			strike = 0;
			ball = 0;
			
			System.out.print("숫자 1 입력: ");
			int user1 = sc.nextInt();
			System.out.print("숫자 2 입력: ");
			int user2 = sc.nextInt();
			System.out.print("숫자 3 입력: ");
			int user3 = sc.nextInt();
			
			if(user1 == com1)
			{
				strike++;
			}
			if(user2 == com2)
			{
				strike++;
			}
			if(user3 == com3)
			{
				strike++;
			}
			if(user1 == com2 || user1 == com3)
			{
				ball++;
			}
			if(user2 == com1 || user2 == com3)
			{
				ball++;
			}
			if(user3 == com1 || user3 == com2)
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

