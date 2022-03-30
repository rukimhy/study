package day9;

import java.util.Scanner;

public class Q18_booking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 비행기 예약 프로그램 만들기
		 * 좌석이 8줄 2개의 좌석이 존재합니다.
		 * 1. 예매 2. 빈좌석 확인 3. 종료
		 * 1번 예매 시 좌석을 선택하세요 : 3 0(엔터)
		 * 3행 0번째 자리가 비어 있으면 좌석 예약이 되었습니다. 출력
		 * 만약 예약이 되어 있다면 이미 예약된 좌석입니다. 출력
		 * 1번 예매를 진행을 하려고 하는데 만약 모든 좌석이 예약 되어있다면 모든 좌석의 예매가 끝났습니다.
		 * 출력 이후에 첫 화면으로 이동
		 * 잘못된 입력시 첫화면으로 이동
		 * 2번 빈좌석 확인을 선택하면 비어있는 좌석의 정보를 전체 출력합니다.
		 * 3번 입력시 프로그램을 종료합니다. 출력하고 프로그램 종료
		 * 메뉴 1, 2, 3이외의 입력은 잘못된 입력입니다. 출력
		 */
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[8][2];

		System.out.println("비행기 예약 프로그램입니다.");

		while(true) {
			int count = 0;
			System.out.println("1. 예매");
			System.out.println("2. 빈 좌석 확인");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택해주세요 : ");
			int user = scan.nextInt();

			if(user != 1 && user != 2 && user != 3) 
			{
				System.out.println("잘못된 입력입니다.");
			} 
			else if(user == 3) 
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
			else if(user == 2) 
			{
				System.out.println("-----비어있는 좌석은-----");
				for(int i = 0; i < 8; i++) 
				{
					for(int j = 0; j < 2; j++) 
					{
						if(arr[i][j] == 0) 
						{
							System.out.print(i+"행 "+j+" 번 // ");
						}
					}
					System.out.println();
				}
				System.out.println();
				System.out.println("-------------------------");				
			} 
			else 
			{
				for(int i = 0; i < 8; i++) 
				{
					for(int j = 0; j < 2; j++) 
					{
						if(arr[i][j] == 1) count++;
					}
				}
				if(count == 16) 
				{
					System.out.println("모든 좌석의 예매가 끝났습니다.");
				} 
				else 
				{
					System.out.print("좌석을 선택해주세요 : ");
					int x = scan.nextInt();
					int y = scan.nextInt();

					if(x > 7 || x < 0 || y > 1 || y < 0) 
					{
						System.out.println("잘못된 입력입니다.");
					} 
					else if(arr[x][y] == 1) 
					{
						System.out.println("이미 예약된 좌석입니다.");
					} 
					else 
					{
						System.out.println("좌석이 예약되었습니다.");
						arr[x][y] = 1;
					}
				}
			}
			System.out.println();
		}
	}

}
