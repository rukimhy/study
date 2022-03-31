package academy.day16;

import java.util.Scanner;

class Plus {
	Plus(int a, int b) {
		System.out.println("�� ������ ���� ���� " + (a + b));
	}

	Plus(double a, double b) {
		System.out.println("�� �Ǽ��� ���� ���� " + (a + b));
	}
}

class Minus {
	Minus(int a, int b) {
		System.out.println("�� ������ �� ���� " + (a - b));
	}

	Minus(double a, double b) {
		System.out.println("�� �Ǽ��� �� ���� " + (a - b));
	}
}

class Multiply {
	Multiply(int a, int b) {
		System.out.println("�� ������ ���� ���� " + (a * b));
	}

	Multiply(double a, double b) {
		System.out.println("�� �Ǽ��� ���� ���� " + (a * b));
	}
}

class Divide {
	Divide(int a, int b) {
		System.out.println("�� ������ ���� ���� " + (a / b));
	}

	Divide(double a, double b) {
		System.out.println("�� �Ǽ��� ���� ���� " + (a / b));
	}
}

public class Q40_calc {

	public static void main(String[] args) {
		/*
		 * ��Ģ���� ���α׷�
		 * ������ �Ǽ��� �Է������� ������ ����Ǵ� ���α׷��� ������.
		 * �����ε� ���� �̿�
		 * ���� ���� /�Ǽ� �Ǽ�
		 */
		Scanner scan = new Scanner(System.in);

		System.out.print("1.���� 2.�Ǽ� : ");
		int choice = scan.nextInt();
		if (choice == 1) {
			System.out.print("���� �ΰ��� �Է��Ͻÿ� : ");
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.print("+, -, *, / �� �Է��Ͻÿ� : ");
			char ch = scan.next().charAt(0);
			if (ch == '+') {
				Plus plus = new Plus(a, b);
			} else if (ch == '-') {
				Minus minus = new Minus(a, b);
			} else if (ch == '*') {
				Multiply multiply = new Multiply(a, b);
			} else {
				Divide divide = new Divide(a, b);
			}
		} else {
			System.out.print("�Ǽ� �ΰ��� �Է��Ͻÿ� : ");
			double a = scan.nextDouble();
			double b = scan.nextDouble();
			System.out.print("+, -, *, / �� �Է��Ͻÿ� : ");
			char ch = scan.next().charAt(0);
			if (ch == '+') {
				Plus plus = new Plus(a, b);
			} else if (ch == '-') {
				Minus minus = new Minus(a, b);
			} else if (ch == '*') {
				Multiply multiply = new Multiply(a, b);
			} else {
				Divide divide = new Divide(a, b);
			}
		}

	}

}
