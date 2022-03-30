package day27;

import java.util.Random;

/* 2명의 사람이 있고 각 사람은 1턴마다 1~20 랜덤수를 받아서 토탈값을 저장한다.
 * 100턴이 지나고 나면 어떤 사람이 이겼는지 출력
 * 단, 각 사람이 번갈아가면서 실행되는 것이 아니라 동시에 100턴이 진행되어야 한다.
 * 쓰레드 사용
 */

class Total{
	int total = 0;
	void sum(Random r) {
		total += r.nextInt(20)+1;
	}
	int getTotal() {
		return total;
	}
}

class Human extends Thread{
	Total t;
	Random r;
	int total;
	
	Human(Total t, String name, Random r){
		this.t = t;
		setName(name);
		this.r = r;
	}
	
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(getName()+"의 "+i+"번째 턴");
			t.sum(r);
		}
		this.total = t.getTotal();
	}
}

public class Q51 {

	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		
		Total t1 = new Total();
		Total t2 = new Total();
		
		Human h1 = new Human(t1, "사람1", r);
		Human h2 = new Human(t2, "사람2", r);
		
		h1.start();
		h2.start();
		
		h1.join();
		h2.join();
		
		System.out.println(h1.getName()+ ":"+h1.total);
		System.out.println(h2.getName()+ ":"+h2.total);
		
		if(h1.total > h2.total) {
			System.out.println(h1.getName()+"이 이겼습니다.");
		} else {
			System.out.println(h2.getName()+"이 이겼습니다.");
		}
	}

}
