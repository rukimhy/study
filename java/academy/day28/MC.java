package day28;

import java.io.IOException;
import java.net.Socket;

public class MC {

	public static void main(String[] args) {
		
		try {
			Socket c_socket = new Socket("192.168.219.103", 8888);
			
			RT rec_thread = new RT();
			rec_thread.setSocket(c_socket);
			
			ST send_thread = new ST();
			send_thread.setSocket(c_socket);
			
			send_thread.start();
			rec_thread.start();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
