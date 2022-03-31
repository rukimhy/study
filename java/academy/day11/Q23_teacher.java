package academy.day11;

import java.util.Random;
import java.util.Scanner;

public class Q23_teacher {

	public static int[] ComRandom() {
		Random r = new Random(); // ���� ��ü����
		int[] com = new int[3];
		com[0] = r.nextInt(9) + 1; // ��ǻ���� ������
		com[1] = r.nextInt(9) + 1;// �ι�° ������
		while (com[0] == com[1]) // ������ �ߺ� ������ ���� ��
		{
			com[1] = r.nextInt(9) + 1;
		}

		com[2] = r.nextInt(9) + 1;// ����° ������
		while (com[0] == com[2] || com[1] == com[2]) // ����° �������� �ߺ� ������ ���� ��
		{
			com[2] = r.nextInt(9) + 1;
		}
		System.out.println(com[0] + " " + com[1] + " " + com[2]); // ������ ������ ���

		return com;

	}

	public static int[] UserInput() {
		Scanner sc = new Scanner(System.in);// ��ĳ�� ��ü ����
		int[] user = new int[3];
		System.out.print("���� 1 �Է�: ");
		user[0] = sc.nextInt();
		System.out.print("���� 2 �Է�: ");
		user[1] = sc.nextInt();
		System.out.print("���� 3 �Է�: ");
		user[2] = sc.nextInt();

		return user;
	}

	public static int[] CheckFunc(int[] user, int[] com) {
		int[] result = new int[2];
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < 3; i++) // user
		{
			for (int j = 0; j < 3; j++) // com
			{
				if (user[i] == com[j]) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}

			}
		}

		result[0] = strike;
		result[1] = ball;

		return result;
	}

	public static boolean ResultPrint(int[] result) {
		if (result[0] == 3) {
			System.out.println("Ȩ���Դϴ�.");
			return false;
		} else if (result[0] == 0 && result[1] == 0) {
			System.out.println("out�Դϴ�.");
		} else {
			System.out.println("Strike :" + result[0] + "," + "Ball : " + result[1] + "�Դϴ�.");
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ComRandom

		///////////////////////////////////////////

		// UserInput

		/////////////////////////////////////////////////////

		// CheckFunc

		////////////////////////////////////////////////////

		// ResultPrint

		///////////////////////////////////////////////////////////////////////////

		int[] com = ComRandom();
		boolean check = true;

		while (check) {
			check = ResultPrint(CheckFunc(UserInput(), com));
		}
	}

}
