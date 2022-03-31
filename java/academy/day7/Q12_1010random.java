package academy.day7;

import java.util.Random;
import java.util.Scanner;

public class Q12_1010random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ���� 10�迭. ���⿡ �������� 0~10���� ���� ����ִ�.
		 * ���� �ߺ��� ����. �� ���Ŀ� ������ ���ڸ� �Է��Ѵ�.
		 * -1�� �Է��ϸ� ����. �׷��� ������ ���� �ݺ��Ѵ�.
		 * 0~10������ ���� �Է����� ������ �߸��� ���̶�� ����Ѵ�.
		 * �ùٸ� 0~10 ������ ���� �Է������� �� ���ڰ� �迭 �ȿ� �� ��� �ִ��� ����Ѵ�.
		 */

		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		int[] cpu = new int[10];

		while (true) {
			int count = 0;

			// �迭�� ������ ����
			for (int i = 0; i < 10; i++) {
				cpu[i] = r.nextInt(11);
				System.out.print(cpu[i] + " ");
			}
			System.out.println();

			// ������ ���ڸ� �Է�
			System.out.print("0~10 ���� �� �ϳ��� �Է��Ͻÿ�(���� : -1) : ");
			int user = scan.nextInt();

			// -1 �Է� �� ����
			if (user == -1) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				// 0~10 ���� ���ڰ� �ƴ� ���
				if (user < 0 || user > 10)
					System.out.println("�߸��� �Է��Դϴ�.");
				// 0~10 ���� ������ ���
				else {
					for (int i = 0; i < 10; i++) {
						if (user == cpu[i])
							count++;
					}
					System.out.println(user + "�� �� ������ " + count + "�� �Դϴ�.");
				}
			}
			System.out.println("--------------------------------------");
		}
	}
}
