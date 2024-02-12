package runSpace;

import java.io.File;
import java.io.IOException;

class Dir {
	private File object;
	public Dir(String name) {
		object = new File(name);
	}
	public Dir(File object) { // ※ wrapper 클래스는 원본 객체를 요구하는 경우가 많음
		this.object = object;
	}
	public boolean delete() {
		return object.delete();
	}
	public boolean mkdir() {
		return object.mkdir();
	}
	// 만약 예외가 발생하는 메서드를 포장할 경우...?
	// 1) 책임전가가 되도록 예외처리를 하시거나...
	public boolean createNewFile1() throws IOException {
		try {
			return object.createNewFile();
		}
		catch(IOException e) {
			throw e;
		}
	}
	// 2) 발생한 곳에서 책임을 지고 처리가 되도록 만듬!
	public boolean createNewFile2() {
		try {
			return object.createNewFile();
		}
		catch(IOException e) {
			return false;
		}
	}
}

public class EX3 {
	public static void main(String[] args) {
		// wrapper 클래스
		// - 상속으로 처리할 수 없을 경우 새롭게 설계하는 클래스
		// -> 물려받다보니 최종클래스로 만들어진 객체는 메서드가 너무 많음
		// -> 지나치게 많은 기능을 제한하는 역할도 수행함
		
		// EX) File Class
		// - 파일시스템 관리용이라, 파일 및 디렉토리의 관리를 담당함
		File file1 = new File("ASD");
		file1.mkdir();
		// 사용성을 높이기 위해 준비가 됨
		// - 상속구조가 아닌 경우가 많기 때문에, 업캐스팅은 제한되니 주의
		Dir dir1 = new Dir("ASD");
		Dir dir2 = new Dir(file1);
		dir1.mkdir();
		dir2.mkdir();
		
	}
}
