package academy.day15;

import java.util.Random;
import java.util.Scanner;

//������
class Fish {

}

// ȣ��
class Hosu {
	Fish[][] hosu = new Fish[5][5];

	// ������ �����۾�
	void randomFish() {
		Random rand = new Random();
		for (int i = 0; i < 3; i++) // 0 1
		{
			int y = rand.nextInt(5); // 3 3
			int x = rand.nextInt(5); // 2 2
			if (hosu[y][x] == null) {
				hosu[y][x] = new Fish();

				System.out.println(y + ", " + x);
			} else {
				i--;
			}
		}
	}

	// ������ �ִ��۾� ���òۿ���
	Fish sendFish(int userY, int userX) {
		return hosu[userY][userX];
	}

	void nullFish(int userY, int userX) {
		hosu[userY][userX] = null;
	}

	public void fishPrint() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (hosu[i][j] == null) {
					System.out.print(0 + "	");
				} else {
					System.out.print(1 + "	");
				}
			}
			System.out.println();
		}
	}

}

// ���ò�
class Fisher {
	int userY;
	int userX;
	Fish[] fishbowl = new Fish[3];
	int count = 0;

	// ĳ����
	public void casting() {
		Scanner sc = new Scanner(System.in);
		// �ѹ� �ϳ��ۿ� ���� �� �����ϱ� ���� 2���̻� ���� �� �ִ� �迭�� ����Ѵ�.
		userX = -1;
		userY = -1;

		while (userX < 0 || userX > 4 || userY < 0 || userY > 4) {
			System.out.print("��ǥ y, x�� �Է��ϼ��� : ");
			userY = sc.nextInt();
			userX = sc.nextInt();

			if (userX < 0 || userX > 4 || userY < 0 || userY > 4) {
				System.out.println("��ǥ�� ���� 0���� �۰ų� 4���� Ů�ϴ�. �߸��� ĳ�����Դϴ�.");
			}

		}
	}

	// �̵�
	public void move(int move) {
		int[] temp = new int[2]; // �Լ��� �ϳ��� ���� �� �ֱ� ������ �ΰ��� userY�� userX�� ������ �ϱ� ������
		// �迭�� ����
		if (move == 1) // ��
		{
			userY--;
			if (userY == -1) {
				userY = 0;
				System.out.println("���̻� ���� ������ �� �����ϴ�.");
			}

		} else if (move == 2)// �Ʒ�
		{
			userY++;
			if (userY == 5) {
				userY = 4;
				System.out.println("���̻� �Ʒ��η� ������ �� �����ϴ�.");
			}
		} else if (move == 3)// ����
		{
			userX--;
			if (userX == -1) {
				userX = 0;
				System.out.println("���̻� �������� ������ �� �����ϴ�.");
			}
		} else if (move == 4)// ������
		{
			userX++;
			if (userX == 5) {
				userX = 4;
				System.out.println("���̻� ���������� ������ �� �����ϴ�.");
			}
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}

	// ������ ������ �ֱ�
	boolean fishRecive(Fish f) {
		if (f != null) {
			fishbowl[count] = f;
			count++;
			System.out.println("�����⸦ " + count + "�� ��ҽ��ϴ�.");
			return true;
		} else {
			return false;
		}

	}

	// ������ ������ üũ
	boolean fishCheck() {
		int check = 0;
		for (int i = 0; i < 3; i++) {
			if (fishbowl[i] != null) {
				check++;
			}
		}

		if (check == 3) {
			return false;
		} else
			return true;
	}

	void fisherPrint() {
		System.out.println("���� ���ò��� ��ġ : " + userY + ", " + userX);
	}

}

public class Q36_teacher {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean check = true;
		Hosu h = new Hosu();
		Fisher man = new Fisher();

		h.randomFish();

		man.casting();

		if (man.fishRecive(h.sendFish(man.userY, man.userX))) {
			h.nullFish(man.userY, man.userX);
		}

		check = man.fishCheck();

		while (check) {
			System.out.print("1. �� 2. �Ʒ� 3. ���� 4. ������ : ");
			int move = sc.nextInt();

			man.move(move);
			if (man.fishRecive(h.sendFish(man.userY, man.userX))) {
				h.nullFish(man.userY, man.userX);
			}

			man.fisherPrint();
			check = man.fishCheck();
		}

	}
}
