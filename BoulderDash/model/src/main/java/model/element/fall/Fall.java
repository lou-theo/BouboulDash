package model.element.fall;

import java.awt.Point;

import model.ElementType;
import model.IElement;
import model.IFall;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;
import model.element.motionless.MotionLessElementFactory;

public class Fall extends Element implements IFall {

	private Point position;
	private IMap map;

	private static ElementType ELEMENT_TYPE = ElementType.FALL;

	public Fall(Sprite sprite, IMap map, Permeability permeability) {
		super(sprite, permeability, ELEMENT_TYPE);
		this.setMap(map);
		this.setPosition(new Point());
	}

	public Fall(int x, int y, Sprite sprite, IMap map, Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}
	
	public void fallOver() {
		if (this.isFallingDown()) {
			this.moveDown();
			if (this.isKilling()) {
				((IMobile) this.getMap().getOnTheMapXY(this.getX(), this.getY())).die();
			}
		} else if (isFallingLeft()) {
			this.moveLeft();
		} else if (isFallingRight()) {
			this.moveRight();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#moveDown()
	 */
	@Override
	public void moveDown() {
		this.getMap().setOnTheMapXY((IElement)this, this.getX(), this.getY() - 1);
		this.getMap().setOnTheMapXY(MotionLessElementFactory.createAir(), this.getX(), this.getY());
		this.setX(this.getY() - 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#moveRight()
	 */
	@Override
	public void moveRight() {
		this.getMap().setOnTheMapXY((IElement)this, this.getX() + 1, this.getY());
		this.getMap().setOnTheMapXY(MotionLessElementFactory.createAir(), this.getX(), this.getY());
		this.setY(this.getX() + 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#moveLeft()
	 */
	@Override
	public void moveLeft() {
		this.getMap().setOnTheMapXY((IElement)this, this.getX() - 1, this.getY());
		this.getMap().setOnTheMapXY(MotionLessElementFactory.createAir(), this.getX(), this.getY());
		this.setY(this.getX() - 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#doNothing()
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	private void setHasMoved() {
		this.getMap().setMapHasChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#getX()
	 */
	@Override
	public int getX() {
		return this.getPosition().x;
	}

	public final void setX(final int x) {
		this.getPosition().x = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#getY()
	 */
	@Override
	public int getY() {
		return this.getPosition().y;
	}

	public final void setY(final int y) {
		this.getPosition().y = y;
	}

	public IMap getMap() {
		return map;
	}

	private void setMap(IMap map) {
		this.map = map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#getPosition()
	 */
	@Override
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.element.fall.IFall#isFalling()
	 */
	@Override
	public boolean isFallingDown() {
		boolean result = false;

		if (getMap().getOnTheMapXY(getX(), getY() - 1).getPermeability() == Permeability.PENETRABLE) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isFallingRight() {
		boolean result = false;

		if (getMap().getOnTheMapXY(getX() + 1, getY()).getPermeability() == Permeability.PENETRABLE) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isFallingLeft() {
		boolean result = false;

		if (getMap().getOnTheMapXY(getX() - 1, getY()).getPermeability() == Permeability.PENETRABLE) {
			result = true;
		}
		return result;
	}

	public boolean isKilling() {
		boolean result = false;

		if (getMap().getOnTheMapXY(getX(), getY() - 1).getPermeability() == Permeability.LIVING) {
			result = true;
		}
		return result;
	}
}
