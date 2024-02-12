package fileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class EX1 {
	public static byte[] readFile(String fileName) throws IOException {
		try {
			// FileInputStream : 파일을 읽어들이는 역할
			// - 필요한 목적지 전달하기 위한 파일을 읽어들임 / 그 내용물을 바로 쓰게 하는 것에는 관심이 없음
			FileInputStream fis1 = new FileInputStream("InputFolder/" + fileName);

			// read() : 1 Byte 단위를 읽어서 정수값으로 변환시켜 반환함
			// - 더이상 읽을 수 없으면 EOF(End Of File)로써 -1을 반환함 / -1은 못쓰는 값이기에 반복이 중단되도록 만들어줌
			byte[] arr = new byte[19]; // byte : 무부호 정수자료형 / 1 Byte
			for (int i = 0; i < 19; i += 1) {
				arr[i] = (byte) fis1.read();
			}

			// close() : 만들었던 스트림을 닫기 위한 메서드
			// - 사용중이던 파일의 사용이 끝났으며, 그에 대한 뒷정리를 진행함 / 이걸 안하면, 나중에 파일에 대한 다른 작업을 못하게 됨
			fis1.close();
			return arr;
		} catch (IOException e) {
			throw e; // FileNotFoundException은 업캐스팅됨
		}
	}

	public static byte[] readFileWithList(String fileName) throws IOException {
		try {
			FileInputStream fis1 = new FileInputStream("InputFolder/" + fileName);
			// java.util.Collections : 자바의 자료구조
			// - 고정되지 않은 수량의 값들의 관리(보관,삭제,변환 등...)
			// - 수많은 상속구조를 가지며, 제네릭 클래스임
			// - 다루는 방법은 메서드에서 의해서 대부분 통일되어 있음
			// ※ java.util.LinkedList - 크기가 변하는 배열
			LinkedList<Byte> lst = new LinkedList<Byte>();
			while (true) {
				int data = fis1.read();
				if (data == -1) break;
				else lst.add((byte)data); // 파이썬의 리스트의 append와 동일한 작업
			}
			fis1.close();
			byte[] arr = new byte[lst.size()];
			for (int i = 0; i < arr.length; i += 1) {
				arr[i] = lst.get(i); // 자바의 배열/파이썬의 리스트의 인덱싱과 동일한 작업
			}
			// lst.toArray()는 Object 배열이기에, 받는 쪽에서 형변환 처리를 해주는게 좋음
			return arr;
		} catch (IOException e) {
			throw e;
		}
	}
	
	public static void writeFile(String fileName, byte[] arr) throws IOException {
		try {
			// FileOutputStream : 파일로 기록하기 위한 통로를 만들어냄
			FileOutputStream fos1 = new FileOutputStream("OutputFolder/WRITEFILE.txt");

			// write : 대상을 기록함. 없으면 생성하나, 덮어쓰기를 해버림
			// - 하나의 값을 받아서 기록하는 방식의 반복을 돌려도 되고..
			// 혹은 배열을 전달해서 한번에 기록하라고 할 수 있음
			fos1.write(arr);

			// close() : Input쪽의 close와 동일함
			fos1.close();
		} catch (IOException e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		File dir1 = new File("InputFolder");
		File dir2 = new File("OutputFolder");
		dir1.mkdir();
		dir2.mkdir();
		try {
			// File Stream의 목적 - 파일의 복사 / 다른 곳에 중계하기 위한 첫번째 통로
			byte[] arr = readFileWithList("READFILE.txt");
			writeFile("WRITEFILE.txt", arr);
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
