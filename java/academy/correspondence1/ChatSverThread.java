package academy.correspondence1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

public class ChatSverThread implements Runnable

{
	Socket child;
	BufferedReader ois;
	PrintWriter oos;

	String user_id;
	HashMap<String, PrintWriter> hm;
	InetAddress ip;
	String msg;

	public ChatSverThread(Socket s, HashMap<String, PrintWriter> h) {

		child = s;
		hm = h;

		try {

			ois = new BufferedReader(new InputStreamReader(child.getInputStream()));

			oos = new PrintWriter(child.getOutputStream());

			user_id = ois.readLine();
			ip = child.getInetAddress();
			System.out.println(ip + "ip // " + user_id + "user_id");
			broadcast(user_id + "user_id.");

			synchronized (hm) {
				hm.put(user_id, oos);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void run() {
		String receiveData;

		try {
			while ((receiveData = ois.readLine()) != null) {

				if (receiveData.equals("/quit")) {
					synchronized (hm) {
						hm.remove(user_id);
					}

					break;
				} else if (receiveData.indexOf("/to") >= 0) {
					sendMsg(receiveData);
				} else {
					System.out.println(user_id + " >> " + receiveData);
					broadcast(user_id + " >> " + receiveData);
				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			synchronized (hm) {
				hm.remove(user_id);
			}

			broadcast(user_id + "user_id");
			System.out.println(user_id + "user_id");

			try// �õ��ϴ�
			{
				if (child != null) {
					ois.close();
					oos.close();
					child.close();
				}
			}

			catch (Exception e) {
			}
		}
	}

	public void broadcast(String message) {
		synchronized (hm) {
			try {
				for (PrintWriter oos : hm.values()) {
					oos.println(message);
					oos.flush();
				}
			} catch (Exception e) {
			}
		}
	}

	public void sendMsg(String message) {
		int begin = message.indexOf(" ") + 1;
		int end = message.indexOf(" ", begin);

		if (end != -1) {
			String id = message.substring(begin, end);
			String msg = message.substring(end + 1);
			PrintWriter oos = hm.get(id);

			try {
				if (oos != null) {
					oos.println(user_id + "user_id : " + msg);
					oos.flush();
				}

			} catch (Exception e) {

			}
		}
	}

}
