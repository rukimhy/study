package academy.day9;

import java.util.Random;

public class Q19_arr5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * arr[5] ������ �迭���� �ȿ� 1~99������ �������� �迭�� �־��
		 * �迭 0~4���� ���� ���� ������� ���ĵǴ� ���α׷��� ������
		 * before : 25[0] 7[1] 88[2] 3[3] 1[4]
		 * after : 1[0] 3[1] 7[2] 25[3] 88[4]
		 */
		Random r = new Random();
		int tmp;
		int[] arr = new int[5];

		System.out.print("before : ");
		for (int i = 0; i < 5; i++) {
			arr[i] = r.nextInt(99) + 1;
			System.out.print(arr[i] + " / ");
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j)
					continue;
				else if (i < j) {
					if (arr[i] > arr[j]) {
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
		}
		System.out.println();
		System.out.print("after : ");
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i] + " / ");
		}
	}

}
