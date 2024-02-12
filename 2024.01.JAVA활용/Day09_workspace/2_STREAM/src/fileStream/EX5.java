package fileStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EX5 {
	public static void main(String[] args) {
		// Buffer : 입력/출력 요청을 최소화해주기 위한 임시저장공간(컴퓨터의 RAM을 활용함)
		// - 시스템이 제공하는 크기로 자동설정하는 것이 일반적으로 최적임
		// - 경우에 따라서는 벤치마크 테스트를 통해 성능 측정을 하여 최적의 버퍼크기를 찾아야 함
		
		// 1) Buffered Input/Output Stream - stream에 버퍼를 추가해줌
		// - File Input/Output Stream에 적용을 하게 됨
		// - 이 스트림을 쓰는 모든 브릿지 클래스/ 랩핑 클래스에 적용됨
		String file = "OutputFolder/TESTFILE";
		try {
			
			OutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			// Buffer가 달린 것들의 고유기능 : flush();
			// - 임시공간에 보관된 것을 기록하라고 바로 지시하는 메서드
			// - 기록방식이 달라질 경우 그 전에 먼저 호출하여 작동시켜줘야 함
			// - 그 외의 경우라면 close할 때 자동호출됨
			// - flush를 호출하지 않더라도 주기적으로 자동호출됨
			for (int i = 0;i < 24000; i += 1) {
				bos.write(65);
			} bos.close();
			
			InputStream bis = new BufferedInputStream(new FileInputStream(file));
			// Buffer가 달린 것들이 읽을 때의 조심할 점
			// - "일정크기만큼" 읽어놓은 상태
			// - "버퍼가 없는" 읽기와 함께 쓰시면 굉장히 곤라해짐(실제 파일내부의 읽는 위치와 버퍼가 읽는 위치가 다름)
			// - 구별하기 위한 문자들(' ', '\t', '\n')을 배치하게 됨
			System.out.println(bis.read());
			bis.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}





