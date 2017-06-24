package model.dao;

/**
 * <h1>The Class Brick.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Brick {

	private int x;
	private int y;
	private char code;

	/**
	 * The Brick constructor
	 * @param Code
	 * @param X
	 * @param Y
	 */
	public Brick(char Code, int X, int Y) {
		
		setX(X);
		setY(Y);
		setCode(Code);

	}

	/**
	 * The getter of the x coordinate
	 * @return int x
	 */
	public int getX() {
		return x;
	}

	/**
	 * The setter of the x coordinate
	 * @param X
	 */
	public void setX(int X) {
		this.x = X;
	}

	/**
	 * The getter of the y coordinate
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * The setter of the y coordinate
	 * @param Y
	 */
	public void setY(int Y) {
		this.y = Y;
	}

	/**
	 * The getter of the brick code
	 * @return
	 */
	public char getCode() {
		return code;
	}

	/**
	 * The setter of the brick code
	 * @param Code
	 */
	public void setCode(char Code) {
		this.code = Code;
	}

}
