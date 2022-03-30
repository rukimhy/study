package day25;

interface MyNumber{
	int getMax(int num1, int num2);
	
}

interface StringConcat{
	void makeString(String s1, String s2);
}

interface PrintString{
	void showString(String str);
}

public class TestMyNumber {
	
	public static void showMyString(PrintString p) {
		p.showString("hello lambda 2");
	}
	
	public static PrintString returnString() {
		return s -> System.out.println(s + "world");
	}
	
	public static void main(String[] args) {
		MyNumber max = (x, y) -> (x >= y) ? x : y;
		System.out.println(max.getMax(10, 20));
		
		String s1 = "Hello";
		String s2 = "World";
		StringConcat concat = (s, v) -> System.out.println(s+", "+v);
		concat.makeString(s1, s2);
		
		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("hello lambda 1");
		showMyString(lambdaStr);
		
		PrintString reStr = returnString();
		reStr.showString("hello, ");
	}
}
