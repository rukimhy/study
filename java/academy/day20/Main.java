package academy.day20;

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

		while (battle.check(knight, villain)) {
			System.out.println(count + "��° ��Ⱑ ���۵˴ϴ�.");
			System.out.println("=====================================");

			if (count % 2 == 1) {
				burf.burf(knight, r);
				battle.attack(knight, villain);

			} else {
				burf.burf(villain, r);
				battle.attack(villain, knight);
			}
			System.out.println("��� ü�� : " + knight.energy + " // ��� ���ݷ� : " + knight.atk + " // �Ǵ� ü�� : "
					+ villain.energy + " // �Ǵ� ���ݷ� : " + villain.atk);

			count++;
			System.out.println("=====================================");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
