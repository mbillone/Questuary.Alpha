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
	
	public Collectible(int x, int y, int width, int height, String fact) {
		this.fact = fact;
		super.setBounds(x, y, width, height);
	}

	// *************************************************
	// Methods


	// *************************************************
	// Getters

	String getFact() {
		return fact;
	}

}
