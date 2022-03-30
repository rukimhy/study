package day11;

import java.util.Random;
import java.util.Scanner;

public class Q25_fishing {

	// 3번(주고 안받고) 물고기 랜덤값 생성
	public static int[][] randomArr()
	{
		Random r = new Random();
		int[][] arr = new int[5][5];
		int fish_count = 0;

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

		return arr;
	}

	// 3번(주고 안받고) 캐스팅 
	public static int[] casting() 
	{
		Scanner scan = new Scanner(System.in);
		int x, y;
		int user_count = 0;

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

		int[] new_arr = new int[] {x, y, user_count};

		return new_arr;
	}


	// 2번(안주고 받고) 물고기가 있는 위치 출력 
	public static void whereFish(int arr[][]) {
		for(int i = 0; i < 5; i++) 
		{
			for(int j = 0; j < 5; j++) 
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}


	// 1번(주고 받고) 낚시대 이동
	public static int[] move(int x, int y, int user_count, int[][] arr) {
		Scanner scan = new Scanner(System.in);
		
		
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

			}

			System.out.println();
			int[] new_arr = new int[] {x, y};
			return new_arr;
		}


	// 1번(주고 받고) 물고기 있는 체크 함수
	public static int[] check(int x, int y, int user_count, int[][] arr) {
		
		if(arr[x][y] == 1) 
		{
			user_count++;
			System.out.println("물고기 "+user_count+"마리를 잡았습니다.");
			arr[x][y] = 0;
		}
		if(user_count == 3) 
		{
			System.out.println("축하합니다. 3마리 다 잡았습니다.");
		}
		int[] new_arr = new int[] {arr[x][y], user_count};
		return new_arr;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 낚시 게임 함수화 // 함수 총 5개

		int[][] arr = randomArr();
		whereFish(arr);
		
		int[] casting = casting();
		int[] check_arr = check(casting[0], casting[1], casting[2], arr);
		int x = casting[0];
		int y = casting[1];
		int user_count = check_arr[1];
		
		while(true) {
			int[] move_arr = move(x, y, user_count, arr);
			x = move_arr[0];
			y = move_arr[1];
			
			check_arr = check(x, y, user_count, arr);
			arr[x][y] = check_arr[0];
			user_count = check_arr[1];
			
			if(user_count == 3) break;
		}

	}

}
