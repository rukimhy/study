package day12;

class Pencil {
	String color;
	
	public void print() {
		System.out.println(color+"색 연필로 적습니다.");
	}
}

class Eraser {
	String maker;
	public void print() {
		System.out.println(maker+"의 제품으로 지웁니다.");
	}
}

class Pen {
	String color;
	String maker;
	public void print() {
		System.out.println(maker+"제품의 "+color+"색으로 씁니다.");
	}
}

public class Q29_pen {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		/* 연필, 지우개, 펜이 있다.
		 * 연필을 색깔을 가지고 있고 쓰는 기능을 한다. -> "XXX색 연필로 적습니다." 출력 (빨강, 파랑, 주황, 노랑)
		 * 지우개는 제조사를 가지고 있고 지우는 기능을 한다. -> "XXX의 제품으로 지웁니다." 출력 (잠자리, 모닝글로리)
		 * 펜은 색깔과 제조사를 가지고 있고 ㅆ느는 기능을 한다. -> "XXX 제품의 XXX색으로 씁니다." 출력 (검정-모나미, 초록-제트스트림, 베이비블루-워터맨)
		 */
		
		Pencil pencil_1 = new Pencil();
		pencil_1.color = "빨간";
		Pencil pencil_2 = new Pencil();
		pencil_2.color = "파란";
		Pencil pencil_3 = new Pencil();
		pencil_3.color = "주황";
		Pencil pencil_4 = new Pencil();
		pencil_4.color = "노랑";
		
		Eraser eraser_1 = new Eraser();
		eraser_1.maker = "잠자리";
		Eraser eraser_2 = new Eraser();
		eraser_2.maker = "모닝글로리";
		
		Pen pen_1 = new Pen();
		pen_1.color = "검정";
		pen_1.maker = "모나미";
		Pen pen_2 = new Pen();
		pen_2.color = "초록";
		pen_2.maker = "제트스트림";
		Pen pen_3 = new Pen();
		pen_3.color = "베이비블루";
		pen_3.maker = "워터맨";
		
		pencil_1.print();
		pencil_2.print();
		pencil_3.print();
		pencil_4.print();
		
		eraser_1.print();
		eraser_2.print();
		
		pen_1.print();
		pen_2.print();
		pen_3.print();
	}
}
