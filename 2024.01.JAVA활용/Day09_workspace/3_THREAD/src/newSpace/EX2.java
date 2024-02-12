package newSpace;

import java.util.Scanner;

class T1 implements Runnable {
	private int[] arr;
	public T1(int[] arr) { // 입력
		this.arr = arr;
	}
	public void run() {
		synchronized(arr) {
			try {
			    Scanner sc = new Scanner(System.in);
				for (int i = 0; i < arr.length; i += 1) {
					System.out.print((i + 1) + "번 값 입력 > ");
					arr[i] = sc.nextInt();
					arr.notify();
					arr.wait();
				} System.out.println("입력 쓰레드 종료");
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
class T2 implements Runnable {
	private int[] arr;
	public T2(int[] arr) { // 정방향출력 -> 입력된 값을 즉시보여주기 위함
		this.arr = arr;
	}
	public void run() {
		synchronized (arr) {
			try {
				if (arr[0] == 0) arr.wait();
				for (int i = 0; i < arr.length; i += 1) {
					System.out.println((i + 1) + "번 값 : " + arr[i]);
					arr.notify();
					if (i != arr.length - 1) arr.wait();
				} System.out.println("출력 쓰레드 종료");
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
class T3 implements Runnable {
	private int[] arr;
	public T3(int[] arr) { // 역방향출력 -> 입력이 끝난 뒤에 전부 보여줄 예정
		this.arr = arr;
	}
	public void run() {
		System.out.println("역방향출력쓰레드");
		for (int i = arr.length - 1; i >= 0; i -= 1) {
			System.out.print(" " + arr[i]);
		} System.out.println();
	}
}

public class EX2 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Thread t1 = new Thread(new T1(arr));
		Thread t2 = new Thread(new T2(arr));
		Thread t3 = new Thread(new T3(arr));
		try {
			// t1과 t2 주거니 받거니 하는 관계
			// - t1이 준비해주고, t2가 이를 이용하는 관계
			// - t2는 준비가 안될 경우 실행되지 않도록 조건문으로 통제함
			// - t1은 준비가 되었음을 알려주기 위해 notify를 수리로 사용함
			// - t2는 마지막에 starvation상태에 빠지기 않기 위해
			//   조건문으로 마지막 wait의 실행은 통제함 
			t1.start();
			t2.start();
			
			// t3
			// - 동시작업이 불가능
			// - 역방향이니, 입력이 다되어야 가능
			// - 순서대로 실행하기 위해, t1 쓰레드가 끝나고 되도록 통제함
			t1.join();
			t3.start();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
