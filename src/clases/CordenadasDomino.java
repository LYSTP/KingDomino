package clases;

public class CordenadasDomino{

	private int x;
	private int y;

	public CordenadasDomino() {
	};

	public CordenadasDomino(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "X: " + getX() + ", Y: " + getY();
	}

}
