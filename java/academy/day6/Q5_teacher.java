package day6;

import java.util.Random;
import java.util.Scanner;

public class Q5_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str =""; //문자열객체 변수 생성 이름은 str 이고 초기값은 아무문자열이 없다.
		Random r = new Random();//Random객체를 생성할때 생성된 이름은 r이다.
		Scanner sc = new Scanner(System.in);
		while(true)//무한반복
		{
			int ran = r.nextInt(26)+65;
			//정수형 변수 ran 만들고 랜덤값으로 0~25까지를 추출하여서
			//65를 더한 값을 ran 변수에 초기값으로 대입한다.
			if((char)ran == 'Q')
			//ran 변수를 강제형변환을 하여서 문자 'Q'와 비교를 해서 참이면 아래 명령어 실행
			{
				break;//제일 가까운 반복문탈출한다.
			}
			else//위에 if문 조건이 거짓이면 실행한다.
			{
				str += (char)ran;
				//문자열 더하기연산을 하는데 ran변수를 char형으로 강제형변환한 값을 
				//str문자열 변수에 추가한다.
			}
		}
		System.out.println(str);//문자열 변수 str에 값을 출력한다.	
		
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);
		int count = 0;
		for(int i =0;i<str.length();i++)
		{
			if(ch == str.charAt(i))
			{
				count++;
			}
		}
		
		System.out.println(ch+"의 총 갯수는 "+count+"입니다.");
		
	}

}
