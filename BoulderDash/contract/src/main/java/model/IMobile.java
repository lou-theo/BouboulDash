package model;

import java.awt.Point;

public interface IMobile {

	/*boolean moveUp();

	boolean moveDown();

	boolean moveRight();

	boolean moveLeft();

	void doNothing();*/

	void setHasMoved();

	int getX();

	void setX(int x);

	int getY();

	void setY(int y);

	Point getPosition();

	IMap getMap();

	void setMap(IMap map);

	boolean isAlive();

	void die();

	PassingState isPassing(int x, int y, ElementType elementType);

	Direction getDirection();

	void setDirection(Direction direction);
}