package view.gameframe;

import java.awt.event.KeyEvent;

public interface IEventPerformer {
	
	/**
	 * Set the stackOrder in the controller according to the key which have been pressed
	 * @param keyCode
	 */
	void eventPerform(KeyEvent keyCode);
	
}
