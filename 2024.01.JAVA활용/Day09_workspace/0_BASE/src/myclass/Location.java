package myclass;

// 클래스는 기본적으로 별로로 준비가 됨
// - 자료형으로 사용되는 소스파일
// - 실행을 위해 사용되는 소스파일
// - 각각의 구분은 패키지를 통해 구분하면 됨
public class Location {
	// 필드
	private double x; // - 필요로 하는 대상이 가지는 속성
	private double y; // - 최대 protected까지만 풀어줌
	private double z;
	
	// 메서드
	// - 객체를 사용할 수 있는 방법
	public Location(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getX() { return x; }
	public double getY() { return y; }
	public double getZ() { return z; }
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	public void setZ(double z) { this.z = z; }
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
