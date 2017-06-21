package model;

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
}
