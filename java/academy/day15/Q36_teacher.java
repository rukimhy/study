package day15;

import java.util.Random;
import java.util.Scanner;

//물고기
class Fish
{

}
//호수
class Hosu
{
	Fish[][] hosu = new Fish[5][5];

	//물고기 세팅작업
	void randomFish()
	{
		Random rand = new Random();
		for(int i = 0;i<3;i++) // 0 1
		{
			int y=rand.nextInt(5);  //3  3 
			int x=rand.nextInt(5);  //2  2
			if(hosu[y][x] == null)
			{
				hosu[y][x] = new Fish();

				System.out.println(y+", "+x);
			}
			else
			{
				i--;
			}
		}
	}
	//물고기 주는작업 낚시꾼에게
	Fish sendFish(int userY, int userX)
	{
		return hosu[userY][userX];
	}

	void nullFish(int userY, int userX)
	{
		hosu[userY][userX] = null;
	}


	public void fishPrint()
	{
		for(int i =0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				if(hosu[i][j] == null)
				{
					System.out.print(0+"	");
				}
				else
				{
					System.out.print(1+"	");
				}
			}
			System.out.println();
		}
	}

}
//낚시꾼
class Fisher
{
	int userY;
	int userX;
	Fish[] fishbowl = new Fish[3];
	int count =0;


	//캐스팅
	public void casting()
	{
		Scanner sc = new Scanner(System.in);
		//한번 하나밖에 보낼 수 없으니까 값을 2개이상 담을 수 있는 배열을 사용한다.
		userX = -1;
		userY = -1;

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
	}
	//이동
	public void move(int move)
	{
		int[] temp = new int[2]; //함수는 하나만 보낼 수 있기 때문에 두개의 userY와 userX를 보내야 하기 때문에
		//배열을 생성
		if(move == 1) //위
		{
			userY--;
			if(userY == -1)
			{
				userY = 0;
				System.out.println("더이상 위로 움직일 수 없습니다.");
			}

		}
		else if(move == 2)//아래
		{
			userY++;
			if(userY == 5)
			{
				userY = 4;
				System.out.println("더이상 아래로로 움직일 수 없습니다.");
			}
		}
		else if(move == 3)//왼쪽
		{
			userX--;
			if(userX == -1)
			{
				userX = 0;
				System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
			}
		}
		else if(move == 4)//오른쪽
		{
			userX++;
			if(userX == 5)
			{
				userX = 4;
				System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
			}
		}
		else
		{
			System.out.println("잘못된 입력입니다.");
		}
	}
	//물고기 잡은것 넣기
	boolean fishRecive(Fish f)
	{
		if(f!=null)
		{
			fishbowl[count] = f;
			count++;
			System.out.println("물고기를 "+count+"를 잡았습니다.");
			return true;
		}
		else
		{
			return false;
		}

	}
	//물고기 잡은거 체크
	boolean fishCheck()
	{
		int check = 0;
		for(int i =0;i<3;i++)
		{
			if(fishbowl[i] !=null)
			{
				check++;
			}
		}

		if(check == 3)
		{
			return false;
		}
		else
			return true;
	}
	
	void fisherPrint()
	{
		System.out.println("현재 낚시꾼의 위치 : "+userY+", "+ userX);
	}
	
}

public class Q36_teacher {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean check = true;
		Hosu h = new Hosu();
		Fisher man = new Fisher();

		h.randomFish();

		man.casting();

		if(man.fishRecive(h.sendFish(man.userY, man.userX)))
		{
			h.nullFish(man.userY, man.userX);
		}

		check=man.fishCheck();

		while(check)
		{
			System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
			int move = sc.nextInt();
			
			man.move(move);
			if(man.fishRecive(h.sendFish(man.userY, man.userX)))
			{
				h.nullFish(man.userY, man.userX);
			}

			man.fisherPrint();
			check=man.fishCheck();
		}

	}
}
