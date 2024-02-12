package run;

// 인터페이스 : 추상클래스의 바리에이션 중 하나
// - 상속관계를 구현하기 위한 것
// - 객체를 만들 수 없음
interface Super {
	// 내부에 준비되는 메서드는 모두 public abstract로 가정함
	void method1();
	// abstract가 아닌 메서드는 default를 붙여 예외라고 설정함
	default void method2() {
		System.out.println("메서드2!");
	}
	// 인터페이스 내부에서는 필드를 준비하면, 다른 것으로 해석됨
	// public static final int VALUE = 10;
	// - 특별하게 필요한 것이 아니라면 준비하질 않음
}
interface Super1 {
	void method1();
}
interface Super2 {
	void method1();
}
// 인터페이스의 특별한 점 - 여러개를 동시에 구현할 수 있음
// - 클래스의 상속 : 수직관계를 구성함
// - 인터페이스의 구현 : 수평관계를 구성함
class Sub implements Super, Super1, Super2 {
	private double value;
	public Sub(double value) {
		this.value = value;
	}
	public void method1() {
		System.out.println("this value : " + this.value);
	}
}

public class EX3 {
	public static void main(String[] args) {
		// 인터페이스의 이해를 위해 알아야 하는 것
		// - 캡슐화의 극한 / 오버라이딩
		//   -> 자식클래스에 동일한 변수를 준비하여 필드를 숨기는 것
		//   -> 필드가 마음에 안드니...대타필드를 준비해 쓰는 방식으로도 가능함
		Sub sub1 = new Sub(3.14);
		sub1.method1();
		sub1.method2();
		Super sup1 = sub1;
		sup1.method1();
		sup1.method2();
		
		// 인터페이스를 통해 다양한 "방향"으로 업캐스팅이 가능하게 됨
		Super1 sup11 = sub1;
		Super2 sup22 = sub1;
		sup11.method1();
		sup22.method1();
	}
}
