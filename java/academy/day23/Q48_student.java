package academy.day23;

import java.util.Random;

/*
 * �׶� �� �׶�
 * �� ���� : �޵� 1�� SCV 1�� ( ���� )
 * �������� ��ũ�� �������� 10���� ������ �ȴ�.
 * 1�� -> 2�� ������ ������ ������ �����Ѵ�.
 * �ڱ� ���� �� ���ݰ� ���� �Ǵ� ���� �Ѵ�. -> ���� + (���� or ��)
 * ������ �������� �������� �ε����� �ִ� ������ ������ �Ѵ�.
 * ���� �Ǵ� ���� �������� �������� �ε��� ������ ���� �Ǵ� ���� �մϴ�.
 * ������ ���� ���� ���õ� �������� �Ѵ�.
 * ������ ���� ���� 5�� ���� �����ݴϴ�.
 * ���� �������� Ǯ�̸� �������� �ʽ��ϴ�.
 * 
 * ���� : ������(50), ���ݷ�(6)
 * ��ũ : ������(45), ���ݷ�(4) -> ���÷��� ������, ���ݴ�� �ε��� ��,�Ʒ� ��� ������ �޽��ϴ�.
 * ���������� ��Ƴ��� ���� ����Դϴ�.
 * �׶� 1��
 * �׶� 2��
 * */

class Terran2 {
	AttUnit[] unit = new AttUnit[10];
	Backup[] backup = new Backup[2];

	Terran2() {
		Random r = new Random();

		for (int i = 0; i < unit.length; i++) {
			unit[i] = (r.nextInt(2) == 0) ? new Marine2() : new Tank2();
		}

		backup[0] = new Medic2();
		backup[1] = new SCV2();
	}

	void attack(AttUnit[] enemy) {
		Random r = new Random();

		int i = r.nextInt(unit.length);

		if (unit[i] != null) {
			unit[i].attack(enemy);
		} else {
			System.out.println(" >> ���� ���� : �츮 ���� ������ �̹� ���� �����Դϴ�.");
		}
	}

	void healOrRepair() {
		Random r = new Random();
		int bIndex = r.nextInt(2);
		int aIndex = r.nextInt(unit.length);
		if (unit[aIndex] != null) {
			backup[bIndex].healOrRepair(unit[aIndex]);
		}

	}

}

interface Backup {
	void healOrRepair(AttUnit object);
}

class Medic2 implements Backup {
	public void healOrRepair(AttUnit object) {
		if (object instanceof Marine2) {
			if (object.getEnergy() != 50) {
				object.setEnergy(object.getEnergy() + 5);

				if (object.getEnergy() > 50) {
					object.setEnergy(50);
				}
				System.out.println(" > �޵��� ������ ġ���߽��ϴ�.");
			} else {
				System.out.println("\t >> �ش� ��ü�� �������� �̹� full�Դϴ�.");
			}
		} else {
			System.out.println("\t >> �޵��� ��ũ�� ������ �� �����ϴ�.");
		}
	}
}

class SCV2 implements Backup {
	public void healOrRepair(AttUnit object) {
		if (object instanceof Tank2) {
			if (object.getEnergy() != 45) {
				object.setEnergy(object.getEnergy() + 5);

				if (object.getEnergy() > 45) {
					object.setEnergy(45);
				}
				System.out.println(" > SCV�� ��ũ�� �����߽��ϴ�.");
			} else {
				System.out.println("\t >> �ش� ��ü�� �������� �̹� full�Դϴ�.");
			}
		} else {
			System.out.println("\t >> SCV�� ������ ġ�� �� �� �����ϴ�.");
		}
	}
}

abstract class AttUnit {
	String name;
	int energy;
	int power;

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public String getName() {
		return name;
	}

	abstract void attack(AttUnit[] object);
}

class Marine2 extends AttUnit {
	Marine2() {
		super.name = "����";
		super.energy = 50;
		super.power = 6;
	}

	void attack(AttUnit[] enemy) {
		Random r = new Random();
		int i = r.nextInt(10);
		System.out.println(" > " + this.name + "�� ����!");
		if (enemy[i] != null) {
			enemy[i].setEnergy(enemy[i].getEnergy() - this.power);
			System.out
					.println("\t ��� " + enemy[i].getName() + "�� �������� " + enemy[i].getEnergy() + "��ŭ ���ҽ��ϴ�.");
			if (enemy[i].getEnergy() < 0) {
				System.out.println(" << ���" + enemy[i].getName() + "��/�� �׾����ϴ�.>>");
			}
		} else {
			System.out.println("\t >> ���� ���� : ��� ������ �̹� ���� �����Դϴ�.");
		}
	}
}

class Tank2 extends AttUnit {
	Tank2() {
		super.name = "��ũ";
		super.energy = 45;
		super.power = 4;
	}

	void attack(AttUnit[] enemy) {
		Random r = new Random();
		int choice = r.nextInt(10);

		for (int i = choice + 1; i >= choice - 1; i--) {
			if (i >= 0 && i < 10) {
				System.out.println(" > " + this.name + "�� ����!");
				if (enemy[i] != null) {
					enemy[i].setEnergy(enemy[i].getEnergy() - this.power);
					System.out.println("\t ��� " + enemy[i].getName() + "[" + i + "] �� �������� "
							+ enemy[i].getEnergy() + "��ŭ ���ҽ��ϴ�.");
					if (enemy[i].getEnergy() < 0) {
						System.out.println(" << ���" + enemy[i].getName() + "��/�� �׾����ϴ�.>>");
						enemy[i] = null;
					}
				} else {
					System.out.println("\t >> ���� ���� : ��� ������ �̹� ���� �����Դϴ�.");
				}
			}
		}

	}
}

class Game {
	Game() {
		Terran2[] team = new Terran2[2];

		for (int i = 0; i < team.length; i++) {
			team[i] = new Terran2();
		}

		int turn = 0;
		int our = 1;
		while (true) {
			turn++;
			our = (our == 0) ? 1 : 0;
			int enemy = (our == 0) ? 1 : 0;
			System.out.println("\n\n=============== �׶� " + (our + 1) + "���� " + turn + " ��° �� ===============");
			team[our].attack(team[enemy].unit);
			if (checkEnd(team[enemy].unit)) {
				System.out.println(" \n>>> �׶� " + (our + 1) + " ���� �¸�!");
				break;
			}
			team[our].healOrRepair();

		}
	}

	boolean checkEnd(AttUnit[] object) {
		for (int i = 0; i < object.length; i++) {
			if (object[i] != null)
				return false;
		}
		return true;
	}
}

public class Q48_student {

	public static void main(String[] args) {

		new Game();
	}

}
