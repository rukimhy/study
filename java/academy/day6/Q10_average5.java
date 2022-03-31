package academy.day6;

import java.util.Scanner;

public class Q10_average5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5���� ������ ���� �Է��� �޾Ƽ� ����� ���

		Scanner scan = new Scanner(System.in);
		double[] scoreArray = new double[5];

		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "��° ������ �Է��ϼ��� : ");
			scoreArray[i] = scan.nextDouble();
		}

		System.out.println("--------------");
		double sum = 0.0;
		for (int i = 0; i < 5; i++) {
			sum += scoreArray[i];
		}
		System.out.println("5���� ��� = " + (sum / 5));
	}

}
