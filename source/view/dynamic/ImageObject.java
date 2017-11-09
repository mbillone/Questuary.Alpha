package view.dynamic;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public abstract class ImageObject {

	// *************************************************
	// Fields

	/// get screen's dimensions
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private double ratio = screenWidth / screenHeight;

	// set the image's dimensions
	private int imgWidth;
	private int imgHeight;

	// number of images
	private int frameCount;
	private int picNum = 0;

	// 2D array for the images
	private BufferedImage[][] pics;

	// *************************************************
	// Methods

	// *************************************************
	// Getters

	public double getScreenWidth() {
		return screenWidth;
	}

	public double getScreenHeight() {
		return screenHeight;
	}

	public double getRatio() {
		return (screenWidth / screenHeight);
	}

	// getter and setter picNum
	public int getPicNum() {
		return picNum;
	}

	// getter for the image dimensions
	public int getWidth() {
		return imgWidth;
	}

	public int getHeight() {
		return imgHeight;
	}

	// getter and setter frameCount
	public int getFrameCount() {
		return frameCount;
	}

	// *************************************************
	// Setters

	// setter for the image dimensions
	public void setWidth(int width) {
		imgWidth = width;
	}

	public void setHeight(int height) {
		imgHeight = height;
	}

	public void setFrameCount(int i) {
		frameCount = i;
	}

	public void setPicNum(int num) {
		picNum = num;
	}

	// setter for the pic 2D array
	public void setPicsArray(int rows) {
		pics = new BufferedImage[rows][frameCount];
	}

	// setter for elements into the array
	public void setImage(int row, int col, BufferedImage img) {
		pics[row][col] = img;
	}
}
