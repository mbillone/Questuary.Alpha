package model.fixed;

import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Collectible extends StaticObject {

	// *************************************************
	// Fields

	String fact;

	// *************************************************
	// Constructor

	public Collectible(Platform platform) {

		super.setName("collectible");

		// set the dimensions
		double width = 0.05 * super.getScreenWidth();
		double height = width * super.getScreenRatio();
		super.setSize((int) width, (int) height);

		super.setLocation((int) (platform.getX() + platform.getWidth()/2 - this.getWidth()/2), (int) (platform.getY() - this.getHeight()));
	}

	// *************************************************
	// Methods

	// TODO: Make facts

	// *************************************************
	// Getters

	String getFact() {
		return fact;
	}

}
