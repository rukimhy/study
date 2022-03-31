package academy.day11;

import java.util.Random;
import java.util.Scanner;

public class Q23_baseBallFunc {

	// cpu ���� ���� ����
	public static int[] randomCpu() {
		Random r = new Random();
		int[] cpu = new int[3];

		while (true) {
			for (int i = 0; i < 3; i++) {
				cpu[i] = r.nextInt(9) + 1;
			}
			if (cpu[0] != cpu[1] && cpu[0] != cpu[2] && cpu[1] != cpu[2])
				break;
		}
		System.out.println("cpu[0] = " + cpu[0] + " // cpu[1] = " + cpu[1] + " // cpu[2] = " + cpu[2]);

		return cpu;
	}

	// user 3�� �Է� ����
	public static int[] input() {
		Scanner scan = new Scanner(System.in);

		int[] user = new int[] { 123, 124, 125 };

		System.out.println("���� �ٸ� ���� 3���� �Է����ּ���.");

		for (int i = 0; i < 3; i++) {
			System.out.print(i + 1 + "��° ���ڸ� �Է����ּ��� : ");
			user[i] = scan.nextInt();

			while (true) {
				if (!(user[i] >= 1 && user[i] <= 9)) {
					System.out.println("�߸��� �Է��Դϴ�.");
					System.out.print("�ٽ� �Է����ּ��� : ");
					user[i] = scan.nextInt();
				} else if (user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
					System.out.println("���� ���ڴ� �Է��ϸ� �ȵ˴ϴ�.");
					System.out.print("�ٽ� �Է����ּ��� : ");
					user[i] = scan.nextInt();
				} else
					break;
			}
		}

		return user;
	}

	// ���� ����
	public static void output() {
		int strike, ball;

		System.out.println("���ھ߱������� �����մϴ�.");
		System.out.println("1���� 9������ ���ڸ� �Է��� �����մϴ�.");

		// cpu ���� ����
		int cpu[] = randomCpu();

		while (true) {
			System.out.println();
			// user 3�� �Է� ����
			int user[] = input();

			// ���� ����
			strike = 0;
			ball = 0;

			for (int i = 0; i < 3; i++) {
				if (user[i] == cpu[i])
					strike++;
			}

			if (user[0] == cpu[1] || user[0] == cpu[2]) {
				ball++;
			}
			if (user[1] == cpu[0] || user[1] == cpu[2]) {
				ball++;
			}
			if (user[2] == cpu[0] || user[2] == cpu[1]) {
				ball++;
			}

			if (strike == 3) {
				System.out.println("Ȩ���Դϴ�.");
				break;
			} else if (strike == 0 && ball == 0) {
				System.out.println("out�Դϴ�.");
			} else {
				System.out.println("Strike :" + strike + " // " + "Ball : " + ball + "�Դϴ�.");
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ھ߱������� �Լ� 3�� �̻����� ����

		output();

	}

}
