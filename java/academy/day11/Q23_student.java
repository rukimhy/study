package academy.day11;

import java.util.Random;
import java.util.Scanner;

public class Q23_student {
	public static int Random() {
		Random r = new Random();
		int a, b, c;
		while (true) {
			a = r.nextInt(10);
			b = r.nextInt(10);
			c = r.nextInt(10);
			if (a == 0) {// ran1�ǰ��� 0�̸� �ٽ� ����
				a = r.nextInt(10);
			} else if (b == a || b == c || b == 0) {// ran2�ǰ��� 0,ran2�� ran1 ran3�� ���ٸ� ran2 �ٽ� ����
				b = r.nextInt(10);
			} else if (c == a || c == b || c == 0) {// ran3�ǰ��� 0,ran3�� ran2 ran1�� ���ٸ� ran3 �ٽ� ����
				c = r.nextInt(10);
			} else { // ���� ���ڰ� �� �ٸ���� while Ż��
				break;
			}
		}
		System.out.println("����" + a + "" + b + "" + c);

		int RAN = (100 * a) + (10 * b) + c;
		return RAN;
	}

	public static int num01() {
		Scanner sc = new Scanner(System.in);

		System.out.println("ù��°���� �Է�:");
		int num1 = sc.nextInt();

		return num1;
	}

	public static int num02() {
		Scanner sc = new Scanner(System.in);

		System.out.println("�ι�°���� �Է�:");
		int num2 = sc.nextInt();

		return num2;
	}

	public static int num03() {
		Scanner sc = new Scanner(System.in);

		System.out.println("����°���� �Է�:");
		int num3 = sc.nextInt();

		return num3;
	}

	public static void game(int a, int b, int c) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			int num1 = num01();
			int num2 = num02();
			int num3 = num03();
			int strike = 0;
			int ball = 0;
			if (num1 == num2 || num2 == num3 || num1 == num3) {// ���� ������ �Է��� �������� �ٽ��Է�
				System.out.println("���� �ٸ����ڸ� �Է����ּ���");
				continue;
			}
			// ���ڴ� ������ �ڸ����� �ٸ����
			if (a == num2 || a == num3) {
				ball++;
			}
			if (b == num1 || b == num3) {
				ball++;
			}
			if (c == num1 || c == num2) {
				ball++;
			}
			// ���ڿ� �ڸ��� ��ΰ������
			if (a == num1) {
				strike++;
			}
			if (b == num2) {
				strike++;
			}
			if (c == num3) {
				strike++;
			}
			if (strike == 3) {
				System.out.println("Ȩ���Դϴ�.");
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (strike == 0 && ball == 0) {
				System.out.println("�ƿ��Դϴ�.");
			} else {
				System.out.println(strike + "��Ʈ����ũ" + ball + "��");
			}
		}

	}

	public static void main(String[] args) {

		int ran = Random();
		int ran1 = ran / 100;
		int ran2 = (ran - (ran1 * 100)) / 10;
		int ran3 = (ran - ((100 * ran1) + (10 * ran2)));
		game(ran1, ran2, ran3);

	}
}