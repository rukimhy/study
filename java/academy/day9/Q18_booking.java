package academy.day9;

import java.util.Scanner;

public class Q18_booking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ����� ���� ���α׷� �����
		 * �¼��� 8�� 2���� �¼��� �����մϴ�.
		 * 1. ���� 2. ���¼� Ȯ�� 3. ����
		 * 1�� ���� �� �¼��� �����ϼ��� : 3 0(����)
		 * 3�� 0��° �ڸ��� ��� ������ �¼� ������ �Ǿ����ϴ�. ���
		 * ���� ������ �Ǿ� �ִٸ� �̹� ����� �¼��Դϴ�. ���
		 * 1�� ���Ÿ� ������ �Ϸ��� �ϴµ� ���� ��� �¼��� ���� �Ǿ��ִٸ� ��� �¼��� ���Ű�
		 * �������ϴ�.
		 * ��� ���Ŀ� ù ȭ������ �̵�
		 * �߸��� �Է½� ùȭ������ �̵�
		 * 2�� ���¼� Ȯ���� �����ϸ� ����ִ� �¼��� ������ ��ü ����մϴ�.
		 * 3�� �Է½� ���α׷��� �����մϴ�. ����ϰ� ���α׷� ����
		 * �޴� 1, 2, 3�̿��� �Է��� �߸��� �Է��Դϴ�. ���
		 */
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
			} else {
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
			}
			System.out.println();
		}
	}

}
