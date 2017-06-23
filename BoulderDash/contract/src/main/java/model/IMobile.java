package model;

public interface IMobile {

	int getX();

	void setX(int x);

	int getY();

	void setY(int y);

	boolean isAlive();

	void die();

	Direction getDirection();

	void setDirection(Direction direction);
}