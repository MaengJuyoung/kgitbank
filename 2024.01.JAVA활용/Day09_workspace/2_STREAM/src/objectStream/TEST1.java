package objectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;

class Location implements Serializable {
	public static final long serialVersionUID = 10000;
	public double x;
	public double y;
	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "(" + x +", " + y + ")";
	}
}

public class TEST1 {
	public static void main(String[] args) {
		// 실습
		// Location 객체들을 list.ser 파일에 모두 기록하고
		// 다시 읽어들여 정상적으로 복원되었는지 확인하고
		// x, y 좌표의 평균을 구하여 출력하세요.
		String file = "OutputFolder/list.ser";
		try (OutputStream fos = new FileOutputStream(file)){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new Location(10.1, 10.2));
			oos.writeObject(new Location(15.2, 13.1));
			oos.writeObject(new Location(17.5, 11.7));
		} catch (IOException e) {
			System.out.println(
					"기록중에서는 클래스 관련 에러가 발생하지 않습니다.\n"
					+ "대신, 기록 과정에서 문제가 생깁니다.");
		}
		try(InputStream fis = new FileInputStream(file)){
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Collection(자료구조)의 핵심 - 넣기, 이용하기, 빼기(제거)
			LinkedList<Location> lst = new LinkedList<Location>();
			
			lst.add((Location)ois.readObject()); // add : 넣기
			lst.add((Location)ois.readObject());
			lst.add((Location)ois.readObject());
			
			System.out.println(lst); // toString 메서드를 내부에서 자동호출함
			
			double avgX = (lst.get(0).x + lst.get(1).x + lst.get(2).x) / 3; // get : 가져오기
			double avgY = (lst.get(0).y + lst.get(1).y + lst.get(2).y) / 3;
			
			System.out.printf("중간좌표 : (%.1f, %.1f)\n", avgX, avgY);
			
			lst.remove(); // 제거
			lst.remove();
			lst.remove();
			
		} catch (InvalidClassException e) {
			System.out.println("IOException 보다 먼저 잡아줘야하고, UID불일치로 발생합니다.");
		} catch (IOException e) {
			System.out.println("읽는 중에는 읽기 과정 전반에서 문제가 생길 수 있습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("또한 읽기 기능이 있는 프로그램에 클래스가 없으면 발생합니다.");
		} 
		
		
		
		
		
		
		
		
		
	}
}
