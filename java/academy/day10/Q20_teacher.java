package academy.day10;

import java.util.Random;
import java.util.Scanner;

public class Q20_teacher {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int[][] hosu = new int[5][5];

		int fishCount = 0;

		for (int i = 0; i < 3; i++) // 0 1
		{
			int y = rand.nextInt(5); // 3 3
			int x = rand.nextInt(5); // 2 2
			if (hosu[y][x] == 0) {
				hosu[y][x] = 1;

				System.out.println(y + ", " + x);
			} else {
				i--;
			}
		}

		int userX = -1;
		int userY = -1;
		while (userX < 0 || userX > 4 || userY < 0 || userY > 4) {
			System.out.print("��ǥ y, x�� �Է��ϼ��� : ");
			userY = sc.nextInt();
			userX = sc.nextInt();

			if (userX < 0 || userX > 4 || userY < 0 || userY > 4) {
				System.out.println("��ǥ�� ���� 0���� �۰ų� 4���� Ů�ϴ�. �߸��� ĳ�����Դϴ�.");
			}

		}

		if (hosu[userY][userX] == 1) {
			fishCount++;
			hosu[userY][userX] = 0;
			System.out.println("�����⸦ " + fishCount + "�� ��ҽ��ϴ�.");
		}

		while (fishCount < 3) {
			System.out.print("1. �� 2. �Ʒ� 3. ���� 4. ������ : ");
			int move = sc.nextInt();

			if (move == 1) // ��
			{
				userY--;
				if (userY == -1) {
					userY = 0;
					System.out.println("���̻� ���� ������ �� �����ϴ�.");
					continue;// �̰� �Ⱦ��� � ������ ���� ���?
				}
				System.out.println("y : " + userY + ", x :" + userX);
				if (hosu[userY][userX] == 1) {
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("�����⸦ " + fishCount + "�� ��ҽ��ϴ�.");
				}

			} else if (move == 2)// �Ʒ�
			{
				userY++;
				if (userY == 5) {
					userY = 4;
					System.out.println("���̻� �Ʒ��η� ������ �� �����ϴ�.");
					continue;// �̰� �Ⱦ��� � ������ ���� ���?
				}
				System.out.println("y : " + userY + ", x :" + userX);
				if (hosu[userY][userX] == 1) {
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("�����⸦ " + fishCount + "�� ��ҽ��ϴ�.");
				}
			} else if (move == 3)// ����
			{
				userX--;
				if (userX == -1) {
					userX = 0;
					System.out.println("���̻� �������� ������ �� �����ϴ�.");
					continue;// �̰� �Ⱦ��� � ������ ���� ���?
				}
				System.out.println("y : " + userY + ", x :" + userX);
				if (hosu[userY][userX] == 1) {
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("�����⸦ " + fishCount + "�� ��ҽ��ϴ�.");
				}
			} else if (move == 4)// ������
			{
				userX++;
				if (userX == 5) {
					userX = 4;
					System.out.println("���̻� ���������� ������ �� �����ϴ�.");
					continue;// �̰� �Ⱦ��� � ������ ���� ���?
				}

				System.out.println("y : " + userY + ", x :" + userX);

				if (hosu[userY][userX] == 1) {
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("�����⸦ " + fishCount + "�� ��ҽ��ϴ�.");
				}
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}

	}
}
