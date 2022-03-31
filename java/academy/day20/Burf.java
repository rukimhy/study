package academy.day20;

import java.util.Random;

public class Burf {

	void burf(Unit unit, Random r) {
		int random_burf = r.nextInt(3); // 0 ���ݷ¾�, 1 ü�¾�, 2 ü�´ٿ�
		int random_atk = r.nextInt(51) + 50;
		int random_energy = r.nextInt(101) + 100;

		// atkUP
		if (random_burf == 0) {
			System.out.println("���� : " + unit.name + "�� ���ݷ��� " + random_atk + "��ŭ �����ߴ�.");
			unit.set = unit.atk + random_atk;
		}
		// energyUP
		else if (random_burf == 1) {
			unit.energy += random_energy;
			System.out.println("���� : " + unit.name + "�� �������� " + random_energy + "��ŭ �����ߴ�.");
		}
		// energyDOWN
		else {
			unit.energy -= random_energy;
			System.out.println("����� : " + unit.name + "�� �������� " + random_energy + "��ŭ �����ߴ�.");
		}

	}
}
