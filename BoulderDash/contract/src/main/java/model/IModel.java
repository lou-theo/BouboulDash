package model;

import java.util.Observable;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

	ICounter getCounter();
	
	ITimer getTimer();
    
	IMap getMap();
	
	boolean isWin();

	void setWin(boolean win);
	
	void setModelChanged();
    
    public Observable getObservable();
}
