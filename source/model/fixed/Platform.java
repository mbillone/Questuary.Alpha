package model.fixed;

import java.awt.Rectangle;

import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Platform extends StaticObject {

	// *************************************************
	// Methods

	/**
	 * Constructor for the Controller class
	 * 
	 * @param x
	 *            - int for the x location of the platform
	 * @param y
	 *            - int for the y location of the platform
	 * @param width
	 *            - int for the width of the platform
	 * @param height
	 *            - int for the height of the platform
	 */
	public Platform(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
	}

	/**
	 * Getter to get the right boundary of the platform
	 * 
	 * @return Rectangle - right boundary
	 */
	public Rectangle getRight() {
		return new Rectangle(x + width, y + 25, 1, 15);
	}

	/**
	 * Getter to get the left boundary of the platform
	 * 
	 * @return Rectangle - left boundary
	 */
	public Rectangle getLeft() {
		return new Rectangle(x, y + 25, 1, 15);
	}

}
