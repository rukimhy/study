package academy.day28;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		URL kbs = new URL("http://www.kbs.co.kr/aboutkbs/history.html");
		System.out.println("�������� : " + kbs.getProtocol());
		System.out.println("��Ʈ : " + kbs.getPort());
		System.out.println("ȣ��Ʈ : " + kbs.getHost());
		System.out.println("����(�������) : " + kbs.getFile());
		System.out.println("��ü URL : " + kbs.toExternalForm());
	}

}
