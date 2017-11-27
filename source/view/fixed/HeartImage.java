package view.fixed;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.ImageObject;

public class HeartImage extends ImageObject {

	// *************************************************
	// Fields

	// get screen's dimensions
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private double screenRatio = screenWidth / screenHeight;

	// set the image's dimensions
	private int imgWidth = 48;
	private int imgHeight = 48;

	int x;
	int y;

	private int frameCount = 1;
	private int picNum = 0;

	private BufferedImage[] pics = new BufferedImage[frameCount];

	// *************************************************
	// Constructor

	public HeartImage(int x, int y) {
		this.x = x;
		this.y = y;

		for (int i = 0; i < frameCount; i++) {
			BufferedImage image = createImage("images/world/Heart.png");
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

	// increment through the image
	public void nextImage(boolean canAnimate) {
		// check to see if the next index exists
		if ((picNum + 1) < frameCount) {
			picNum++;
		} else {
			picNum = 0;
		}
	}

	// return the image in the array
	public BufferedImage show(int direct) {
		return pics[picNum];
	}

	// *************************************************
	// Getters
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return imgWidth;
	}

	@Override
	public int getHeight() {
		return imgHeight;
	}
}
