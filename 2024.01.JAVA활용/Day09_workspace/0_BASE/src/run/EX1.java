package run;
// 상속은 "관계성"이 존재함
// - 합쳐지는 것은 "결과" 만 놓고 보면 합쳐진 것처럼 보임
// - 실제로는 Phone을 기반으로 객체가 만들어지고...
//   이를 상속한 Smartphone 껍데기가 추가로 붙는 구조
class Phone {
	// 부모클래스의 필드
	// - 이를 상속받은 자식클래스가 반드시 가져야만 하는 필드를 의미함
	protected String number;
	// 부모클래스의 생성자
	// - 생성자가 없음(기본생성자만 있음) -> 필드를 마음대로 채우는 것을 허용함
	// - 생성자가 있음(기본생성자가 없음) -> 필드를 채우는 방식을 강제함
	public Phone(String number) {
		this.number = number;
	}
	// 부모클래스의 메서드
	// - 반드시 있어야 하는 기능이며, 필요하면 고쳐 쓰는 것(오버라이딩)을 허용함
	public void call() {
		System.out.println("무선전화기능!");
	}
	public void sms() {
		System.out.println("문자기능!");
	}
}
class Smartphone extends Phone {
	private String model;
	public Smartphone(String number, String model) {
		super(number);
		this.model = model;
	}
	public void game() {
		System.out.println("게임!");
	}
	public void browsing() {
		System.out.println("인터넷 서핑!");
	}
	public void music() {
		System.out.println("음악 듣는 중!");
	}
}
class Featurephone extends Phone {
	private String model;
	public Featurephone(String number, String model) {
		super(number);
		this.model = model;
	}
	public void radio() {
		System.out.println("라디오기능!");
	}
}
class Publicphone extends Phone {
	public Publicphone(String number) {
		super(number);
	}
	public void call() {
		System.out.println("유선전화기능!");
	}
	public void sms() {
		System.out.println("문자불가능!");
	}
}

public class EX1 {
	public static void main(String[] args) {
		// 제네릭은 자료형을 바꿔서 쓸 수 있게 해주는 기술 -> 어디에도 적용이 가능함

		// 클래스의 목적 - 묘사(현실에 있는 것을 모방 / 내기 필요한 것을 설계)

		// 스마트폰 - 스마트폰 클래스
		// -> 다른 형태로도 취급될 필요가 있음
		// -> 그 때는 다른 기능은 다 필요없고, 오로지 특정기능만 이용할 수 있으면 끝!
		// -> 똑같은 과정이 코드로도 모방되어야 함

		// 상속(Inheritance) - 이어받는 것
		// 1) 빠른 클래스의 정의를 도와줌
		// 유지보수도 간편해짐
		// 2) 상속이 된 것이라면 필요에 따라 취급되는 방식을 바꿀 수 있게 해줌
		// -> 업캐스팅 / 다운캐스팅
		// -> 자료형은 그대로 유지가 되면서...취급방식을 바꾸는 과정
		// -> 인간적으로 메서드가 많아도 너무 많음....
		
		Smartphone sp1 = new Smartphone("010-1234-5678", "아이폰15");
		sp1.call();
		sp1.sms();
		Phone p1 = sp1; // 업캐스팅 - 자료형 변환이  아님, 취급방식을 바꾸는 과정
		p1.call();
		p1.sms();  // 이 취급방식일 때 필요한 기능만 쓸 수 있게 됨
		
		Publicphone pp1 = new Publicphone("010-5432-9876");
		pp1.call();
		pp1.sms();
		Phone p2 = pp1;
		p2.call(); // 자료형 변환이 아니기에, 고유기능은 손실되지 않고 유지됨
		p2.sms();
	}
}
