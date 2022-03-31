package academy.correspondence1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MainServer {
	int port = 7777; // �������� port������ 7777 ����
	ServerSocket server = null; // ServerSocketŸ�� server ���� �� null ����
	Socket child = null; // SocketŸ�� child ���� �� null ����

	HashMap<String, PrintWriter> hm;
	// �÷����� HashMapŸ���� Ű���� String ���� PrintWriter�� hm ���� ����

	public MainServer() { // ChatServer ������

		ChatSverThread sr;
		// ChatServerThreadŸ�Կ� sr ���� ����
		// ��ε� ĳ������ �ϱ����� ������ ��ü
		Thread t;
		// Thread Ÿ���� t ���� ����

		try { // �õ��ϴ�
			server = new ServerSocket(port); // ���������� �����ؼ� server ������ ����

			System.out.println("**************************************");// ���
			System.out.println("*              ä�� ����                *");// ���
			System.out.println("**************************************");// ���
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�.");// ���

			hm = new HashMap<String, PrintWriter>(); // hashMap��ü�� �����ؼ� hm ������ ����

			while (true) { // ���� �ݺ�
				child = server.accept();
				// ServerSocket�� ������ server�� �̿��Ͽ� accept�Լ� ȣ���� �Ͽ�
				// Ŭ���̾�Ʈ ���ӽñ��� ��⸦ �մϴ�.
				// ���ӽÿ��� Ŭ���̾�Ʈ�� ���� �˴ϴ�.
				// Ŭ���̾�Ʈ�� ������ ����޽��ϴ�.
				if (child != null) {
					// SocketŸ�Կ� ������ child�� null ���� �ƴϸ� ����
					// child���� Ŭ���̾�Ʈ ���ϰ� ������ �� �� �ִ� �����Դϴ�.
					sr = new ChatSverThread(child, hm);
					// ChatSverThread ��ü�� Socket�� HashMap�� �޾Ƽ� ���� �Ŀ�
					// ChatSverThread�� ������ sr�� ����
					t = new Thread(sr);
					// Thread��ü�� ChatSverThread�� �޾Ƽ� ������
					// Thread�� ������ t�� ����
					t.start();// ������ ����
				}
			}
		} catch (Exception e) { // ����ó���� �߻��ϸ� ����
			e.printStackTrace(); // ����ó�� ���
		}
	}

	public static void main(String[] args) {
		new MainServer(); // MainServer ��ü ����
	}
}
