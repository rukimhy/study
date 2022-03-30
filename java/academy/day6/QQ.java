package day6;

import java.util.Scanner;

public class QQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		//1번 문제
		System.out.print("1번) 성적을 입력하세요 : ");
		int num1 = scan.nextInt();
		
		if(num1 >= 90) System.out.println("축하합니다. A학점을 취득하셨습니다.");
		System.out.println("감사합니다.");
		
		//2번 문제
		System.out.print("2번) 숫자를 하나 입력하세요 : ");
		int num2 = scan.nextInt();
		
		if(num2 < 0) System.out.println("음수입니다.");
		else if(num2 == 0) System.out.println("0입니다.");
		else System.out.println("양수입니다.");
		
		//3번 문제
		System.out.print("3번) A~F 중 학점을 입력하세요 : ");
		char char1 = scan.next().charAt(0);
		
		if(!(char1 == 'A' || char1 == 'B' || char1 == 'C' || char1 == 'D' || char1 == 'F')) {
			System.out.println("정확한 성적이 아닙니다.");
		} else {
			if(char1 == 'A' || char1 == 'B') {
				System.out.println("우수한 성적입니다.");
			} else if(char1 == 'C' || char1 == 'D') {
				System.out.println("분발하십쇼");
			} else System.out.println("많은 노력이 필요합니다.");
		}
		
		//4번 문제
		System.out.print("4번) 정수를 입력하세요 : ");
		int num4 = scan.nextInt();
		int sum4 = 0;
		for(int i=1; i<=num4; i++) {
			if(i%2 == 0) {
				sum4 += i;
			}
		}
		System.out.println(num4+"까지의 짝수의 합은 "+sum4);
		
		//5번 문제
		System.out.print("5번) 정수를 입력하세요 : ");
		int num5 = scan.nextInt();
		
		System.out.print(num5+"의 약수 : ");
		for(int i=1; i<=num5; i++) {
			if(num5 % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		//6번 문제
		int num6, sum;
		while(true) {
			sum = 0;
			System.out.print("6번) 정수를 입력하세요(종료 = -1) : ");
			num6 = scan.nextInt();
			if(num6 == -1) {
				break;
			}
			else {
				System.out.print("1부터 "+num6+"까지의 결과 : ");
				for(int i=1; i<=num6; i++) {
					sum += i;
				}
				System.out.println(num6+"까지의 합은 "+sum);
			}
		}
	}
}
