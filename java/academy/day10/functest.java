package academy.day10;

public class functest {

	// 1�� �ְ� �ް�
	public static int abc(int a) {
		return a;
	}

	// 2�� ���ְ� �ް�
	public static void def(int b) {
		System.out.println(b);
	}

	// 3�� �ְ� �ȹް�
	public static int ghi() {
		return 10;
	}

	// 4�� ���ְ� �ȹް�
	public static void xyz() {
		System.out.println("�ȳ��ϼ���.");
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
