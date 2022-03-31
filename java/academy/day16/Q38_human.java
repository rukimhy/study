package academy.day16;

import java.util.Random;
import java.util.Scanner;

class Gun {
}

class Human {
	Gun gun;

	void print() {
		if (gun != null) {
			System.out.println("���� ������ �ֽ��ϴ�.");
		} else {
			System.out.println("���� �����ϴ�.");
		}
	}
}

public class Q38_human {

	public static void main(String[] args) {
		/*
		 * ����� �� 5�� �ִ�. �� �� �������� �Ѹ��� ������ ��� �ִ�.
		 * ������ ������ �ִ� ����� ã���� ������ ������ ������.
		 */
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		Human[] human = new Human[5];
		Gun gun = new Gun();

		int gunRandom = r.nextInt(5);
		System.out.println((gunRandom + 1) + "���� ���� ������.");

		for (int i = 0; i < 5; i++) {
			human[i] = new Human();
		}

		human[gunRandom].gun = gun;
		gun = null;

		while (true) {
			System.out.print("1~5�� ���� �� ���� ���� ����� ã������ : ");
			int choice = scan.nextInt();
			human[choice - 1].print();
			if (human[choice - 1].gun != null)
				break;
		}
	}

}
