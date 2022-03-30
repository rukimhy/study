package day28;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public static void main(String[] args) throws Exception {
		URL kbs = new URL("http://www.kbs.co.kr/aboutkbs/history.html");
		URLConnection kbsCon = kbs.openConnection();
		System.out.println("문서의 타입 : "+kbsCon.getContentType());
		System.out.println("==== 문서의 내용 ====");
		InputStream input = kbsCon.getInputStream();
		int i = 500;
		int c;
		while(((c = input.read()) != -1) && (--i > 0))
		{
			System.out.println((char)c);
		}
		input.close();
	}

}
