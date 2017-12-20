package absurd.walpurgisnight.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

//http://zetcode.com/tutorials/javagamestutorial/basics/
@SuppressWarnings("serial")
public class SpriteBoardViewer extends JPanel {

    private Image sprite;

    public SpriteBoardViewer(Image s) {
    	sprite = s;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(600, 400));
        
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(sprite, 0, 0, null);
    }
}