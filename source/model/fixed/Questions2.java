package model.fixed;

import java.util.ArrayList;

public class Questions2 {

	// *************************************************
	// Fields

	private static ArrayList<Question2> questions = new ArrayList<Question2>();

	// *************************************************
	// Constructor

	public Questions2() {
		Question2 question1 = new Question2("What is your name?", new String[] { "Bob", "Dick", "Harry", "Jane" }, "Bob");
		questions.add(question1);
	}

	// *************************************************
	// Methods

	public Question2 pickQuestion(int numCollectible) {
		int questionIndex = numCollectible % 3;
		return questions.get(0);
	}

}
