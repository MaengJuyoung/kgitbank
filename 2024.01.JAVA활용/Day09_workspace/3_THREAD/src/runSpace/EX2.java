package runSpace;

// Runnable 인터페이스 구현하기
class App1 implements Runnable {
	public void run() {
		for (int i = 1; i <= 9; i += 1)
			System.out.print(" " + i);
		System.out.println();
	}
}

public class EX2 {
	public static void test1() {
		// (1) run 메서드를 정의함
		App1 app1 = new App1();
		App1 app2 = new App1();

		// (2) Thread 객체를 생성해야 함
		Thread t1 = new Thread(app1);
		Thread t2 = new Thread(app2);

		// (3) start() 메서드를 호출함
		t1.start();
		t2.start();
	}

	public static void test2() {
		// 익명객체
		// - 이름이 없는 클래스를 실시간으로 만들어 객체를 생성한 것
		// - 이름이 없어서 원본명을 알 수 없음
		// - 상속을 해야만 만들 수 있도록 허용되어 있음
		/*
		 * Runnable app1 = new App1(); Runnable app2 = new Runnable() { public void
		 * run() { for (int i = 1; i <= 9; i += 1) System.out.print(" " + i);
		 * System.out.println(); } }; System.out.println(app1); // 실체가 있는 객체는 어떤 클래스로
		 * 만들어졌는지 나옴 System.out.println(app2); // 익명객체는 "생성위치" 만 나옴 Thread t1 = new
		 * Thread(app1); Thread t2 = new Thread(app2); t1.start(); t2.start();
		 */

		// ※ 익명객체는 "주목적"이 1회성 사용이다
		// - 추상클래스/인터페이스이고, 추가적인 상속/구현은 안됨
		Thread t1 = new Thread(new App1());
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 9; i += 1)
					System.out.print(" " + i);
				System.out.println();
			}
		});
		
		// - 인터페이스에 구현해줄 메서드가 하나밖에 없을 경우 좀 더 간결하게 하기 위해
		//   람다식으로 바꿔 작성함
		Thread t3 = new Thread(() -> {
			for (int i = 1; i <= 9; i += 1)
				System.out.print(" " + i);
			System.out.println();
		});
		t1.start();
		t2.start();
		t3.start();
		
		// 이렇게 쓰는 것은 별로 메리트가 없으니 피할 것
		(new Thread(() -> {
			for (int i = 1; i <= 9; i += 1)
				System.out.print(" " + i);
			System.out.println();
		})).start();
	}

	public static void main(String[] args) {
		// 2) Runnable 인터페이스 구현하기 - 권장방식
		// ※ Thread 관리과 실제 앱의 구분(분리관리 / 모듈화)

		// ※ 좀 더 유연하게 사용할 수 있음
		// test1();

		// ※ 익명 객체를 만들어 준비하는 경우가 많음
		test2();

	}
}
