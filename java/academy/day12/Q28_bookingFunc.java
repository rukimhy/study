package day12;

import java.util.Scanner;

public class Q28_bookingFunc {

	// 1. 예매
	public static int book(int arr[][], int count) {
		Scanner scan = new Scanner(System.in);

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
		return count;
	}

	// 2. 빈 좌석 확인
	public static void check(int arr[][]) {
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

	// 3. output
	public static void output() {
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
				check(arr);	
			} 
			else 
			{
				count = book(arr, count);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 18번 문제 최소 3개 이상의 함수로 구현
		output();
	}

}
