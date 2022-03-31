package academy.day11;

import java.util.Random;
import java.util.Scanner;

public class Q25_fishing {

	// 3��(�ְ� �ȹް�) ������ ������ ����
	public static int[][] randomArr() {
		Random r = new Random();
		int[][] arr = new int[5][5];
		int fish_count = 0;

		while (true) {
			int fishX = r.nextInt(5);
			int fishY = r.nextInt(5);
			if (arr[fishX][fishY] == 0) {
				arr[fishX][fishY] = 1;
				fish_count++;
			}
			if (fish_count == 3)
				break;
		}

		return arr;
	}

	// 3��(�ְ� �ȹް�) ĳ����
	public static int[] casting() {
		Scanner scan = new Scanner(System.in);
		int x, y;
		int user_count = 0;

		while (true) {
			System.out.println("������ ��� ������ �����մϴ�.");
			System.out.print("��ǥ x, y�� �Է��ϼ��� : ");
			x = scan.nextInt();
			y = scan.nextInt();

			if (x > 4 || x < 0 || y > 4 || y < 0) {
				System.out.println("�߸��� ĳ�����Դϴ�.");
				System.out.println();
			} else
				break;

		}

		int[] new_arr = new int[] { x, y, user_count };

		return new_arr;
	}

	// 2��(���ְ� �ް�) �����Ⱑ �ִ� ��ġ ���
	public static void whereFish(int arr[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	// 1��(�ְ� �ް�) ���ô� �̵�
	public static int[] move(int x, int y, int user_count, int[][] arr) {
		Scanner scan = new Scanner(System.in);

		System.out.print("[1]�� [2]�Ʒ� [3]���� [4]������ : ");
		int choice = scan.nextInt();

		if (choice < 1 || choice > 4)
			System.out.println("�߸��� �Է��Դϴ�.");
		else {
			if (choice == 1) {
				if (x - 1 < 0) {
					System.out.println("�� �̻� �̵��� �� �����ϴ�.");
				} else
					x--;
			} else if (choice == 2) {
				if (x + 1 > 4) {
					System.out.println("�� �̻� �̵��� �� �����ϴ�.");
				} else
					x++;
			} else if (choice == 3) {
				if (y - 1 < 0) {
					System.out.println("�� �̻� �̵��� �� �����ϴ�.");
				} else
					y--;
			} else {
				if (y + 1 > 4) {
					System.out.println("�� �̻� �̵��� �� �����ϴ�.");
				} else
					y++;
			}

		}

		System.out.println();
		int[] new_arr = new int[] { x, y };
		return new_arr;
	}

	// 1��(�ְ� �ް�) ������ �ִ� üũ �Լ�
	public static int[] check(int x, int y, int user_count, int[][] arr) {

		if (arr[x][y] == 1) {
			user_count++;
			System.out.println("������ " + user_count + "������ ��ҽ��ϴ�.");
			arr[x][y] = 0;
		}
		if (user_count == 3) {
			System.out.println("�����մϴ�. 3���� �� ��ҽ��ϴ�.");
		}
		int[] new_arr = new int[] { arr[x][y], user_count };
		return new_arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ���� �Լ�ȭ // �Լ� �� 5��

		int[][] arr = randomArr();
		whereFish(arr);

		int[] casting = casting();
		int[] check_arr = check(casting[0], casting[1], casting[2], arr);
		int x = casting[0];
		int y = casting[1];
		int user_count = check_arr[1];

		while (true) {
			int[] move_arr = move(x, y, user_count, arr);
			x = move_arr[0];
			y = move_arr[1];

			check_arr = check(x, y, user_count, arr);
			arr[x][y] = check_arr[0];
			user_count = check_arr[1];

			if (user_count == 3)
				break;
		}

	}

}
