package academy.day21;

import java.util.ArrayList;

class Animal1 {
	public void move() {
		System.out.println("������ �����Դϴ�.");
	}
}

class Human1 extends Animal1 {
	public void move() {
		System.out.println("����� �� �߷� �Ƚ��ϴ�.");
	}

	public void readBook() {
		System.out.println("����� å�� �н��ϴ�.");
	}
}

class Tiger1 extends Animal1 {
	public void move() {
		System.out.println("ȣ���̰� �� �߷� �ݴϴ�.");
	}

	public void hunting() {
		System.out.println("ȣ���̰� ����� �մϴ�.");
	}
}

class Eagle1 extends Animal1 {
	public void move() {
		System.out.println("�������� �ϴ��� ���ϴ�.");
	}

	public void flying() {
		System.out.println("�������� ������ �� ��� �ָ� ���ư��ϴ�.");
	}
}

public class AnimalTest {

	ArrayList<Animal1> aniList = new ArrayList<Animal1>();

	public void addAnimal() {
		aniList.add(new Human1());
		aniList.add(new Tiger1());
		aniList.add(new Eagle1());

		for (Animal1 ani : aniList) {
			ani.move();
		}
	}

	public void testCasting() {
		for (int i = 0; i < aniList.size(); i++) {
			Animal1 ani = aniList.get(i);
			if (ani instanceof Human1) {
				Human1 h = (Human1) ani;
				h.readBook();
			} else if (ani instanceof Tiger1) {
				Tiger1 t = (Tiger1) ani;
				t.hunting();
			} else if (ani instanceof Eagle1) {
				Eagle1 e = (Eagle1) ani;
				e.flying();
			} else {
				System.out.println("�������� �ʴ� ���Դϴ�.");
			}
		}
	}

	public static void main(String[] args) {
		AnimalTest aTest = new AnimalTest();
		aTest.addAnimal();
		System.out.println("���� ������ �ٿ� ĳ����");
		aTest.testCasting();
	}

}
