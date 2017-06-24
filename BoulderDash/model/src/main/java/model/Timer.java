package model;

import java.util.Observable;

public class Timer extends Thread implements ITimer {
	private int time;
	private IModel model;
	private boolean gameFinished = false;
	
	/**
	 * The Timer constructor
	 * @param time
	 * @param model
	 */
	public Timer(int time, IModel model) {
		this.model = model;
		setTime(time);
		
		this.start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		this.timeGo();
	}

	/* (non-Javadoc)
	 * @see model.ITimer#getTime()
	 */
	@Override
	public int getTime() {
		return time;
	}

	/**
	 * The setter of the time given at the beginning of the level
	 * @param time
	 */
	private void setTime(int time) {
		this.time = time;
		this.setTimeHasChanged();
	}
	
	/* (non-Javadoc)
	 * @see model.ITimer#timeGo()
	 */
	@Override
	public void timeGo() {
		while (getTime() > 0 && this.isGameFinished() == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
	
	/**
	 * Tell to the view that the window has to been updated
	 */
	public void setTimeHasChanged() {
		this.model.setModelChanged();
	}
	
	/**
	 * Give the model
	 * @return an observable : the model
	 */
	public Observable getObservable() {
		return this.model.getObservable();
	}

	/**
	 * Tell if the game is finished or not
	 * @return true if the game is over
	 */
	public boolean isGameFinished() {
		return gameFinished;
	}

	/* (non-Javadoc)
	 * @see model.ITimer#setGameFinished(boolean)
	 */
	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}
}
