package day17;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//달리기선수
class Player
{
	//나라, 이동거리 , 돌발 상황(기능)
	String nara;
	int move =0;
	
	Player(String nara) {
		// TODO Auto-generated constructor stub
		this.nara = nara;
	}
	
	void checkMove(Random r, boolean check) //check가 true이면 돌방상황 false이면 문제없음
	{
		if(!check)
		{
			move += r.nextInt(10)+1;
		}
		
	}
}


public class Q39_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		boolean check = true;
		Player[] players = new Player[4];
		
		String[] country = {"한국", "중국", "미국", "러시아"};
		
		for(int i =0;i<players.length;i++)
		{
			players[i] = new Player(country[i]);
		}
		
		while(check)
		{
			int d = r.nextInt(4);
			System.out.println("돌발 > " + (d + 1) + "번 레인");
			for(int i=0;i<players.length;i++)
			{
				if(i == d)
				{
					players[i].checkMove(r, true);
				}
				else
				{
					players[i].checkMove(r, false);
				}
				if(players[i].move>=100)
				{
					check = false;
				}
				System.out.println((i+1)+"번 레인"+players[i].nara+"선수가 : "+players[i].move+"M");
			}
			System.out.println();
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int max = 0;
		
		for(int i =0;i<players.length;i++)
		{
			if(players[max].move < players[i].move)
			{
				max = i;
			}
		}
		
		System.out.println("우승국은 "+players[max].nara+"입니다.");
		/*
		//1번레인이 우승
		if(players[0].move> players[1].move && players[0].move> players[2].move && players[0].move> players[3].move)
		{
			System.out.println("우승국은 "+players[0].nara+"입니다.");
			
		}
		//2번레인이 우승
		if(players[1].move> players[0].move && players[1].move> players[2].move && players[1].move> players[3].move)
		{
			System.out.println("우승국은 "+players[0].nara+"입니다.");
			
		}
		//3번레인이 우승
		if(players[2].move> players[0].move && players[2].move> players[1].move && players[2].move> players[3].move)
		{
			System.out.println("우승국은 "+players[0].nara+"입니다.");
			
		}
		//4번레인이 우승
		if(players[3].move> players[0].move && players[3].move> players[1].move && players[3].move> players[2].move)
		{
			System.out.println("우승국은 "+players[0].nara+"입니다.");
			
		}
		*/
	}

}
