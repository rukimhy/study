package academy.day12;

import java.util.Random;
import java.util.Scanner;

public class Q26_teacher {

	public static int comRan() {
		Random r = new Random();
		return r.nextInt(3);
	}

	public static String userInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���� ���� �Է� : ");
		return sc.next();

	}

	public static int changeUserValue(String str) {
		int user;
		if (!(str.equals("����") || str.equals("����") || str.equals("��"))) {
			System.out.println("�߸����Է��Դϴ�.");
			return -1;
		} else {
			// equals("����") => �Լ� String�ȿ� �ִ� �Լ� int �⺻�� �Լ� ��ü�� �����ϴ�.
			if (str.equals("����")) {
				user = 0;
			} else if (str.equals("����")) {
				user = 1;
			} else {
				user = 2;
			}
		}

		return user;
	}

	public static void check(int user, int ran) {

		if (user != -1) {
			int value = user - ran;

			if (value == 1 || value == -2) {
				System.out.println("������");
			} else {
				if (value == 0) {
					System.out.println("���º�");
				} else {
					System.out.println("��ǻ�� ��");
				}
			}
		}

	}

	public static void main(String[] args) {
		check(changeUserValue(userInput()), comRan());
	}

}
