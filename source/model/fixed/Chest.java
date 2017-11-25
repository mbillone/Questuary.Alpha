package model.fixed;

import java.util.HashMap;
import java.util.List;
import model.StaticObject;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class Chest extends StaticObject {

	// *************************************************
	// Fields
	
	private boolean isOpen = false;
	
	HashMap<Collectible, String> allQuestionsAndAnswers;

	HashMap<Collectible, String> buildAllQAndA(HashMap<Collectible, String> allQuestionsAndAnswers) {
		return allQuestionsAndAnswers;
	}

	// *************************************************
	// Constructor

	public Chest(Platform platform) {

		super.setName("chest");

		// set the dimensions
		double width = 0.05 * super.getScreenWidth();
		double height = width * super.getScreenRatio();
		super.setSize((int) width, (int) height);

		super.setLocation((int) (platform.getX() + platform.getWidth() / 2 - this.getWidth() / 2),
				(int) (platform.getY() - this.getHeight()));
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
	
	public boolean getIsOpen() {
		return isOpen;
	}

	public String getQuestion() {
		return "foo";
	}

	public String getAnswer() {
		return "bar";
	}

	public String getOptions() {
		return "option";
	}
	
	// *************************************************
		// Setters
	
	public void setIsOpen(boolean b) {
		isOpen = b;
	}
	
	

}
