package space3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EX1 {
	public static void main(String[] args) {
		// ※ Socket은 통로만 만들어줌
		// -> Socket을 쓸 수 있는 스트림을 만들어서 줌
		// getInputStream();
		// getOutputStream();
		
		try {
			InetAddress dest = InetAddress.getLocalHost();
			Thread client = new Thread(new SampleClient(dest, 8080));
			Thread server = new Thread(new SampleServer(8080));
			server.start();
			client.start();
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}
}
