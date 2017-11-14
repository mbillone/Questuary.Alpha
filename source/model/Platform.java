package model;

import java.awt.Rectangle;

import model.sprites.fixed.Obstacle;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Platform extends Rectangle {

	// *************************************************
	// Methods
	
	
	/**
	 * Constructor for the Controller class
	 */
	public Platform(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
	}

	/**
	 * Getter to get the right boundary of the platform
	 */
	public Rectangle getRight() {
		return new Rectangle(x + width, y + 25, 1, 15);
	}
	
	/**
	 * Getter to get the left boundary of the platform
	 */
	public Rectangle getLeft() {
		return new Rectangle(x, y + 25, 1, 15);
	}

}
