package model.fixed;

import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Ground extends StaticObject {

	// *************************************************
	// Constructor

	/**
	 * Constructor for the ground object
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Ground(int x, int y, int width, int height) {
		super.setName("ground");
		
		super.setBounds(x, y, width, height);
	}
}
