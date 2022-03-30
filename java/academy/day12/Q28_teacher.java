package day12;

import java.util.Scanner;

public class Q28_teacher {
	public static void guide() {
		System.out.println("비행기 에약 프로그램입니다.");
		System.out.print("1.예매 2.빈좌석 확인 3. 종료 : ");
	}

	public static boolean triger(int N) {
		if(N==16) //예약 다 찼을 떄의 트리거
		{
			System.out.println("죄송합니다. 모든 좌석의 예매가 끝났습니다.");
			return false;
		}
		return true;
	}

	
	public static int input() {
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		return str;
	}
	
	public static int[] input2()
	{
		int[] temp = new int[2];
		Scanner sc = new Scanner(System.in);
		System.out.print("좌석을 선택하세요. : ");
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		temp[0] = R;
		temp[1] = C;
		
		return temp;
	}
	
	public static boolean failCheck(int[] input)
	{
		if (input[0] > 7 || input[0] < 0 || input[0] > 1 || input[1] < 0) {
			System.out.println("잘못된 입력입니다.");
			return false;
		}
		return true;
	}
	
	public static int reserve(boolean[][] seat, int R, int C)
	{
		if (seat[R][C] == true) {
			System.out.println("이미 예약된 좌석입니다.");
		}
		if (seat[R][C] == false) {
			seat[R][C] = true;
			System.out.println(R + "열" + C + "석 예약이 완료되었습니다.");
			return 1;
		}
		
		return 0;
		
	}
	
	public static void allPrint(boolean [][] seat)
	{
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[2].length; j++)
				if (seat[i][j] == false) // boolean 배열의 초기값은 false 로 초기화 되므로 false는 빈좌석
				{
					System.out.println(i + "열" + j + "석 이 비어있습니다. ");
				}
		}
	}

	public static void P() {

		
		boolean[][] seat = new boolean[8][2]; // true 예약 false 는 빈자리
		
		int N = 0;
		
		while (true) {

			guide();
			int str=input();
			
			if(str == 1)
			{
				boolean maxCheck=triger(N);
				if(maxCheck)
				{
					int[] temp=input2();
					boolean inputCheck=failCheck(temp);
					if(inputCheck)
					{
						N += reserve(seat, temp[0], temp[1]);
					}
				}
				else
				{
					N = 16;
				}
			}
			else if(str == 2)
			{
				allPrint(seat);
			}
			else if(str == 3)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else
			{
				System.out.println("잘못된 입력입니다.");
			}
		}
	}	

	public static void main(String[] args) {
		P();

	}
}
