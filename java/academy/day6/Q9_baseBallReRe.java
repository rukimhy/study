package academy.day6;

import java.util.Random;
import java.util.Scanner;

public class Q9_baseBallReRe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int cpu1, cpu2, cpu3;
		int strike, ball;

		System.out.println("���ھ߱������� �����մϴ�.");
		System.out.println("1���� 9������ ���ڸ� �Է��� �����մϴ�.");

		// cpu 3�� ���� ���� ����
		cpu1 = r.nextInt(9) + 1;
		while (true) {
			cpu2 = r.nextInt(9) + 1;
			if (cpu1 != cpu2) {
				break;
			}
		}
		while (true) {
			cpu3 = r.nextInt(9) + 1;
			if (cpu1 != cpu3 && cpu2 != cpu3) {
				break;
			}
		}
		System.out.println("cpu1 = " + cpu1 + " cpu2 = " + cpu2 + " cpu3 = " + cpu3);

		while (true) {
			// user 3�� �Է� ����
			System.out.print("1��° ���ڸ� �Է����ּ��� : ");
			int user1 = scan.nextInt();
			while (true) {
				if (!(user1 >= 1 && user1 <= 9)) {
					System.out.println("�߸��� �Է��Դϴ�.");
					System.out.print("�ٽ� �Է����ּ��� : ");
					user1 = scan.nextInt();
				} else {
					break;
				}
			}

			System.out.print("2��° ���ڸ� �Է����ּ��� : ");
			int user2 = scan.nextInt();

			while (true) {
				if (user2 == user1) {
					System.out.println("���� ���ڴ� �Է��ϸ� �ȵ˴ϴ�.");
					System.out.print("�ٽ� �Է����ּ��� : ");
					user2 = scan.nextInt();
				} else if (!(user2 >= 1 && user2 <= 9)) {
					System.out.println("�߸��� �Է��Դϴ�.");
					System.out.print("�ٽ� �Է����ּ��� : ");
					user2 = scan.nextInt();
				} else {
					break;
				}
			}

			System.out.print("3��° ���ڸ� �Է����ּ��� : ");
			int user3 = scan.nextInt();

			while (true) {
				if (user3 == user1 || user3 == user2) {
					System.out.println("���� ���ڴ� �Է��ϸ� �ȵ˴ϴ�.");
					System.out.print("�ٽ� �Է����ּ��� : ");
					user3 = scan.nextInt();
				} else if (!(user3 >= 1 && user3 <= 9)) {
					System.out.println("�߸��� �Է��Դϴ�.");
					System.out.print("�ٽ� �Է����ּ��� : ");
					user3 = scan.nextInt();
				} else {
					break;
				}
			}

			// ���� ����
			strike = 0;
			ball = 0;

			if (user1 == cpu1) {
				strike++;
			}
			if (user2 == cpu2) {
				strike++;
			}
			if (user3 == cpu3) {
				strike++;
			}
			if (user1 == cpu2 || user1 == cpu3) {
				ball++;
			}
			if (user2 == cpu1 || user2 == cpu3) {
				ball++;
			}
			if (user3 == cpu1 || user3 == cpu2) {
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
