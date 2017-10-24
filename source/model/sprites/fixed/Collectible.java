package model.sprites.fixed;

import model.FixedSprites;

public class Collectible extends FixedSprites{
	
	String fact;
	
	public Collectible(String fact) {
		this.fact = fact;
	}
	
	String getFact() {
		return fact;
	}
	
	void IncrementScore() {
		
	}

}
