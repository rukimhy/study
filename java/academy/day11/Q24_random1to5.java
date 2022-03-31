package academy.day11;

import java.util.Random;
import java.util.Scanner;

public class Q24_random1to5 {

	// cpu ������ �޴� �Լ� (3��)
	public static int randomCpu() {
		Random r = new Random();
		int cpu = r.nextInt(5) + 1;
		return cpu;
	}

	// user �Է� �޴� �Լ� (3��)
	public static int input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("1~5 �� ���ڸ� �Է����ּ��� : ");
		int user = scan.nextInt();
		return user;
	}

	// ����� �����ϴ� �Լ� (1��)
	public static int output(int cpu, int user) {
		int result = 0;
		if (cpu == user)
			result = 1;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * �������� 1~5���� �Է� �ް� �� ��ȣ�� ����
		 * ������ 1~5���� ��� �Է��ؼ� ������ ã�� ����. ������ ã�� ������ �ݺ�
		 * ������ �ƴ� ���� �Է��ϸ� ������ ���� ���߽��ϴ�.
		 * ���ι�ȣ�� �Է��ϸ� ������ ��ҽ��ϴ� ��� �Ŀ� ���α׷� ����
		 * �Լ� 3��, 1��(�ְ� �ް�)�� 3��(�ְ� �ȹް�)�� ���
		 */

		int cpu = randomCpu();

		System.out.println(cpu);

		while (true) {
			int user = input();

			if (output(cpu, user) == 1) {
				System.out.println("������ ��ҽ��ϴ�.");
				break;
			} else
				System.out.println("������ ���� ���߽��ϴ�.");
		}
	}

}
