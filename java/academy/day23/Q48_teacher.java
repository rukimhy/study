package academy.day23;

import java.util.Random;

class Terran1 {
	Unit1[] u = new Unit1[10];
	A[] sm = new A[2];

	public Terran1() {
		// TODO Auto-generated constructor stub
		Random r = new Random();

		for (int i = 0; i < u.length; i++) {
			u[i] = (r.nextInt(2) == 0) ? new Marine1() : new Tank1();
		}

		sm[0] = new SCV1();
		sm[1] = new Medic1();

	}

	boolean check() {
		for (int i = 0; i < u.length; i++) {
			if (u[i] != null) {
				return false;
			}
		}
		return true;
	}

}

interface A {
	void handR(Unit1 u);
}

class Unit1 {
	private String name;
	private int hp;
	private int attack;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

}

interface Heal1 {

}

interface Repair1 {

}

class Marine1 extends Unit1 implements Heal1 {
	// ���� ���� �̸�, hp, attack
	Marine1() {
		super.setName("����");
		super.setHp(50);
		super.setAttack(6);
	}

	// ����
	void shootAttack(Unit1 u) {
		if (u != null) {
			u.setHp(u.getHp() - super.getAttack());
			System.out.println(u.getName() + "�� �������� " + u.getHp() + "�Դϴ�.");
		} else {
			System.out.println("�̹� �׾��ֽ��ϴ�.");
		}
	}

}

class Tank1 extends Unit1 implements Repair1 {
	// ��ũ ���� �̸�, hp, attack
	Tank1() {
		super.setName("��ũ");
		super.setHp(45);
		super.setAttack(4);
	}

	// ����
	void shootAttack(Unit1[] u, int index) {
		for (int i = index + 1; i >= index - 1; i--) {
			if (!(i < 0 || i >= 10)) {
				if (u[i] != null) {
					u[i].setHp(u[i].getHp() - super.getAttack());
					System.out.println(u[i].getName() + "�� �������� " + u[i].getHp() + "�Դϴ�.");
					if (u[i].getHp() <= 0) {
						u[i] = null;
					}
				} else {
					System.out.println("�̹� �׾��ֽ��ϴ�.");
				}
			}
		}
	}
}

class Medic1 implements A {

	public void handR(Unit1 u) {
		if (u != null) {
			if (u instanceof Marine1) {
				u.setHp(u.getHp() + 5);
				if (u.getHp() > 50) {
					u.setHp(50);
				}
				System.out.println("�ŵ���" + u.getName() + "�� �������� " + u.getHp() + "�� ġ�Ḧ �߽��ϴ�.");
			} else {
				System.out.println("��ũ�� ġ�Ḧ �� �� �����ϴ�.");
			}
		} else {
			System.out.println("�̹� �׾����ϴ�.");
		}
	}

}

class SCV1 implements A {
	// �����
	public void handR(Unit1 u) {
		if (u != null) {
			if (u instanceof Tank1) {
				u.setHp(u.getHp() + 5);
				if (u.getHp() > 45) {
					u.setHp(45);
				}
				System.out.println("SCV��" + u.getName() + "�� �������� " + u.getHp() + "�� ������ �߽��ϴ�.");
			} else {
				System.out.println("�����̶� ������ �� �� �����ϴ�.");
			}
		} else {
			System.out.println("�̹� �׾����ϴ�.");
		}
	}
}

public class Q48_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Terran1[] t = new Terran1[2];

		for (int i = 0; i < t.length; i++) {
			t[i] = new Terran1();
		}

		// 1. ���� 2. ���Ǵ� ���� 3. null üũ 4. marine �������� Ȯ���ؼ� null set

		int turn = 1;

		Random r = new Random();

		while (true) {
			int attck = r.nextInt(10);
			int horR = r.nextInt(10);
			int def = r.nextInt(10);
			int selSM = r.nextInt(2);

			System.out.println("�� : " + turn + "�Դϴ�.");

			if (turn % 2 == 1) {
				System.out.println("��1 ����");
				if (t[0].u[attck] instanceof Marine1) {
					Marine1 m = (Marine1) t[0].u[attck];
					m.shootAttack(t[1].u[def]);

					if (t[1].u[def] != null && t[1].u[def].getHp() <= 0) {
						t[1].u[def] = null;
					}
					t[0].sm[selSM].handR(t[0].u[horR]);

				} else {
					System.out.println("��2 ����");
					Tank1 tank = (Tank1) t[0].u[attck];
					if (tank != null) {
						tank.shootAttack(t[1].u, def);
					}
					t[0].sm[selSM].handR(t[0].u[horR]);
				}

			} else {
				if (t[1].u[attck] instanceof Marine1) {
					Marine1 m = (Marine1) t[1].u[attck];
					m.shootAttack(t[0].u[def]);

					if (t[0].u[def] != null && t[0].u[def].getHp() <= 0) {
						t[0].u[def] = null;
					}
					t[1].sm[selSM].handR(t[1].u[horR]);
				} else {
					Tank1 tank = (Tank1) t[1].u[attck];
					if (tank != null) {
						tank.shootAttack(t[0].u, def);
					}
					t[1].sm[selSM].handR(t[1].u[horR]);
				}
			}

			if (t[0].check()) {
				System.out.println("�׶� 2���� �¸��߽��ϴ�.");
				break;
			}
			if (t[1].check()) {
				System.out.println("�׶� 1���� �¸��߽��ϴ�.");
				break;
			}

			turn++;
		}
	}

}