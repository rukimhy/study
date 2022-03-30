package day16;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Runner
{
	String country;
	int lane;
	int m;

	void print() 
	{
		System.out.println(lane+"번레인 "+country+" 선수가 현재 "+m+"m 입니다.");
	}

	void winner() 
	{
		if(m >= 100) 
		{
			System.out.println("우승국은 "+country+"입니다!!!");
		}
	}
}

public class Q39_runner {

	public static void main(String[] args) {
		/* 육상선수 4명이 있다. 한국, 중국, 미국, 러시아 선수가 있다.
		 * 턴제 게임이고, 1턴마다 랜덤으로 1~10m씩 이동을 할 수 있다.
		 * 1번레인 - 한국, 2번레인 - 중국, 3번레인 - 미국, 4번레인 - 러시아
		 * 각 턴마다 돌발 상황이 생겨서 한 선수는 이동을 할 수가 없다.
		 * 각 턴마다 출력이 되야한다.
		 * 먼저 100m 결승점에 도착한 나라의 선수가 있으면 "우승국 XXX입니다!" 출력하고 게임을 종료한다.
		 * 동시에 100m를 넘으면 값이 더 큰 국가가 우승한다.
		 */
		Random r = new Random();
		String[] country = new String[]{"한국", "중국", "미국", "러시아"};
		int[] lane = new int[] {1, 2, 3, 4};

		Runner[] runner = new Runner[4];
		for(int i = 0; i<4; i++) 
		{
			runner[i] = new Runner();
			runner[i].country = country[i];
			runner[i].lane = lane[i];
			runner[i].m = 0;
		}

		int turn = 1;
		while(true) 
		{
			int warning = r.nextInt(4);
			for(int i=0; i<4; i++) 
			{
				if(i == warning) continue; // 사고가 나서 한 선수는 한 턴 쉰다.
				else
				{
					int randomMeter = r.nextInt(10)+1;
					runner[i].m += randomMeter;
				}
			}
			System.out.println("-------"+turn+"턴--------");
			for(int i=0; i<4; i++) 
			{
				runner[i].print();
			}
			System.out.println("-------------------------");
			turn++;

			if(runner[0].m >= 100 || runner[1].m >= 100 || runner[2].m >= 100 || runner[3].m >= 100) 
			{
				
				int winIndex = 0;
				for(int i = 1; i<4; i++) // 누가 더 먼 거리를 달렸나 확인한다.
				{
					if(runner[winIndex].m < runner[i].m) 
					{
						winIndex = i;
					}
				}
				runner[winIndex].winner();
				
				break;
			}

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
