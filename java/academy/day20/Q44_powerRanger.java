package day20;
/* 부모 : 로봇 / 자식 : 레드, 블루, 그린, 옐로우, 핑크
 * 부모로 5배열 만든다. 객체를 생성해서 로봇 배열에 채운다.
 * 0~4 랜덤값을 받아서 0이면 레드, 1이면 블루, 2면 그린, 3이면 옐로우, 4면 핑크
 * 랜덤으로 객체 채우다보면 중복될 경우가 있다
 * 레드 블루 그린 옐로우 핑크 순서 상관없이 들어가면 프로그램 종료
 * 부모 배열 채울때마다 0~4 인덱스 안에 어떤 객체가 있는지 출력
 */

import java.util.Random;

class Robot{}
class Red extends Robot{}
class Blue extends Robot{}
class Green extends Robot{}
class Yellow extends Robot{}
class Pink extends Robot{}

public class Q44_powerRanger {

	public static void main(String[] args) {
		Random r = new Random();
		Robot[] robot = new Robot[5];
		
		while(true) 
		{
			int redCount = 0;
			int blueCount = 0;
			int greenCount = 0;
			int yellowCount = 0;
			int pinkCount = 0;
			
			for(int i = 0; i<5; i++) 
			{
				int random = r.nextInt(5);
				if(random == 0) 
				{
					robot[i] = new Red();
					redCount++;
				} 
				else if(random == 1) 
				{
					robot[i] = new Blue();
					blueCount++;
				} 
				else if(random == 2) 
				{
					robot[i] = new Green();
					greenCount++;
				} 
				else if(random == 3) 
				{
					robot[i] = new Yellow();
					yellowCount++;
				} 
				else 
				{
					robot[i] = new Pink();
					pinkCount++;
				}
			}
			
			for(int i = 0; i < 5; i++) 
			{
				if(robot[i] instanceof Red) 
				{
					System.out.print(i+"=레드 // ");
				} 
				else if(robot[i] instanceof Blue) 
				{
					System.out.print(i+"=블루 // ");
				} 
				else if(robot[i] instanceof Green) 
				{
					System.out.print(i+"=그린 // ");
				} 
				else if(robot[i] instanceof Yellow) 
				{
					System.out.print(i+"=옐로우 // ");
				} 
				else 
				{
					System.out.print(i+"=핑크 // ");
				}
			}
			System.out.println();
			
			if(redCount == 1 && blueCount == 1 && greenCount == 1 && yellowCount == 1 && pinkCount == 1) 
			{
				System.out.println("합체성공");
				break;
			}
		}
	}

}
