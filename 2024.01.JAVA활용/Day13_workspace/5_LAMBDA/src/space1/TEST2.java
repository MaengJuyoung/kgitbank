package space1;

import java.util.function.Predicate;

public class TEST2 {
	public static void main(String[] args) {
		// Predicate<E> 인터페이스를 활용하세요.
		// 1) 0보다 크면 true, 그 외엔 false가 나오는 gt0를 람다식으로 생성하세요.
		//    Integer를 받아서 판별합니다.
		Predicate<Integer> gt0 = (Integer value) -> (value > 0);
		
		// 2) 10보다 작으면 true, 그 외엔 false가 나오는 lt10을 람다식으로 생성하세요.
		//    Integer를 받아서 판별합니다.
		Predicate<Integer> lt10 = (Integer value) -> (value < 10);
		
		// 3) gt0와 lt10을 합성하여 1이상 9이하가 맞는지 판별하는 결합메서드를 생성하세요.
		//    Integer를 받아서 판별합니다. x > 0 && x < 10
		Predicate<Integer> b1to9 = gt0.and(lt10);
		System.out.println(gt0.test(1) + " " + gt0.test(0));	// true false
		System.out.println(lt10.test(10) + " " + lt10.test(9));	// false true
		System.out.println(
				b1to9.test(5) + " " +
			    b1to9.test(10) + " " +
			    b1to9.test(0)
			  ); // true false false
	}
}
