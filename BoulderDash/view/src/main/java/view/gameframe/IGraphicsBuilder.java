package view.gameframe;

import java.awt.Graphics;

public interface IGraphicsBuilder {
	
	void applyModelToGraphics(Graphics graphics);

	int getGlobalWidth();
	
	int getGlobalHeight();
}
