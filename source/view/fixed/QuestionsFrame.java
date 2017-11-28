package view.fixed;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.*;

import model.fixed.Question;

public class QuestionsFrame {

	private JFrame questionFrame;
	String[] answers;
	private static ArrayList<JRadioButton> options = new ArrayList<JRadioButton>();
	private static ListIterator<JRadioButton> iter = options.listIterator();
	private static boolean upFlag = true;
	private static boolean downFlag = true;
	int frameWidth = 500;
	int frameHeight = 250;
	final private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	final private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	int x = (int) (screenWidth / 2) - (frameWidth / 2);
	int y = (int)(screenHeight/2) - (frameHeight/2);


	public QuestionsFrame(Question question) {
		
		answers = question.getAnswers();
		questionFrame = new JFrame("Estuary Question");
		questionFrame.setSize(frameWidth, frameHeight);
		
		questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		questionFrame.setLocation(x, y);
		
		//add the question label onto the frame
		JLabel label = new JLabel(question.getQuestion());
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setHorizontalAlignment(JLabel.CENTER);
		questionFrame.add(label, BorderLayout.NORTH);
		
		//add the JRadio Buttons
		Box buttonBox = Box.createVerticalBox();
		JRadioButton a = new JRadioButton("A) " + answers[0]);
		a.setSelected(true);
		options.add(a);
		buttonBox.add(a);
		JRadioButton b = new JRadioButton("B) " + answers[1]);
		options.add(b);
		buttonBox.add(b);
		JRadioButton c = new JRadioButton("C) " + answers[2]);
		options.add(c);
		buttonBox.add(c);
		JRadioButton d = new JRadioButton("D) " + answers[3]);
		options.add(d);
		questionFrame.add(buttonBox);
		questionFrame.requestFocus();
		//questionFrame.setVisible(true);
		//return questionFrame;	
		
	}

	// implemented with arrow keys to visually display the selected options
	public void updateQuestion(int index) {
		JRadioButton selectedButton = options.get(index);
		selectedButton.setSelected(true);
		
		Iterator<JRadioButton> btnIter = options.iterator();
		while(btnIter.hasNext())
		{
			JRadioButton btn = btnIter.next();
			if(!(btn.equals(selectedButton)))
			{
				btn.setSelected(false);
			}
		}
		(options.get(index)).setSelected(true);
	}

	public void displayCorrect(Question q) {
		removeButtons();
		Box box = Box.createVerticalBox();
		JLabel correctMessage = new JLabel(q.getCorrectAnswer() + " was correct");
		JLabel continueMessage = new JLabel("Press the Right Key to continue your adventure");
		box.add(correctMessage);
		box.add(continueMessage);
		questionFrame.add(box);
		questionFrame.setVisible(true);
	}

	public void displayWrong(Question q) {
		removeButtons();
		Box box = Box.createVerticalBox();
		JLabel message = new JLabel("Sorry Incorrect, the right answer is: ");
		JLabel correctAnswer = new JLabel(q.getCorrectAnswer());
		box.add(message);
		box.add(correctAnswer);
		box.add(new JLabel("Press the Right Key to continue your adventure"));
		questionFrame.add(box);
		questionFrame.setVisible(true);
	}

	private void removeButtons() {
		//set each JRadioButton to invisible
		Iterator<JRadioButton> btnIter = options.iterator();
		while(btnIter.hasNext())
		{
			JRadioButton btn = btnIter.next();
			btn.setVisible(false);
			btnIter.remove();
		}
	}

	public void TurnOffQuestionFrame() {
		questionFrame.removeAll();
		questionFrame.setVisible(false);
	}
	/*
	 * public static void down() { if (downFlag) { iter.next(); } if(iter.hasNext())
	 * { JRadioButton j = iter.next(); j.setSelected(true);
	 * System.out.println("Go down a button"); } downFlag = false; upFlag = true; }
	 * 
	 * public static void up() { if (upFlag) { iter.previous(); }
	 * if(iter.hasPrevious()) { JRadioButton j = iter.previous();
	 * j.setSelected(true); System.out.println("Go up a button"); } upFlag = false;
	 * downFlag = true; }
	 */
	public JFrame getQuestionFrame() {
		return questionFrame;
	}
}