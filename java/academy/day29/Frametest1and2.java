package day29;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

class FirstFrame1{
	public FirstFrame1() {
		JFrame jf = new JFrame("첫 번째 GUI 프로그램"); //프레임 객체 생성 (제목 지정)
		Container ct = jf.getContentPane(); //프레임으로부터 컨테이너 생성
		JButton jb = new JButton("테스트버튼"); // 버튼 컴포넌트 생성
		ct.add(jb); //버튼을 컨테이너에 추가
		jf.setSize(400,300); //프레임 크기 설정
		jf.setVisible(true); // 프레임을 화면에 출력
	}
}

public class Frametest1and2 {

	public static void main(String[] args) {
		new FirstFrame1();
	}

}
