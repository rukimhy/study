
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MS {

   public static void main(String[] args) {

      try {
         ServerSocket s_socket = new ServerSocket(8888);
         Socket c_socket = s_socket.accept();

         RT rec_thread = new RT();
         rec_thread.setSocket(c_socket);

         ST send_thread = new ST();
         send_thread.setSocket(c_socket);

         rec_thread.start();
         send_thread.start();
      }

      catch (IOException e) {
         e.printStackTrace();
      }

   }
}