/**
 * Written By Evan Williams
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

/**
 * The winScreen class to create the game over screen for the end of the game
 * @author Evan Williams
 *
 */
public class winScreen extends JComponent{	
	private Toolkit t = Toolkit.getDefaultToolkit();
	private Image gameOver = t.getImage("src/gameOver.jpg");
	
	/**
	 * empty constructor
	 */
	public winScreen() {
	}
	
	/**
	 * Paints the game over screen
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(gameOver, 0, 0, 1000, 700, this);
	}
}
