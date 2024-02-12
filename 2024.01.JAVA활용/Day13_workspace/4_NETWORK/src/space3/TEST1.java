package space3;

import java.net.InetAddress;

public class TEST1 {
	public static void main(String[] args) {
		// 실습
		// 쓰레드 3개를 위한 클래스 3개를 준비하세요.
		// 1) Client1
		// - 입력한 내용(문자열)을 서버에게 전송합니다.
		// - Writer 클래스를 이용하세요.
		//   "종료"를 입력하면 전송을 종료합니다.
		
		// 2) RelayServer
		// - Client1에서 받은 내용을 Client2에게 중계합니다.
		// - 그 외에는 아무것도 안합니다. 중계만 합니다.
		// - 단 Client1에서 보낸 문자열이 "종료"일 경우
		//   Client2에게도 "종료"를 전송하고 중계역할을 종료합니다.
		
		// 3) Client2
		// - 중계받은 내용을 출력합니다.
		// - Reader 클래스를 이용하세요.
		//   "종료"를 전달받으면 바로 종료합니다.
		try {
			InetAddress dest = InetAddress.getLocalHost();
			Thread c1 = new Thread(new Client1(dest, 8080));
			Thread c2 = new Thread(new Client2(dest, 8080));
			Thread rs = new Thread(new RelayServer(8080));
			rs.start();
			Thread.sleep(1000); // 쓰레드의 실행을 1000밀리세컨드(1초) 지연시킵니다.
			c1.start();
			Thread.sleep(1000);
			c2.start();
		} catch (Exception e) {
			
		}
	}
}
