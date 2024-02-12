package fileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class TEST1 {
	public static void main(String[] args) {
		// 실습 - 파일 복사하기
		// FileInputStream과 FileOutputStream을 이용하여 파일을 복사하세요.
		// 소스파일은 "InputFolder/READFILE.txt"이고
		// 목적지파일은 "OutputFolder/READFILE_copy1.txt"입니다.
		// 
		// 단, READFILE_copy1.txt가 존재할 경우 READFILE_copy2.txt로,
		// 이것도 존재할 경우 READFILE_copy3.txt, 또 존재하면 READFILE_copy4.txt ....
		// 계속 존재하면 숫자를 늘려서 복사가 되도록 만들어보세요.
		// ※ 실행할 때마다 뒤에 숫자가 붙은 파일들이 점점 늘어나게 됩니다.
		// ※ File 클래스 도움이 필요함
		
		try {
			// 1) 파일을 읽어서
			FileInputStream fis = new FileInputStream("InputFolder/READFILE.txt");
			LinkedList<Byte> tmp = new LinkedList<Byte>();
			while (true) {
				int data = fis.read();
				if (data == -1) break;
				else tmp.add((byte)data);
			}
			fis.close();
			
			// 2) 이름 중복이 있는지 체크하고
			int count = 1;
			while (true) {
				File file = new File("OutputFolder/READFILE_copy" + count + ".txt");
				// 3) 다음 이름 중복을 체크를 반복하고
				if (file.exists()) count += 1;
				else break;
			}
			// 4) 없으면 그 이름으로 파일로 출력한다
			FileOutputStream fos = new FileOutputStream("OutputFolder/READFILE_copy" + count + ".txt");
			for (int i = 0; i < tmp.size(); i += 1) {
				fos.write(tmp.get(i));
			}
			fos.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
