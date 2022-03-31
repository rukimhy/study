package academy.day18;
/* ���ֿ� ����, ������, ���ݷ�, ����, ���ݴ��, �ӵ�, ������ �ִ�.
 * ������ ��ӹ��� Ŭ������ ����Ʈ�ϴ� ����� �ִ�.
 * ���۸� - 50, 35, 5, 0, "����", 2.612, "����, ����, ��ü"
 * ����� - 100, 80, 10, 0, "����, ����", 1.742, "����, ����, ��ü"
 * ��Ŀ - 250, 125, 20, 1, "����", 2.813, "����, ����, ��ü"
 * ���� - 50, 50, 6, 0, "����, ����", 1.875, "����, ����, ��ü"
 * ���̾�� - 75, 50, 16, 1, "����", 1.875, "����, ����, ��ü"
 * ����Ʈ ��� - �� ������ �� �����鼭 �����̸��� �� ������ ���
 */

class unit {
	int price;
	int energy;
	int atk;
	int def;
	String object;
	double speed;
	String type;
}

class Zergling extends unit {
	Zergling() {
		price = 50;
		energy = 35;
		atk = 5;
		def = 0;
		object = "����";
		speed = 2.612;
		type = "����, ����, ��ü";
	}

	void print() {
		System.out.println(
				"���۸� " + price + " " + energy + " " + atk + " " + def + " " + object + " " + speed + " " + type);
	}
}

class Hydra extends unit {
	Hydra() {
		price = 100;
		energy = 80;
		atk = 10;
		def = 0;
		object = "����, ����";
		speed = 1.742;
		type = "����, ����, ��ü";
	}

	void print() {
		System.out.println(
				"����� " + price + " " + energy + " " + atk + " " + def + " " + object + " " + speed + " " + type);
	}
}

class Lurker extends unit {
	Lurker() {
		price = 250;
		energy = 125;
		atk = 20;
		def = 1;
		object = "����";
		speed = 2.813;
		type = "����, ����, ��ü";
	}

	void print() {
		System.out.println(
				"��Ŀ " + price + " " + energy + " " + atk + " " + def + " " + object + " " + speed + " " + type);
	}
}

class Marine extends unit {
	Marine() {
		price = 50;
		energy = 50;
		atk = 6;
		def = 0;
		object = "����, ����";
		speed = 1.875;
		type = "����, ����, ��ü";
	}

	void print() {
		System.out.println(
				"���� " + price + " " + energy + " " + atk + " " + def + " " + object + " " + speed + " " + type);
	}
}

class Firebat extends unit {
	Firebat() {
		price = 75;
		energy = 50;
		atk = 16;
		def = 1;
		object = "����";
		speed = 1.875;
		type = "����, ����, ��ü";
	}

	void print() {
		System.out.println(
				"���̾�� " + price + " " + energy + " " + atk + " " + def + " " + object + " " + speed + " " + type);
	}
}

class Collection {
	Zergling zergling = new Zergling();
	Hydra hydra = new Hydra();
	Lurker lurker = new Lurker();
	Marine marine = new Marine();
	Firebat firebat = new Firebat();
}

public class Q41_starcraft {

	public static void main(String[] args) {
		/*
		 * Zergling zergling = new Zergling();
		 * Hydra hydra = new Hydra();
		 * Lurker lurker = new Lurker();
		 * Marine marine = new Marine();
		 * Firebat firebat = new Firebat();
		 * 
		 * zergling.print();
		 * hydra.print();
		 * lurker.print();
		 * marine.print();
		 * firebat.print();
		 */
		Collection collect = new Collection();
		collect.zergling.print();
		collect.hydra.print();
		collect.lurker.print();
		collect.marine.print();
		collect.firebat.print();
	}

}
