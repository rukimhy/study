package day3;

import java.util.Random;
import java.util.Scanner;

public class Rock_paper_scissors {

	public static void main(String[] args) {
		// 가위바위보 게임. 문자열을 입력 받아 "가위" "바위" "보". 컴퓨터는 랜덤으로 가위 바위 보. "유저가 이겼습니다." "비겼습니다." "컴퓨터가 이겼습니다."
		// 이외의 입력은 "잘못된 입력입니다." 출력 후 바로 종료
		// 0 = 가위, 1 = 바위, 2 = 보
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("컴퓨터와 가위 바위 보 게임을 시작합니다.");
		System.out.print("가위, 바위, 보 중 하나를 입력하시오 : ");
		String str = scan.next();
		int i = -1;
		int cpu_choice = rand.nextInt(3);
		
		if(str.equals("가위")) {
			i = 0;
			if(cpu_choice == 0) {
				System.out.println("비겼습니다.");
			} else if(cpu_choice == 1) {
				System.out.println("컴퓨터가 이겼습니다.");
			} else {
				System.out.println("유저가 이겼습니다.");
			}
		} else if(str.equals("바위")) {
			i = 1;
			if(cpu_choice == 0) {
				System.out.println("유저가 이겼습니다.");
			} else if(cpu_choice == 1) {
				System.out.println("비겼습니다.");
			} else {
				System.out.println("컴퓨터가 이겼습니다.");
			}
		} else if(str.equals("보")) {
			i = 2;
			if(cpu_choice == 0) {
				System.out.println("컴퓨터가 이겼습니다.");
			} else if(cpu_choice == 1) {
				System.out.println("유저가 이겼습니다.");
			} else {
				System.out.println("비겼습니다.");
			}
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

}
