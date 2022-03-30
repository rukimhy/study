package day11;

import java.util.Random;
import java.util.Scanner;

public class Q23_student {
	public static int Random () 
	{
		Random r = new Random();   
		int a,b,c;
		while(true) 
		{
			a = r.nextInt(10);
			b = r.nextInt(10);
			c = r.nextInt(10);
			if(a == 0)
			{//ran1의값이 0이면 다시 랜덤
				a = r.nextInt(10);
			}
			else if(b==a || b==c || b == 0) 
			{//ran2의값이 0,ran2가 ran1 ran3과 같다면 ran2 다시 랜덤
				b = r.nextInt(10);
			}else if(c==a || c ==b || c == 0) 
			{//ran3의값이 0,ran3가 ran2 ran1과 같다면 ran3 다시 랜덤
				c = r.nextInt(10);
			}else 
			{ //각각 숫자가 다 다를경우 while 탈출
				break;
			}	
		}
		System.out.println("랜덤"+a+""+b+""+c);
		
		int RAN = (100*a)+(10*b)+c;
		return RAN;
	}
	public static int num01 () 
	{	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째숫자 입력:");
		int num1 = sc.nextInt();
		
		return num1;
	}
	public static int num02 () 
	{	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두번째숫자 입력:");
		int num2 = sc.nextInt();
		
		return num2;
	}
	public static int num03 () 
	{	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("세번째숫자 입력:");
		int num3 = sc.nextInt();
		
		return num3;
	}

	public static void game (int a,int b,int c) 
	{
		Scanner sc = new Scanner(System.in);
		
		while(true) 
		{			
			
			int num1 = num01();	
			int num2 = num02();
			int num3 = num03();
			int strike = 0;
			int ball = 0;
			if(num1 == num2 ||num2 == num3 ||num1 == num3 ) {//같은 숫자의 입력이 들어왔을때 다시입력
				System.out.println("각각 다른숫자를 입력해주세요");
				continue;
			}
			//숫자는 같지만 자리수가 다른경우
			if(a == num2 || a == num3){ball++;}
			if(b == num1 || b == num3){ball++;}
			if(c == num1 || c == num2){ball++;}
			//숫자와 자리가 모두같은경우
			if(a == num1){strike++;}
			if(b == num2){strike++;}
			if(c == num3){strike++;}
			if(strike==3) {
				System.out.println("홈런입니다.");
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(strike == 0 && ball == 0){
				System.out.println("아웃입니다.");
			}
			else {
				System.out.println(strike+"스트라이크"+ball+"볼");
			}
		}
	

	}


	public static void main(String[] args) {
			
		int ran = Random();
		int ran1 = ran / 100;
		int ran2 = (ran-(ran1*100))/ 10;
		int ran3 = (ran-((100*ran1)+(10*ran2)));	
		game(ran1,ran2,ran3);
		
		



	}
}