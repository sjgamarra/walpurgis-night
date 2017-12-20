package absurd.walpurgisnight.test;

import javax.swing.JFrame;
import absurd.walpurgisnight.mapper.SpriteMapper;

public class SpriteMapperTest {
	
	public static void main(String[] args) {
		SpriteMapper map = new SpriteMapper("wizz-sprite",3,3,4,32);
		
		JFrame frame = new JFrame();
		frame.add(new SpriteBoardViewer(map.getSprite(0, 0)));
		
		//frame.add(new SpriteBoardViewer(map.getSprite(2, 0)));
		frame.setSize(600, 400);
		frame.setTitle("Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
