package model;

import java.util.ArrayList;
import java.util.Observable;

public interface IMap {

	int getWidth();

	int getHeight();

	IElement getOnTheMapXY(int x, int y);

	void setOnTheMapXY(IElement element, int x, int y);

	void setMapHasChanged();

	Observable getObservable();

	IMobile getMyCharacter();

	ArrayList<IMob> getMobs();

	void addMob(IMob mob);

	void removeMob(IMob mob);

	void removeMob(int x, int y);

	ArrayList<IFall> getFalls();

	void addFall(IFall fall);

	void removeFall(IFall fall);

	void removeFall(int x, int y);
	
	
	boolean moveDown(IMobile mobile);

	boolean moveUp(IMobile mobile);
	
	boolean moveRight(IMobile mobile);
	
	boolean moveLeft(IMobile mobile);
	
	boolean moveDown(IFall fall);
	
	boolean moveRight(IFall fall);
	
	boolean moveLeft(IFall fall);
}