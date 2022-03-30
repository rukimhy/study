package day3;

import java.util.Random;
import java.util.Scanner;

public class Q5_endQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* A = 65 ~ Z = 90
		 * 0~25까지 랜덤으로 문자를 받는다
		 * 문자 중 Q(65+16=81)가 나오기 전까지 랜덤을 돌려서 문자열을 만든다
		 * 반복문이 종료되고 현재까지 만들어진 문자열을 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		
		
		while(true) 
		{
			int alphabet = 65;
			int random_a = r.nextInt(25);
			
			int sum = alphabet + random_a;
			
			if(sum == 81) break;
			
			System.out.print((char)sum);
		}
		
	}

}
