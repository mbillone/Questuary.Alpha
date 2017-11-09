package model.sprites.fixed;

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
	
	public Collectible(String fact) {
		this.fact = fact;
	}

	// *************************************************
	// Methods

	void IncrementScore() {

	}

	// *************************************************
	// Getters

	String getFact() {
		return fact;
	}

}
