package view.gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3094804353530880172L;
	private IGraphicsBuilder graphicsBuilder;
	
	public GamePanel(IGraphicsBuilder graphicsBuilder) {
		this.setGraphicsBuilder(graphicsBuilder);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
		
	}
	
	public void paintComponent(Graphics graphics) {
		this.getGraphicsBuilder().applyModelToGraphics(graphics);
	}

	public IGraphicsBuilder getGraphicsBuilder() {
		return graphicsBuilder;
	}

	public void setGraphicsBuilder(IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

}
