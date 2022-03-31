package academy.correspondence1;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

class ReceiveDataThread implements Runnable {
	Socket client; // Socket ���� client ����
	BufferedReader ois; // BufferReader ���� ois ����
	String receiveData; // ���ڿ� ���� receiveData ����

	public ReceiveDataThread(Socket s, BufferedReader ois) {
		// ReceiveDataThread ������ �̰� Socket�� BufferReader�� ���ڷ� �޴´�.
		client = s;
		// ���� s�� client�� ����
		this.ois = ois;
		// ���� ois�� �ν��Ͻ� ���� ois�� ����
	}

	public void run() {
		// �޴°� ���� ������ �ʴ� run �Լ�
		try {// �õ��ϴ�
			while ((receiveData = ois.readLine()) != null)
				// ois�� readLine �Լ��� ȣ���Ͽ� ���ڿ� ���� ���� receiveDate�� ������ �ϸ�
				// receiveDate�� null�� �ƴϸ� ��� �ݺ�
				System.out.println(receiveData);
			// receiveData ���

		} catch (Exception e) {// ����ó�� �߻��� ����
			e.printStackTrace(); // ����ó���� ���
		} finally {
			// ���� try catch ���Ȳ�̵� �ٳ����� ����
			try {// �õ��ϴ�.
				ois.close();
				// BufferReader ��ü ois close()
				client.close();
				// Socket ��ü client close()
			} catch (IOException e2) { // ����ó�� �߻��� ����(IOException ��)
				e2.printStackTrace();// ����ó�� ���
			}
		}
	}
}