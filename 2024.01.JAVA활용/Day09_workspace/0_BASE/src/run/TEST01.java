package run;
import myclass.GLocation;
public class TEST01 {
	public static void main(String[] args) {
		// 실습
		// 1) Location 클래스의 좌표들의 자료형을 바꿀 수 있도록
		//    제네릭을 적용하세요.
		//    새로운 클래스로 만들어내시고, 해당 클래스의 이름은
		//    GLocation으로 합니다.
		// 아래의 코드가 실행됩니다.
		
		GLocation<Integer, Integer, Integer> t1 = new GLocation<Integer, Integer, Integer>(10,20,30);
		// ※ 제네릭의 자료형은 오로지...
		//   클래스 자료형만 받으니 주의해야 함
		//   -> 원시 자료형은 설정 불가함
		//   -> 원시 자료형이 필요하면 wrapper 클래스를 사용해야 함
		System.out.println(t1);	// (10, 20, 30)
		t1.setX(100);
		System.out.println(t1.getX());	// 100
	}
}
