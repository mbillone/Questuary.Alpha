package view;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public abstract class ImageObject {

	// *************************************************
	// Fields

	// get screen's dimensions
	private static double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static double screenRatio = screenWidth / screenHeight;

	private String name;

	// *************************************************
	// Methods

	public abstract BufferedImage show(int direct);

	public abstract void nextImage(boolean canAnimate);

	public abstract int getWidth();

	public abstract int getHeight();

	// *************************************************
	// Getters

	public double getScreenWidth() {
		return screenWidth;
	}

	public double getScreenHeight() {
		return screenHeight;
	}

	public double getScreenRatio() {
		return screenRatio;
	}

	// *************************************************
	// Setters

	protected void setName(String n) {
		name = n;
	}

}
