package model.sprites.fixed;

import java.util.HashMap;
import java.util.List;
import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Chest extends StaticObject {

	// *************************************************
	// Fields

	HashMap<Collectible, String> allQuestionsAndAnswers;

	HashMap<Collectible, String> buildAllQAndA(HashMap<Collectible, String> allQuestionsAndAnswers) {
		return allQuestionsAndAnswers;
	}

	// *************************************************
	// Methods
	
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
	
	// *************************************************
	// Getters

	String getQuestion() {
		return "foo";
	}

	String getAnswer() {
		return "bar";
	}

	String getOptions() {
		return "option";
	}

}
