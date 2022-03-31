package academy.day5;

import java.util.Random;
import java.util.Scanner;

public class Q5_endQRe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * A = 65 ~ Z = 90
		 * 0~25���� �������� ���ڸ� �޴´�
		 * ���� �� Q(65+16=81)�� ������ ������ ������ ������ ���ڿ��� �����
		 * �ݺ����� ����ǰ� ������� ������� ���ڿ��� ���
		 * ���� �Է� �޾Ƽ� ���� �� �� ���ڰ� ���ڿ��� � �ִ��� ���� ���
		 */

		Scanner scan = new Scanner(System.in);
		Random r = new Random();
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

		int count = 0;

		while (true) {
			int alphabet = 65;
			int random_a = r.nextInt(25);

			int sum = alphabet + random_a;

			if (sum == a2z)
				count++;

			if (sum == 81)
				break;

			System.out.print((char) sum);
		}
		System.out.println("\n" + a2z + "�� ������ " + count + "�� �Դϴ�.");
	}
}
