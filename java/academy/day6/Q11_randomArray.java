package day6;

import java.util.Random;
import java.util.Scanner;

public class Q11_randomArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 사용자가 정수 입력하면 그 수 만큼의 배열 생성
		 * 전체 배열에 0~100 중 랜덤값으로 채워준다.
		 * 그 이후 가장 큰값의 인덱스와 가장 작은 값의 인덱스를 출력 
		 */

		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		System.out.print("원하는 배열 크기를 입력 : ");
		int num = scan.nextInt();

		int[] arr = new int[num];

		for(int i=0; i<arr.length; i++) 
		{
			arr[i] = r.nextInt(101);
			System.out.print(arr[i]+" ");
		}
		System.out.println();

		int max = 0;
		int min = 100;

		for(int i=0; i<arr.length; i++) 
		{
			if(arr[i] > max) max = arr[i];
			if(arr[i] < min) min = arr[i];
		}
		
		System.out.println("-----------------");
		for(int i=0; i<arr.length; i++) 
		{
			if(arr[i] == max) 
			{
				System.out.println("가장 큰 값의 인덱스 : "+i);
				break;
			}

		}
		
		for(int i=0; i<arr.length; i++) 
		{
			if(arr[i] == min) 
			{
				System.out.println("가장 작은 값의 인덱스 : "+i);
				break;
			}
		}
		System.out.println("-----------------");

	}
}
