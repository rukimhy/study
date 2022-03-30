package day29;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class A extends JFrame implements ActionListener
{
	JPanel p1;
	A()
	{
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		p1 = new Mframe();
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
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		c.add(p1);
		c.add(p2, BorderLayout.SOUTH);
		setSize(415,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		// e.getActionCommand().equals("Red") 레드 버튼이 눌림
		//p1.repaint(); 그림을 다시그려
		
		
	}
}

class Mframe extends JPanel
{
	public void paintComponent(Graphics g)
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
}


public class GUITEST_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new A();
	}

}
