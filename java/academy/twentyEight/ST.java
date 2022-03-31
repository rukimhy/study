package academy.twentyEight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ST extends Thread {

   private Socket m_Socket; // Socket Ÿ�� ���� m_Socket ����, Client socket ��.

   public void run() // thread�� �ִ� thread���� �����ϴ� run �Լ��� �������̵�
   {
      super.run(); // �θ� thread�� run �Լ� ȣ��

      try {
         BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
         // ���۸����� �̿��� �Է� ��ü ����
         PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream()); // bufferreader�� �Է�, printwriter��
                                                                               // ������.
         // PrintWriter�� sendWriter�� ������ ���� �� ��ü�� ����
         // ��ü�� �����Ҷ� ������ ��� ��Ʈ���� ���ڷ� �޾Ƽ� ����
         String sendString;
         // ���ڿ� ���� sendString ����

         while (true) // ���� �ݺ�, ������ ������ ��� �ְ��ް� �̹Ƿ�.
         {
            sendString = tmpbuf.readLine();
            // �Է��� �޾Ƽ� ���ڿ� ���� sendString�� ����
            sendWriter.println(sendString);
            // PrintWriter�� println�Լ��� ���ڿ� ���� sendString�� ����
            sendWriter.flush();
            // PrintWriter�� flush �Լ� ȣ��
            // ���ڿ��� �Է� �޾Ƽ� PrintWriter�� ��ü�� �Է� ���� ���ڿ��� �ް�
            // PrintWriter�� flush �Լ��� ȣ�� �Ǹ� ���ڿ� �����͸� �����ϰ� �˴ϴ�.
         }
      }

      catch (IOException e) {
         // ����� ����ó�� �߻��� ����
         e.printStackTrace();
      }
   }

   // ���ι����� ���� ��ü �޾Ƽ� �� ������ ����
   public void setSocket(Socket _socket) // Main server���� c_socket ������.
   {
      // m_Socket�� main���� ���� ���� ����
      m_Socket = _socket;
   }

}