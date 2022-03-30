
package day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ST extends Thread {
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
			
			
			while(true) {
				sendString = tmpbuf.readLine();
				if(sendString.equals("exit")) {
					break;
				}
				sendWriter.println(sendString);
				sendWriter.flush();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class RT extends Thread{
	private Socket socket;

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	
	public void run() {
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String receiveString;
			
			while(true) {
				receiveString = tmpbuf.readLine();
				
				if(receiveString == null) {
					System.out.println("상대와 연결이 끊겼습니다.");
					
					break;
				} else {
					System.out.println(receiveString);
				}
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
