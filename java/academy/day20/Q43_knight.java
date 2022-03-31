package academy.day20;
/* ���� �Ǵ� ����
 * ������ ��ӹ޾Ƽ� ���� �Ǵ��� �����.
 * ���� �̸�, ���ݷ�, ������ - ���, 100, 1000
 * �Ǵ��� �̸�, ���ݷ�, ������ - �Ǵ�, 100, 1000
 * �� �����ư��鼭 ��� ���� ���� �Ǵ� ����
 * ���� �� ������ ���� ������ �Ǿ� �Ѵ�. ������ ���ݷ¾�(���ݷ� 50~100 ����), ��(������ 100~200 ����), ������ �ٿ�(����� 100~200 ����)
 * ���� �Ǵ��� ������ �ϸ� ����� ���� ������ ���;��Ѵ�.
 * ���ݽÿ��� ��糪 �Ǵ��� �����̶�� ������ ����� �ǰ�, ���ϴ� ������ �������� �ϸ��� ��µž��Ѵ�.
 * �� �� �ϳ��� �������� 0 ���ϰ� �Ǹ� ������ ����Ǹ鼭 "���� : XXX"�� ��µȴ�.
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
