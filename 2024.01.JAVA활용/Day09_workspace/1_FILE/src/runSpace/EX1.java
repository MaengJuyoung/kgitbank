package runSpace;

import java.io.File;
import java.io.IOException;

public class EX1 {
	public static void main(String[] args) {
		// File : 저장공간을 관리하기 위한 클래스
		// 관리원칙
		// 1) 있는지 없는지를 체크함
		// 2) 필요한 작업을 수행함
		// exists() - 같은 이름을 가진 것이 있는지 없는지를 체크함 / 더 빠름
		// createNewFile() - 설정된 이름으로 파일을 만듬 / 느림
		// mkdir() - 설정된 이름으로 폴더를 만듬		   / 느림
		
		// case 1. 디렉토리 생성 - 예외가 발생하는 경우가 잘 없음
		File dir1 = new File("InputFolder"); // 경로정보가 없으면 앱이 실행된 위치를 기본으로 함
		System.out.println(dir1.exists());	 // 같은 이름을 가진 무언가를 체크함
		System.out.println(dir1.mkdir());    // 설정된 명칭으로 폴더를 만들어줬음
		
		// case 2. 파일 생성(실제 사용방식으로 작성됨) - 예외가 자주 발생함 
		File file1 = new File("C:/JAVAFILE");
		if (file1.exists()) {
			System.out.println("이미 존재하는 파일입니다!");
		}
		else {
			try {
				file1.createNewFile(); // 예외처리 필수
				// createNewFile의 true/false는 이용할려는 저장공간에 문제가 없는 상황에서 발생하는 성공/실패
				// -> 파일이 이미 존재한다는 중복을 의미함
			}
			catch (IOException e) {
				// ※ 파일의 생성 실패는, 중복에 의해서만 발생하지 않음
				System.out.println("파일 생성에 실패했습니다.");
				// 이용할려는 저장공간에 모종의 예측할 수 없는 제한/문제가 있음
				// -> 저장공간의 존재유무, 저장공간의 사용권한문제 등...
			}
		}
		
	}
}
