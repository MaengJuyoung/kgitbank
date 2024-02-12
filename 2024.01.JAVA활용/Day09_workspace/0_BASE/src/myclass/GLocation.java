package myclass;

// 제네릭 클래스
// - 미리 준비할려면 경험이 필요한 클래스
// - 자료형에만 관여함
// - 고정된 자료형의 반환은 조심해야 함
//   -> 설정된 자료형과 반환값의 자료형이 불일치하면
//      예외가 발생하니 주의해야 함
//   -> null을 잘 사용해야 하는 요구조건이 붙기도 함
public class GLocation<T1, T2, T3> {
		private T1 x;
		private T2 y;
		private T3 z;
		public GLocation(T1 x, T2 y, T3 z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public T1 getX() { return x; }
		public T2 getY() { return y; }
		public T3 getZ() { return z; }
		public void setX(T1 x) { this.x = x; }
		public void setY(T2 y) { this.y = y; }
		public void setZ(T3 z) { this.z = z; }
		public String toString() {
			return "(" + x + ", " + y + ", " + z + ")";
		}
}
