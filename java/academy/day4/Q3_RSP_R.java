package day4;

import java.util.Random;
import java.util.Scanner;

public class Q3_RSP_R {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 유저승 가위0/보2 바위1/가위0 보2/바위1 => 유저 - 컴퓨터 = 1 or -2
		
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		 // 0 = 가위, 1 = 바위, 2 = 보
		int usr_win = 0, usr_defeat = 0, usr_draw = 0;
		
		System.out.println("----------------------------------------");
		System.out.println("컴퓨터와 하는 가위 바위 보 게임입니다.");
		System.out.println("가위, 바위, 보 중 하나를 입력하세요.");
		System.out.println("[종료]라고 입력하면 게임이 끝납니다.");
		System.out.println("----------------------------------------");

		while(true) {
			int cpu_choice = r.nextInt(3);
			int usr_number; int sum;
			
			System.out.print("가위, 바위, 보 중 하나를 입력하세요 : ");
			String usr_choice = scan.next();
			
			if(usr_choice.equals("종료")) {
				System.out.println("종료합니다.");
				System.out.println("----------------------------------------");
				System.out.println("유저의 승 : "+ usr_win);
				System.out.println("무승부 : "+ usr_draw);
				System.out.println("유저의 패 : "+ usr_defeat);
				System.out.println("----------------------------------------");
				break;
				
			} else {
				if(!(usr_choice.equals("가위") || usr_choice.equals("바위") || usr_choice.equals("보"))) {
					System.out.println("잘못된 입력입니다.");
					System.out.println("종료합니다.");
					break;
				} else {
					if(usr_choice.equals("가위")) usr_number = 0;
					else if(usr_choice.equals("바위")) usr_number = 1;
					else usr_number = 2;
					
					sum = usr_number - cpu_choice;
					
					if(sum == 1 || sum == -2) {
						System.out.println("유저가 이겼습니다.");
						usr_win++;
					} else if(sum == 0) {
						System.out.println("비겼습니다.");
						usr_draw++;
					} else {
						System.out.println("컴퓨터가 이겼습니다.");
						usr_defeat++;
					}
				}
				System.out.println("");
			}
		}
	}
}
