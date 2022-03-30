package day2;

import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		// 두개의 숫자를 입력 받는다.
		// 두 숫자를 덧셈, 곱셈, 뺌셈의 결과값을 출력
		
		Scanner sc1 = new Scanner(System.in); // 스캐너의 객체를 생성
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("두 개의 숫자를 입력하세요.");
		
		int a = sc1.nextInt();
		int b = sc2.nextInt();
		
		System.out.println("합한 값 :" + (a+b));
		System.out.println("곱한 값 :" + (a*b));
		System.out.println("뺀 값 :" + (a-b));
	}
}
