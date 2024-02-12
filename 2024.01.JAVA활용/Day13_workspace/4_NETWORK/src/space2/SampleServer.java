package space2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//서버(Server or Host)
//- 접속요청이 오면 접속을 받아주는 컴퓨터
//- 요청에 대한 수락처리가 필요함
//- 접속된 컴퓨터에 서비스를 제공함
public class SampleServer implements Runnable {
	private int port;	// 나에게 통신을 시도한 컴퓨터가 사용하는 "개찰구번호"를 기록함
	public SampleServer(int port) {
		this.port = port;
	}
	public void run() {
		try {
			// ServerSocket
			// - 들어온 요청을 받아서 연결을 받아주는 클래스/객체
			// - Listener라고 말하기도 함
			ServerSocket link = new ServerSocket(port);

			// accept메서드 : 실제 연결을 만들어내는 메서드
			// -> Socket 객체가 생성됨
			// -> 요청이 여러개가 들어오면 따로따로 만들어주던가, 재활용을 하게 됨
			Socket linkToClient1 = link.accept();
			Socket linkToClient2 = link.accept();
			System.out.println("Server : Connected!");
			linkToClient1.close();
			linkToClient2.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
