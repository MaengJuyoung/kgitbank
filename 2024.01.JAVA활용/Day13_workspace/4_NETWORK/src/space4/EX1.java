package space4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EX1 {
	public static void main(String[] args) {
		// 통신의 기본 : 1대1 통신
		// ※ TCP의 단점 - 자원이 많이 소모됨
		// -> 수백/수천/수만단위의 통신이 집중되면 컴퓨터(서버/클라이언트)가 마비됨
		// -> 일정하게 흘러가는 통신이 아니라면 UDP를 쓰게 됨
		
		// 2) UDP(User Datagram Protocol)
		//    - 상대방이 받든 말든 데이터를 전송하는 방식
		//    - 데이터의 무결성에 대한 보장이 안되어 있음
		//      -> 데이터가 오염/손실되기도 함
		//      -> 데이터가 오염/손실이 되어도 문제가 없는 것들을 보냄
		//      -> EX) 영상 스트리밍/게임조작 데이터 등....
		//    - TCP보다 빠름( + 컴퓨터의 자원을 덜 소모함 )
		try {
			InetAddress dest = InetAddress.getLocalHost();
			Thread client = new Thread(new UDPClient(dest, 6005));
			Thread server = new Thread(new UDPServer(6005));
			// ※ UDP는 목적지로 즉시 갈 수 있는 구조
			// -> P2P에 가까움 / 서로가 서로에게 서버이자 클라이언트가 됨
			// -> 서버/클라이언트는 상대적인 롤(Role/역할)
			// -> UDP는 어떤 코드를 작성하는가에 따라 역할이 결정되니...
			//    서버는 "서버"답게 코드를 생각해두는 것이 좋음
			server.start();
			client.start();
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}
}
