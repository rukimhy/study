package academy.twentyEight;

import java.io.IOException;
import java.net.Socket;

public class MC { // Main Client

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      try {
         // 1. ���ϻ��� Ư¡ ���� ip�� �ʿ�, ��Ʈ
         Socket c_socket = new Socket("192.168.219.103", 8888);

         // 2. ���ú� ������ ����
         RT rec_thread = new RT();
         // 3. ���ú� �����忡 ���� ����
         rec_thread.setSocket(c_socket);

         // 4. ���� ������ ����
         ST send_thread = new ST();
         // 5. ���� �����忡 ���� ����
         send_thread.setSocket(c_socket);

         // 6. ���� ������ ����
         send_thread.start();
         // 7. ���ú� ������ ����
         rec_thread.start();
      }

      catch (IOException e) {
         // ����� ���� �߻��� ����
         e.printStackTrace();
      }

   }

}