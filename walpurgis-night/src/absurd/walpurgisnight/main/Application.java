package absurd.walpurgisnight.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import absurd.walpurgisnight.mapper.SpriteMapper;

@SuppressWarnings("serial")
public class Application extends JFrame{

	//http://zetcode.com/tutorials/javagamestutorial/basics/
	public Application() {

		initUI();
	}

	private void initUI() {
		SpriteMapper map = new SpriteMapper("wizz-sprite.png",3,3,4,32);		
		add(new Board(map.getSprite(0, 0)));
		//setResizable(false);
		//pack();
		setSize(300, 150);
		setTitle("Bouncy Wizzard");
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
