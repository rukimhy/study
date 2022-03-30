package day12;

import java.util.Scanner;

public class Q28_teacher2 {

	public static int one(int[][] seat,int count )
	{
		Scanner sc = new Scanner(System.in);// 입력 객체
		//함수
		if(count == 16)
		{
			System.out.println("모든 좌석이 예약 됐습니다.");
		}
		System.out.print("좌석을 선택하세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if(seat[num1][num2] == 0)
		{
			seat[num1][num2] = 1;
			System.out.println((num1+1)+"행"+(num2+1)+"번째 자리가 예약 됐습니다.");
			return 1;  //1
		}
		else
		{
			System.out.println("이미 예약된 좌석입니다.");
			return 0;
		}
	}
	public static void two(int[][] seat)
	{
		//함수
		for(int i =0;i<8;i++)
		{
			for(int j =0;j<2;j++)
			{
				if(seat[i][j] == 0)
				{
					System.out.println((i+1)+"행"+(j+1)+"번째 자리가 비어있습니다.");
				}
			}
		}
	}
	public static boolean three()
	{
		//함수
		System.out.println("프로그램을 종료합니다.");
		return false;
	}
	public static void four()
	{
		//함수
		System.out.println("잘못된 입력입니다.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);// 입력 객체
		int[][] seat = new int[8][2]; // 함수로 보내면 소스가 어려워
		int count = 0; // 무조건
		boolean check = true;
		
		while(check) //sel 조건으로 종료인 3 입력시 종료 시키면 됩니다. true
		{
			//함수
			System.out.print("1. 예매 2. 빈좌석 확인 3. 종료 :");
			int sel = sc.nextInt();
			
			if(sel == 1)
			{
				count+=one(seat, count);

			}
			else if(sel == 2)
			{
				two(seat);
			}
			else if(sel == 3)
			{
				check = three();
			}
			else
			{
				four();
			}
		}

	}
}


