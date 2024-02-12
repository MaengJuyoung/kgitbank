package space1;

import java.util.function.Function;
import java.util.function.Predicate;

class Sample {
	public int x;
	public int y;
	public Sample(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class EX3 {
	public static void EX31() {
		// Function
		// A.compose(B) - B를 먼저 실행하고 A를 실행함 -> A(B(value)) 구조가 성립해야 함
		// A.andThen(B) - A를 먼저 실행하고 B를 실행함 -> B(A(value)) 구조가 성립해야 함
		// -> 서로 다른 메서드가 동시에 도는 것이 아니라
		//    서로 순번을 가지고 전달되는/전달된 것을 받아서 새로운 것을 만드는 과정으로 작동함
		Sample sam1 = new Sample(0, 0);
		Function<Sample, Sample> function1 = (Sample o) -> {
			o.x += 5;
			o.y -= 5;
			return o;
		};
		Function<Sample, Integer[]> function2 = (Sample o) -> {
			Integer[] arr = new Integer[2];
			arr[0] = o.x;
			arr[1] = o.y;
			return arr;
		};
		// Function 인터페이스의 합성
		Function<Sample, Integer[]> comp = function2.compose(function1);
		Function<Sample, Integer[]> andT = function1.andThen(function2);
		Integer[] arr1 = comp.apply(sam1);
		Integer[] arr2 = comp.apply(sam1);
		System.out.println(arr1[0] + " " + arr1[1]);
		System.out.println(arr2[0] + " " + arr2[1]);
	}
	public static void EX32() {
		// Predicate의 결합
		// and / or 메서드를 활용
		// - A.and(B) -> A(value) && B(value) 
		// - A.or(B) -> A(value) || B(value)
		Predicate<Sample> xgt5 = (Sample o) -> (o.x > 5);
		Predicate<Sample> ygt5 = (Sample o) -> (o.y > 5);
		Predicate<Sample> XandY = xgt5.and(ygt5);
		Predicate<Sample> XorY = xgt5.or(ygt5);
		Sample sam1 = new Sample(10, 10);
		Sample sam2 = new Sample(10, 3);
		System.out.println(XandY.test(sam1)); // xgt5(sam1) && ygt5(sam1)
		System.out.println(XandY.test(sam2));
		System.out.println(XorY.test(sam1)); // xgt5(sam1) || ygt5(sam1)
		System.out.println(XorY.test(sam2));
	}
	public static void main(String[] args) {
		// ※ function 패키지의 사용 이유 -> 메서드의 재사용/재활용/결합/조합
		// Function	 : compose / andThen
		EX31();
		// Predicate : and / or
		EX32();
	}
}
