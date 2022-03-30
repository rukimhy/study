package day16;

import java.util.Scanner;

class Plus{
	Plus(int a, int b){
		System.out.println("두 정수를 더한 값은 "+(a+b));
	}
	Plus(double a, double b){
		System.out.println("두 실수를 더한 값은 "+(a+b));
	}
}

class Minus{
	Minus(int a, int b){
		System.out.println("두 정수를 뺀 값은 "+(a-b));
	}
	Minus(double a, double b){
		System.out.println("두 실수를 뺀 값은 "+(a-b));
	}
}

class Multiply{
	Multiply(int a, int b){
		System.out.println("두 정수를 곱한 값은 "+(a*b));
	}
	Multiply(double a, double b){
		System.out.println("두 실수를 곱한 값은 "+(a*b));
	}
}

class Divide{
	Divide(int a, int b){
		System.out.println("두 정수를 나눈 값은 "+(a/b));
	}
	Divide(double a, double b){
		System.out.println("두 실수를 나눈 값은 "+(a/b));
	}
}

public class Q40_calc {

	public static void main(String[] args) {
		/* 사칙연산 프로그램
		 * 정수와 실수를 입력했을때 연산이 실행되는 프로그램을 만들어라.
		 * 오버로딩 개념 이용
		 * 정수 정수 /실수 실수
		 */
		Scanner scan = new Scanner(System.in);

		System.out.print("1.정수 2.실수 : ");
		int choice = scan.nextInt();
		if(choice == 1) {
			System.out.print("정수 두개를 입력하시오 : ");
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.print("+, -, *, / 중 입력하시오 : ");
			char ch = scan.next().charAt(0);
			if(ch == '+') {
				Plus plus = new Plus(a, b);
			} else if(ch == '-') {
				Minus minus = new Minus(a, b);
			} else if(ch == '*') {
				Multiply multiply = new Multiply(a, b);
			} else {
				Divide divide = new Divide(a, b);
			}
		} else {
			System.out.print("실수 두개를 입력하시오 : ");
			double a = scan.nextDouble();
			double b = scan.nextDouble();
			System.out.print("+, -, *, / 중 입력하시오 : ");
			char ch = scan.next().charAt(0);
			if(ch == '+') {
				Plus plus = new Plus(a, b);
			} else if(ch == '-') {
				Minus minus = new Minus(a, b);
			} else if(ch == '*') {
				Multiply multiply = new Multiply(a, b);
			} else {
				Divide divide = new Divide(a, b);
			}
		}


	}

}
