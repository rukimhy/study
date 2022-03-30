package day12;

import java.util.Random;
import java.util.Scanner;

public class Q25_teacher {

	//3번유형
	public static int [][] fishRandom()
	{
		Random rand = new Random();
		int [][] hosu = new int[5][5];
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
		
		return hosu;
	}
	
	
	//3번 유형
	public static int[] casting()
	{
		Scanner sc = new Scanner(System.in);
		int[] temp = new int[2]; //Y, X 값을 동시에 리턴을 해주기 위해서 배열을 이용해서 보내야한다.
		//한번 하나밖에 보낼 수 없으니까 값을 2개이상 담을 수 있는 배열을 사용한다.
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
		//캐스팅 된 userY와 userX를 temp 배열에 [0] [1]각각 담아서 리턴한다.
		temp[0] = userY;
		temp[1] = userX;
		return temp;
	}
	
	
	//2번 유형
	public static void fishPrint(int [][] hosu)
	{
		for(int i =0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.print(hosu[i][j]+"	");
			}
			System.out.println();
		}
	}
	
	//1번 유형
	public static int[] move(int move, int userY, int userX)
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
		
		temp[0] = userY; // temp[0] -> userY
		temp[1] = userX; // temp[1] -> userX
		return temp; //temp배열을 리턴
	}
	
	//1번 유형
	public static int check(int[][] hosu, int userY, int userX)
	{
		
		if(hosu[userY][userX] == 1) //호수 배열에 물고기가 있는지 확인
		{
			hosu[userY][userX] = 0; // 호수 배열의 값을 0으로 세팅해서 물고기를 잡음
			return 1;//1을 리턴
		}
		return 0;//0을 리턴
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int [][] hosu = fishRandom();
		fishPrint(hosu);
		int userY = 0;
		int userX = 0;
		int fishCount = 0; 
		
		int[] cast = casting(); //캐스팅 함수에서 리턴한 배열을 cast배열이 받는다.
		
		userY = cast[0]; //cast 배열[0]에 있는 값을 userY에 대입
		userX = cast[1]; //cast 배열[1]에 있는 값을 userX에 대입
		
		//캐스팅 했을때 바로 물고기가 있는지 확인하는 함수
		if(hosu[userY][userX] == 1)
		{
			fishCount++;
			hosu[userY][userX] = 0;
			System.out.println("물고기를 "+fishCount+"를 잡았습니다.");
		}
		
		//물고기가 3마리 잡힐때 까지 계속 반복
		while(fishCount <3)
		{
			System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
			int move = sc.nextInt();
			
			int[] temp = move(move, userY, userX); // 낚시대 움직여서 나온 결과 값을 temp배열이 받습니다.
			userY = temp[0]; // temp[0] -> userY
			userX = temp[1]; // temp[1] -> userX 
			
			System.out.println("y : "+userY+", x :"+userX);
			//체크함수를 호출해서 물고기를 잡았는지 확인
			int num = check(hosu, userY, userX); //체크에 대한 결과 값을 num변수가 받습니다.
			
			if(num == 1) //num이 1이면 물고기를 잡은 것임
			{
				fishCount += num;// 물고기 카운터를 1 증가
				System.out.println("물고기를 "+fishCount+"를 잡았습니다."); //출력
			}
			
		}
		
	}
}
