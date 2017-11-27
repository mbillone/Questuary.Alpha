package view.fixed;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.ImageObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 *         Collectible Image from -- "https://opengameart.org/content/spincoin"
 */
public class CollectibleImage extends ImageObject {

	// *************************************************
	// Fields

	// set the image's dimensions
	private int imgWidth = 36;
	private int imgHeight = 40;

	private int frameCount = 6;
	private int picNum = 0;

	private BufferedImage[] pics = new BufferedImage[frameCount];

	public CollectibleImage() {
		int xLoc = 0;
		int yLoc = 0;
		super.setName("collectible");

		// load in the image
		BufferedImage image = createImage("images/world/Coin.png");
		for (int i = 0; i < frameCount; i++) {
			pics[i] = image.getSubimage(xLoc, yLoc, imgWidth, imgHeight);
			xLoc = xLoc + 36;
		}

	}

	// *************************************************
	// Methods

	// The String imageFile is the input to the method, and is the file name
	private BufferedImage createImage(String imageFile) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(imageFile));
			return bufferedImage;
		} catch (IOException e) {
			System.out.println("Error with file upload");
			e.printStackTrace();
		}
		return null;
	}

	// return the image
	public BufferedImage show(int direct) {
		return pics[picNum];
	}

	public void nextImage(boolean canAnimate) {
		// check to see if the next index exists
		if ((picNum + 1) < frameCount) {
			picNum++;
		} else {
			picNum = 0;
		}
	}

	// *************************************************
	// Getters

	// getter for the image width
	public int getWidth() {
		return imgWidth;
	}

	// getter for the image height
	public int getHeight() {
		return imgHeight;
	}

}
