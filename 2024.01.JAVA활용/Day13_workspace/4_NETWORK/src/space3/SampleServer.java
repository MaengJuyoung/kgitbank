package space3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

//서버(Server or Host)
public class SampleServer implements Runnable {
	private int port;
	public SampleServer(int port) {
		this.port = port;
	}
	public void run() {
		try {
			ServerSocket link = new ServerSocket(port);
			Socket linkToClient = link.accept();
			System.out.println("Server : Accepted!");
			
			InputStream fromClient = linkToClient.getInputStream();
			Reader fromClientReader = new InputStreamReader(fromClient);
			BufferedReader bR = new BufferedReader(fromClientReader);
			while (true) {
				String msg = bR.readLine();
				if (msg.equals("종료")) break;
				else System.out.println("SERVER RECEIVED\n" + msg);
			}
			bR.close();
			linkToClient.close();
			link.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
