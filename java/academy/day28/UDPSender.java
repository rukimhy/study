package academy.day28;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket();
		InetAddress ia = InetAddress.getByName("127.0.0.1");
		int port = 8800;
		byte buffer[] = "�ڹٴ½���".getBytes();
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, port);

		ds.send(dp);

	}

}
