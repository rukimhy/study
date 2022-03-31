package academy.day6;

import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class Q9_teacher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// ��ĳ�� ��ü ����
		Random r = new Random(); // ���� ��ü����

		int com1 = r.nextInt(9) + 1; // ��ǻ���� ������
		int com2 = r.nextInt(9) + 1;// �ι�° ������

		int strike = 0;
		int ball = 0;

		while (com1 == com2) // ������ �ߺ� ������ ���� ��
		{
			com1 = r.nextInt(9) + 1;
		}

		int com3 = r.nextInt(9) + 1;// ����° ������
		while (com1 == com3 || com2 == com3) // ����° �������� �ߺ� ������ ���� ��
		{
			com3 = r.nextInt(9) + 1;
		}
		System.out.println(com1 + " " + com2 + " " + com3); // ������ ������ ���

		while (true) {

			strike = 0;
			ball = 0;

			System.out.print("���� 1 �Է�: ");
			int user1 = sc.nextInt();
			System.out.print("���� 2 �Է�: ");
			int user2 = sc.nextInt();
			System.out.print("���� 3 �Է�: ");
			int user3 = sc.nextInt();

			if (user1 == com1) {
				strike++;
			}
			if (user2 == com2) {
				strike++;
			}
			if (user3 == com3) {
				strike++;
			}
			if (user1 == com2 || user1 == com3) {
				ball++;
			}
			if (user2 == com1 || user2 == com3) {
				ball++;
			}
			if (user3 == com1 || user3 == com2) {
				ball++;
			}

			if (strike == 3) {
				System.out.println("Ȩ���Դϴ�.");
				break;
			} else if (strike == 0 && ball == 0) {
				System.out.println("out�Դϴ�.");
			} else {
				System.out.println("Strike :" + strike + "," + "Ball : " + ball + "�Դϴ�.");
			}

		}

	}

}
