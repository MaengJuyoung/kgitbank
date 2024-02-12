package runSpace;

import java.util.Scanner;

public class TEST3 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Thread inputThread = new Thread(
				new Runnable() {
					public void run() {
						// 1) 배열에 값을 입력을 받아 저장하는 코드를 작성하세요.
						Scanner sc = new Scanner(System.in);
						System.out.print("값을 5개 입력하세요 > ");
						for (int i = 0; i < arr.length; i += 1) {
							arr[i] = sc.nextInt();
						}
					}
				}
			);
		Thread outputThread = new Thread(
				new Runnable() {
					public void run() {
						// 2) 배열에 저장된 값을 출력하세요.
						for (int i = 0;i < arr.length; i += 1) {
							System.out.println(arr[i]);
						}
					}
				}
			);
		inputThread.start();
		outputThread.start();
		try {
			inputThread.start();
			inputThread.join();
			outputThread.start();
		} catch(InterruptedException e) {
			System.out.println(e);
		}
	}
}
