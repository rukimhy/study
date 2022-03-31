package academy.correspondence1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
	String ipAddress; // ���ڿ� ���� ipAdress ����
	static final int port = 7777; // static final ���� ���� port ������ 7777 �ʱ�ȭ
	Socket client = null; // Socket ���� client ���� �� null �� �ʱ�ȭ
	BufferedReader read; // BufferReader ���� read ����
	PrintWriter oos; // PrintWriter ���� oos ����
	BufferedReader ois; // BufferReader ���� ois ����
	String sendData; // ���ڿ� ���� sendDate ����
	String receiveData; // ���ڿ� ���� receiveDate ����

	String user_id; // ���ڿ� ���� user_id ����
	ReceiveDataThread rt; // ReceiveDateThread ���� rt ����
	boolean endflag = false; // ������ ���� endflag ���� �� false�� �ʱ�ȭ

	public MainClient(String id, String ip) {
		// MainClient �����ڷ� ���ڷ� ���ڿ� 2���� �޴´�.
		user_id = id; // user_id�� id ����
		ipAddress = ip; // ipAddress�� ip ����
		try {// �õ��ϴ�.
			System.out.println("**** Ŭ���̾�Ʈ*****");// ���
			client = new Socket(ipAddress, port);
			// client(Socket)�� Socket ��ü�� �����Ͽ� ����
			// Socket��ü�� ���� �Ҷ� ���ڷ� ���ڿ� 2���� ��Ƽ� ������ ȣ��

			read = new BufferedReader(new InputStreamReader(System.in));
			// BufferReader ��ü�� ������ �ϴµ� InputStrreamReader ��ü�� ���� ���ڷ� �޴´�.
			// InputStreamReader�� System.in�� ���ڷ� �޾Ƽ� ��ü�� �����.
			// BufferReader��ü�� �����Ǹ� read�� ����
			ois = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// BufferReader ��ü�� ������ InputStreamReader ��ü�� ���ڸ� �ް�
			// InputStreamReader ��ü�� �����ÿ��� child(Socket)�� getInputStream()�Լ���
			// ȣ���ϸ�
			// InputStream�� �����Ͽ� ���ڷ� �ް� InputStreamReader ��ü�� ����
			// BufferReader�� ������ ��ü�� ois�� ����
			oos = new PrintWriter(client.getOutputStream());
			// PrintWriter ��ü�� �����ÿ��� child(Socket)�� getOutputStream()�Լ��� ȣ���ϸ�
			// OutputStream�� �����Ͽ� ���ڷ� �ް� PrintWriter ��ü�� ����
			// PrintWriter�� ������ ��ü�� oos�� ����
			oos.println(user_id);
			// oos(PrintWriter)�� println�Լ��� user_id(���ڿ�)�� �־ ȣ��
			// PrintWriter�� user_id(���ڿ�)�� ����.
			oos.flush();
			// oos(PrintWriter)�� �Լ� flush()�� ȣ���Ѵ�.
			// flush�Լ��� ȣ���ϸ� PrintWirter�� ����ִ�
			// ���ڿ��� ����� Socket�� ���� �����ϰ� �ȴ�.

			rt = new ReceiveDataThread(client, ois);
			// ReceiveDataThread ��ü�� �����Ҷ� client(Socket)�� ois(BufferReader)��
			// ���ڷ� �־��༭ ��ü�� �����ϰ� rt�� ����
			Thread t = new Thread(rt);
			// Thread ��ü�� �����Ҷ� ReceiveDateThread�� ���ڷ� �־��ְ� ���� �Ŀ�
			// Thread ���� t�� ����
			t.start();
			// ������ ����

			while (true) {
				// ���� �ݺ�
				sendData = read.readLine();
				// Ű���� �Է��� �޾Ƽ� sendData�� ����

				oos.println(sendData);
				// oos(PrintWriter)�� println�Լ��� sendData(���ڿ�)�� �־ ȣ��
				// PrintWriter�� sendDate(���ڿ�)�� ����.
				oos.flush();
				// oos(PrintWriter)�� �Լ� flush()�� ȣ���Ѵ�.
				// flush�Լ��� ȣ���ϸ� PrintWirter�� ����ִ�
				// ���ڿ��� ����� Socket�� ���� �����ϰ� �ȴ�.

				if (sendData.equals("/quit")) {
					// sendData(���ڿ�)dl /quit�̸� �Ʒ� ���ɾ� ����
					endflag = true; // ������ ���� endflag�� true�� ����
					break;// �ݺ��� Ż��
				}
			}
			System.out.print("Ŭ����Ʈ�� ������ �����մϴ�. ");// ���
			System.exit(0);// ���α׷� ����
		} catch (Exception e) { // ����ó���� ����
			if (!endflag)
				e.printStackTrace();// ����ó���� ���
		} finally {
			// ���� try catch ���Ȳ�̵� �ٳ����� ����
			try {// �õ��ϴ�.
				ois.close();
				// BufferReader ��ü ois close()
				oos.close();
				// PrintWriter ��ü oos close()
				client.close();
				// Socket ��ü client close()

				System.exit(0); // ���α׷��� �����մϴ�.

			} catch (IOException e2) {// ����ó���� ����(IOException��)
				e2.printStackTrace();// ����ó���� ���
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // ��ĳ�� �Է�
		System.out.print("���̵� �Է��ϼ��� : ");// ���
		String id = sc.next();// �Է� �ޱ�
		new MainClient(id, "���� IP");
		// MainClient��ü ������ ���ڿ� 2���� �־ ��ü�� ����(id, ip)
	}
}
