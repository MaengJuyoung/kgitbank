package runSpace;

import java.util.Scanner;

class TestApp1 implements Runnable {
	public void run() {
		for (int i = 10; i >= 1; i -= 1) System.out.print(" " + i);
		System.out.println();
	}
}
class TestApp2 implements Runnable {
	public void run() {
		System.out.print("마지막 숫자를 입력하세요 > ");
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		for (int i = 1;  i <= limit; i += 1) System.out.print(" " + i);
		System.out.println();
	}
}

public class TEST1 {
	public static void main(String[] args) {
		// 실습 - Runnable 인터페이스를 구현하고 Thread 객체를 생성하세요.
		// 1) TestApp1 클래스를 정의합니다.
		//    run 메서드를 오버라이딩하면서, 내부에서 정수를 10부터 1까지 출력합니다.
		// 2) TestApp2 클래스를 정의합니다.
		//    run 메서드를 오버라이딩하면서, Scanner로 정수를 하나 입력을 받아
		//    1부터 입력된 정수까지 출력하세요.
		//    양수가 아닐 경우 출력하지 않습니다.
		Thread t1 = new Thread(new TestApp1());
		Thread t2 = new Thread(new TestApp2());
		// t1.start();
		// t2.start();
		
		// 쓰레드는 기본적으로 "동시" 실행으로 취급됨
		// - 동시성 관리 유틸리티 클래스/메서드 등을 사용해줘야 함
		// - 간단한 방식으로는 t1 쓰레드 내부에서 t2 쓰레드가 시작되도록 연계를 맞춰주면 가능함
		// ※ 익명객체를 이용한 방법도 존재함
		Thread t4 = new Thread(() -> {
				System.out.println("4번 쓰레드!");
			}
		);
		Thread t3 = new Thread(() -> {
				System.out.println("3번 쓰레드!");
				t4.start();
			}
		);
		t3.start();
	}
}
