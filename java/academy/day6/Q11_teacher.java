package academy.day6;

import java.util.Random;
import java.util.Scanner;

public class Q11_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int a = 10;
		 * int b = 20;
		 * 
		 * if(a > b)
		 * {
		 * System.out.println("a�� Ů�ϴ�.");
		 * }
		 * else if(a == b)
		 * {
		 * System.out.println("a�� b�� �����ϴ�.");
		 * }
		 * else
		 * {
		 * System.out.println("b�� Ů�ϴ�.");
		 * }
		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.print("�迭�� ���̸� �Է� : ");
		int size = sc.nextInt();
		int maxindex = 0;
		int minindex = 0;
		int max = -1;
		int min = 101;

		int[] total = new int[size];

		for (int i = 0; i < size; i++) {
			total[i] = r.nextInt(101);
			System.out.print(total[i] + " , ");
		}
		System.out.println();

		for (int i = 0; i < size; i++) {
			if (max < total[i]) {
				max = total[i];
				maxindex = i;
			}
			if (min > total[i]) {
				min = total[i];
				minindex = i;
			}
		}

		System.out.println("max���� �ε��� : " + maxindex + " min���� �ε��� : " + minindex);

	}

}
