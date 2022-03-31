package academy.day9;

import java.util.Random;
import java.util.Scanner;

public class Q20_5x5Lake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 5x5 ũ���� ȣ���� �ִ�. ȣ������ ������ 3������ �ִ�.
		 * �������� ��ǥ�� ������ ���ؼ� ��ġ�� ��������.
		 * ��, ���� �ڸ��� �����Ⱑ 2������ ���� �� ����.
		 * ȣ���� �������� ������ ������ ���� ������ ���۵ȴ�. ���ò��� ĳ������ �켱 �ؾ��Ѵ�.
		 * ��ǥ x, y�� �Է��ϼ��� : ��ǥ�Է�; ��ǥ���� 0���� �۰ų� 4���� ũ�� �߸��� ĳ�����Դϴ�.
		 * ���
		 * ���� �ٽ� ĳ���� ��û
		 * ĳ������ �ùٸ��� �ߴٸ� �� ��ǥ�� �����Ⱑ �ִ��� üũ�� �Ѵ�.
		 * ���� �� ��ġ�� ������ ������ ������ 1������ ��ҽ��ϴ�. ��� �� ���ô� �����̴� ����
		 * ����
		 * 1.�� 2.�Ʒ� 3.���� 4.������ : (�̵�����) �Է�
		 * ĳ������ ��ġ���� �� -y �Ʒ� +y ���� -x ������ +x�� ��ĭ�� �̵��Ѵ�.
		 * ���� ȣ���� ũ�⸦ ����� ĳ�����̸� �� �̻� �̵��� �� �� ����.
		 * ����ϰ� ���ô� �����̴� ���� ���� ȭ������ �̵��Ѵ�.
		 * ������ 3���� ��� ������ �����մϴ�. ����ϰ� ���α׷� ����
		 */
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[5][5];
		int x, y;
		int fish_count = 0;
		int user_count = 0;

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

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

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

		if (arr[x][y] == 1) {
			user_count++;
			System.out.println("������ " + user_count + "������ ��ҽ��ϴ�.");
			arr[x][y] = 0;
		}

		while (true) {
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

				if (arr[x][y] == 1) {
					user_count++;
					System.out.println("������ " + user_count + "������ ��ҽ��ϴ�.");
					arr[x][y] = 0;
				}
				if (user_count == 3) {
					System.out.println("�����մϴ�. 3���� �� ��ҽ��ϴ�.");
					break;
				}
			}
			System.out.println("���� ��ġ x : " + x + " / y : " + y);
			System.out.println();
		}

	}
}
