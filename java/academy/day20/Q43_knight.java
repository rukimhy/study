package day20;
/* 기사와 악당 게임
 * 유닛을 상속받아서 기사와 악당을 만든다.
 * 기사는 이름, 공격력, 에너지 - 기사, 100, 1000
 * 악당은 이름, 공격력, 에너지 - 악당, 100, 1000
 * 턴 번갈아가면서 기사 공격 이후 악당 공격
 * 공격 시 버프가 먼저 실행이 되야 한다. 버프는 공격력업(공격력 50~100 증가), 힐(에너지 100~200 증가), 에너지 다운(디버프 100~200 감소)
 * 기사와 악당이 공격을 하면 기사의 버프 내용이 나와야한다.
 * 공격시에는 기사나 악당의 공격이라는 문구가 출력이 되고, 당하는 상대방의 에너지가 턴마다 출력돼야한다.
 * 둘 중 하나의 에너지가 0 이하가 되면 게임이 종료되면서 "승자 : XXX"가 출력된다.
 * Battle.java // Burf.java // Knight.java // Main.java // Unit.java // Villain.java
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Q43_knight {

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
