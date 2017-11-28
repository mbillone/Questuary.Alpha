package model.fixed;

public class Question {

	String name = "Estuary Question";
	String question;
	String[] answers;
	String correctAnswer;
	int index = 0;
	
	public Question(String q, String[] ans, String cAns) {
		question = q;
		answers = ans;
		correctAnswer = cAns;
	}
	
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
	
	public int getIndex() {
		return index;
	}
	
	public String getName() {
		return name;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public String getA1() {
		return answers[0];
	}
	
	public String getA2() {
		return answers[1];
	}
	
	public String getA3() {
		return answers[2];
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
}
