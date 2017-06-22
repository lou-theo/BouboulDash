package model;

import java.util.Observable;

public class Timer extends Observable implements ITimer {
	private int time;
	private IModel model;
	
	public Timer(int time, IModel model) {
		this.model = model;
		setTime(time);
	}

	/* (non-Javadoc)
	 * @see model.ITimer#getTime()
	 */
	@Override
	public int getTime() {
		return time;
	}

	private void setTime(int time) {
		this.time = time;
		this.setTimeHasChanged();
	}
	
	/* (non-Javadoc)
	 * @see model.ITimer#timeGo()
	 */
	@Override
	public void timeGo() {
		if (getTime() <= 0) {
			setTime(getTime() - 1);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.ITimer#isTimeAway()
	 */
	@Override
	public boolean isTimeAway() {
		return getTime() == 0;
	}
	
	/* (non-Javadoc)
	 * @see model.ITimer#setTimeHasChanged()
	 */
	@Override
	public void setTimeHasChanged() {
		this.model.setModelChanged();
	}
	
	/* (non-Javadoc)
	 * @see model.ITimer#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this.model.getObservable();
	}
}
