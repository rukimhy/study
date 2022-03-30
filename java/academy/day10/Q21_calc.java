package day10;

import java.util.Scanner;


public class Q21_calc {
	
	
	//1번 주고 받고
	public static int add(int a, int b) {
		int sum = a + b;
		return sum;
	}
	
	//2번 안주고 받고
	public static void minus(int a, int b) {
		System.out.println("결과값은 "+(a-b));
	}
	
	//3번 주고 안받고
	public static int multiply() {
		Scanner scan = new Scanner(System.in);

		System.out.print("숫자1 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("숫자2 입력 : ");
		int num2 = scan.nextInt();

		return num1*num2;
	}
	
	//4번 안주고 안받고
	public static void devide() {
		Scanner scan = new Scanner(System.in);

		System.out.print("숫자1 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("숫자2 입력 : ");
		int num2 = scan.nextInt();

		System.out.println("결과값은 "+num1/num2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		char calc;

		System.out.print("연산자를 입력하세요 (+,-,*,/) : ");
		calc = scan.next().charAt(0);

		if(calc == '+') {
			System.out.print("숫자1 입력 : ");
			int num1 = scan.nextInt();
			System.out.print("숫자2 입력 : ");
			int num2 = scan.nextInt();

			System.out.println("결과값은 "+add(num1, num2));
		}
		else if(calc == '-') {
			System.out.print("숫자1 입력 : ");
			int num1 = scan.nextInt();
			System.out.print("숫자2 입력 : ");
			int num2 = scan.nextInt();
			minus(num1, num2);
		}
		else if(calc == '*') {
			System.out.println("결과값은 "+multiply());
		}
		else if(calc == '/') {
			devide();
		}
	}

}
