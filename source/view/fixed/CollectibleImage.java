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
		// load in the images
		for (int i = 0; i < frameCount; i++) {
			BufferedImage image = createImage("images/bird/Fly (" + (i + 1) + ")" + ".png");
			pics[i] = image;
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

	// increment through the CatImage
	public void nextImage(boolean canAnimate) {
		if (canAnimate) {
			picNum = (picNum + 1) % frameCount;
		}
	}

	// return the image in the array
	public BufferedImage show(int direct) {
		return pics[picNum];
	}

	// *************************************************
	// Getters

	// getter for the image dimensions
	public int getWidth() {
		return imgWidth;
	}

	public int getHeight() {
		return imgHeight;
	}

}
