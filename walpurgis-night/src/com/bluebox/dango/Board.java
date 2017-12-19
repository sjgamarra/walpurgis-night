package com.bluebox.dango;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel implements Runnable {

	private final int B_WIDTH = 600;
	private final int B_HEIGHT = 400;
	private final int INITIAL_X = -40;
	private final int INITIAL_Y = -40;
	private final int DELAY = 5;

	private Image star;
	private Thread animator;
	private int x, y;

	private int x_ori, y_ori;

	public Board() {

		initBoard();
	}

	private void loadImage() {

		ImageIcon ii = new ImageIcon("src/com/bluebox/images/shuriken.png");
		star = ii.getImage();
	}

	private void initBoard() {

		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);

		loadImage();

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

		g.drawImage(star, x, y, this);
		Toolkit.getDefaultToolkit().sync();
	}

	private void cycle() {
		// System.out.println("x:"+x+" - y:"+y);

		x += x_ori;
		y += y_ori;

		if (y > (B_HEIGHT - 40) && y_ori == 1) {
			y_ori = -1;
		}
		if (y < -40 && y_ori == -1) {
			y_ori = 1;
		}
		if (x > (B_WIDTH - 40) && x_ori == 1) {
			x_ori = -1;
		}
		if (x < -40 && x_ori == -1) {
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