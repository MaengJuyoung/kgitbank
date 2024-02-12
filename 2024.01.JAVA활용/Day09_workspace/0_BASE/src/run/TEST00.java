package run;
import myclass.Location;
public class TEST00 {
	public static void main(String[] args) {
		// 실력테스트문제 - myclass에 정의하고, 실행은 여기서 합니다.
		// 1) 좌표를 관리하기 위한 클래스 Location을 정의하세요.
		// - 필드 : x좌표(실수), y좌표(실수), z좌표(실수)
		// - 메서드 : 생성자, 각 좌표에 대한 getter/setter, toString 오버라이딩
		// 아래의 코드가 실행됩니다.
		Location tag1 = new Location(10.1, 10.2, 10.3);
		System.out.println(tag1.getX());	// 10.1
		System.out.println(tag1.getY());	// 10.2
		System.out.println(tag1.getZ());	// 10.3
		System.out.println(tag1);			// (10.1, 10.2, 10.3)
		tag1.setX(10.5);
		tag1.setY(10.9);
		tag1.setZ(10.7);
		System.out.println(tag1);			// (10.5, 10.9, 10.7)
	}
}
