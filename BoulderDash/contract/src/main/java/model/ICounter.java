package model;

import java.util.Observable;

public interface ICounter {

	int getPoint();

	int getDiamondLeft();

	void addPoint(int point);

	void removeOneDiamond();

	void setCounterHasChanged();

	Observable getObservable();

}