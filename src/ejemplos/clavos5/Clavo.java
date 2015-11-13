package ejemplos.clavos5;

public class Clavo {
	private int x, y;
	
	public Clavo(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return x + "," + y + "\n";
	}
}
