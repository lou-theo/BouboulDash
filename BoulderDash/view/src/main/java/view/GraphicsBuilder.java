package view;

import java.awt.Graphics;

import model.ElementType;
import model.IElement;
import model.IModel;
import view.gameframe.IGraphicsBuilder;

public class GraphicsBuilder implements IGraphicsBuilder {

	private IModel model;
	//private Image emptyMap;
	private int squareSize = 32;
	//private int imageSize = 32;
	private int globalHeight;
	private int globalWidth;

	public GraphicsBuilder(IModel model) {
		this.setModel(model);
		this.globalHeight = (this.getModel().getMap().getHeight() + 0) * this.squareSize;
		this.globalWidth =  (this.getModel().getMap().getWidth() + 1) * this.squareSize;
	}

	@Override
	public void applyModelToGraphics(Graphics graphics) {
		this.buildEmptyMap(graphics);
		this.drawElements(graphics);

	}

	private void buildEmptyMap(Graphics graphics) {
		graphics.fillRect(0, 0, getGlobalWidth(), getGlobalHeight());
	}

	private void drawElements(Graphics graphics) {
		this.buildEmptyMap(graphics);
		
		
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.MONTIONLESS) {
					this.drawMotionLessElement(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				} else if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.MOB) {
					this.drawMob(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				} else if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.FALL) {
					this.drawFall(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				} else if (this.getModel().getMap().getOnTheMapXY(x, y).getElementType() == ElementType.HERO) {
					this.drawHero(graphics, this.getModel().getMap().getOnTheMapXY(x, y), x, y);
				}

				//System.out.print(this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
			}
			//System.out.println("");
		}
		//System.out.println("\n");
	}

	private void drawMotionLessElement(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize, null);
	}

	private void drawMob(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize, null);
	}

	private void drawFall(Graphics graphics, IElement element, int x, int y) {
		graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize, null);
	}

	private void drawHero(Graphics graphics, IElement element, int x, int y) {
		if (/*((IMobile)element).getDirection() == Direction.NONE*/ true) {
			/*graphics.drawImage(element.getImage(), 0 * this.squareSize, 0 * this.squareSize,
					1 * this.squareSize, 1 * this.squareSize, x * this.imageSize, y * this.imageSize,
					(x+1) * this.imageSize, (y+1) * this.imageSize, null);*/
			graphics.drawImage(element.getImage(), x * this.squareSize, y * this.squareSize, null);
		}
		/*graphics.setColor(Color.BLACK);
		graphics.fillRect(element.getX() * this.squareSize, element.getY() * this.squareSize, 32, 32);
		System.out.println(element.getX() + " plop " +element.getY());*/
	}

	@Override
	public int getGlobalWidth() {
		return this.globalWidth;
	}

	@Override
	public int getGlobalHeight() {
		return this.globalHeight;
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}
}
