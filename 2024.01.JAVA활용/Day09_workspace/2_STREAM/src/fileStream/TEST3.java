package fileStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TEST3 {
	public static void makeFile(String file, String name, int age, String hobby) {
		// 이 내부에서는 FileOutputStream과 DataOutputStream, OutputStreamWriter를 활용함
		try (FileOutputStream fos = new FileOutputStream("OutputFolder/" + file)){
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			DataOutputStream dos = new DataOutputStream(fos);
			osw.write(name);
			osw.flush();	// flush : Buffer의 내용을 기록하도록 지시하는 메서드
			dos.writeInt(age);
			osw.write(hobby);
			osw.flush();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	public static void readFile(String fileLocation) {
		// 이 내부에서는 FileInputStream과 DataInputStream, InputStreamReader를 활용함
		try(FileInputStream fis = new FileInputStream(fileLocation)){
			DataInputStream dis = new DataInputStream(fis);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			String name = "";
			name += (char)isr.read();
			name += (char)isr.read();
			name += (char)isr.read();
			System.out.println(name);
			// 문제상황
			// - 기록방식/읽는방식의 차이로 문제가 생김
			// - 내부에서 읽을 데이터가 있지만, 읽을 수 없음(EOF)으로 거부된 상태
			int age = 0;
			age += isr.read();
			age += isr.read();
			age += isr.read();
			age += isr.read();
			System.out.println(age);
			
			String hobby = "";
			for (int i = 0; i < 7; i += 1) {
				hobby += (char)isr.read();
			}
			System.out.println(hobby);
			
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// 실습
		// 1) 개인정보가 담겨있는 파일을 만드는 실습입니다.
		//    여기서는 Data Stream과 Reader, Writer 모두 사용하셔야 합니다.
		// 2) 파일은 총 3줄/3개의 자료로 구성됩니다.
		//    1번줄 : 이름 - 문자열(Reader/Writer로 다룹니다.)
		//    2번줄 : 나이 - 정수(Data Stream으로 다룹니다.)
		//    3번줄 : 취미 - 문자열(Reader/Writer로 다룹니다.)
		// 3) 지정한 파일명으로 OutputFolder에 전달된 값으로 파일을 만드는 makeFile 메서드를 정의하세요.
		// 4) 지정한 파일명으로 대상이 된 파일을 읽어 출력하는 readFile 메서드를 정의하세요.
		
		// 실행코드 - 예외처리는 각 메서드에서 책임을 담당합니다.
		makeFile("person1", "고길동", 54, "둘리 괴롭히기");
		readFile("OutputFolder/person1");
		// readFile 메서드에서 이름, 나이, 취미를 출력합니다.
	}
}
