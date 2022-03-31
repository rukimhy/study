package academy.day10;

import java.util.Arrays;
import java.util.Random;

public class Q19_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		int num;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 99) + 1;
		}
		System.out.print("before : " + Arrays.toString(arr));
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					num = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = num;
				}
			}
		}
		System.out.println();
		System.out.print("after : " + Arrays.toString(arr));

	}

}
