package objectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Sample implements Serializable {
	// serialVersionUID
	// - 파일로 변환할 때 호환성을 위해 준비하는 변수
	// - 정수값은 버전관리요령에 따라 숫자를 부여하게 됨
	// - 설정안할 경우, 숫자가 임의로 부여되고...
	//   클래스에 변동이 생기면 숫자가 임의로 부여가 됨
	public static final long serialVersionUID = 100;
	public String name;
	public int age;
	public Sample(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class EX1 {
	public static void main(String[] args) {
		// Object Stream : 객체를 파일로 만들고, 다시 읽어들여 객체를 만들기 위한 스트림
		Sample sam1 = new Sample("고길동", 14);
		Sample sam2 = new Sample("김길동", 16);

		// Object Stream의 결과물은 관례로써, 확장자를 .ser로 설정함
		try (OutputStream fos = new FileOutputStream("OutputFolder/sam.ser")){
			// 직렬화 - Serialization -> 파일로 변환
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sam1); // 객체를 파일로 변환시켜서 기록함
			oos.writeObject(sam2);
		} catch (IOException e) {
			System.out.println(e);
		}
		sam1 = null;
		sam2 = null;
		try (InputStream fis = new FileInputStream("OutputFolder/sam.ser")){
			ObjectInputStream ois = new ObjectInputStream(fis);
			// 역직렬화 - Deserialization -> 객체로 변환
			sam1 = (Sample)ois.readObject(); // 파일로부터 객체의 정보를 읽어서 객체를 반환함
			sam2 = (Sample)ois.readObject(); // Object로 업캐스팅된 상태이니 다운캐스팅이 필요함
			System.out.println(sam1 + " " + sam1.name + " " + sam1.age);
			System.out.println(sam2 + " " + sam2.name + " " + sam2.age);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}
