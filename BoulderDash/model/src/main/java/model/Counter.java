package model;

import java.util.Observable;

public class Counter implements ICounter {
	private int point;
	private int diamondLeft;
	private IModel model;
	
	/**
	 * The counter constructor
	 * @param diamondLeft
	 * @param model
	 */
	public Counter(int diamondLeft, IModel model) {
		this.model = model;
		setDiamondLeft(diamondLeft);
		setPoint(0);
	}

	/* (non-Javadoc)
	 * @see model.ICounter#getPoint()
	 */
	@Override
	public int getPoint() {
		return point;
	}

	/**
	 * The setter of the counter's point
	 * @param point
	 */
	private void setPoint(int point) {
		this.point = point;
		this.setCounterHasChanged();
	}

	/* (non-Javadoc)
	 * @see model.ICounter#getDiamondLeft()
	 */
	@Override
	public int getDiamondLeft() {
		return diamondLeft;
	}

	/**
	 * The setter of the number of diamonds to collect
	 * @param diamondLeft
	 */
	private void setDiamondLeft(int diamondLeft) {
		this.diamondLeft = diamondLeft;
		this.setCounterHasChanged();
	}
	
	/* (non-Javadoc)
	 * @see model.ICounter#addPoint(int)
	 */
	@Override
	public void addPoint(int point) {
		setPoint(getPoint() + point);
	}
	
	/* (non-Javadoc)
	 * @see model.ICounter#removeOneDiamond()
	 */
	@Override
	public void removeOneDiamond() {
		if (this.getDiamondLeft() > 0) {
			setDiamondLeft(this.getDiamondLeft() - 1);
		}
	}

	/**
	 * Tell to the view that the window has to been updated
	 */
	public void setCounterHasChanged() {
		model.setModelChanged();
	}

	/**
	 * Give the model
	 * @return an observable : the model
	 */
	public Observable getObservable() {
		return this.model.getObservable();
	}
}
