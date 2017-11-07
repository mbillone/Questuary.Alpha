package model.sprites.dynamic;

import model.Sprites;

/*
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public abstract class Enemy extends Sprites{

	boolean killable; 
	int health;
	
	void damage(Player p) {
		
	}
	
	void changeHealth(boolean killable, int health) {
		
	}
	
	void move() {
		
	}	
	
}
