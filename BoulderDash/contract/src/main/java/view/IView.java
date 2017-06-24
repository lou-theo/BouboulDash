package view;

import controller.IOrderPerformer;

/**
 * <h1>The Interface IView.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public interface IView {

    void displayMessage(String message);
    
    void setOrderPerformer(IOrderPerformer orderPerformer);
    
    void closeAll();
	
}
