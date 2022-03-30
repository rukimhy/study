package day14;

import java.util.Random;

class Monkey{
	Fire fire_check;
	String color;
	void print() {
		if(fire_check != null) {
			System.out.println(color+" 원숭이가 불을 가지고 있습니다.");
		}
	}
}

class Fire{
	
}

public class Q35_monkey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 원숭이 불수건 돌리기 게임
		 * 원숭이 5마리가 있다. 각각 빨간색, 노란색, 파란색, 초록색, 검정색
		 * 랜덤으로 숫자 두 개 받는다. 하나는 0(왼쪽) 1(오른쪽) / 하나는 1~5까지 중 랜덤
		 * 원숭이는 시계방향으로 빨노파초검, 불은 객체화한다.
		 * 메인문에서 두 랜덤값을 출력한다.
		 * 원숭이는 불이 자기한테 오면 "XXX 원숭이가 불을 가지고 있습니다."가 출력되야한다.
		 */
		
		Random r = new Random();
		int direction = r.nextInt(2);
		int count = r.nextInt(5)+1;
		
		Fire fire = new Fire();
				
		Monkey[] monkey = new Monkey[5];
		for(int i = 0; i < 5; i++) 
		{
			monkey[i] = new Monkey();
		}
		monkey[0].color = "빨간색";
		monkey[1].color = "노란색";
		monkey[2].color = "파란색";
		monkey[3].color = "초록색";
		monkey[4].color = "검정색";
		
		System.out.println("방향값 : "+direction+" // 이동값 : "+count);

		if(direction == 1) {
			for(int i = 1; i <= count; i++) 
			{
				if(i % 5 != 0) 
				{
					monkey[i].fire_check = new Fire();
					
					monkey[i].print();
					monkey[i].fire_check = null;
				}
				else 
				{
					monkey[0].fire_check = new Fire();
					monkey[0].print();
					monkey[0].fire_check = null;

				}
			}
			
		} 
		else 
		{
			for(int i = 4; i > 4-count; i--) 
			{
				monkey[i].fire_check = new Fire();
				monkey[i].print();
				monkey[i].fire_check = null;

			}
		}
	}
}
