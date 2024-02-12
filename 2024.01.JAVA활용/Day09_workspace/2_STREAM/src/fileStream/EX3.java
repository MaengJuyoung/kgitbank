package fileStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX3 {
	public static void main(String[] args) {
		// Data Stream에서 생각해볼점 - 문자 입출력
		// 1) 무조건 이 프로그램으로 만들어진 것만 읽어들지 않음
		//    문자값은 여기에 "기록방식(인코딩-encoding)" 이 관여함
		// 2) 다른 곳에서 만들어진 것들은
		//    문자값은 적절한 "읽는방식(디코딩-decoding)" 이 적용되야 함
		// -> 기록방식/읽는방식을 지정해줘야 제대로 다룰 수 있음
		// -> 만들어진 파일은 다른 프로그램으로 읽어서 내용물을 확인할 수 있음
		String fileName = "OutputFolder/file1";
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
			dos.writeChar('A');
			dos.writeChars("Apple");
			dos.writeChar('가');
			dos.writeChars("사과");
		} catch (IOException e) {
			System.out.println(e);
		}
		// Stream 전반에서 생각해볼 요소 - 속도문제
		// ※ I/O Request : 입출력 요청
		// -> 이 동작은 제한이 있음
		// -> 일괄로 요청해서, 일괄로 받아오는 것이 제일 베스트 -> Buffer(컴퓨터의 RAM)
		// 전체를 한번에 읽기는 부담스러우니, 읽기/쓰기가 병행되지만...
		try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
			for (int i = 0; i < 9; i += 1) {
				System.out.println(dis.readChar());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
