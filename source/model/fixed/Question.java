package model.fixed;

public class Question {

	String name = "Estuary Question";
	String question;
	String[] answers;
	String correctAnswer;
	String reason;
	int index = 0;
	
	/**
	 * Constructor for the question object
	 * @param q - the question statement
	 * @param ans - the possible answers that will be incorrect
	 * @param cAns - the answer that is the correct answer
	 * @param res - reason why the correct answer is correct
	 */
	public Question(String q, String[] ans, String cAns, String res) {
		question = q;
		answers = ans;
		correctAnswer = cAns;
		reason = res;
	}
	
	/**
	 * Increments up in the possible answers
	 */
	public void up() {
		if(index > 0)
		{
			index--;
		}
		System.out.println("index: " + index);
	}
	
	/**
	 * Increments down in the possible answers
	 */
	public void down() {
		if(index < 2)
		{
			index++;
		}
		System.out.println("index: " + index);
	}
	
	/**
	 * Submits the answer
	 * @return the correct answer
	 */
	public boolean right() {
		System.out.println("Chose answer: " + answers[index]);
		System.out.println("Correct answer: " + correctAnswer);
		System.out.println("Correct: " + answers[index].equalsIgnoreCase(correctAnswer));
		return (answers[index].equalsIgnoreCase(correctAnswer));
	}
	
	/**
	 * Index of the possible answer
	 * @return index - the index in the possible answer array
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Gets the name of the answer
	 * @return name - name of the answer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the question to be displayed
	 * @return question - question being displayed
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Gets the possible answers array
	 * @return answers - array of strings of possible answers
	 */
	public String[] getAnswers() {
		return answers;
	}
	
	/**
	 * Gets the first option for the answer
	 * @return answers[0] - first string in the answers array
	 */
	public String getA1() {
		return answers[0];
	}
	
	/**
	 * Gets the second option for the answer
	 * @return answers[1] - second string in the answers array
	 */
	public String getA2() {
		return answers[1];
	}
	
	/**
	 * Get the third option for the answer
	 * @return answers[3] - third string in the answers array
	 */
	public String getA3() {
		return answers[2];
	}
	/**
	 * Get the reason why the correct answer is correct
	 * @return reason - reasoning of the correct answer
	 */
	public String getReason() {
		return reason;
	}
	
	/**
	 * Gets the correct answer for the question
	 * @return correctAnswer - the correct answer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}
}
