/**
 * Written By Evan Williams
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * The turret class will create the users character that they control with either arrow keys or a and d
 * @author Evan Williams
 *
 */
public class Turret extends JComponent {
	private Toolkit t = Toolkit.getDefaultToolkit();
	private Image playerImage = t.getImage("src/player.png");
	private int x = 400;
	private int y = 500;
	private ArrayList<Missile> playerShots = new ArrayList<Missile>();
	
	/**
	 * Constructor for Turret Class
	 */
	public Turret() {
		for(int i = 0; i<10; i++) {
			playerShots.add(new Missile());
		}
	}

	/**
	 * Paints the players turret
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(playerImage, x, y, this);
	}

	/**
	 * Moves the turrt to the left
	 */
	public void moveLeft() {
		if (x >= 0) {
			x = x - 15;
			repaint();
		}
	}

	/**
	 * Moves the turret to the right
	 */
	public void moveRight() {
		if (x <= 840) {
			x = x + 15;
			repaint();
		}
	}
	
	/**
	 * returns the current x position of the turret
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * returns the current y position of the turret
	 */
	public int getY() {
		return y;
	}
	
}


