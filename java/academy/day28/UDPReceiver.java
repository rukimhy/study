package day28;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {

	public static void main(String[] args) throws Exception {
		int port = 8800;
		int times = 10;
		DatagramSocket ds = new DatagramSocket(port);
		
		int i = 1;
		while(i <= times) {
			byte buffer[] = new byte[30];
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			ds.receive(dp);
			String str = new String(dp.getData());
			System.out.println("수신된 데이터 : "+str);
			++i;
		}
	}

}
