package day20;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		Unit knight = new Knight();
		Unit villain = new Villain();
		Burf burf = new Burf();
		Battle battle = new Battle();
		
		int random = -1;
		int count = 1;
		boolean check = true;
		
		while(battle.check(knight, villain)) {
			System.out.println(count+"번째 경기가 시작됩니다.");
			System.out.println("=====================================");
			
			if(count % 2 == 1) {
				burf.burf(knight, r);				
				battle.attack(knight, villain);

			} else {
				burf.burf(villain, r);
				battle.attack(villain, knight);
			}
			System.out.println("기사 체력 : "+knight.energy+" // 기사 공격력 : "+knight.atk+" // 악당 체력 : "+villain.energy+" // 악당 공격력 : "+villain.atk);
			
			count++;
			System.out.println("=====================================");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
