package Twentyeight;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MS {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
     
	  try // 예외처리
      {
    	 //1. 서버소켓을 객체로 생성
         ServerSocket s_socket = new ServerSocket(8888);
         //2. 서버소켓의 accept함수를 호출해서 결과값 Socket을 Socket에 c_socket변수에 대입
         Socket c_socket = s_socket.accept(); // 대기하고 있다가 client socket 오면 전달
         //TCP 통신
         
         
         //3.리시브 스래드 객체 생성
         RT rec_thread = new RT();
         //4.리시브 스래드에 소캣 전달
         rec_thread.setSocket(c_socket); // client에 전달해야되니 c_socket을 쓴다.
         
         //5. 샌드 스래드 생성
         ST send_thread = new ST();
         //6. 샌드 스래드에 소켓 전달
         send_thread.setSocket(c_socket);
         
         // 샌드는 스레드가 굳이 필요하진않다. 할 때마다 enter를 입력해 값을 보내면 되니깐.
         // 하지만 리시브는 스레드를 써야한다. 언제 올 지 모르기 때문에.
         
         //7. 리시브 스래드 시작
         rec_thread.start();
         //8. 샌드 스래드 시작
         send_thread.start();
      } 
      
      catch(IOException e)
      {
         //9.입출력의 문제가 생기면 실행
         e.printStackTrace();
      }
      
   }
}