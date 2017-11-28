package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IntroductionView extends JPanel{

	JFrame frame;
	int frameCount = 5;
	BufferedImage[] images = new BufferedImage[frameCount];
	
	public IntroductionView(JFrame f) {
		frame = f;
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Questary Beta");
		this.loadImages();
		
	}
	
	private void loadImages() {
		for(int i = 0; i < frameCount; i++)
		{
			int fileNumber = i + 1;
			try {
				File fileName = new File("images/IntroImages/New Project(" + fileNumber + ").png");
				BufferedImage bufferedImage = ImageIO.read(fileName);
				images[i] = bufferedImage;
			} catch (IOException e) {
				System.out.println("Error with file upload");
				e.printStackTrace();
			}
		}
	}
}
