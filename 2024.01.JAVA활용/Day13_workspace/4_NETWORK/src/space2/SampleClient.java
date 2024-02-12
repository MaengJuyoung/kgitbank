package space2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

//클라이언트(Client or Guest)
//- 상대방에게 접속하고자 하는 컴퓨터
//- 목적지가 필요함
//- 접속한 컴퓨터에게 서비스를 요청함
public class SampleClient implements Runnable {
	private InetAddress destination;	// 목적지 정보
	private int port;					// 통신하기 위해 나가는 "개찰구번호"
	public SampleClient(InetAddress dest, int port) {
		this.destination = dest;
		this.port = port;
	}
	public void run() {
		try {
			// Socket 클래스
			// - 클라이언트가 서버에게 접속을 시도해 통로를 만드는 클래스
			// - 이 통로를 이용하는 스트림을 준비해서 사용하게 됨
			Socket link = new Socket(destination, port);
			System.out.println("Client : Connected!");
			// Socket으로 만들어지는 통로는 close처리가 필요함
			link.close();
		} catch (IOException e) {
			// ConnectException일 경우, 재시도를 하도록 만들기도 함
			System.out.println(e);
		}
	}
}
