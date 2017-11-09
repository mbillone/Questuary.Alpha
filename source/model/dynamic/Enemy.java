package model.dynamic;

import model.DynamicObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public abstract class Enemy extends DynamicObject {

	// *************************************************
	// Fields

	boolean killable;
	int health;

	// *************************************************
	// Methods

	void damage(Player p) {
	}

	void changeHealth(boolean killable, int health) {
	}

}
