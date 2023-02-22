/**
 * Written By Evan Williams
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Creates the class Missile to be fired at enemies and DESTROY THEM
 * @author Evan Williams
 *
 */
public class Missile extends JComponent {
	private Toolkit t = Toolkit.getDefaultToolkit();
	private Image missileImage = t.getImage("src/rocket.png");
	private int x;
	private int y;

	/**
	 * constructor for missile class
	 */
	public Missile() {
		this.x = 400;
		this.y = 500;
	}

	/**
	 * constructor for missile class and places it at the given location
	 * @param x
	 * @param y
	 */
	public Missile(int x, int y) {
		this.x = x+65;
		this.y = y-15;
	}

	/**
	 * paints the missile
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(missileImage, x, y, this);
		super.paintComponent(g);
	}

	/**
	 * moves the missile upwards
	 */
	public void moving() {
		if (y >= -150) {
			y = y - 15;
			repaint();
		}
	}

	/**
	 * moves the missile to the given X
	 * @param x
	 */
	public void setX(int x) {
		this.x = x+2;
		repaint();
	}

	/**
	 * moves the missile to the given Y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y-50;
		repaint();
	}
	
	/**
	 * returns the missiles current X
	 */
	public int getX() {
		return x;
	}

	/**
	 * returns the missile current Y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * creates the hitbox for the missile to be used when checking collisions
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 75, 75);
	}
}
