package model.fixed;

//import java.util.ArrayList;

public class Question {

	// *************************************************
	// Fields

	private String question;
	private String[] answers;
	private String correctAnswer;
	int index = 0;

	// *************************************************
	// Constructor

	public Question(String question, String[] answers, String correctAnswer) {
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}

	// *************************************************
	// Methods
	public void up() {
		if(index > 0)
		{
			index--;
		}
		System.out.println("index: " + index);
	}
	
	public void down() {
		if(index < 2)
		{
			index++;
		}
		System.out.println("index: " + index);
	}
	
	public boolean right() {
		System.out.println("Chose answer: " + answers[index]);
		System.out.println("Correct answer: " + correctAnswer);
		System.out.println("Correct: " + answers[index].equalsIgnoreCase(correctAnswer));
		return (answers[index].equalsIgnoreCase(correctAnswer));
	}
	
	public boolean checkAnswer(int index) {
		if (answers[index-1] == correctAnswer) {
			return true;
		} else {
			return false;
		}
	}

	// *************************************************
	// Getters
	public int getIndex() {
		return index;
	}
	/**
	 * Getter for question
	 * 
	 * @return String- returns the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Getter for answers
	 * 
	 * @return String[]- returns the list of answers
	 */
	public String[] getAnswers() {
		return answers;
	}

	/**
	 * Getter for Correct answer
	 * 
	 * @return String- returns the Correct answer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}
}
