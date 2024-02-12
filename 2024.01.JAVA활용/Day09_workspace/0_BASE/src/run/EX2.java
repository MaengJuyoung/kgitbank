package run;

// 추상클래스 : abstract키워드가 붙어있는 클래스
// - 내부에 추상메서드가 있던 없던...
//   상속을 위한 용도로 제한되어 있음을 의미함
abstract class Base {
	protected int value;
	public Base() {
		value = 0;
	}
	// 추상메서드 : 저장된 코드가 없는 상태인 메서드
	// - 무조건 오버라이딩을 해줄 것을 알리기 위함
	//   내용물이 비어있는 상태로 준비하게 됨
	public abstract void method1();
	// + 메서드에서 실행할 코드의 자율성을 부여함
}
class Child extends Base {
	public Child(int value) {
		this.value = value;
	}
	public void method1() {
		System.out.println("값 : " + value);
	}
}

public class EX2 {
	public static void main(String[] args) {
		// 추상클래스와 인터페이스를 이해할려면 상속에 대한 이해가 필요함
		// - 오버라이딩
		// - 부모클래스에 준비된 메서드를 상속했을 때 매번 오버라이딩한다면?
		//   기존 코드의 재활용을 할 수 없을 때, 과연 부모 클래스의 메서드의 가치는?
		
		// 추상클래스는 상속관계를 구성해주기 위한 용도
		// -> 부모클래스로 객체생성 불가
		Child c1 = new Child(100);
		
		// 관계 구축이 주 목적이며, 그 관계를 이용하는 업캐스팅은 가능함
		// -> 여러 단계로 구성된 클래스를 만들 때 도움이 됨
		Base b1 = c1;
		b1.method1();
	}
}
