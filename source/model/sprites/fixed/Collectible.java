package model.sprites.fixed;

import model.Sprites;

public class Collectible extends Sprites{
	
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
