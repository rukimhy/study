package academy.day6;

import java.util.Scanner;

public class QQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		// 1�� ����
		System.out.print("1��) ������ �Է��ϼ��� : ");
		int num1 = scan.nextInt();

		if (num1 >= 90)
			System.out.println("�����մϴ�. A������ ����ϼ̽��ϴ�.");
		System.out.println("�����մϴ�.");

		// 2�� ����
		System.out.print("2��) ���ڸ� �ϳ� �Է��ϼ��� : ");
		int num2 = scan.nextInt();

		if (num2 < 0)
			System.out.println("�����Դϴ�.");
		else if (num2 == 0)
			System.out.println("0�Դϴ�.");
		else
			System.out.println("����Դϴ�.");

		// 3�� ����
		System.out.print("3��) A~F �� ������ �Է��ϼ��� : ");
		char char1 = scan.next().charAt(0);

		if (!(char1 == 'A' || char1 == 'B' || char1 == 'C' || char1 == 'D' || char1 == 'F')) {
			System.out.println("��Ȯ�� ������ �ƴմϴ�.");
		} else {
			if (char1 == 'A' || char1 == 'B') {
				System.out.println("����� �����Դϴ�.");
			} else if (char1 == 'C' || char1 == 'D') {
				System.out.println("�й��Ͻʼ�");
			} else
				System.out.println("���� ����� �ʿ��մϴ�.");
		}

		// 4�� ����
		System.out.print("4��) ������ �Է��ϼ��� : ");
		int num4 = scan.nextInt();
		int sum4 = 0;
		for (int i = 1; i <= num4; i++) {
			if (i % 2 == 0) {
				sum4 += i;
			}
		}
		System.out.println(num4 + "������ ¦���� ���� " + sum4);

		// 5�� ����
		System.out.print("5��) ������ �Է��ϼ��� : ");
		int num5 = scan.nextInt();

		System.out.print(num5 + "�� ��� : ");
		for (int i = 1; i <= num5; i++) {
			if (num5 % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// 6�� ����
		int num6, sum;
		while (true) {
			sum = 0;
			System.out.print("6��) ������ �Է��ϼ���(���� = -1) : ");
			num6 = scan.nextInt();
			if (num6 == -1) {
				break;
			} else {
				System.out.print("1���� " + num6 + "������ ��� : ");
				for (int i = 1; i <= num6; i++) {
					sum += i;
				}
				System.out.println(num6 + "������ ���� " + sum);
			}
		}
	}
}
