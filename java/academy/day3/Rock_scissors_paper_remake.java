package day3;

import java.util.Random;
import java.util.Scanner;

public class Rock_scissors_paper_remake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("컴퓨터와 가위 바위 보 게임을 시작합니다.");
		System.out.print("가위, 바위, 보 중 하나를 입력하시오 : ");
		String str = scan.next();
		
		int i = -1;
		int sum = 0;
		int cpu_choice = rand.nextInt(3);
		
		if(!(str.equals("가위") || str.equals("바위") || str.equals("보"))) {
			System.out.println("잘못된 입력입니다.");
		} else {
			if(str.equals("가위")) {
				i = 0;
			} else if(str.equals("바위")) {
				i = 1;
			} else {
				i = 2;
			}
			
			sum = i - cpu_choice;
			
			if(sum == 1 || sum == -2) {
				System.out.println("유저가 이겼습니다.");
			} else if(sum == 0) {
				System.out.println("비겼습니다.");
			} else {
				System.out.println("컴퓨터가 이겼습니다.");
			}
			System.out.println("컴퓨터의 수 : " + cpu_choice + " - 유저의 수 : " + i);
		}
	}

}
