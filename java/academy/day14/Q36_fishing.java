package day14;

import java.util.Random;
import java.util.Scanner;

class Fish{}

class Fisher{
	
	//물고기 가두리
	Fish[] fish = new Fish[3];
	
	//캐스팅 
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

	//낚시대 이동
	public static int[] move(int x, int y) {
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
}

class Lake{	
	//물고기 랜덤값 생성
	public static Fish[][] random_arr(){
		Random r = new Random();
		Fish[][] arr = new Fish[5][5];
		int fish_count = 0;

		while(true) {
			int fishX = r.nextInt(5);
			int fishY = r.nextInt(5);
			if(arr[fishX][fishY] == null) 
			{
				arr[fishX][fishY] = new Fish();
				fish_count++;
			}
			if(fish_count == 3) break;
		}

		return arr;
	}

	//물고기 있는 체크 함수
	public static int[] check(int x, int y, int user_count, Fish[][] arr, Fish[] fish) { 
		
		if(arr[x][y] != null) 
		{
			fish[user_count] = new Fish();
			user_count++;
			System.out.println("물고기 "+user_count+"마리를 잡았습니다.");
			arr[x][y] = null;
		}
		if(user_count == 3) 
		{
			System.out.println("축하합니다. 3마리 다 잡았습니다.");
		}
		int[] new_arr = new int[] {x, y, user_count};
		return new_arr;
	}
}

public class Q36_fishing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fisher fisher = new Fisher();
		Lake lake = new Lake();

		Fish[][] arr = lake.random_arr();

		int[] casting = fisher.casting();
		int x = casting[0];
		int y = casting[1];
		int[] check_arr = lake.check(x, y, casting[2], arr, fisher.fish);
		int user_count = check_arr[2];

		while(true) {
			
			int[] move_arr = fisher.move(x, y);
			x = move_arr[0];
			y = move_arr[1];

			check_arr = lake.check(x, y, user_count, arr, fisher.fish);
			user_count = check_arr[2];

			if(fisher.fish[0] != null && fisher.fish[1] != null && fisher.fish[2] != null) break;
		}

	}

}
