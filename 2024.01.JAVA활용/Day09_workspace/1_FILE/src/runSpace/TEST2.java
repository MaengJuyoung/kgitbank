package runSpace;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TEST2 {
	public static void main(String[] args) {
		// 예외처리는 크게 2가지가 존재함
		// - Checked Exception : Exception클래스를 바로 상속한 예외클래스
		//   -> 무조건 예외처리를 해줘야 함
		// - Unchecked Exception : Exception클래스를 상속한 RuntimeException을 상속한 예외클래스
		//   -> 예외처리를 하지 않아도 됨
		for (int i = 1; i <= 4; i += 1) {
			try {
				(new File("testfile" + i)).createNewFile();
			} catch(IOException e) {
				break;
			}
		}
		// 실습
		// Scanner를 이용해 삭제할 파일의 번호(1~4)만 입력을 받아
		// 삭제해보세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("파일 번호 > ");
		int num = sc.nextInt();
		File file = new File("testfile" + num);
		System.out.println("존재하는지 여부 : " + file.exists());	// true
		file.delete();
		System.out.println("존재하는지 여부 : " + file.exists()); // false
	}
}





