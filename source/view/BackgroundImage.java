package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * @author Andrew Baldwin, Matt Billone, David Chan, Akash Sharma, Vineeth Gutta
 */

public class BackgroundImage extends JLabel {
	
	// get the screen's dimensions
	final private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	final private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	final private double screenRatio = screenWidth/screenHeight;
	
	public BackgroundImage() {
		//this.setSize(new Dimension((int) screenWidth, (int) screenHeight));
		try {
			this.setIcon(new ImageIcon(ImageIO.read(new File("images/estuary/Background.jpg"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		/*JLabel background = new JLabel(new ImageIcon("images/estuary/Background.jpg"));
		this.add(background);*/
		
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
	}
	
}
