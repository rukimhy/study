package day14;

class A{
	int a;
}

class B{
	A[][][] a;
}

public class ClassArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A[] a = new A[10];
		for(int i = 0; i<10; i++) {
			a[i] = new A();
		}
		a[0].a = 10;
		System.out.println(a[0].a);
		
		A[][] b = new A[2][2];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				b[i][j] = new A();
			}
		}
		b[1][1].a = 20;
		System.out.println(b[1][1].a);
	}

}
