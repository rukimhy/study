package academy.day12;

import java.util.Random;
import java.util.Scanner;

public class Q25_teacher {

	// 3������
	public static int[][] fishRandom() {
		Random rand = new Random();
		int[][] hosu = new int[5][5];
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

		return hosu;
	}

	// 3�� ����
	public static int[] casting() {
		Scanner sc = new Scanner(System.in);
		int[] temp = new int[2]; // Y, X ���� ���ÿ� ������ ���ֱ� ���ؼ� �迭�� �̿��ؼ� �������Ѵ�.
		// �ѹ� �ϳ��ۿ� ���� �� �����ϱ� ���� 2���̻� ���� �� �ִ� �迭�� ����Ѵ�.
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
		// ĳ���� �� userY�� userX�� temp �迭�� [0] [1]���� ��Ƽ� �����Ѵ�.
		temp[0] = userY;
		temp[1] = userX;
		return temp;
	}

	// 2�� ����
	public static void fishPrint(int[][] hosu) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(hosu[i][j] + "	");
			}
			System.out.println();
		}
	}

	// 1�� ����
	public static int[] move(int move, int userY, int userX) {
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

		temp[0] = userY; // temp[0] -> userY
		temp[1] = userX; // temp[1] -> userX
		return temp; // temp�迭�� ����
	}

	// 1�� ����
	public static int check(int[][] hosu, int userY, int userX) {

		if (hosu[userY][userX] == 1) // ȣ�� �迭�� �����Ⱑ �ִ��� Ȯ��
		{
			hosu[userY][userX] = 0; // ȣ�� �迭�� ���� 0���� �����ؼ� �����⸦ ����
			return 1;// 1�� ����
		}
		return 0;// 0�� ����
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] hosu = fishRandom();
		fishPrint(hosu);
		int userY = 0;
		int userX = 0;
		int fishCount = 0;

		int[] cast = casting(); // ĳ���� �Լ����� ������ �迭�� cast�迭�� �޴´�.

		userY = cast[0]; // cast �迭[0]�� �ִ� ���� userY�� ����
		userX = cast[1]; // cast �迭[1]�� �ִ� ���� userX�� ����

		// ĳ���� ������ �ٷ� �����Ⱑ �ִ��� Ȯ���ϴ� �Լ�
		if (hosu[userY][userX] == 1) {
			fishCount++;
			hosu[userY][userX] = 0;
			System.out.println("�����⸦ " + fishCount + "�� ��ҽ��ϴ�.");
		}

		// �����Ⱑ 3���� ������ ���� ��� �ݺ�
		while (fishCount < 3) {
			System.out.print("1. �� 2. �Ʒ� 3. ���� 4. ������ : ");
			int move = sc.nextInt();

			int[] temp = move(move, userY, userX); // ���ô� �������� ���� ��� ���� temp�迭�� �޽��ϴ�.
			userY = temp[0]; // temp[0] -> userY
			userX = temp[1]; // temp[1] -> userX

			System.out.println("y : " + userY + ", x :" + userX);
			// üũ�Լ��� ȣ���ؼ� �����⸦ ��Ҵ��� Ȯ��
			int num = check(hosu, userY, userX); // üũ�� ���� ��� ���� num������ �޽��ϴ�.

			if (num == 1) // num�� 1�̸� �����⸦ ���� ����
			{
				fishCount += num;// ������ ī���͸� 1 ����
				System.out.println("�����⸦ " + fishCount + "�� ��ҽ��ϴ�."); // ���
			}

		}

	}
}
