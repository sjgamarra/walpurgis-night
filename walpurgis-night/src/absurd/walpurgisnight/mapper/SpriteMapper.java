package absurd.walpurgisnight.mapper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import absurd.walpurgisnight.util.Common;

public class SpriteMapper {
	@SuppressWarnings("unused")
	private int frameCount;
	private BufferedImage[][] sprites;

	public SpriteMapper(String sheetName, int frameCount, int columns, int rows, int frameSize) {
		this.frameCount = frameCount;
		try {
			BufferedImage spriteSheet = ImageIO.read(new File(Common.IMG_PATH + sheetName + Common.IMG_EXTE));
			buildSprites(spriteSheet, columns, rows, frameSize);
		} catch (IOException e) {
			System.out.println("Image not found...");
		}
	}

	private void buildSprites(BufferedImage spriteSheet, int columns, int rows, int frameSize) {
		sprites = new BufferedImage[columns][rows];
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				sprites[x][y] = spriteSheet.getSubimage(x * frameSize, y * frameSize, frameSize, frameSize);
			}
		}
	}

	public BufferedImage getSprite(int col, int row) {
		return sprites[col][row];
	}
}
