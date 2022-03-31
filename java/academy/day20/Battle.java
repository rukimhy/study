package academy.day20;

public class Battle {

	void attack(Unit a, Unit b) {
		System.out.println(a.name + "�� ����!!");
		b.energy -= a.set;
		System.out.println(b.name + "�� ü���� " + b.energy + " ��ŭ ���Ҵ�.");
		a.set = a.atk;
	}

	boolean check(Unit a, Unit b) {
		if (a.energy <= 0 || b.energy <= 0) {
			if (a.energy > 0) {
				System.out.println(a.name + "�� �¸�!");
			} else {
				System.out.println(b.name + "�� �¸�!");
			}
			return false;
		}
		return true;
	}
}
