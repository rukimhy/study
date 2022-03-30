package day11;

import java.util.Random;
import java.util.Scanner;

public class Q23_teacher {

	public static int[] ComRandom()
	{
		Random r = new Random(); //랜덤 객체생성
		int[] com = new int[3];
		com[0] = r.nextInt(9)+1; //컴퓨터의 랜덤값
		com[1] = r.nextInt(9)+1;//두번째 랜덤값
		while(com[0] == com[1]) //랜덤값 중복 방지를 위한 식
		{
			com[1] = r.nextInt(9)+1; 
		}

		com[2] = r.nextInt(9)+1;//세번째 랜덤값
		while(com[0] == com[2] || com[1] == com[2]) //세번째 랜덤값도 중복 방지를 위한 식
		{
			com[2] = r.nextInt(9)+1; 
		}
		System.out.println(com[0] + " " + com[1] +" " + com[2]); // 정해진 랜덤값 출력
		
		return com;
		
	}
	
	public static int[] UserInput()
	{
		Scanner sc = new Scanner(System.in);//스캐너 객체 생성
		int[] user = new int[3];
		System.out.print("숫자 1 입력: ");
		user[0] = sc.nextInt();
		System.out.print("숫자 2 입력: ");
		user[1] = sc.nextInt();
		System.out.print("숫자 3 입력: ");
		user[2] = sc.nextInt();
		
		return user;
	}

	public static int[] CheckFunc(int[] user, int[] com)
	{
		int[] result = new int[2];
		int strike = 0;
		int ball = 0;


		for(int i =0;i<3;i++) //user
		{
			for(int j = 0;j<3;j++) // com
			{
				if(user[i] == com[j])
				{
					if(i==j)
					{
						strike++;
					}
					else
					{
						ball++;
					}
				}

			}
		}
		
		result[0] = strike;
		result[1] = ball;
		
		return result;
	}

	public static boolean ResultPrint(int[] result)
	{
		if(result[0] == 3)
		{
			System.out.println("홈런입니다.");
			return false;
		}
		else if(result[0] == 0 && result[1] == 0)
		{
			System.out.println("out입니다.");
		}
		else
		{
			System.out.println("Strike :"+result[0]+","+"Ball : "+result[1]+"입니다.");
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		//ComRandom


		///////////////////////////////////////////

		//UserInput	
		
		/////////////////////////////////////////////////////

		//CheckFunc
		


		////////////////////////////////////////////////////

		//ResultPrint
		
		///////////////////////////////////////////////////////////////////////////

		int[] com =ComRandom();
		boolean check = true;
		
		while(check)
		{
			check=ResultPrint(CheckFunc(UserInput(), com)) ;
		}
	}

}
