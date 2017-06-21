package model;

import java.util.Observable;

public interface ITimer {

	int getTime();

	void timeGo();

	boolean isTimeAway();

	void setTimeHasChanged();

	Observable getObservable();

}