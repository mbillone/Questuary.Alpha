package model.sprites.fixed;

import java.util.HashMap;
import java.util.List;

import model.FixedSprites;

public class Chest extends FixedSprites{
	
	HashMap<Collectible, String> allQuestionsAndAnswers;
	
	HashMap<Collectible, String> buildAllQAndA(HashMap<Collectible, String> allQuestionsAndAnswers) {
		return allQuestionsAndAnswers;
	}
	
	String getQuestion() {
		return "foo";
	}
	
	String getAnswer() {
		return "bar";
	}
	
	String getOptions() {
		return "option";
	}
	
	String keyGenerator(List<Collectible> c) {
		return "bar";
	}
	
	void choosePowerUp() {
		
	}
	
	boolean checkResponse() {
		return false;
	}
	
	void healthPowerUp() {
		
	}
	
	void speedPowerUp() {
		
	}
	
	void invincibilityPowerUp() {
		
	}
}
