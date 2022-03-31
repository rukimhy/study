package academy.day3;

import java.util.Random;
import java.util.Scanner;

public class Rock_scissors_paper_remake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �����մϴ�.");
		System.out.print("����, ����, �� �� �ϳ��� �Է��Ͻÿ� : ");
		String str = scan.next();

		int i = -1;
		int sum = 0;
		int cpu_choice = rand.nextInt(3);

		if (!(str.equals("����") || str.equals("����") || str.equals("��"))) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} else {
			if (str.equals("����")) {
				i = 0;
			} else if (str.equals("����")) {
				i = 1;
			} else {
				i = 2;
			}

			sum = i - cpu_choice;

			if (sum == 1 || sum == -2) {
				System.out.println("������ �̰���ϴ�.");
			} else if (sum == 0) {
				System.out.println("�����ϴ�.");
			} else {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}
			System.out.println("��ǻ���� �� : " + cpu_choice + " - ������ �� : " + i);
		}
	}

}
