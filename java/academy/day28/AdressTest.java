package academy.day28;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AdressTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println("���� ��ǻ���� �̸� : " + Address.getHostName());
		System.out.println("���� ��ǻ���� IP �ּ� : " + Address.getHostAddress());
		Address = InetAddress.getByName("java.sun.com");
		System.out.println("java.sun.com�� ��ǻ�� �̸��� IP �ּ� : " + Address);
		InetAddress all[] = InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}

}
