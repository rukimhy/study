package academy.day2;

import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		// �ΰ��� ���ڸ� �Է� �޴´�.
		// �� ���ڸ� ����, ����, ������ ������� ���

		Scanner sc1 = new Scanner(System.in); // ��ĳ���� ��ü�� ����
		Scanner sc2 = new Scanner(System.in);

		System.out.println("�� ���� ���ڸ� �Է��ϼ���.");

		int a = sc1.nextInt();
		int b = sc2.nextInt();

		System.out.println("���� �� :" + (a + b));
		System.out.println("���� �� :" + (a * b));
		System.out.println("�� �� :" + (a - b));
	}
}
