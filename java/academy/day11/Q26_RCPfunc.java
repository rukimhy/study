package day11;

import java.util.Random;
import java.util.Scanner;

public class Q26_RCPfunc {

	//컴퓨터 랜덤 구현
	public static int cpu_random() {
		Random r = new Random();
		int cpu_choice = r.nextInt(3);
		return cpu_choice;
	}

	
	//usr_input 입력
	public static String usr_input_input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("가위, 바위, 보 중 하나를 입력하세요 : ");
		String usr_choice = scan.next();
		
		return usr_choice;
	}
	
	//usr_input 판별
	public static int usr_input_check() {
		int usr_number;
		while(true) {
			String usr_choice = usr_input_input();
			if(usr_choice.equals("종료")) {
				usr_number = -1;
				break;
			} else {
				if(!(usr_choice.equals("가위") || usr_choice.equals("바위") || usr_choice.equals("보"))) 
				{
					System.out.println("잘못된 입력입니다."); 
				} 

				else 
				{
					if(usr_choice.equals("가위")) usr_number = 0;
					else if(usr_choice.equals("바위")) usr_number = 1;
					else usr_number = 2;
					break;
				}
			}
		}
		return usr_number;
	}
	
	//게임 시작
	public static void game_start() {
		System.out.println("----------------------------------------");
		System.out.println("컴퓨터와 하는 가위 바위 보 게임입니다.");
		System.out.println("가위, 바위, 보 중 하나를 입력하세요.");
		System.out.println("[종료]라고 입력하면 게임이 끝납니다.");
		System.out.println("----------------------------------------");
	}
	
	//가위바위보 판별
	public static int[] RCP(int usr_sum[]) {
		if(usr_sum[0] == 1 || usr_sum[0] == -2) {
			System.out.println("유저가 이겼습니다.");
			usr_sum[1]++;
		} else if(usr_sum[0] == 0) {
			System.out.println("비겼습니다.");
			usr_sum[2]++;
		} else {
			System.out.println("컴퓨터가 이겼습니다.");
			usr_sum[3]++;
		}
		return usr_sum;
	}
	

	//게임 구현
	public static void output() {
		// TODO Auto-generated method stub
		// 가위바위보 문제 함수화하는데 최대한 잘게 쪼개서 하고 메인문에 함수 하나만 호출
		// 0 = 가위, 1 = 바위, 2 = 보

		int[] sum = new int[4];
		
		game_start();
		
		while(true) {

			int usr_number = usr_input_check();
			if(usr_number == -1) break;
			else {
				int cpu_choice = cpu_random();
				int usr_sum = usr_number - cpu_choice; 
				sum[0] = usr_sum;

				sum = RCP(sum);
			}
		}
		System.out.println("");
	}



	public static void main(String[] args) {
		output();
	}

}
