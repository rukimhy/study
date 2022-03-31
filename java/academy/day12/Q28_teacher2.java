package academy.day12;

import java.util.Scanner;

public class Q28_teacher2 {

	public static int one(int[][] seat, int count) {
		Scanner sc = new Scanner(System.in);// �Է� ��ü
		// �Լ�
		if (count == 16) {
			System.out.println("��� �¼��� ���� �ƽ��ϴ�.");
		}
		System.out.print("�¼��� �����ϼ��� : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if (seat[num1][num2] == 0) {
			seat[num1][num2] = 1;
			System.out.println((num1 + 1) + "��" + (num2 + 1) + "��° �ڸ��� ���� �ƽ��ϴ�.");
			return 1; // 1
		} else {
			System.out.println("�̹� ����� �¼��Դϴ�.");
			return 0;
		}
	}

	public static void two(int[][] seat) {
		// �Լ�
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 2; j++) {
				if (seat[i][j] == 0) {
					System.out.println((i + 1) + "��" + (j + 1) + "��° �ڸ��� ����ֽ��ϴ�.");
				}
			}
		}
	}

	public static boolean three() {
		// �Լ�
		System.out.println("���α׷��� �����մϴ�.");
		return false;
	}

	public static void four() {
		// �Լ�
		System.out.println("�߸��� �Է��Դϴ�.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);// �Է� ��ü
		int[][] seat = new int[8][2]; // �Լ��� ������ �ҽ��� �����
		int count = 0; // ������
		boolean check = true;

		while (check) // sel �������� ������ 3 �Է½� ���� ��Ű�� �˴ϴ�. true
		{
			// �Լ�
			System.out.print("1. ���� 2. ���¼� Ȯ�� 3. ���� :");
			int sel = sc.nextInt();

			if (sel == 1) {
				count += one(seat, count);

			} else if (sel == 2) {
				two(seat);
			} else if (sel == 3) {
				check = three();
			} else {
				four();
			}
		}

	}
}
