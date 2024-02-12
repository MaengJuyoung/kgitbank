package space3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client2 implements Runnable  {
	private InetAddress dest;
	private int port;
	public Client2(InetAddress dest, int port) {
		this.dest = dest;
		this.port = port;
	}
	public void run() {
try(Socket link = new Socket(dest, port)){
	System.out.println("C2 - Connected!");
			BufferedReader bR = 
					new BufferedReader(
							new InputStreamReader(
									link.getInputStream()
									)
							);
			while (true) {
				String msg = bR.readLine();
				if (msg.equals("종료")) break;
				else System.out.println("\nC2 : " + msg);
			}
			bR.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
