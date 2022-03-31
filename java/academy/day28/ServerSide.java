package academy.day28;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
	// TCP
	public static void main(String[] args) throws Exception {
		int port = 8888;
		int times = 10;
		ServerSocket ss = new ServerSocket(port);
		int i = 1;
		while (i <= times) {
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			for (int j = 1; j <= 10; j++) {
				dos.writeInt(j);
				++i;
			}
			s.close();
			ss.close();
		}
	}

}
