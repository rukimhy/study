package academy.day10;

import java.util.Scanner;

public class Q18_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);// �Է� ��ü
		int[][] seat = new int[8][2]; // 8�� 2���� �¼� �ʱ� ���� 0���� ����
		// ��������� �ݺ����� ������ ���� �����ִ� �ڸ� ���� ���ϴ°� �����Ѱ���?
		// ������ ���� ��� ī���� �ϴ°� �����ұ��?
		int count = 0;

		while (true) {
			System.out.print("1. ���� 2. ���¼� Ȯ�� 3. ���� :");
			int sel = sc.nextInt();
			if (sel == 1) {
				if (count == 16) {
					System.out.println("��� �¼��� ���� �ƽ��ϴ�.");
				} else {
					System.out.print("�¼��� �����ϼ��� : ");
					int num1 = sc.nextInt();
					int num2 = sc.nextInt();

					if (seat[num1][num2] == 0) {
						seat[num1][num2] = 1;
						System.out.println((num1 + 1) + "��" + (num2 + 1) + "��° �ڸ��� ���� �ƽ��ϴ�.");
						count++;
					} else {
						System.out.println("�̹� ����� �¼��Դϴ�.");
					}
				}
			} else if (sel == 2) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 2; j++) {
						if (seat[i][j] == 0) {
							System.out.println((i + 1) + "��" + (j + 1) + "��° �ڸ��� ����ֽ��ϴ�.");
						}
					}
				}
			} else if (sel == 3) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}

	}

}
