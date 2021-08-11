import java.util.*;

import javax.imageio.*;

import java.awt.image.*;
import java.io.*;

public class Fourier {

	public static void main(String[] args) {
		int[][][] imgInfo = readImage();

		for (int i = 0; i < imgInfo.length; i++) {
			for (int j = 0; j < imgInfo[i].length; j++) {
				System.out.println(i + " " + j + " " + imgInfo[i][j][0] + " " + imgInfo[i][j][1] + " "
						+ imgInfo[i][j][2]);
			}
		}
		
		
	}

	public static int[][][] readImage() {
		try {
			File f = new File("/Users/louisbu/Documents/GitHub/Fun_Side_Projects/FourierOnImg/src/image0.jpg");
			BufferedImage image = ImageIO.read(f);
			return loopImageWH(image);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public static int[][][] loopImageWH(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		int[][][] arr = new int[w][h][4];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = image.getRGB(j, i);
				arr[j][i] = getPixelARGB(pixel);

			}
		}
		return arr;
	}

	public static int[] getPixelARGB(int pixel) {
		int alpha = (pixel >> 24) & 0xff;
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
		int[] aRGB = new int[3];
		
		aRGB[0] = red;
		aRGB[1] = green;
		aRGB[2] = blue;
		return aRGB;
	}

}
