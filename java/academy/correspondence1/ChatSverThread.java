package academy.correspondence1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

public class ChatSverThread implements Runnable

{
	Socket child; // Socket Ŭ���� Ÿ���� ���� child ����
	BufferedReader ois; // BufferReader Ŭ���� Ÿ���� ���� ois ����
	PrintWriter oos; // PrintWriter Ŭ���� Ÿ���� ���� oos ����

	String user_id; // ���ڿ� ���� user_id ����
	HashMap<String/* ���� ID */, PrintWriter/* ������ PrintWriter */> hm; // ������ ����
	// �÷��� HashMap�� Ű�� String�� ��PrintWriter�� ���� hm�� ����
	InetAddress ip; // InetAddress Ŭ���� Ÿ���� ���� ip ����
	String msg; // ���ڿ� ���� msg ����

	public ChatSverThread(Socket s, HashMap<String, PrintWriter> h) {
		// ChatSverThread�� Socket�� HashMap�� ���ڷ� �޴� ������
		child = s;
		// ���ڷ� ���� ���� s�� child�� ����(Socket)
		hm = h;
		// ���ڷ� ���� ���� h�� hm�� ����(HashMap)

		try {
			// �õ��Ѵ�.
			ois = new BufferedReader(new InputStreamReader(child.getInputStream()));
			// BufferReader ��ü�� ������ InputStreamReader ��ü�� ���ڸ� �ް�
			// InputStreamReader ��ü�� �����ÿ��� child(Socket)�� getInputStream()�Լ���
			// ȣ���ϸ�
			// InputStream�� �����Ͽ� ���ڷ� �ް� InputStreamReader ��ü�� ����
			// BufferReader�� ������ ��ü�� ois�� ����
			oos = new PrintWriter(child.getOutputStream());
			// PrintWriter ��ü�� �����ÿ��� child(Socket)�� getOutputStream()�Լ��� ȣ���ϸ�
			// OutputStream�� �����Ͽ� ���ڷ� �ް� PrintWriter ��ü�� ����
			// PrintWriter�� ������ ��ü�� oos�� ����

			user_id = ois.readLine();
			// ois�� readLine�Լ��� ȣ���Ͽ� ������ ���ڿ��� �о user_id�� ����
			ip = child.getInetAddress();
			// child(Socket)�� ���ؼ� getInetAddress()�Լ��� ���ؼ�
			// Client IP �ּҸ� ���ڿ��� �޾� ip�� ����
			System.out.println(ip + "�κ��� " + user_id + "���� �����Ͽ����ϴ�.");// ���
			broadcast(user_id + "���� �����ϼ̽��ϴ�.");
			// broadcast �Լ� ȣ�� ȣ���� �Ҷ� ���ڿ� ���ڷ� ����

			synchronized (hm) {
				// �Ӱ迵�� ���� ��
				// HashMap�� �߰��� �� �����常 ���ͼ� ��� ������
				hm.put(user_id, oos);
				// HashMap�� Ű:user_id(String) ��: oos(PrintWriter)�� �߰���
			}
		}

		catch (Exception e) {// ����ó�� �߻��� ����
			e.printStackTrace();// ���� ���
		}

	}

	public void run() {
		String receiveData; // ���ڿ� ���� receiveDate ����

		try// �õ��ϴ�
		{
			while ((receiveData = ois.readLine()) != null) {
				// ois�� readLine �Լ��� ȣ���Ͽ� ���ڿ� ���� ���� receiveDate�� ������ �ϸ�
				// receiveDate�� null�� �ƴϸ� ��� �ݺ�
				// ������
				if (receiveData.equals("/quit")) {
					// receiveDate�� /quit�̸� �Ʒ� ���ɹ� ����
					synchronized (hm) {
						// �Ӱ迵�� ���� ��
						// HashMap�� ������ �� �����常 ���ͼ� ��� ������
						hm.remove(user_id);
						// HashMap�� Ű���� user_id�� ���� �����ϴ� �Լ�
					}

					break;// �ݺ��� Ż��
				}
				// �ӼӸ�
				else if (receiveData.indexOf("/to") >= 0) {
					// receiveDate�� �Լ� indexOf�� �̿��� ���ڿ��� �ִ����� Ž��
					// ���࿡ ������ 0�̻��� �ֱ� ������ �Ʒ� ���ɾ� ����
					sendMsg(receiveData);// sendMsg�Լ��� receiveData�� ���ڷ� �޾Ƽ� ȣ��
				}
				// ��ü �޼��� ������
				else {
					// ���� ������ ��� �ƴϸ� �Ʒ����ɹ� ����
					System.out.println(user_id + " >> " + receiveData);// ���
					broadcast(user_id + " >> " + receiveData);
					// broadcast �Լ� ȣ�� ȣ���� �Ҷ� ���ڿ� ���ڷ� ����
				}

			}

		}

		catch (Exception e) {// ����ó�� �߻��ϸ� ����
			e.printStackTrace();// ����ó�� ���
		}

		finally {// ���� try catch ���Ȳ�̵� �ٳ����� ����
			synchronized (hm) {
				//// �Ӱ迵�� ���� ��
				// HashMap�� ������ �� �����常 ���ͼ� ��� ������
				hm.remove(user_id);
				// HashMap�� Ű���� user_id�� ���� �����ϴ� �Լ�
			}

			broadcast(user_id + "���� �����߽��ϴ�.");
			// broadcast �Լ� ȣ�� ȣ���� �Ҷ� ���ڿ� ���ڷ� ����
			System.out.println(user_id + "���� �����߽��ϴ�.");// ���

			try// �õ��ϴ�
			{
				if (child != null) {
					// child(Socket)�� ���࿡ null�� �ƴϸ�
					ois.close();
					// BufferReader ��ü ois close()
					oos.close();
					// PrintWriter ��ü oos close()
					child.close();
					// Socket ��ü child close()
				}
			}

			catch (Exception e) {
			} // ����ó�� �߻���
		}
	}

	public void broadcast(String message) {
		// ������ �����ʰ� ���ڿ��� ���ڷ� �޴� broadcast �Լ�
		synchronized (hm) {
			// �Ӱ迵�� ���� ��
			try {
				for (PrintWriter oos : hm.values()) {
					// HashMap���� ���� ���� PrintWriter oos��� ������ ������ �Ѵ�.
					// null�� ������������ ��� �ݺ��Ѵ�.
					oos.println(message);
					// oos(PrintWriter)�� �Լ� println�� ���ڿ�(message)�� �ִ´�.
					// message(���ڿ�)�� PrintWriter�� ����.
					oos.flush();
					// oos(PrintWriter)�� �Լ� flush()�� ȣ���Ѵ�.
					// flush�Լ��� ȣ���ϸ� PrintWirter�� ����ִ�
					// ���ڿ��� ����� Socket�� ���� �����ϰ� �ȴ�.
				}
				// �ݺ��� �ϸ鼭 ��� ����� ���Ͽ� ���ڿ��� �۽��ϰ� �ȴ�.
			} catch (Exception e) {
			} // ����ó�� �߻��� ����
		}
	}

	public void sendMsg(String message) {
		// ������ ���� �ʰ� ���ڿ��� ���ڷ� �޴� sendMsg �Լ�
		int begin = message.indexOf(" ") + 1;
		// ó�� �����̽� �� ���� �ε��� ���ڸ� ������ ���� begin�� ����
		int end = message.indexOf(" ", begin);
		// begin���� ������ �� �״��� �����̽� �ִ� �ε����� ������ ���� end�� ����

		if (end != -1) {
			// ������ ���� end�� -1�� �ƴϸ� ����
			String id = message.substring(begin, end);
			// ���ڿ� ���� message�� begin���� end��ū �߶� ���ڿ� ���� id�� ����
			String msg = message.substring(end + 1);
			// ���ڿ� ���� message�� end���� 1�� ���� �ε������� ������ �ִ� ���ڿ���
			// ���ڿ� ���� msg�� ����
			PrintWriter oos = hm.get(id);
			// PrintWriter�� ���� oos �� HashMap���� get �Լ��� ���ڸ� ���ڿ� ���� id�� �־
			// Value�� PrintWriter�� ���� oos�� ����

			try {// �õ��ϴ�
				if (oos != null) {
					// PrintWriter oos�� ���� ���� �ƴϸ� �Ʒ� ���ɹ� ����
					oos.println(user_id + "���� ������ ���� �ӼӸ��� �����̽��ϴ�. : " + msg);
					// oos(PrintWirter)�� println�Լ��� ���ڿ��� ��´�.
					oos.flush();
					// oos(PrintWriter)�� �Լ� flush()�� ȣ���Ѵ�.
					// flush�Լ��� ȣ���ϸ� PrintWirter�� ����ִ�
					// ���ڿ��� ����� Socket�� ���� �����ϰ� �ȴ�.
				}

			} catch (Exception e)// ����ó���� �߻��ϸ� ����
			{

			}
		}
	}

}
