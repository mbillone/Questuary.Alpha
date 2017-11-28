package view.fixed;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.ImageObject;

public class FactImage extends ImageObject {

	// *************************************************
	// Fields

	// set the image's dimensions
	private int imgWidth = 400;
	private int imgHeight = 100;

	private int frameCount = 15;

	private BufferedImage[] pics = new BufferedImage[frameCount];

	// *************************************************
	// Constructor

	public FactImage() {
		super.setName("fact");
		
		// load in the images
		for (int i = 0; i < frameCount; i++) {
			BufferedImage image = createImage("images/facts/Fact (" + (i + 1) + ")" + ".png");
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

	// return the image in the array
	public BufferedImage show(int picNum) {
		return pics[picNum - 1];
	}

	// increment through the BirdImage
	public void nextImage(boolean canAnimate) {
		/*
		 * if (canAnimate) { picNum = (picNum + 1) % frameCount; }
		 */
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
