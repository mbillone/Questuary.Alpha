package model.sprites.fixed;

import model.Sprites;

/*
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

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
