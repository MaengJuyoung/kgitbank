package space1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EX2 {
	public static void EX21() {
		// 1) Predicate<E> : 조건식을 메서드 형태로 구현한 것
		// -> test() 메서드를 이용해 사용함
		// -> 반환형이 boolean으로 고정되어 있음
		Predicate<Integer> biggerThan5 = (Integer o) -> (o > 5);
		System.out.println(biggerThan5.test(10));
	}
	public static void EX22() {
		// 2) Consumer<E> : 값을 받아서 내부에서 결론을 만들어 출력하는 메서드용
		// -> accept() 메서드를 이용함
		// -> 반환형이 void로 고정되어 있음
		Consumer<Integer> showValue = (Integer o) -> {
			System.out.println("결과 : " + o);
		};
		showValue.accept(10);
	}
	public static void EX23() {
		// Supplier<E> : 반환만 하는 메서드
		// - 내부에서 준비한 것을 호출된 곳에 반환하도록 구성해야 하는 인터페이스
		// - get() 메서드를 활용함
		// - 제네릭은 반환형에 적용이 되며, 매개변수가 없는 인터페이스
		Supplier<InetAddress> getter = () -> { // 고정된 값을 가진 객체생성에 유리함
			try {
				return InetAddress.getByName("www.google.com");
			} catch (UnknownHostException e) {
				return null;
			}
		};
		InetAddress a1 = getter.get();
		System.out.println(a1.getHostName());
	}
	public static void EX24() {
		// Function<E1, E2> : E1 - 매개변수, E2 - 반환형
		// - 내부에는 연산과정만 담아서 만들라고 준비된 인터페이스
		// - 응용은 가능하지만, 권장하지 않음
		// - apply()메서드를 활용함
		Function<Integer, Integer> makeSum = (Integer o) -> {
			int result = 0;
			for (int i = 1; i <= o; i += 1) result += i;
			return result;
		};
		System.out.println(makeSum.apply(10));
	}
	
	public static void main(String[] args) {
		// java.util.function 패키지
		// - 람다식을 적용하기 편한 인터페이스가 제공되는 패키지
		//   -> 추상메서드가 하나만 존재함
		// - and/or 등의 메서드로 새로운 메서드를 조합하여 생성도 가능함
		EX21();
		EX22();
		EX23();
		EX24();
	}
}
