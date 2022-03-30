package day27;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthColorChooserUI;

//올림픽 게임을 쓰레드를 이용해서 동작하게 구현


class Check{
	int chk1;
	boolean chk2 = true;
}

class Runner extends Thread
{
	String country;
	int lane;
	Random r;
	int m;
	Check chk;

	Runner(Random r, Check c){
		this.r = r;
		this.m = 0;
		this.chk = c;
	}

	void print() 
	{
		System.out.println(lane+"번레인 "+country+" 선수가 현재 "+m+"m 입니다.");
	}

	synchronized void winner() 
	{
		if(m >= 100) 
		{
			System.out.println("우승국은 "+country+"입니다!!!");
			chk.chk2 = false;
		}
	}

	public void run() {
		while(chk.chk2) {
			chk.chk1 = r.nextInt(2);
			if(chk.chk1 == 1) {
				m += r.nextInt(10)+1;
				System.out.println(country+"의 선수가 넘어졌습니다~");
			} 
			print();
			winner();
		
		}
	}

}

public class Q52 {

	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		String[] country = new String[]{"한국", "중국", "미국", "러시아"};
		int[] lane = new int[] {1, 2, 3, 4};
		Check chk = new Check();

		Runner[] runner = new Runner[4];
		for(int i = 0; i<4; i++) 
		{
			runner[i] = new Runner(r, chk);
			runner[i].country = country[i];
			runner[i].lane = lane[i];
		}


		for(int i=0; i<4; i++) 
		{
			runner[i].start();

		}

		for(int i=0; i<4; i++) 
		{
			runner[i].join();

		}



	}

}
