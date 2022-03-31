package academy.day10;

import java.util.Scanner;

public class Q21_calc {

	// 1�� �ְ� �ް�
	public static int add(int a, int b) {
		int sum = a + b;
		return sum;
	}

	// 2�� ���ְ� �ް�
	public static void minus(int a, int b) {
		System.out.println("������� " + (a - b));
	}

	// 3�� �ְ� �ȹް�
	public static int multiply() {
		Scanner scan = new Scanner(System.in);

		System.out.print("����1 �Է� : ");
		int num1 = scan.nextInt();
		System.out.print("����2 �Է� : ");
		int num2 = scan.nextInt();

		return num1 * num2;
	}

	// 4�� ���ְ� �ȹް�
	public static void devide() {
		Scanner scan = new Scanner(System.in);

		System.out.print("����1 �Է� : ");
		int num1 = scan.nextInt();
		System.out.print("����2 �Է� : ");
		int num2 = scan.nextInt();

		System.out.println("������� " + num1 / num2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		char calc;

		System.out.print("�����ڸ� �Է��ϼ��� (+,-,*,/) : ");
		calc = scan.next().charAt(0);

		if (calc == '+') {
			System.out.print("����1 �Է� : ");
			int num1 = scan.nextInt();
			System.out.print("����2 �Է� : ");
			int num2 = scan.nextInt();

			System.out.println("������� " + add(num1, num2));
		} else if (calc == '-') {
			System.out.print("����1 �Է� : ");
			int num1 = scan.nextInt();
			System.out.print("����2 �Է� : ");
			int num2 = scan.nextInt();
			minus(num1, num2);
		} else if (calc == '*') {
			System.out.println("������� " + multiply());
		} else if (calc == '/') {
			devide();
		}
	}

}
