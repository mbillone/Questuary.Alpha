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
		private int imgWidth = 100;
		private int imgHeight = 60;

		private int frameCount = 15;
		private int picNum = 0;

		private BufferedImage[] pics = new BufferedImage[frameCount];

		// *************************************************
		// Constructor

		/**
		 * Constructor for the fact image
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

		// The String imageFile is the input to the method, and is the file name
		/**
		 * Creates image
		 * @param imageFile
		 * @return bufferedImage - BufferedImage displayed unless excpetion is thrown
		 */
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
		/**
		 * Shows the image
		 * @param direct
		 */
		public BufferedImage show(int direct) {
			return pics[picNum];
		}

		// increment through the BirdImage
		/**
		 * Increments to next image
		 * @param canAnimate
		 */
		public void nextImage(boolean canAnimate) {
			if (canAnimate) {
				picNum = (picNum + 1) % frameCount;
			}
		}

		// *************************************************
		// Getters

		// getter for the image width
		/**
		 * Gets the width of image
		 */
		public int getWidth() {
			return imgWidth;
		}

		// getter for the image height
		/**
		 * Gets the height image
		 */
		public int getHeight() {
			return imgHeight;
		}


}
