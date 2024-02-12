package run;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EX4 {
	public static void sample1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 2개 입력 > ");
		try {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if (num2 == 0)
				System.out.println("연산불가");
			else
				System.out.println("결과 : " + (num1 / num2));
		}
		// 정확하게 예외를 잡아줘야 함
		// - 예외에 따라서 대응을 달리해야 함
		// -> 치명적인 것은 중단시켜야 함
		// -> 치명적이지 않는 것은 그에 맞는 코드를 대응시킴
		catch (InputMismatchException e) {
			System.out.println("잘못된 입력이 감지되었습니다!");
			System.out.println(e); // 예외를 확인할 수 있음
			System.out.println(e.getMessage()); // 이유가 반환됨
		}
		// 추가도 가능하며, 단 Exception의 사용은 왠만하면 피하는게 좋음
		catch (Exception e) {
			System.out.println("무언가 심각한 문제가 발생했습니다!");
		}
	}

	public static void sample2() {
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		while (true) {
			System.out.print("정수 2개 입력 > ");
			try {
				num1 = sc.nextInt();
				num2 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다!");
				sc.nextLine();
				continue;
			} break;
		}
		if (num2 == 0)
			System.out.println("연산불가");
		else
			System.out.println("결과 : " + (num1 / num2));
	}

	public static void sample3() throws Exception {
		// 1) throw - 생성된 예외객체를 반환하기 위한 전용 키워드
		// - 조건문과도 사용이 가능함
		// - 예외처리 내부에 적용 가능함
		// 2) throws - 자료형을 설정하는 것이며, 여러종류일 경우 공통된 부모클래스로 설정해야 함
		// - 메서드 오른쪽에 붙으며 어떤 종류의 예외가 나오는지를 표기함
		// - 메서드의 반환형 설정과 동일함 
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 2개 입력 > ");
		try {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if (num2 == 0) throw new Exception();
			else
				System.out.println("결과 : " + (num1 / num2));
		}
		catch (InputMismatchException e) {
			// 예외처리 내부에 작성해서 그대로 전달도 가능함
			throw e;
		}
	}
	
	public static void main(String[] args) {
		// 예외처리(Exception Handling)
		// - 자바의 코드를 실행하면서 발생하는 모든 에러가 예외라고 불림
		// - 예외처리는 이를 없애는 것이 아니라, 안정성을 높이기 위함
		// ※ 없앨 수 있는 것들은 판별될 수 있고...
		// 판별은 조건문의 역할이며, 이를 통해 제거됨
		// - 예외는 대부분의 경우 판별할 수 없는 것이 많음...

		// 예측 가능하며 판별되는 것은 "예외"라고 취급하지 않음
		// - 코드 외부에 존재하면서 우리가 개입할 수 없는 것이 "예외"이다!
		// - 다행스럽게도, 자바는 이러한 예외에 대부분의 경우 다 대응해둔 상태임

		// ※ 예외처리를 할 때 원칙
		// (1) 발생한 곳에서 책임을 져야 함
		// (2) 책임질 수 없으면 책임을 전가해야 함
		sample1();
		sample2();
		try {
			sample3();	// throws가 설정될 경우 외부에서 반드시 잡아줘야 함
		}
		catch (Exception e) {
			System.out.println("오류!");
		}
	}
}
