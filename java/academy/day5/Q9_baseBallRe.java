package academy.day5;

import java.util.Random;
import java.util.Scanner;

public class Q9_baseBallRe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		/*
		 * ���ھ߱�����
		 * cpu�� 1~9 �� 3���� ���ڸ� �������� �޽��ϴ�. (��, ���� ���ڰ� �� �޶�� ��)
		 * user�� 1~9 �� 3���� ���ڸ� �Է��մϴ�. (�Ȱ��� �Է��̸� �߸��� �Է��̶�� �˷��ְ� �ٽ� �Է�
		 * �޴´�.)
		 * cpu 3 2 1 user 2 7 9 => 1ball
		 * cpu 3 2 1 user 1 3 2 => 3ball
		 * cpu 3 2 1 user 3 9 6 => 1strike
		 * cpu 3 2 1 user 4 5 6 => out
		 * cpu 3 2 1 user 3 2 1 => Ȩ���Դϴ�. => ���α׷� ���� �˴ϴ�.
		 */
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int cpu1, cpu2, cpu3;

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
			int strike = 0;
			int ball = 0;

			// strike
			if (user1 == cpu1 && user2 == cpu2 && user3 == cpu3) {
				System.out.println("Home run !!");
				break;
			} else if ((user1 == cpu1 && user2 == cpu2) || (user1 == cpu1 && user3 == cpu3)
					|| (user2 == cpu2 && user3 == cpu3)) {
				strike = 2;
			} else if ((user1 == cpu1) || (user2 == cpu2) || (user3 == cpu3)) {
				strike = 1;
			} else if ((user1 != cpu1) && (user2 != cpu2) && (user3 != cpu3)) {
				strike = 0;
			}

			// ball
			if (((user1 == cpu2) && (user2 == cpu3) && (user3 == cpu1))
					|| ((user1 == cpu3) && (user2 == cpu1) && (user3 == cpu2))) {
				ball = 3;
			} else if ((user1 == cpu2 && (user2 == cpu1 || user2 == cpu3 || user3 == cpu1))
					|| (user1 == cpu3 && (user2 == cpu1 || user3 == cpu1 || user3 == cpu2))
					|| (user2 == cpu1 && (user1 == cpu2 || user1 == cpu3 || user3 == cpu2))
					|| (user2 == cpu3 && (user1 == cpu2 || user3 == cpu1 || user3 == cpu2))
					|| (user3 == cpu1 && (user1 == cpu2 || user1 == cpu3 || user2 == cpu3))
					|| (user3 == cpu2 && (user1 == cpu3 || user2 == cpu1 || user2 == cpu3))) {
				ball = 2;
			} else if ((user1 == cpu2 || user1 == cpu3 || user2 == cpu1 || user2 == cpu3 || user3 == cpu1
					|| user3 == cpu2)) {
				ball = 1;
			} else if ((user1 != cpu2) && (user1 != cpu3) && (user2 != cpu1) && (user2 != cpu3) && (user3 != cpu1)
					&& (user3 != cpu2)) {
				ball = 0;
			}

			if (ball == 0 && strike == 0) {
				System.out.println("OUT!!");
			} else {
				System.out.println("Strike : " + strike + "ȸ // Ball : " + ball + "ȸ");
			}
		}

	}
}
