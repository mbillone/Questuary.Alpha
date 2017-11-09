package model.fixed;

import model.StaticObject;

public class Collectible extends StaticObject {
	
	public Collectible(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	String fact;
	
	
	String getFact() {
		return fact;
	}
	
	void IncrementScore() {
		
	}

}
