package com.bluebox.utils;

//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class SpriteMapper {
	int _imageCount = 0;
	int _animationStart = 0;
	int _spriteSize;
	int _frameCount;

	BufferedImage[] sprites;

	public SpriteMapper(String sheetName, int frameCount, int columns, int rows, int frameSize) {
		_frameCount = frameCount;
		try {
			BufferedImage spriteSheet = ImageIO.read(new File("src/com/bluebox/images/" + sheetName + ".png"));
			buildSprites(spriteSheet, columns, rows, frameSize);
		} catch (IOException e) {
			System.out.println("Image not found: Sprite2.java line 50");
		}

	}

	public void triggerUpdate() {
		System.out.println("image count is " + _imageCount);
		if (_imageCount < _frameCount - 1) {
			_imageCount += 1;
		} else {
			_imageCount = 0;
		}

	}

	private void buildSprites(BufferedImage spriteSheet, int columns, int rows, int frameSize) {

		sprites = new BufferedImage[25];

		for (int x = 0; x < columns; x++) {

			for (int y = 0; y < rows; y++) {

				sprites[(x * 5) + y] = spriteSheet.getSubimage(x * (frameSize + 1),y * (frameSize + 1), frameSize, frameSize);
			}

		}

	}

	public BufferedImage getSprite(int imageNumber) {

		return sprites[imageNumber];

	}

	public BufferedImage getSprite() {

		return sprites[_imageCount];

	}
}