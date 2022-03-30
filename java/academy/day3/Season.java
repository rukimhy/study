package day3;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {
		//1~12 숫자를 하나 입력받아 1보다 작거나 12보다 큰경우 "잘못된 입력입니다."를 출력
		//올바르게 숫자가 입력되면 3~6 => "봄입니다." 7~9 => "여름입니다." 10~11 => "가을입니다." 12~2 => "겨울입니다."
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월별 계절을 알려주는 프로그램입니다.");
		System.out.print("1부터 12까지의 숫자 중 하나를 입력하세요 : ");
		int num = scan.nextInt();
		
		if(num >= 3 && num <= 6) {
			System.out.println("봄입니다.");
		} else if(num >= 7 && num <= 9) {
			System.out.println("여름입니다.");
		} else if(num >= 10 && num <= 11) {
			System.out.println("가을입니다.");
		} else if(num == 12 || num == 1 || num ==2 ) {
			System.out.println("겨울입니다.");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

}
