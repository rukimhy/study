package academy.day12;

import java.util.Scanner;

public class Q28_bookingFunc {

	// 1. ����
	public static int book(int arr[][], int count) {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 2; j++) {
				if (arr[i][j] == 1)
					count++;
			}
		}
		if (count == 16) {
			System.out.println("��� �¼��� ���Ű� �������ϴ�.");
		} else {
			System.out.print("�¼��� �������ּ��� : ");
			int x = scan.nextInt();
			int y = scan.nextInt();

			if (x > 7 || x < 0 || y > 1 || y < 0) {
				System.out.println("�߸��� �Է��Դϴ�.");
			} else if (arr[x][y] == 1) {
				System.out.println("�̹� ����� �¼��Դϴ�.");
			} else {
				System.out.println("�¼��� ����Ǿ����ϴ�.");
				arr[x][y] = 1;
			}
		}
		return count;
	}

	// 2. �� �¼� Ȯ��
	public static void check(int arr[][]) {
		System.out.println("-----����ִ� �¼���-----");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 2; j++) {
				if (arr[i][j] == 0) {
					System.out.print(i + "�� " + j + " �� // ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-------------------------");
	}

	// 3. output
	public static void output() {
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[8][2];

		System.out.println("����� ���� ���α׷��Դϴ�.");

		while (true) {
			int count = 0;
			System.out.println("1. ����");
			System.out.println("2. �� �¼� Ȯ��");
			System.out.println("3. ����");
			System.out.print("�޴��� �������ּ��� : ");
			int user = scan.nextInt();

			if (user != 1 && user != 2 && user != 3) {
				System.out.println("�߸��� �Է��Դϴ�.");
			} else if (user == 3) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (user == 2) {
				check(arr);
			} else {
				count = book(arr, count);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 18�� ���� �ּ� 3�� �̻��� �Լ��� ����
		output();
	}

}
