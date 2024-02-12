package fileStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class EX4 {
	public static void main(String[] args) {
		// Reader / Writer 클래스
		// - 문자 입출력에 특화된 클래스
		// - wrapper 클래스 / 문자 입출력 외의 용도로는 사용 불가
		String fileName = "OutputFolder/file2";
		
		// new OutputStreamWriter(입력스트림, "인코딩방식");
		try (Writer writer1 = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")){
			// write - 문자값 기록이 가능함
			writer1.write('A'); writer1.write('p'); writer1.write('p'); writer1.write('\n');
			// write - 오버로딩으로 문자열도 처리가능
			writer1.write("App\n");
			// writer1.close();
		} catch(IOException e) {
			System.out.println(e);
		}
		// new InputStreamReader(입력스트림, "인코딩방식");
		// - 인코딩을 따로 지정하지 않을 경우, 운영체제 등에서 자동으로 인식해서 설정됨
		//   안정적인 입출력을 위해서 지정하는 편이 좋음
		try (Reader reader1 = new InputStreamReader(new FileInputStream(fileName), "UTF-8")){
			while (true) {
				int data = reader1.read();
				if (data == -1) break; // File Stream의 -1 처리 방식으로 동작을 멈추게 됨
				else System.out.print((char)data);
			}  // reader1.close();
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}
}
