package academy.day12;

import java.util.Random;
import java.util.Scanner;

public class Q27_andQfunc {

	// ���� ���� �Է�
	public static int input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("A~Z �� ���ڸ� �ϳ� �Է����ּ��� : ");
		char a2z = scan.next().charAt(0);

		while (true) {
			if (!((int) a2z >= 65 && (int) a2z <= 90)) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				System.out.print("A~Z �� ���ڸ� �ϳ� �Է����ּ��� : ");
				a2z = scan.next().charAt(0);
			} else
				break;
		}

		return (int) a2z;
	}

	// ��ǻ�� ���� ���ڿ�
	public static void cpuRandom(int input) {
		Random r = new Random();

		int count = 0;

		while (true) {
			int alphabet = 65;
			int random_a = r.nextInt(25);

			int sum = alphabet + random_a;

			if (sum == input)
				count++;

			if (sum == 81)
				break;

			System.out.print((char) sum);
		}
		System.out.println("\n" + (char) input + "�� ������ " + count + "�� �Դϴ�.");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5�� ���� �ּ� 2�� �̻��� �Լ��� ����

		cpuRandom(input());
	}
}
