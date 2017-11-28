package model.fixed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Questions {

	// *************************************************
	// Fields

	private static ArrayList<Question> questions = new ArrayList<Question>();

	// *************************************************
	// Constructor

	public Questions() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("Questions.txt");
			br = new BufferedReader(fr);
			String text;
			while((text = br.readLine()) != null)
			{
				String question = text;
				String a1 = br.readLine();
				String a2 = br.readLine();
				String a3 = br.readLine();
				String cAns = br.readLine();
				String[] answers = {a1,a2,a3};
				questions.add(new Question(question,answers,cAns));
			}
		}catch (IOException e) {
			System.out.println("Error with file reading");
			e.printStackTrace();
		}finally {
			try {
				if(br != null)
				{
					br.close();
				}
				if(fr != null)
				{
					fr.close();
				}
			}catch(IOException e){
				System.out.println("Error in closing bufferedreader or filereader");
				e.printStackTrace();
			}
		}
	}

	// *************************************************
	// Methods

	public Question pickQuestion(int numCollectible) {
		int questionIndex = numCollectible / 3;
		return questions.get(0);        //TODO: when there are more questions questionIndex is passed into questions.get(questionIndex)
		//TODO: this method will not work
	}

}
