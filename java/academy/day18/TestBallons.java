package day18;

import java.util.Scanner;

class Ballon
{
	String color;
	
	void print()
	{
		System.out.println("Ç³¼± : " + color);
	}
}

class Check
{
	int indexCheck(String color, Ballon[] b)
	{
		int index = -1;
		for(int i =0;i<b.length;i++)
		{
			if(b[i].color.equals(color))
			{
				index = i;
			}
		}
		
		return index;
	}
}

class Air
{
	Air(Ballon[] b)
	{
		String[] color = {"»¡°£", "ÆÄ¶õ", "³ë¶û", "ÁÖÈ²", "ÃÊ·Ï"};
		for(int i =0;i<b.length;i++)
		{
			b[i] = new Ballon();
			b[i].color = color[i];
		}
	}
}

class Run
{
	Run()
	{
		Ballon[] b = new Ballon[5];
		Air a = new Air(b);
		Check ch = new Check();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("»ö±òÀ» ÀÔ·ÂÇÏ¼¼¿ä : ");
		String color = sc.next();
		
		int index=ch.indexCheck(color, b);
		
		System.out.println("Ç³¼± "+ color+" ÀÇ ÀÎµ¦½º : "+ index );
	}
}

public class TestBallons {
	public static void main(String[] args)
	{
		new Run();
	}
}
