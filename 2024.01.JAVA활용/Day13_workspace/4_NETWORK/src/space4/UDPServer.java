package space4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer implements Runnable {
	private int port; // 포트번호 - 전송된 것을 받을 경우, 이 번호와 일치하지 않으면 못받음
	public UDPServer(int port) {
		this.port = port;
	}
	public void run() {
		try {
			DatagramSocket entrance = new DatagramSocket(port);
			
			// 1. 받은 데이터를 저장할 공간을 먼저 준비함
			byte[] buffer = new byte[1024];
			// 2. 그 공간으로 DatagramPacket 객체를 조립함
			DatagramPacket data = new DatagramPacket(buffer, buffer.length);
			// 3. DatagramSocket 객체의 receive로 데이터를 받음
			entrance.receive(data);
			// 4. 받아온 것을 getData() / getLength() 메서드로 다시 배열을 꺼냄
			System.out.println(data.getData());		// 투입된 버퍼에 대한 getter
			System.out.println(data.getLength());	// 투입된 버퍼에 보관된 크기에 대한 getter
			// 5. 변환처리함
			String msg = new String(data.getData(), 0, data.getLength());
			// 6. 변환된 것을 이용하게 됨
			System.out.println(msg);
			
			entrance.close();
		} catch (SocketException e) {
			System.out.println(e);
			System.out.println("포트번호가 사용중/중복임");
		} catch (IOException e) {
			System.out.println(e);
			System.out.println("준비한 패킷에 기록중 문제가 생김");
		}
	}
}
