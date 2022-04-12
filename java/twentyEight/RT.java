
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RT extends Thread {
   private Socket m_Socket;

   public void run() {
      super.run();

      try {
         BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));

         String receiveString;

         while (true) {
            receiveString = tmpbuf.readLine();

            if (receiveString == null) {
               System.out.println("���� ������ ������ϴ�");
               break;
            } else {
               System.out.println("���� :" + receiveString);
            }
         }
         tmpbuf.close();
      }

      catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void setSocket(Socket _socket) {
      m_Socket = _socket;
   }

}