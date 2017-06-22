package model;

import java.util.Observable;

public class Counter extends Observable implements ICounter {
	private int point;
	private int diamondLeft;
	private IModel model;
	
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
	
	/* (non-Javadoc)
	 * @see model.ICounter#setCounterHasChanged()
	 */
	@Override
	public void setCounterHasChanged() {
		model.setModelChanged();
	}
	
	/* (non-Javadoc)
	 * @see model.ICounter#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this.model.getObservable();
	}
}
