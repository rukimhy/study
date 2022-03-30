package day6;

import java.util.Scanner;

public class Q10_average5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5명의 점수를 각각 입력을 받아서 평균을 출력
		
		Scanner scan = new Scanner(System.in);
		double[] scoreArray = new double[5];
		
		for(int i=0; i<5; i++) {
			System.out.print((i+1)+"번째 점수를 입력하세요 : ");
			scoreArray[i] = scan.nextDouble();
		}
		
		System.out.println("--------------");
		double sum = 0.0;
		for(int i=0; i<5; i++) {
			sum += scoreArray[i];
		}
		System.out.println("5명의 평균 = "+(sum/5));
	}

}
