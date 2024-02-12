package runSpace;

import java.io.File;
import java.util.Scanner;

public class EX2 {
	public static void main(String[] args) {
		// delete 메서드
		// - 일치하는 이름을 찾아서 삭제함
		
		// 1) 파일을 삭제할 때, 문답무용으로 삭제를 함
		File file1 = new File("JAVAFILE");
		System.out.println(file1.delete());

		// 2) 디렉토리는 내부에 다른 것이 존재하면 삭제를 못함
		File dir1 = new File("FOLDER");
		System.out.println(dir1.delete());
		
		// 파일의 경우는 exists를 이용해, 삭제실행/취소여부를 결정하도록 만듬
		File file2 = new File("TEMPFILE");
		if (file2.exists()) {
			System.out.print("TEMPFILE을 삭제할까요? (1. 예 / 2. 아니오) ");
			Scanner sc = new Scanner(System.in);
			if (sc.nextInt() == 1) {
				file2.delete();
				System.out.println("삭제가 완료되었습니다.");
			}
			else System.out.println("삭제가 취소되었습니다.");
		}
	}
}
