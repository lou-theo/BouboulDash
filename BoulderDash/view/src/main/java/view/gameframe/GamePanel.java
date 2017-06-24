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
	
	/**
	 * The GamePanel constructor
	 * @param graphicsBuilder
	 */
	public GamePanel(IGraphicsBuilder graphicsBuilder) {
		this.setGraphicsBuilder(graphicsBuilder);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
		
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics graphics) {
		this.getGraphicsBuilder().applyModelToGraphics(graphics);
	}

	/**
	 * The getter of the graphicsBuilder
	 * @return graphicsBuilder
	 */
	public IGraphicsBuilder getGraphicsBuilder() {
		return graphicsBuilder;
	}

	/**
	 * The setter of the graphicsBuilder
	 * @param graphicsBuilder
	 */
	public void setGraphicsBuilder(IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

}
