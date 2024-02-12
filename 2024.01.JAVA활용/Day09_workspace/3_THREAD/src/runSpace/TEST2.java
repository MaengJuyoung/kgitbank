package runSpace;

class ThreadShow implements Runnable {
	private int[] arr;
	private int direction;
	public ThreadShow(int[] arr, int direction) {
		this.arr = arr;
		this.direction = direction;
	}
	public void run() {
		// 내부에서...
		// direction이 1이면 0번부터 마지막까지
		if (direction == 1) {
			for (int i = 0; i < arr.length; i += 1) System.out.print(" " + arr[i]);
		}
		// direction이 -1이면 마지막부터 0번까지
		else if (direction == -1) {
			for (int i = arr.length - 1; i >= 0; i -= 1) System.out.print(" " + arr[i]);
		}
		System.out.println();
		// 순서로 출력하는 코드를 작성합니다.
	}
}

public class TEST2 {
	public static void main(String[] args) {
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i += 1) arr[i] = i + 1;
		// 실습 - 배열을 출력하는 쓰레드를 준비하세요.
		// 1) 생성자에서 배열과 방향을 설정할 수 있도록 만들어줍니다.
		//   방향은 정수변수로 설정하며, 1이면 0번 인덱스부터, -1이면 마지막 인데스부터 시작합니다.
		// 2) 생성자로 받아온 배열과 방향을 토대로 객체를 생성하고
		//   쓰레드로 실행하세요.
		// 3) 아래와 같이 결과가 나오도록 순서를 조절해보세요.
		Thread t1 = new Thread(new ThreadShow(arr, 1));
		Thread t2 = new Thread(new ThreadShow(arr, 1));
		Thread t3 = new Thread(new ThreadShow(arr, -1));
		Thread t4 = new Thread(new ThreadShow(arr, -1));
		
		// ---- 출력결과예시 ---- (※ 몇번이고 실행도 동일한 순서로만 나옵니다.)
		// 1 2 3 4 5 6 7 8 9
		// 9 8 7 6 5 4 3 2 1
		// 9 8 7 6 5 4 3 2 1
		// 1 2 3 4 5 6 7 8 9
		try {
			t1.start();
			t1.join();
			t3.start();
			t3.join();
			t4.start();
			t4.join();
			t2.start();
			t2.join();
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
