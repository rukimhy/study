package academy.day6;

import java.util.Random;
import java.util.Scanner;

public class Q11_randomArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ����ڰ� ���� �Է��ϸ� �� �� ��ŭ�� �迭 ����
		 * ��ü �迭�� 0~100 �� ���������� ä���ش�.
		 * �� ���� ���� ū���� �ε����� ���� ���� ���� �ε����� ���
		 */

		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		System.out.print("���ϴ� �迭 ũ�⸦ �Է� : ");
		int num = scan.nextInt();

		int[] arr = new int[num];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(101);
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int max = 0;
		int min = 100;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}

		System.out.println("-----------------");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				System.out.println("���� ū ���� �ε��� : " + i);
				break;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == min) {
				System.out.println("���� ���� ���� �ε��� : " + i);
				break;
			}
		}
		System.out.println("-----------------");

	}
}
