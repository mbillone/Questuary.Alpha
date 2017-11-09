package model;

import java.awt.Rectangle;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

// the Rectangle has data fields for the coordinates of x and y
public abstract class DynamicObject extends Rectangle {

	// *************************************************
	// Fields

	private int xVelocity;
	private int yVelocity;
	// a direction of 0 is left and 1 is right
	private int direction;

	// *************************************************
	// Methods

	/**
	 * Increments both x & y positions by the respective velocities
	 */
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}

	// *************************************************
	// Getters

	/**
	 * Gets the x velocity of a dynamic object
	 * 
	 * @return int - object's x velocity
	 * 
	 */
	public int getDx() {
		return xVelocity;
	}

	/**
	 * Gets the y velocity of a dynamic object
	 * 
	 * @return int - object's y velocity
	 * 
	 */
	public int getDy() {
		return yVelocity;
	}

	/**
	 * Gets the int version of direction
	 * 
	 * @return int - object's direction (-1 or 1)
	 * 
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Gets the string version of direction
	 * 
	 * @return String - direction of player (left or right)
	 * 
	 */
	public String getDirectionString() {
		if (direction == 0) {
			return "LEFT";
		} else {
			return "RIGHT";
		}
	}

	// *************************************************
	// Setters

	/**
	 * This sets the x velocity of a dynamic object
	 * 
	 * @param dx
	 *            - The velocity of that will be set by the function
	 */
	public void setDx(int dx) {
		xVelocity = dx;
	}

	/**
	 * This sets the y velocity of a dynamic object
	 * 
	 * @param dx
	 *            - The velocity of that will be set by the function
	 */
	public void setDy(int dy) {
		yVelocity = dy;
	}

	/**
	 * This sets the direction that the dynamic object is facing
	 * 
	 * @param dx
	 *            - The velocity of that will be set by the function
	 */
	public void setDirection(int d) {
		direction = d;
	}

}
