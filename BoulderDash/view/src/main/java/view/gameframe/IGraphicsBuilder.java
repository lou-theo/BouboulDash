package view.gameframe;

import java.awt.Graphics;

public interface IGraphicsBuilder {
	
	/**
	 * Paint all the GamePanel
	 * @param graphics
	 */
	void applyModelToGraphics(Graphics graphics);

	/**
	 * Get the width of the window, according to the size of the map
	 * @return window width
	 */
	int getGlobalWidth();
	
	/**
	 * Get the height of the window, according to the size of the map
	 * @return window height
	 */
	int getGlobalHeight();
}
