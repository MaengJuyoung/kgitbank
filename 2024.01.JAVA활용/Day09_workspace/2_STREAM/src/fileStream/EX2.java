package fileStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX2 {
	public static void main(String[] args) {
		// File Stream의 제한사항 : 바이트를 다룸
		// -> 1바이트 - 8비트의 집합
		// -> int자료형은 4바이트 -> 1바이트 4조각 쪼갬 -> 파일입출력에 넘겨야 함
		// -> 실수값, 문자값 등을 포함하게 되면 변환과정이 쉽지 않음 / 자바코드로 구현불가능도 생김
		// -> 각종 종류의 값을 다루기 위해...
		// File Stream에 기능을 추가/변환하는 wrapper/decorator 클래스

		// Data Stream : Input/Output - 원시자료형을 다루기 위함(정수/실수를 위한 용도)
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("OutputFolder/SAMPLEFILE.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(1234);
			dos.writeInt(13456); // 4바이트를 기록함
			dos.writeInt(145678); // 정수값 4바이트는 1바이트씩 쪼개지고 변환되어 전달됨
			dos.writeInt(1567890);
			dos.writeInt(16789012);
		} catch (IOException e) {
			System.out.println("파일 생성 및 내용 기록에 문제가 생겼습니다.");
		}
		// 예외처리 - finally : 예외가 발생해도 무조건 실행되어야 하는 코드를 작성하는 곳
		finally { // 스트림을 다룰 때는 통로의 개방/닫기 처리를 놓치지 않도록 조심해야 함
			try {
				if (fos != null)
					fos.close(); // fos에 대한 close처리
			} catch (IOException e) { // 여기서 발생하는 예외는 심각한 문제가 됨
				System.out.println("저장소에 심각한 문제가 생긴 것 같습니다.");
			}
		}

		// try-with-resource 예외처리 : 스트림의 close처리를 예외가 발생하면 자동으로 해주는 예외처리
		// -> 스트림의 close를 위한 예외처리를 간단하게 만들어줌
		// -> try 옆에 메서드의 매개변수 준비하는 것처럼 진행하며 미리 객체를 생성해줌
		try (DataInputStream dis = new DataInputStream(new FileInputStream("OutputFolder/SAMPLEFILE.txt"))) {
			System.out.println(dis.readInt());
			System.out.println(dis.readInt()); // 4바이트를 읽어들임
			System.out.println(dis.readInt()); // 쪼개진 것을 합쳐서 원본을 만들어냄
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());
			// + 부가효과 : try 외부로 벗어나면 자동 close를 해줌
			// dis.close(); 안붙여도 됨
		} catch (FileNotFoundException e) {// 입력스트림을 만들 때 대상파일이 없으면 발생함
			System.out.println("해당파일이 없습니다.");
		} catch (EOFException e) { // 잘못된 방식으로 읽었음을 의미함
			System.out.println("읽어들이는 크기만큼의 데이터가 없음");
		} catch (IOException e) { // 각종 읽기/쓰기에 발생하는 예외의 종합
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}
}
