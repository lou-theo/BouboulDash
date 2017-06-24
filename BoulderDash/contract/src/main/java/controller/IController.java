package controller;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface IController {

	/**
	 * Launch the game
	 * @throws InterruptedException
	 */
	void play() throws InterruptedException;
	
	/**
	 * 
	 * @return IOrderPerformer
	 */
	IOrderPerformer getOrderPerformer();
}
