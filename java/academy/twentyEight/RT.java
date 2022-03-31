package academy.twentyEight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RT extends Thread {
   // ��Ĺ ���� ����
   private Socket m_Socket; // Client socket ��.
   // Thread Ŭ���� run �Լ� �������̵�

   public void run() {
      // 1. �θ� ������ run ����
      super.run();

      try {
         // 2. ���۸��� ���� -&gt; m_Socket.getInputStream()(��Ĺ�� �̿��� ���۸��� ����),
         // ������ġ, ��ŭ ���� �𸣴ϱ�
         BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));

         // ���ڿ� ���� ����
         String receiveString;

         // ���ѹݺ�
         while (true) {
            // ���ڿ� ���� receiveString &lt;- ���۸��� ������� ���پ� ����
            receiveString = tmpbuf.readLine();

            // ���࿡ receiveString ���̸� ����
            if (receiveString == null) {
               System.out.println("���� ������ ������ϴ�");
               // ���
               break;
               // �ݺ�Ż��
            } else {
               // receiveString�� ���
               System.out.println("���� :" + receiveString);
            }
         }
         // �ݺ����� ������ ���۸��� ����
         tmpbuf.close();
      }

      catch (IOException e) {
         // ����� ����ó�� �߻��� ����
         e.printStackTrace();
      }
   }

   // ���ι����� ���� ��ü �޾Ƽ� �� ������ ����
   public void setSocket(Socket _socket) {
      // m_Socket�� main���� ���� ���� ����
      m_Socket = _socket;
   }

}