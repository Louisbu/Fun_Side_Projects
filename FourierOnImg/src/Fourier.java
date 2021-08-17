import javax.imageio.*;

import java.awt.image.*;
import java.io.*;

public class Fourier {

	public static void main(String[] args) throws IOException {
		int[][][] imgInfo = readImage();
		int width = imgInfo.length;
		int height = imgInfo[0].length;

		int[][] redsInRows = getOneColor(0, height, width, imgInfo);
		int[][] greenInRows = getOneColor(1, height, width, imgInfo);
		int[][] bluesInRows = getOneColor(2, height, width, imgInfo);

//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				System.out.println(
//						i + " " + j + " " + imgInfo[i][j][0] + " " + imgInfo[i][j][1] + " " + imgInfo[i][j][2]);
//			}
//		}
//
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				System.out.println(i + " " + j + " " + redsInRows[i][j]);
			}
		}

		writeOneColorToFile(redsInRows, 0);
		writeOneColorToFile(greenInRows, 1);
		writeOneColorToFile(bluesInRows, 2);

	}

	public static int[][] getOneColor(int colorIndex, int height, int width, int[][][] imgInfo) {
		int[][] arr = new int[width][height];
//		System.out.println(height + " " + width);
//		System.out.println(imgInfo.length + " " + imgInfo[0].length);
//		System.out.println(arr.length + " " + arr[0].length);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// System.out.println(i + " " + j + " " + imgInfo[i][j][colorIndex]);
				arr[j][i] = imgInfo[j][i][colorIndex];
				// System.out.println(arr[i][j]);
			}
		}
		return arr;
	}

	public static void writeOneColorToFile(int[][] oneColor, int colorIndex) throws IOException {
		String color = null;
		if (colorIndex == 0) {
			color = "Red";
		} else if (colorIndex == 1) {
			color = "Green";
		} else {
			color = "Blue";
		}

		String fName = color.concat(".txt");
		FileWriter f = new FileWriter(fName);

		f.write(color + "\n");

		for (int i = 0; i < oneColor.length; i++) {
			for (int j = 0; j < oneColor[0].length; j++) {
				f.write(oneColor[i][j] + "\t");
			}
			f.write("\n");
		}

		f.flush();
		f.close();

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
				arr[j][i] = getPixelRGB(pixel);

			}
		}
		return arr;
	}

	public static int[] getPixelRGB(int pixel) {
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
