package academy.day17;

import java.util.Scanner;

class OP {
	void add(int a, int b) {
		System.out.println(a + b);
	}

	void add(double a, double b) {
		System.out.println(a + b);
	}

	void min(int a, int b) {
		System.out.println(a - b);
	}

	void min(double a, double b) {
		System.out.println(a - b);
	}

	void mul(int a, int b) {
		System.out.println(a * b);
	}

	void mul(double a, double b) {
		System.out.println(a * b);
	}

	void div(int a, int b) {
		System.out.println(a / b);
	}

	void div(double a, double b) {
		System.out.println(a / b);
	}
}

public class Q40_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OP op = new OP();
		Scanner sc = new Scanner(System.in);

		System.out.println("1. ���� 2. �Ǽ� : ");
		int select = sc.nextInt();

		if (select == 1) {
			System.out.println("���� 1 �Է� : ");
			int num1 = sc.nextInt();
			System.out.println("���� 2 �Է� : ");
			int num2 = sc.nextInt();
			System.out.println("������ �Է� : ");
			char ch = sc.next().charAt(0);

			if (ch == '+') {
				op.add(num1, num2);
			} else if (ch == '-') {
				op.min(num1, num1);
			} else if (ch == '*') {
				op.mul(num1, num2);
			} else if (ch == '/') {
				op.div(num1, num2);
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}

		} else if (select == 2) {
			System.out.println("���� 1 �Է� : ");
			double num1 = sc.nextDouble();
			System.out.println("���� 2 �Է� : ");
			double num2 = sc.nextDouble();
			System.out.println("������ �Է� : ");
			char ch = sc.next().charAt(0);

			if (ch == '+') {
				op.add(num1, num2);
			} else if (ch == '-') {
				op.min(num1, num1);
			} else if (ch == '*') {
				op.mul(num1, num2);
			} else if (ch == '/') {
				op.div(num1, num2);
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}

	}

}
