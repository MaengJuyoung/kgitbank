package space3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RelayServer implements Runnable {
	private int port;
	public RelayServer(int port) {
		this.port = port;
	}
	public void run() {
		try (ServerSocket listener = new ServerSocket(port)){
			Socket fromC1 = listener.accept();
			Socket toC2 = listener.accept();
			BufferedReader bR = new BufferedReader(new InputStreamReader(fromC1.getInputStream()));
			BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(toC2.getOutputStream()));
			while (true) {
				String msg = bR.readLine();
				/*
				 * 요 사이에 검열이 필요하면 검열 / 로깅이 필요하면 로깅 등 코드를 작성함
				 */
				bW.write(msg);
				bW.newLine();
				bW.flush();
				if (msg.equals("종료")) break;
			}
			bW.close();
			bR.close();
			fromC1.close();
			toC2.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
