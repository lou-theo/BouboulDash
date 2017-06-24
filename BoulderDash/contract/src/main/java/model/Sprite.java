package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The Class Sprite.</h1>
 * 
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class Sprite {
	private Image image;
	private String imageName;
	private char consoleImage;
	private boolean imageLoaded = false;
	
	/**
	 * The Sprite's constructor
	 * @param character
	 * @param imageName
	 */
	public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName + ".png");
    }
    
	/**
	 * Get the Image of the Sprite
	 * @return
	 */
    public final Image getImage() {
        return this.image;
    }
    
    /**
     * Load the image from the name element 
     * @throws IOException
     */
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("images/" + this.getImageName())));
    }
    
    /**
     * get the code of the sprite
     * @return char
     */
    public char getConsoleImage() {
        return this.consoleImage;
    }

    /**
     * Set the image of the sprite
     * @param image
     */
    private void setImage(final Image image) {
        this.image = image;
    }

    /**
     * set the code of the sprite
     * @param consoleImage
     */
    private void setConsoleImage(final char consoleImage) {
        this.consoleImage = consoleImage;
    }

    /**
     * get the name of the associated element
     * @return
     */
    public final String getImageName() {
        return this.imageName;
    }

    /**
     * Set the image name which corresponds to the name of the associated element
     * @param imageName
     */
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    /**
     * Tell if the image has been loaded or not
     * @return
     */
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    /**
     * Set if the image has been loaded or not
     * @param isImageLoaded
     */
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }
}
