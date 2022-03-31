package academy.day18;
/* ���� 10����, ���۸� 10����
 * ������� �Լ�, ���� ������ ��Ȳ ��� �Լ�
 * �������� �����ϴ� ���� ���� // ���� or �׶�
 * �� �ȿ��� � �������� ������ �� �����ؼ� �����Ѵ�. ���� ��� ����.
 * �������� 0�� �Ǵ� ������ ������ ��ü �Ҹ�
 * ���� ���� ��� ��ü�� ������ �� ���� �������� �Ѿ��.
 * ������ ��ü�� 0�� �Ǹ� �����ϰ� �¸��� ���� ���
 */

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Unit10 {
	int price;
	int energy;
	int atk;
	int def;
	String object;
	double speed;
	String type;
}

class Zergling10 extends Unit10 {
	Zergling10() {
		price = 50;
		energy = 35;
		atk = 5;
		def = 0;
		object = "����";
		speed = 2.612;
		type = "����, ����, ��ü";
	}

	void damage(int a, int i) {
		this.energy -= a;
		System.out.println(i + "�� ���۸��� " + a + "�� �������� �Ծ���.");
	}
}

class Marine10 extends Unit10 {
	Marine10() {
		price = 50;
		energy = 50;
		atk = 6;
		def = 0;
		object = "����, ����";
		speed = 1.875;
		type = "����, ����, ��ü";
	}

	void damage(int a, int i) {
		this.energy -= a;
		System.out.println(i + "�� ������ " + a + "�� �������� �Ծ���.");
	}
}

public class Q42_star5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		Zergling10[] zergling = new Zergling10[10];
		Marine10[] marine = new Marine10[10];

		for (int i = 0; i < 10; i++) {
			zergling[i] = new Zergling10();
			marine[i] = new Marine10();
		}

		int count = 1;

		int marine_count = 0;
		int zergling_count = 0;
		int choice = r.nextInt(2);
		while (true) {

			System.out.println("---" + count + "��° ��Ȳ--------------");
			// ������ �׶�
			if (choice == 0) {
				int random;
				while (true) {
					int attack_r = r.nextInt(10);
					if (marine[attack_r] != null) {
						random = attack_r;
						break;
					}
				}
				int attack = r.nextInt(10);
				if (zergling[attack] != null) {
					zergling[attack].damage(marine[random].atk, attack);

					if (zergling[attack].energy <= 0) {
						System.out.println(attack + "�� ���۸��� �׾���.");
						zergling[attack] = null;
						zergling_count++;
					}
				} else {
					System.out.println(attack + "�� ���۸��� �̹� �׾��ִ�.");
				}
				choice = 1;
			}
			// ������ ����
			else {
				int random;
				while (true) {
					int attack_r = r.nextInt(10);
					if (zergling[attack_r] != null) {
						random = attack_r;
						break;
					}
				}
				int attack = r.nextInt(10);
				if (marine[attack] != null) {
					marine[attack].damage(zergling[random].atk, attack);

					if (marine[attack].energy <= 0) {
						System.out.println(attack + "�� ������ �׾���.");
						marine[attack] = null;
						marine_count++;
					}
				} else {
					System.out.println(attack + "�� ������ �̹� �׾��ִ�.");
				}
				choice = 0;
			}

			if (marine_count == 10 || zergling_count == 10) {
				if (marine_count == 10) {
					System.out.println("���װ� �¸��ߴ�!");
					break;
				} else {
					System.out.println("�׶��� �¸��ߴ�!");
					break;
				}
			}

			for (int i = 0; i < 10; i++) {
				if (marine[i] != null) {
					System.out.print(i + "�� ���� " + marine[i].energy + "/ ");
				}
			}
			System.out.println();
			for (int i = 0; i < 10; i++) {
				if (zergling[i] != null) {
					System.out.print(i + "�� ���۸� " + zergling[i].energy + "/ ");
				}
			}
			System.out.println();
			System.out.println("--------------------------");

			count++;
			/*
			 * try {
			 * TimeUnit.SECONDS.sleep(1);
			 * } catch(InterruptedException e) {
			 * e.printStackTrace();
			 * }
			 */
		}

	}
}
