package day18;
/* 마린 10마리, 저글링 10마리
 * 공격출력 함수, 현재 에너지 상황 출력 함수
 * 랜덤으로 공격하는 종족 선택 // 저그 or 테란
 * 그 안에서 어떤 유닛으로 공격할 지 선택해서 공격한다. 공격 대상도 랜덤.
 * 에너지가 0이 되는 유닛이 있으면 객체 소멸
 * 만약 공격 대상 객체가 없으면 그 다음 종족으로 넘어간다.
 * 종족의 객체가 0이 되면 종료하고 승리한 종족 출력
 */

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Unit10{
	int price;
	int energy;
	int atk;
	int def;
	String object;
	double speed;
	String type;
}

class Zergling10 extends Unit10{
	Zergling10(){
		price = 50;
		energy = 35;
		atk = 5;
		def = 0;
		object = "지상";
		speed = 2.612;
		type = "지상, 소형, 생체";
	}
	
	void damage(int a, int i) {
		this.energy -= a;
		System.out.println(i+"번 저글링이 "+a+"의 데미지를 입었다.");
	}
}

class Marine10 extends Unit10{
	Marine10(){
		price = 50;
		energy = 50;
		atk = 6;
		def = 0;
		object = "지상, 공중";
		speed = 1.875;
		type = "지상, 소형, 생체";
	}
	
	void damage(int a, int i) {
		this.energy -= a;
		System.out.println(i+"번 마린이 "+a+"의 데미지를 입었다.");
	}
}

public class Q42_star5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		Zergling10[] zergling = new Zergling10[10];
		Marine10[] marine = new Marine10[10];

		for(int i = 0; i < 10; i++) {
			zergling[i] = new Zergling10();
			marine[i] = new Marine10();
		}

		int count = 1;
		
		int marine_count = 0;
		int zergling_count = 0;
		int choice = r.nextInt(2);
		while(true) {
			
			System.out.println("---"+count+"턴째 상황--------------");
			//공격이 테란
			if(choice == 0) 
			{
				int random;
				while(true) {
					int attack_r = r.nextInt(10);
					if(marine[attack_r] != null) {
						random = attack_r;
						break;
					} 
				}
				int attack = r.nextInt(10);
				if(zergling[attack] != null) 
				{
					zergling[attack].damage(marine[random].atk, attack);

					if(zergling[attack].energy <= 0) 
					{
						System.out.println(attack+"번 저글링이 죽었다.");
						zergling[attack] = null;
						zergling_count++;
					}
				} 
				else 
				{
					System.out.println(attack+"번 저글링은 이미 죽어있다.");
				}
				choice = 1;
			}
			//공격이 저그
			else
			{
				int random;
				while(true) {
					int attack_r = r.nextInt(10);
					if(zergling[attack_r] != null) {
						random = attack_r;
						break;
					} 
				}
				int attack = r.nextInt(10);
				if(marine[attack] != null) 
				{
					marine[attack].damage(zergling[random].atk, attack);
					
					if(marine[attack].energy <= 0) 
					{
						System.out.println(attack+"번 마린이 죽었다.");
						marine[attack] = null;
						marine_count++;
					}
				} 
				else 
				{
					System.out.println(attack+"번 마린은 이미 죽어있다.");
				}
				choice = 0;
			}

			if(marine_count == 10 || zergling_count == 10) 
			{
				if(marine_count == 10) 
				{
					System.out.println("저그가 승리했다!");
					break;
				} 
				else 
				{
					System.out.println("테란이 승리했다!");
					break;
				}
			}

			for(int i=0; i<10; i++) 
			{
				if(marine[i] != null) 
				{
					System.out.print(i+"번 마린 "+marine[i].energy+"/ ");
				}
			}
			System.out.println();
			for(int i=0; i<10; i++) 
			{
				if(zergling[i] != null) 
				{
					System.out.print(i+"번 저글링 "+zergling[i].energy+"/ ");
				}
			}
			System.out.println();
			System.out.println("--------------------------");

			count++;
			/*
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			*/
		}

	}
}
