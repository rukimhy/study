package academy.twentyEight;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MS {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      try // ����ó��
      {
         // 1. ���������� ��ü�� ����
         ServerSocket s_socket = new ServerSocket(8888);
         // 2. ���������� accept�Լ��� ȣ���ؼ� ����� Socket�� Socket�� c_socket������ ����
         Socket c_socket = s_socket.accept(); // ����ϰ� �ִٰ� client socket ���� ����
         // TCP ���

         // 3.���ú� ������ ��ü ����
         RT rec_thread = new RT();
         // 4.���ú� �����忡 ��Ĺ ����
         rec_thread.setSocket(c_socket); // client�� �����ؾߵǴ� c_socket�� ����.

         // 5. ���� ������ ����
         ST send_thread = new ST();
         // 6. ���� �����忡 ���� ����
         send_thread.setSocket(c_socket);

         // ����� �����尡 ���� �ʿ������ʴ�. �� ������ enter�� �Է��� ���� ������ �Ǵϱ�.
         // ������ ���ú�� �����带 ����Ѵ�. ���� �� �� �𸣱� ������.

         // 7. ���ú� ������ ����
         rec_thread.start();
         // 8. ���� ������ ����
         send_thread.start();
      }

      catch (IOException e) {
         // 9.������� ������ ����� ����
         e.printStackTrace();
      }

   }
}