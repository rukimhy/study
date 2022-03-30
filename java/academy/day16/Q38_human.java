package day16;

import java.util.Random;
import java.util.Scanner;

class Gun{}

class Human
{
	Gun gun;
	
	void print() 
	{
		if(gun != null) 
		{
			System.out.println("총을 가지고 있습니다.");
		} 
		else 
		{
			System.out.println("총이 없습니다.");
		}
	}
}

public class Q38_human {

	public static void main(String[] args) {
		/* 사람이 총 5명 있다. 그 중 랜덤으로 한명이 권총을 들고 있다.
		 * 권총을 가지고 있는 사람을 찾으면 끝나는 게임을 만들어라.
		 */
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		Human[] human = new Human[5];
		Gun gun = new Gun();
		
		int gunRandom = r.nextInt(5);
		System.out.println((gunRandom+1)+"번이 총을 가졌다.");
		
		for(int i = 0; i < 5; i++) 
		{
			human[i] = new Human();
		}
		
		human[gunRandom].gun = gun;
		gun = null;
		
		while(true) 
		{
			System.out.print("1~5의 숫자 중 총을 가진 사람을 찾으세요 : ");
			int choice = scan.nextInt();
			human[choice-1].print();
			if(human[choice-1].gun != null) break;
		}
	}

}
