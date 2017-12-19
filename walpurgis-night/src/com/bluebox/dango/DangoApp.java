package com.bluebox.dango;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DangoApp extends JFrame{

	public DangoApp() {

		initUI();
	}

	private void initUI() {

		add(new Board());
		setSize(600, 400);
		
		setTitle("Dango Aplication...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				DangoApp ex = new DangoApp();
				ex.setVisible(true);
			}
		});
	}

}
