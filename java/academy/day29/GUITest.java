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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Banana{}

class Monkey{
	Banana banana;
	String color;
	String print() {
		if(banana != null) {
			return color+" 원숭이가 정답";
		} else {
			return "바나나가 없습니다.";
		}
	}
}

class Control{
	Monkey[] monkey = new Monkey[5];
	Banana b = new Banana();
	
	public void game() {
		Random r = new Random();
		int num = r.nextInt(5);
		for(int i = 0; i < 5; i++) 
		{
			monkey[i] = new Monkey();
			if(i == num) {
				monkey[i].banana = b; 
			}
		}
		monkey[0].color = "Red";
		monkey[1].color = "Yellow";
		monkey[2].color = "Blue";
		monkey[3].color = "Green";
		monkey[4].color = "Pink";
	}
}

class Paint extends JFrame implements ActionListener
{
	Mframe1 p1;
	JTextField jf;
	Control control = new Control(); 
	
	Paint() {
		control.game();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		p1 = new Mframe1();
		p1.setLayout(new FlowLayout());
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,5,4,4));
		JPanel p3 = new JPanel();
		
		JButton b1 = new JButton(control.monkey[0].color);
		JButton b2 = new JButton(control.monkey[1].color);
		JButton b3 = new JButton(control.monkey[2].color);
		JButton b4 = new JButton(control.monkey[3].color);
		JButton b5 = new JButton(control.monkey[4].color);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);
		
		jf = new JTextField("   바나나를 가지고 있는 원숭이는?   ");
		p3.add(jf);
		c.add(p3, BorderLayout.NORTH);
		setSize(415,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals(control.monkey[0].color)) {
			jf.setText(control.monkey[0].print());
			p1.select = 0;
			p1.repaint();
		} else if(e.getActionCommand().equals(control.monkey[1].color)) {
			jf.setText(control.monkey[1].print());
			p1.select = 1;
			p1.repaint();
		} else if(e.getActionCommand().equals(control.monkey[2].color)) {
			jf.setText(control.monkey[2].print());
			p1.select = 2;
			p1.repaint();
		} else if(e.getActionCommand().equals(control.monkey[3].color)) {
			jf.setText(control.monkey[3].print());
			p1.select = 3;
			p1.repaint();
		} else {
			jf.setText(control.monkey[4].print());
			p1.select = 4;
			p1.repaint();
		}		
	}
}

class Mframe1 extends JPanel
{
	int select = -1;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(select == -1) {
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
		} else if(select == 0) {
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
		} else if(select == 1) {
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
		} else if(select == 2) {
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
		} else if(select == 3) {
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
		} else if(select == 4) {
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
	}
	
	/*
	public void repaint(int a, int b, int c, int d) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(a,b,c,d);
	}
	*/
}


public class GUITest {

	public static void main(String[] args) {
		new Paint();
	}

}
