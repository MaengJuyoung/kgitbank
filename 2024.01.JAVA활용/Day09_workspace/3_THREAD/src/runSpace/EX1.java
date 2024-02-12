package runSpace;

class App extends Thread {
	// 필드 - App을 굴리는데 필요한 기반환경을 맞춰주기 위한 변수
	
	// 메서드 - App내에서 사용하는 것을 전제로하는 메서드를 준비함
	
	// public void run() {} - 오버라이딩해야 하는 메서드
	public void run() {
		for (int i = 1; i <= 9; i += 1) System.out.print(" " + i);
		System.out.println();
	}
}

public class EX1 {
	public static void main(String[] args) {
		// 멀티 쓰레딩 - 프로그램 내에서의 다중작업

		// 1) Thread 클래스를 상속하여 활용함
		App t1 = new App();
		App t2 = new App();
		App t3 = new App();
		// start - 쓰레드 시작 메서드 -> run 메서드를 내부에서 호출함
		t1.start(); // 코드 순서상으로는 t1, t2, t3 순이지만..
		t2.start(); // 내부 처리하는 코드양에 따라서...
		t3.start(); // 먼저 끝나거나, 나중에 끝나는 등 서로 다른 과정을 거치게 됨
		
		// 주의사항
		// 1) 쓰레드를 어떻게 통제할 것인가?
		// 2) 실제로 적용해서 성능 이점이 있는가?
	}
}
