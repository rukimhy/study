package day28;

import java.util.Random;

class Referee
{
	Newplayer n1;
	Newplayer n2;
	Newplayer n3;
	Newplayer n4;

	public Referee(Newplayer n1, Newplayer n2, Newplayer n3, Newplayer n4) {
		// TODO Auto-generated constructor stub
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}

	synchronized void stop()
	{
		
		n1.setCheck(false);
		n2.setCheck(false);
		n3.setCheck(false);
		n4.setCheck(false);
	}

}

class Newplayer extends Thread
{
	private int number;
	private String country;
	private int go;
	Referee r;
	private boolean check = true;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getGo() {
		return go;
	}

	public void setGo(int go) {
		this.go = go;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public void run()
	{
		Random r = new Random();
		while(check)
		{
			int ch = r.nextInt(2);

			if(ch == 1)
			{
				go+= r.nextInt(10)+1;
			}

			System.out.println(getCountry()+"��" + getGo()+"M �Դϴ�.");

			if(getGo()>=100)
			{
				this.r.stop();
			}
		}
	}


}




public class Q52_teacher {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Newplayer korea = new Newplayer();
		Newplayer china = new Newplayer();
		Newplayer america = new Newplayer();
		Newplayer russia = new Newplayer();

		Referee r = new Referee(korea, china, america, russia);


		korea.setNumber(1);
		korea.setCountry("�ѱ�");
		korea.setGo(0);
		korea.r = r;

		china.setNumber(2);
		china.setCountry("�߱�");
		china.setGo(0);
		china.r = r;

		america.setNumber(3);
		america.setCountry("�̱�");
		america.setGo(0);
		america.r = r;

		russia.setNumber(4);
		russia.setCountry("���þ�");
		russia.setGo(0);
		russia.r = r;

		korea.start();
		china.start();
		america.start();
		russia.start();

		korea.join();
		china.join();
		america.join();
		russia.join();
		
	    if(korea.getGo()>china.getGo() && korea.getGo()>america.getGo() &&
	            korea.getGo()>russia.getGo())
	      {
	         System.out.println("��±��� �ѱ��Դϴ�.");
	      }
	      if(china.getGo()>korea.getGo() && china.getGo()>america.getGo() &&
	            china.getGo()>russia.getGo())
	      {
	         System.out.println("��±��� �߱��Դϴ�.");
	      }
	      if(america.getGo()>korea.getGo() && america.getGo()>china.getGo() &&
	            america.getGo()>russia.getGo())
	      {
	         System.out.println("��±��� �̱��Դϴ�.");
	      }
	      if(russia.getGo()>china.getGo() && russia.getGo()>america.getGo() &&
	            russia.getGo()>korea.getGo())
	      {
	         System.out.println("��±��� ���þ��Դϴ�.");
	      }
		
	}

}
