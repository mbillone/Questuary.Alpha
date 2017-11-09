package model.dynamic;

import model.DynamicObject;

public abstract class Enemy extends DynamicObject{

	boolean killable; 
	int health;
	
	void damage(Player p) {
		
	}
	
	void changeHealth(boolean killable, int health) {
		
	}
	
	protected void move() {
		
	}
	
}
