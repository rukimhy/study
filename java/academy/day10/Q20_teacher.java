package day10;

import java.util.Random;
import java.util.Scanner;

public class Q20_teacher {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int [][] hosu = new int[5][5];
		
		int fishCount = 0; 
		
		for(int i = 0;i<3;i++) // 0 1
		{
			int y=rand.nextInt(5);  //3  3 
			int x=rand.nextInt(5);  //2  2
			if(hosu[y][x] == 0)
			{
				hosu[y][x] = 1;
				
				System.out.println(y+", "+x);
			}
			else
			{
				i--;
			}
		}

		int userX = -1;
		int userY = -1;
		while(userX <0 || userX >4 || userY <0 || userY >4)
		{
			System.out.print("좌표 y, x를 입력하세요 : ");
			userY = sc.nextInt();
			userX = sc.nextInt();
			
			if(userX <0 || userX >4 || userY <0 || userY >4)
			{
				System.out.println("좌표의 값이 0보다 작거나 4보다 큽니다. 잘못된 캐스팅입니다.");
			}
			
		}
		
		if(hosu[userY][userX] == 1)
		{
			fishCount++;
			hosu[userY][userX] = 0;
			System.out.println("물고기를 "+fishCount+"를 잡았습니다.");
		}
		
		while(fishCount <3)
		{
			System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
			int move = sc.nextInt();
			
			if(move == 1) //위
			{
				userY--;
				if(userY == -1)
				{
					userY = 0;
					System.out.println("더이상 위로 움직일 수 없습니다.");
					continue;// 이걸 안쓰면 어떤 문제가 있을 까요?
				}
				System.out.println("y : "+userY+", x :"+userX);
				if(hosu[userY][userX] == 1)
				{
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("물고기를 "+fishCount+"를 잡았습니다.");
				}
				
			}
			else if(move == 2)//아래
			{
				userY++;
				if(userY == 5)
				{
					userY = 4;
					System.out.println("더이상 아래로로 움직일 수 없습니다.");
					continue;// 이걸 안쓰면 어떤 문제가 있을 까요?
				}
				System.out.println("y : "+userY+", x :"+userX);
				if(hosu[userY][userX] == 1)
				{
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("물고기를 "+fishCount+"를 잡았습니다.");
				}
			}
			else if(move == 3)//왼쪽
			{
				userX--;
				if(userX == -1)
				{
					userX = 0;
					System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
					continue;// 이걸 안쓰면 어떤 문제가 있을 까요?
				}
				System.out.println("y : "+userY+", x :"+userX);
				if(hosu[userY][userX] == 1)
				{
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("물고기를 "+fishCount+"를 잡았습니다.");
				}
			}
			else if(move == 4)//오른쪽
			{
				userX++;
				if(userX == 5)
				{
					userX = 4;
					System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
					continue;// 이걸 안쓰면 어떤 문제가 있을 까요?
				}
				
				System.out.println("y : "+userY+", x :"+userX);				
				
				if(hosu[userY][userX] == 1)
				{
					fishCount++;
					hosu[userY][userX] = 0;
					System.out.println("물고기를 "+fishCount+"를 잡았습니다.");
				}
			}
			else
			{
				System.out.println("잘못된 입력입니다.");
			}
		}
		
	}
}
