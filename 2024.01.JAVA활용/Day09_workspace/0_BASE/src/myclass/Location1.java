package myclass;

public class Location1 {
	private int x;
	private int y;
	private int z;
	
	public Location1(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public int getZ() { return z; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setZ(int z) { this.z = z; }
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
