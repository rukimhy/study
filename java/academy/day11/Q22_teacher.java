package day11;

import java.util.Scanner;

public class Q22_teacher {
	
	public static String input()
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		return str;
	}
	
	public static String makeString(String str)
	{
		char[][] ch = {
				{'1'},//1
				{'A', 'B', 'C'}, // 2
				{'D', 'E', 'F'}, // 3
				{'G', 'H', 'I'}, // 4
				{'J', 'K', 'L'}, // 5
				{'M', 'N', 'O'}, // 6
				{'P', 'Q', 'R', 'S'}, // 7
				{'T', 'U', 'V'}, // 8
				{'W', 'X', 'Y', 'Z'}, // 9
				{'*'},//*
				{'0'},//0
				{'#'}//#
		};
		
		String make = "";
		
		int i = 0;
		while(i != str.length())
		{
			if(str.charAt(i) == '1' || str.charAt(i) == '*' || 
					str.charAt(i) == '0' ||str.charAt(i) == '#')
			{
				make += str.charAt(i);
				i++;
			}
			else
			{
				int count = 0;

				System.out.println(i);

				while(i+count < str.length()&&str.charAt(i) == str.charAt(i+count))
				{
					count++;
				}

				System.out.println(count);
				//						
				if(str.charAt(i) == '9' || str.charAt(i) == '7')
				{

					int num = (str.charAt(i) - '0') -1;
					make+=ch[num][(count-1)%4];

				}
				else
				{
					int num = (str.charAt(i) - '0') -1;
					make+=ch[num][(count-1)%3];
				}

				i += count;

				System.out.println(make);
			}

			

		}
		return make;
	}
	
	public static void output()
	{

		while(true)
		{			
			String make = makeString(input());
			
			System.out.println("결과 값 : "+make+"입니다.");


			if(make.equals("QUIT"))
			{

				System.out.println(make+"입니다. 프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		output();

	}
}
