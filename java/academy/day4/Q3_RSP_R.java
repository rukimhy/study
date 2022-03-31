package academy.day4;

import java.util.Random;
import java.util.Scanner;

public class Q3_RSP_R {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������ ����0/��2 ����1/����0 ��2/����1 => ���� - ��ǻ�� = 1 or -2

		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		// 0 = ����, 1 = ����, 2 = ��
		int usr_win = 0, usr_defeat = 0, usr_draw = 0;

		System.out.println("----------------------------------------");
		System.out.println("��ǻ�Ϳ� �ϴ� ���� ���� �� �����Դϴ�.");
		System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ���.");
		System.out.println("[����]��� �Է��ϸ� ������ �����ϴ�.");
		System.out.println("----------------------------------------");

		while (true) {
			int cpu_choice = r.nextInt(3);
			int usr_number;
			int sum;

			System.out.print("����, ����, �� �� �ϳ��� �Է��ϼ��� : ");
			String usr_choice = scan.next();

			if (usr_choice.equals("����")) {
				System.out.println("�����մϴ�.");
				System.out.println("----------------------------------------");
				System.out.println("������ �� : " + usr_win);
				System.out.println("���º� : " + usr_draw);
				System.out.println("������ �� : " + usr_defeat);
				System.out.println("----------------------------------------");
				break;

			} else {
				if (!(usr_choice.equals("����") || usr_choice.equals("����") || usr_choice.equals("��"))) {
					System.out.println("�߸��� �Է��Դϴ�.");
					System.out.println("�����մϴ�.");
					break;
				} else {
					if (usr_choice.equals("����"))
						usr_number = 0;
					else if (usr_choice.equals("����"))
						usr_number = 1;
					else
						usr_number = 2;

					sum = usr_number - cpu_choice;

					if (sum == 1 || sum == -2) {
						System.out.println("������ �̰���ϴ�.");
						usr_win++;
					} else if (sum == 0) {
						System.out.println("�����ϴ�.");
						usr_draw++;
					} else {
						System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
						usr_defeat++;
					}
				}
				System.out.println("");
			}
		}
	}
}
