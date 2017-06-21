package model;

import java.awt.Point;

public interface IFall {

	void moveDown();

	void moveRight();

	void moveLeft();

	void doNothing();

	int getX();

	int getY();

	Point getPosition();

	boolean isFallingDown();

	boolean isFallingRight();

	boolean isFallingLeft();

	void setX(int i);

	void setY(int i);

}