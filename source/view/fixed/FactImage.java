package view.fixed;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.ImageObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */
public class FactImage extends ImageObject {

	// *************************************************
	// Fields

	// set the image's dimensions
	private int imgWidth = 300;
	private int imgHeight = 200;

	private int frameCount = 10;

	private BufferedImage[] pics = new BufferedImage[frameCount];

	// *************************************************
	// Constructor
	
	/**
	 * Constructor for Fact image
	 * Places images from file in pics array
	 */
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
	
	/**
	 * gets the image from file and returns a BufferedImage
	 * @return BufferedImage  
	*/
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
	
	/**
	 * Returns a BufferedImage at a specific index
	 * @param - takes the index of array pics
	 * @return BufferedImage at the index 
	*/
	// return the image in the array
	public BufferedImage show(int picNum) {
		return pics[(picNum) % frameCount];
	}

	
	public void nextImage(boolean canAnimate) {
		/*
		 * if (canAnimate) { picNum = (picNum + 1) % frameCount; }
		 */
	}

	// *************************************************
	// Getters
	
	/**
	 * Gets width of fact image
	 * @return imgWidth
	 */
	// getter for the image width
	public int getWidth() {
		return imgWidth;
	}
	
	/**
	 * Gets height of fact image
	 * @return imgHeight
	 */
	// getter for the image height
	public int getHeight() {
		return imgHeight;
	}

}
