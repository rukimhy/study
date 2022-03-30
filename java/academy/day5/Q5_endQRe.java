package day5;

import java.util.Random;
import java.util.Scanner;

public class Q5_endQRe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* A = 65 ~ Z = 90
		 * 0~25까지 랜덤으로 문자를 받는다
		 * 문자 중 Q(65+16=81)가 나오기 전까지 랜덤을 돌려서 문자열을 만든다
		 * 반복문이 종료되고 현재까지 만들어진 문자열을 출력
		 * 문자 입력 받아서 끝날 때 그 문자가 문자열에 몇개 있는지 개수 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		System.out.print("A~Z 중 문자를 하나 입력해주세요 : ");
		char a2z = scan.next().charAt(0);
		
		while(true) {
			if(!((int)a2z >= 65 && (int)a2z <= 90)) {
				System.out.println("잘못입력하셨습니다.");
				System.out.print("A~Z 중 문자를 하나 입력해주세요 : ");
				a2z = scan.next().charAt(0);
			} else break;
		}
		
		int count = 0;
		
		while(true) 
		{
			int alphabet = 65;
			int random_a = r.nextInt(25);
			
			int sum = alphabet + random_a;
			
			if(sum == a2z) count++;
			
			if(sum == 81) break;
			
			System.out.print((char)sum);
		}
		System.out.println("\n"+a2z+"의 개수는 "+count+"개 입니다.");
	}
}
