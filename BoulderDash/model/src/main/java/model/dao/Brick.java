package model.dao;

public class Brick {

	private int x;
	private int y;
	private char code;

	public Brick(char Code, int X, int Y) {
		
		setX(X);
		setY(Y);
		setCode(Code);

	}

	public int getX() {
		return x;
	}

	public void setX(int X) {
		this.x = X;
	}

	public int getY() {
		return y;
	}

	public void setY(int Y) {
		this.y = Y;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char Code) {
		this.code = Code;
	}

}
