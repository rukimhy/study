package academy.day3;

import java.util.Random;
import java.util.Scanner;

public class Q5_endQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * A = 65 ~ Z = 90
		 * 0~25���� �������� ���ڸ� �޴´�
		 * ���� �� Q(65+16=81)�� ������ ������ ������ ������ ���ڿ��� �����
		 * �ݺ����� ����ǰ� ������� ������� ���ڿ��� ���
		 */

		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		while (true) {
			int alphabet = 65;
			int random_a = r.nextInt(25);

			int sum = alphabet + random_a;

			if (sum == 81)
				break;

			System.out.print((char) sum);
		}

	}

}
