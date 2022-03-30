package day10;

public class functest {
	
	//1번 주고 받고
	public static int abc(int a) {
		return a;
	}
	
	//2번 안주고 받고
	public static void def(int b) {
		System.out.println(b);
	}
	
	//3번 주고 안받고
	public static int ghi() {
		return 10;
	}
	
	//4번 안주고 안받고
	public static void xyz() {
		System.out.println("안녕하세요.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xyz();
		int three = ghi();
		System.out.println(three);
		def(20);
		int one = abc(1);
		System.out.println(one);
	}

}
