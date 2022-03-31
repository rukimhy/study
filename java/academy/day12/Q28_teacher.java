package academy.day12;

import java.util.Scanner;

public class Q28_teacher {
	public static void guide() {
		System.out.println("����� ���� ���α׷��Դϴ�.");
		System.out.print("1.���� 2.���¼� Ȯ�� 3. ���� : ");
	}

	public static boolean triger(int N) {
		if (N == 16) // ���� �� á�� ���� Ʈ����
		{
			System.out.println("�˼��մϴ�. ��� �¼��� ���Ű� �������ϴ�.");
			return false;
		}
		return true;
	}

	public static int input() {
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		return str;
	}

	public static int[] input2() {
		int[] temp = new int[2];
		Scanner sc = new Scanner(System.in);
		System.out.print("�¼��� �����ϼ���. : ");
		int R = sc.nextInt();
		int C = sc.nextInt();

		temp[0] = R;
		temp[1] = C;

		return temp;
	}

	public static boolean failCheck(int[] input) {
		if (input[0] > 7 || input[0] < 0 || input[0] > 1 || input[1] < 0) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return false;
		}
		return true;
	}

	public static int reserve(boolean[][] seat, int R, int C) {
		if (seat[R][C] == true) {
			System.out.println("�̹� ����� �¼��Դϴ�.");
		}
		if (seat[R][C] == false) {
			seat[R][C] = true;
			System.out.println(R + "��" + C + "�� ������ �Ϸ�Ǿ����ϴ�.");
			return 1;
		}

		return 0;

	}

	public static void allPrint(boolean[][] seat) {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[2].length; j++)
				if (seat[i][j] == false) // boolean �迭�� �ʱⰪ�� false �� �ʱ�ȭ �ǹǷ� false�� ���¼�
				{
					System.out.println(i + "��" + j + "�� �� ����ֽ��ϴ�. ");
				}
		}
	}

	public static void P() {

		boolean[][] seat = new boolean[8][2]; // true ���� false �� ���ڸ�

		int N = 0;

		while (true) {

			guide();
			int str = input();

			if (str == 1) {
				boolean maxCheck = triger(N);
				if (maxCheck) {
					int[] temp = input2();
					boolean inputCheck = failCheck(temp);
					if (inputCheck) {
						N += reserve(seat, temp[0], temp[1]);
					}
				} else {
					N = 16;
				}
			} else if (str == 2) {
				allPrint(seat);
			} else if (str == 3) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	public static void main(String[] args) {
		P();

	}
}
