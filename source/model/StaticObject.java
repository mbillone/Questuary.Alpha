package model;

import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */
public abstract class StaticObject extends Rectangle {
	
	String name;

	// *************************************************
	// Fields
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private double screenRatio = screenHeight / screenWidth;

	// *************************************************
	// Getters

	protected double getScreenWidth() {
		return screenWidth;
	}

	protected double getScreenHeight() {
		return screenHeight;
	}

	protected double getScreenRatio() {
		return screenRatio;
	}

	/**
	 * Gets the x location of a static object
	 * 
	 * @return int - object's x location
	 * 
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y location of a static object
	 * 
	 * @return int - object's y location
	 * 
	 */
	public double getY() {
		return y;
	}
	
	public String getName() {
		return name;
	}
	
	// *************************************************
	// Setters
	
	protected void setName(String n) {
		name = n;
	}

}
