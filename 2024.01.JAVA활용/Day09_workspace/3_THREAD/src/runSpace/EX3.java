package runSpace;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class CopyThread implements Runnable {
	private String fileName;
	public CopyThread(String fileName) {
		this.fileName = fileName;
	}
	public void run() {
		try {
			FileInputStream fis = new FileInputStream("file.pdf");
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			while (true) {
				int data = bis.read();
				if (data != -1) bos.write((byte)data);
				else break;
			}
			bis.close();
			bos.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}

public class EX3 {
	// 코드의 첫시작을 담당하는 항상 존재하는 쓰레드가 있음
	// -> main 쓰레드
	public static void main(String[] args) {
		// 1) 쓰레드를 쓰더라도 순서는 지켜줘야 함
		// 2) 동시 작업시에는 서로 영향을 주고 받는지를 점검해야 함
		Thread[] tArr = new Thread[8];
		
		// 쓰레드 생성을 담당
		for (int i = 0; i < tArr.length; i += 1) {
			tArr[i] =  new Thread(new CopyThread("file" + i +".pdf"));
		}
		// 쓰레드 시작을 담당
		for (int i = 0; i < tArr.length; i += 1) {
			tArr[i].start();
		}
		// 쓰레드들의 "합류"를 지시함
		for (int i = 0; i < tArr.length; i += 1) {
			try {
				// join() 메서드 - 해당 쓰레드가 생성되고, 실행된 곳에 "합류"를 지시함
				tArr[i].join();
			} catch (InterruptedException e) {
				System.out.println("모종의 이유로 쓰레드가 중단됨!");
			}
		}
		// 합류된 쓰레드가 다 끝나면 이 코드가 실행됨
		System.out.println("파일 복사 완료~!");
	}
}
