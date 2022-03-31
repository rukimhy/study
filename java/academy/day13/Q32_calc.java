package academy.day13;

import java.util.Scanner;

class Sum {
	void sum(int a, int b) {
		System.out.println(a + b);
	}
}

class Minus {
	void minus(int a, int b) {
		System.out.println(a - b);
	}
}

class Multiply {
	void multiply(int a, int b) {
		System.out.println(a * b);
	}
}

class Divide {
	void divide(int a, int b) {
		System.out.println(a / b);
	}
}

public class Q32_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("�� ���ڸ� �Է��Ͻÿ� : ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.print("+, -, *, / �߿� �Է��Ͻÿ� : ");
		char c = scan.next().charAt(0);

		if (c == '+') {
			Sum sum = new Sum();
			sum.sum(a, b);
		} else if (c == '-') {
			Minus minus = new Minus();
			minus.minus(a, b);
		} else if (c == '*') {
			Multiply multiply = new Multiply();
			multiply.multiply(a, b);
		} else {
			Divide divide = new Divide();
			divide.divide(a, b);
		}
	}

}
