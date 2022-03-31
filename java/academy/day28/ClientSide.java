package academy.day28;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

//TCP
public class ClientSide {

	public static void main(String[] args) throws Exception {
		String server = "192.168.219.103";
		int port = 8888;
		Socket c = new Socket(server, port);
		InputStream is = c.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		for (int i = 1; i <= 10; i++) {
			int j = dis.readInt();
			System.out.println("�����κ��� ���� ������ " + j + " ���");
		}
		c.close();
	}

}
