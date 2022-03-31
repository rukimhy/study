package academy.day6;

import java.util.Scanner;

public class Q10_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		int sum = 0;

		for (int i = 0; i < num.length; i++) {
			System.out.print((i + 1) + "��° ��� �Է� : ");
			num[i] = sc.nextInt();

		}
		for (int i = 0; i < num.length; i++) {
			sum = sum + num[i];// sum+=num[i];
		}

		System.out.println("��� �� : " + (sum / 5));
	}

}
