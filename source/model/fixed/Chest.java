package model.fixed;

import java.util.HashMap;
import java.util.List;

import model.StaticObject;

public class Chest extends StaticObject{
	
	public Chest(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

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
