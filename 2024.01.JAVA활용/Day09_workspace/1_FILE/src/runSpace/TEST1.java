package runSpace;

import java.io.File;
import java.io.IOException;

public class TEST1 {
	public static void main(String[] args) {
		// 실습
		// 1) File클래스를 이용하여 OutputFolder라는 이름으로 폴더를 생성하세요.
		// 2) File클래스를 이용하여 TEMPFILE이라는 이름으로 파일을 생성하세요.
		// 3) 다 만들어낸 다음, 만들어낸 것들이 존재하는지 여부를 출력하세요.
		
		File dir1 = new File("OutputFolder");
		
		if (dir1.mkdir()) System.out.println("폴더가 만들어졌습니다.");
		else System.out.println("이미 폴더가 만들어진 상태입니다.");
		
		File file1 = new File("TEMPFILE");
		try {
			file1.createNewFile();
		}
		catch (IOException e) {
			System.out.println("저장공간에 문제가 있습니다.");
		}
		System.out.println(dir1.exists() + " " + file1.exists());
		
		// 이용하는 시나리오
		// - 최초 실행에서는 mkdir, createNewFile로 필요한 구조를 만듬
		// - 두번째 실행부터는 exists로 생성과정을 건너뛸지 말지를 결정하도록 만듬
		// -> 이 2개는 exists를 기반으로 연동되거나, 따로 메서드로 만들어서 골라서 실행하는 등...
		//    다양하게 조합될 수 있음
		
		
		
	}
}
