package model.fixed;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QuestionBank {

	ArrayList<Question> questions = new ArrayList<Question>();
	
	public QuestionBank() {
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
	
	public Question pickQuestion() {
		int size = questions.size();
		Random random = new Random(System.nanoTime());
		int index = (random.nextInt(25))%size;
		return questions.get(index);
	}
}
