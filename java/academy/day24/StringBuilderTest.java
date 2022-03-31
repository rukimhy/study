package academy.day24;

public class StringBuilderTest {

	public static void main(String[] args) {
		String javaStr = new String("java");
		System.out.println("javaStr ���ڿ� �ּ� : " + System.identityHashCode(javaStr));

		StringBuilder buffer = new StringBuilder(javaStr);
		System.out.println("���� �� buffer �޸� �ּ� : " + System.identityHashCode(buffer));

		buffer.append(" and");
		buffer.append(" android");
		buffer.append(" programming is fun!!!");
		System.out.println("���� �� buffer �޸� �ּ� : " + System.identityHashCode(buffer));

		javaStr = buffer.toString();
		System.out.println(javaStr);
		System.out.println("����� ���ڿ� �ּ� ��: " + System.identityHashCode(javaStr));

	}

}
