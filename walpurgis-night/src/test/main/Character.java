package test.main;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Character extends Sprite{

	private int dx;
    private int dy;
    private ArrayList missiles;

    public Character(int x, int y) {
        super(x, y);
        initCraft();
    }

    private void initCraft() {
        missiles = new ArrayList();
        loadImage("wizz-sprite.png"); 
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            image = imageSprites[0][1];
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            image = imageSprites[0][2];
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            image = imageSprites[0][3];
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            image = imageSprites[0][0];
        }
    }



    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    public void fire() {
        //missiles.add(new Missile(x + width, y + height / 2));
    }

}
