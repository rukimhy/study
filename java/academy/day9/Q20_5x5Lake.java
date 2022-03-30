package day9;

import java.util.Random;
import java.util.Scanner;

public class Q20_5x5Lake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 5x5 크기의 호수가 있다. 호수에는 물고기 3마리가 있다.
		 * 물고기의 좌표는 랜덤을 통해서 위치가 정해진다.
		 * 단, 같은 자리에 물고기가 2마리가 있을 수 없다.
		 * 호수와 물고기의 세팅이 끝나면 낚시 게임이 시작된다. 낚시꾼의 캐스팅을 우선 해야한다.
		 * 좌표 x, y를 입력하세요 : 좌표입력; 좌표값이 0보다 작거나 4보다 크면 잘못된 캐스팅입니다. 출력
		 * 이후 다시 캐스팅 요청
		 * 캐스팅을 올바르게 했다면 그 좌표에 물고기가 있는지 체크를 한다.
		 * 만약 그 위치에 물고기 있으면 물고기 1마리를 잡았습니다. 출력 후 낚시대 움직이는 게임 시작
		 * 1.위 2.아래 3.왼쪽 4.오른쪽 : (이동숫자) 입력
		 * 캐스팅을 위치에서 위 -y 아래 +y 왼쪽 -x 오른쪽 +x로 한칸씩 이동한다.
		 * 만약 호수의 크기를 벗어나는 캐스팅이면 더 이상 이동을 할 수 없다.
		 * 출력하고 낚시대 움직이는 게임 시작 화면으로 이동한다.
		 * 물고기 3마리 모두 잡으면 축하합니다. 출력하고 프로그램 종료
		 */
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[5][5];
		int x, y;
		int fish_count = 0;
		int user_count = 0;
		
		while(true) {
			int fishX = r.nextInt(5);
			int fishY = r.nextInt(5);
			if(arr[fishX][fishY] == 0) 
			{
				arr[fishX][fishY] = 1;
				fish_count++;
			}
			if(fish_count == 3) break;
		}
		
		for(int i = 0; i < 5; i++) 
		{
			for(int j = 0; j < 5; j++) 
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		while(true) {
			System.out.println("물고기 잡기 게임을 시작합니다.");
			System.out.print("좌표 x, y를 입력하세요 : ");
			x = scan.nextInt();
			y = scan.nextInt();

			if(x > 4 || x < 0 || y > 4 || y < 0 ) 
			{
				System.out.println("잘못된 캐스팅입니다.");
				System.out.println();
			} else break;
		}
		
		if(arr[x][y] == 1) 
		{
			user_count++;
			System.out.println("물고기 "+user_count+"마리를 잡았습니다.");
			arr[x][y] = 0;
		} 
		
		while(true) {
			System.out.print("[1]위 [2]아래 [3]왼쪽 [4]오른쪽 : ");
			int choice = scan.nextInt();
			
			if(choice < 1 || choice > 4) System.out.println("잘못된 입력입니다.");
			else 
			{
				if(choice == 1) 
				{
					if(x-1 < 0) 
					{
						System.out.println("더 이상 이동할 수 없습니다.");
					} else x--;
				}
				else if(choice == 2) 
				{
					if(x+1 > 4) 
					{
						System.out.println("더 이상 이동할 수 없습니다.");
					} else x++;
				}
				else if(choice == 3) 
				{
					if(y-1 < 0) 
					{
						System.out.println("더 이상 이동할 수 없습니다.");
					} else y--;
				}
				else 
				{
					if(y+1 > 4) 
					{
						System.out.println("더 이상 이동할 수 없습니다.");
					} else y++;
				}
				

				if(arr[x][y] == 1) 
				{
					user_count++;
					System.out.println("물고기 "+user_count+"마리를 잡았습니다.");
					arr[x][y] = 0;
				}
				if(user_count == 3) 
				{
					System.out.println("축하합니다. 3마리 다 잡았습니다.");
					break;
				}
			}
			System.out.println("현재 위치 x : "+x+" / y : "+y);
			System.out.println();
		}

	}
}
