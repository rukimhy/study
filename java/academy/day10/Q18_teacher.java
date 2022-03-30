package day10;

import java.util.Scanner;

public class Q18_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);// 입력 객체
		int[][] seat = new int[8][2]; //8줄 2개의 좌석 초기 값은 0으로 세팅
		//계속적으로 반복문을 돌려서 현재 남아있는 자릿 수를 구하는게 현명한가요?
		//변수를 만들어서 계속 카운팅 하는게 현명할까요?
		int count = 0;
		
		while(true)
		{
			System.out.print("1. 예매 2. 빈좌석 확인 3. 종료 :");
			int sel = sc.nextInt();
			if(sel == 1)
			{
				if(count == 16)
				{
					System.out.println("모든 좌석이 예약 됐습니다.");
				}
				else
				{
					System.out.print("좌석을 선택하세요 : ");
					int num1 = sc.nextInt();
					int num2 = sc.nextInt();
					
					if(seat[num1][num2] == 0)
					{
						seat[num1][num2] = 1;
						System.out.println((num1+1)+"행"+(num2+1)+"번째 자리가 예약 됐습니다.");
						count++;
					}
					else
					{
						System.out.println("이미 예약된 좌석입니다.");
					}
				}
			}
			else if(sel == 2)
			{
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
			else if(sel == 3)
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

}
