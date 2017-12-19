package com.bluebox.thread;

import java.awt.EventQueue;

import javax.swing.JFrame;

//http://zetcode.com/tutorials/javagamestutorial/basics/
@SuppressWarnings("serial")
public class Application extends JFrame{

	public Application() {

		initUI();
	}

	private void initUI() {

		add(new Board());
		//setResizable(false);
		//pack();
		setSize(600, 400);
		
		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Application ex = new Application();
				ex.setVisible(true);
			}
		});
	}

}