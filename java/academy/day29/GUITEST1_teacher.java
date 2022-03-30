package day29;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//1. 버튼 클릭시 색깔이 같은 원만 꽉 채워서 출력
//2. 원숭이 게임이 실행되게 만들기


class B extends JFrame implements ActionListener
{
	Random r = new Random();
	int x = r.nextInt(5);
	Mframe2 p1;
	JTextField jf;
	B()
	{
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		p1 = new Mframe2();
		p1.setLayout(new FlowLayout());
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,5,4,4));
		JButton b1 = new JButton("Red");
		JButton b2 = new JButton("Yellow");
		JButton b3 = new JButton("Blue");
		JButton b4 = new JButton("Green");
		JButton b5 = new JButton("Pink");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		jf = new JTextField("바바나를 가지고 있는 원숭이는?");
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p1.add(jf,BorderLayout.NORTH);
		c.add(p1);
		c.add(p2, BorderLayout.SOUTH);
		setSize(415,550);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		// e.getActionCommand().equals("Red") 레드 버튼이 눌림 바나나 누가가지고 있는지에 사용
		//p1.repaint(); 그림을 다시그려 버튼 놀렸을때 원 채우기 기능 사용

		if(e.getActionCommand().equals("Red"))
		{
			if(x == 0)
			{
				jf.setText("정답입니다.");
			}
			else
			{
				jf.setText("제가 안가지고 있습니다.");
			}
			p1.select = 1;
			p1.repaint();
		}
		else if(e.getActionCommand().equals("Yellow"))
		{
			if(x == 1)
			{
				jf.setText("정답입니다.");
			}
			else
			{
				jf.setText("제가 안가지고 있습니다.");
			}
			p1.select = 2;
			p1.repaint();
		}
		else if(e.getActionCommand().equals("Blue"))
		{
			if(x == 2)
			{
				jf.setText("정답입니다.");
			}
			else
			{
				jf.setText("제가 안가지고 있습니다.");
			}
			p1.select = 3;
			p1.repaint();
		}
		else if(e.getActionCommand().equals("Green"))
		{
			if(x == 3)
			{
				jf.setText("정답입니다.");
			}
			else
			{
				jf.setText("제가 안가지고 있습니다.");
			}
			p1.select = 4;
			p1.repaint();
		}
		else if(e.getActionCommand().equals("Pink"))
		{
			if(x == 4)
			{
				jf.setText("정답입니다.");
			}
			else
			{
				jf.setText("제가 안가지고 있습니다.");
			}
			p1.select = 5;
			p1.repaint();
		}
		else
		{
			System.out.println("잘못된 입력입니다.");
		}

	}
}

class Mframe2 extends JPanel
{
	int select = 0;
	public void paintComponent(Graphics g)
	{
		if(select == 0)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(150,100,80,80);
			g.setColor(Color.YELLOW);
			g.drawOval(70,190,80,80);
			g.setColor(Color.GREEN);
			g.drawOval(100,300,80,80);
			g.setColor(Color.BLUE);
			g.drawOval(220,190,80,80);
			g.setColor(Color.PINK);
			g.drawOval(210,300,80,80);
		}
		else if(select == 1)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval(150,100,80,80);
			g.setColor(Color.YELLOW);
			g.drawOval(70,190,80,80);
			g.setColor(Color.GREEN);
			g.drawOval(100,300,80,80);
			g.setColor(Color.BLUE);
			g.drawOval(220,190,80,80);
			g.setColor(Color.PINK);
			g.drawOval(210,300,80,80);
		}
		else if(select == 2)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(150,100,80,80);
			g.setColor(Color.YELLOW);
			g.fillOval(70,190,80,80);
			g.setColor(Color.GREEN);
			g.drawOval(100,300,80,80);
			g.setColor(Color.BLUE);
			g.drawOval(220,190,80,80);
			g.setColor(Color.PINK);
			g.drawOval(210,300,80,80);
		}
		else if(select == 3)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(150,100,80,80);
			g.setColor(Color.YELLOW);
			g.drawOval(70,190,80,80);
			g.setColor(Color.GREEN);
			g.drawOval(100,300,80,80);
			g.setColor(Color.BLUE);
			g.fillOval(220,190,80,80);
			g.setColor(Color.PINK);
			g.drawOval(210,300,80,80);
		}
		else if(select == 4)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(150,100,80,80);
			g.setColor(Color.YELLOW);
			g.drawOval(70,190,80,80);
			g.setColor(Color.GREEN);
			g.fillOval(100,300,80,80);
			g.setColor(Color.BLUE);
			g.drawOval(220,190,80,80);
			g.setColor(Color.PINK);
			g.drawOval(210,300,80,80);
		}
		else if(select == 5)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(150,100,80,80);
			g.setColor(Color.YELLOW);
			g.drawOval(70,190,80,80);
			g.setColor(Color.GREEN);
			g.drawOval(100,300,80,80);
			g.setColor(Color.BLUE);
			g.drawOval(220,190,80,80);
			g.setColor(Color.PINK);
			g.fillOval(210,300,80,80);
		}
		else
		{
			System.out.println("잘못된 입력입니다.");
		}
	}
}


public class GUITEST1_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new B();
	}

}
