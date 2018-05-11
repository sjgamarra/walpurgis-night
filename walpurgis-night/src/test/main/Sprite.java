package test.main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import absurd.walpurgisnight.util.Common;

public class Sprite {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean vis;
	protected Image image;
	protected BufferedImage[][] imageSprites;

	public Sprite(int x, int y) {

		this.x = x;
		this.y = y;
		vis = true;
	}

	protected void loadImage(String imageName){		
		
//		ImageIcon ii = new ImageIcon(imageName);
//		image = ii.getImage();
		
		//mapeando desde un sprite
		try{
			int rows = 4;
			int columns = 3;
			int frameSize = 32;
			BufferedImage spriteSheet = ImageIO.read(getClass().getResource(Common.IMG_PATH + imageName));
			imageSprites = new BufferedImage[columns][rows];
			for (int x = 0; x < columns; x++) {
				for (int y = 0; y < rows; y++) {
					imageSprites[x][y] = spriteSheet.getSubimage(x * frameSize, y * frameSize, frameSize, frameSize);
				}
			}
			image = imageSprites[0][0];
		} catch (IOException e) {
			System.out.println("Image not found...");
		}
	}

	protected void getImageDimensions() {

		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVisible() {
		return vis;
	}

	public void setVisible(Boolean visible) {
		vis = visible;
	}
}