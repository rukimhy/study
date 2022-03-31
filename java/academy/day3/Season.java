package academy.day3;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {
		// 1~12 ���ڸ� �ϳ� �Է¹޾� 1���� �۰ų� 12���� ū��� "�߸��� �Է��Դϴ�."�� ���
		// �ùٸ��� ���ڰ� �ԷµǸ� 3~6 => "���Դϴ�." 7~9 => "�����Դϴ�." 10~11 => "�����Դϴ�."
		// 12~2 => "�ܿ��Դϴ�."

		Scanner scan = new Scanner(System.in);

		System.out.print("���� ������ �˷��ִ� ���α׷��Դϴ�.");
		System.out.print("1���� 12������ ���� �� �ϳ��� �Է��ϼ��� : ");
		int num = scan.nextInt();

		if (num >= 3 && num <= 6) {
			System.out.println("���Դϴ�.");
		} else if (num >= 7 && num <= 9) {
			System.out.println("�����Դϴ�.");
		} else if (num >= 10 && num <= 11) {
			System.out.println("�����Դϴ�.");
		} else if (num == 12 || num == 1 || num == 2) {
			System.out.println("�ܿ��Դϴ�.");
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}

}
