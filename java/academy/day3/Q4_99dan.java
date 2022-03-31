package academy.day3;

import java.util.Scanner;

public class Q4_99dan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ��ü ��� 2. ���Է� 3. ����
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("9x9���� ����ϴ� ���α׷��Դϴ�.");
			System.out.println("1. ��ü ���");
			System.out.println("2. �� �Է�");
			System.out.println("3. ����");
			System.out.print("�޴��� �������ּ��� : ");
			int choice = scan.nextInt();

			if (!(choice == 1 || choice == 2 || choice == 3)) {
				System.out.println("�߸��� �Է��Դϴ�.");
				System.out.println("--------------");
				// continue;
			} else {
				if (choice == 1) {
					for (int i = 2; i <= 9; i++) {
						for (int j = 1; j <= 9; j++) {
							System.out.println(i + "X" + j + "=" + i * j);
						}
						System.out.println();
					}
				} else if (choice == 2) {
					System.out.print("���� �Է����ּ��� : ");
					int num = scan.nextInt();

					if (!(num >= 2 && num <= 9)) {
						System.out.println("�߸��� �Է��Դϴ�.");
						// continue;
					} else {
						int i = num;
						for (int j = 1; j <= 9; j++) {
							System.out.println(i + "X" + j + "=" + i * j);
						}
						System.out.println();

					}
				} else {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
			}

		}

	}

}
