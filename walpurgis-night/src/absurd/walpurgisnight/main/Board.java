package absurd.walpurgisnight.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel implements Runnable {

	private final int B_WIDTH = 300;
	private final int B_HEIGHT = 100;
	private final int INITIAL_X = 0;
	private final int INITIAL_Y = 0;
	private final int DELAY = 15;

	private Image sprite;
	private Thread animator;
	private int x, y;

	private int x_ori, y_ori;

	public Board(Image s) {

		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);

		sprite = s;

		x = INITIAL_X;
		y = INITIAL_Y;
		x_ori = 1;
		y_ori = 1;
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawStar(g);
	}

	private void drawStar(Graphics g) {

		g.drawImage(sprite, x, y, this);
		Toolkit.getDefaultToolkit().sync();
	}

	private void cycle() {
		x += x_ori;
		y += y_ori;

		if (y > (B_HEIGHT - 32) && y_ori == 1) {
			y_ori = -1;
		}
		if (y < 0 && y_ori == -1) {
			y_ori = 1;
		}
		if (x > (B_WIDTH - 32) && x_ori == 1) {
			x_ori = -1;
		}
		if (x < 0 && x_ori == -1) {
			x_ori = 1;
		}
	}

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {

			cycle();
			repaint();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}

			beforeTime = System.currentTimeMillis();
		}
	}
}