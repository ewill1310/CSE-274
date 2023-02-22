/**
 * Written By Evan Williams
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class contains the paintable objects such as the enemies, turret, and
 * missile. It also keeps track of the
 * 
 * @author Dr. Garrett Goodman
 */
public class GamePanel extends JPanel {
	private boolean gamePlaying = true;
	private int size = 70;
	private Font bigFont = new Font("SansSerif", Font.BOLD, 70);
	private Font medFont = new Font("SansSerif", Font.BOLD, 20);
	private Random rand = new Random();
	private Random enemyDif = new Random();
	private Toolkit t = Toolkit.getDefaultToolkit();
	private Image space = t.getImage("src/space.jpg");
	private JLabel label;
	private JLabel score;
	private JLabel winScore;
	private int totalScore = 0;
	private Turret player;
	private BigEnemy biggie;
	private BigEnemy biggie2;
	private BigEnemy biggie3;
	private SmallEnemy smalls;
	private winScreen gameOver;
	int shots = 25;
	private ArrayList<Missile> missiles = new ArrayList<Missile>();
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	int randX = (int) Math.random() * 850;
	int randY = (int) Math.random() * 350;

	/**
	 * Constructor for GamePanel class builds the panel
	 */
	public GamePanel() {
		setFocusable(true);
		requestFocus();
		for (int i = 0; i < shots; i++) {
			Missile temp = new Missile(-500, -500);
			temp.setVisible(true);
			missiles.add(temp);
		}
		player = new Turret();
		player.setVisible(true);
		smalls = new SmallEnemy(200, -20);
		enemyList.add(smalls);
		smalls.setVisible(true);
		biggie2 = new BigEnemy(600, 80);
		enemyList.add(biggie2);
		biggie2.setVisible(true);
		biggie3 = new BigEnemy(300, 200);
		biggie3.setLeft(true);
		enemyList.add(biggie3);
		biggie3.setVisible(true);
		biggie = new BigEnemy(400, 320);
		enemyList.add(biggie);
		biggie.setVisible(true);
		label = new JLabel("Shots Left: 25");
		score = new JLabel("Score: 0");
		gameOver = new winScreen();
		gameOver.setVisible(false);
		addKeyListener(new Keychecker());
		Timer t = new Timer(35, new TimeEventListener());
		t.start();
		Timer e = new Timer(1500, new TimeEnemySpawner());
		e.start();
	}

	/**
	 * Paints all the components of the game as well as the win screen
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(space, 0, 0, 1000, 700, this);
		player.paintComponent(g);

		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).paintComponent(g);
		}
		for (int i = 0; i < missiles.size(); i++) {
			missiles.get(i).paintComponent(g);
		}
		g.setColor(Color.WHITE);
		g.setFont(medFont);
		g.drawString(label.getText(), 850, 20);
		g.drawString(score.getText(), 10, 20);
		
		if(shots == 0) {
			winScore = new JLabel("Final Score: " + totalScore);
			gameOver.paintComponent(g);
			g.setFont(bigFont);
			g.drawString(winScore.getText(), 220, 90);
		}
		repaint();
	}

	/**
	 * Creates the class Detection to run the detectCollision commans
	 * @author Evan Williams
	 */
	class Detection implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			detectCollision();
		}
	}

	/**
	 * Creates the TimeEnemySpawner class to spawn a random enemy at random locations after a certain time has passed
	 * @author Evan Williams
	 */
	class TimeEnemySpawner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (enemyList.size() < 3 && shots > 1) {
				if (enemyDif.nextInt(10) > 2) {
					BigEnemy temp = new BigEnemy(rand.nextInt(850), rand.nextInt(350));
					enemyList.add(temp);
					repaint();
				} else {
					SmallEnemy temp = new SmallEnemy(rand.nextInt(850), rand.nextInt(350));
					enemyList.add(temp);
					repaint();
				}
			}
		}
	}

	/**
	 * Creates the class TimeEventListener to do certain events after a selected time has passed
	 * @author Evan Williams
	 */
	class TimeEventListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < enemyList.size(); i++) {
				if (enemyList.get(i).getLeft()) {
					enemyList.get(i).moveLeft();
					detectCollision();
					repaint();
				} else {
					enemyList.get(i).moveRight();
					detectCollision();
					repaint();
				}
			}
			for (int i = 0; i < missiles.size(); i++) {
				missiles.get(i).moving();
				detectCollision();
				repaint();
			}
		}
	}

	/**
	 * creates a class to read for user input and react accordingly
	 * @author Evan Williams
	 *
	 */
	class Keychecker extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == 37 || event.getKeyCode() == 65) {
				player.moveLeft();
				repaint();
			} else if (event.getKeyCode() == 39 || event.getKeyCode() == 68) {
				player.moveRight();
				repaint();
			} else if (event.getKeyCode() == 32) {
				if (shots > 0) {
					missiles.get(shots - 1).setX(player.getX());
					missiles.get(shots - 1).setY(player.getY());
					shots = shots - 1;
					label.setText("Shots Left: " + shots);
					repaint();
				}
			}
		}

	}

	/**
	 * Method detects the collision of the missile and all the enemies. This is done
	 * by drawing invisible rectangles around the enemies and missiles, if they
	 * intersect, then they collide.
	 */
	public void detectCollision() {
		for (int i = 0; i < missiles.size(); i++) {
			Rectangle misBounds = missiles.get(i).getBounds();
			for (int j = 0; j < enemyList.size(); j++) {
				Rectangle enemyBounds = enemyList.get(j).getBounds();
				if (misBounds.intersects(enemyBounds)) {
					missiles.get(i).setVisible(false);
					enemyList.get(j).setVisible(false);
					if (enemyList.get(j) instanceof BigEnemy) {
						totalScore = totalScore + 100;
						score.setText("Score: " + totalScore);
					} else {
						totalScore = totalScore + 150;
						score.setText("Score: " + totalScore);
					}
					missiles.remove(missiles.get(i));
					enemyList.remove(enemyList.get(j));
					break;
				}
			}
		}
	}
}
