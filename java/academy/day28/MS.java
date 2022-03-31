package academy.day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
class Server extends Thread{
	public static ArrayList<Socket> list = new ArrayList<Socket>();
	private Socket socket;
	private static String ID;

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public static String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void run() {
		super.run();

		try {

		}

		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

 */

class SocketArrayList extends Thread {
	ArrayList<Socket> list;

	SocketArrayList() {
		list = new ArrayList<Socket>();
	}

	void addSocket(Socket socket) {
		list.add(socket);
	}

	private Socket socket;

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		super.run();
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(socket.getOutputStream());
			String sendString;

			BufferedReader receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String receiveString;

			while (true) {
				sendString = tmpbuf.readLine();

				if (sendString.equals("exit")) {
					break;
				} else {
					sendWriter.println(sendString);
					sendWriter.flush();
				}

				receiveString = receiver.readLine();
				if (receiveString == null) {
					System.out.println("���� ������ ������ϴ�.");
					break;
				} else {
					for (int i = 0; i < list.size(); i++) {

					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class MS {

	public static void main(String[] args) {

		SocketArrayList SAL = new SocketArrayList();

		try {
			ServerSocket s_socket = new ServerSocket(8888);

			while (true) {
				Socket c_socket = s_socket.accept();
				SAL.addSocket(c_socket);
				SAL.setSocket(c_socket);

				RT rec_thread = new RT();
				rec_thread.setSocket(c_socket);

				ST send_thread = new ST();
				send_thread.setSocket(c_socket);

				send_thread.start();
				rec_thread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
