package org.church.our.loving.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {
	
	public static void convertImage(Integer IMG_WIDTH, String sourceImage) throws IOException {
		BufferedImage originalImage = ImageIO.read(new File(sourceImage));
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		System.out.println("Image width: " + width + "Image Height: " + height);
		double ratio = (width * 1.00)/(height * 1.00);
		Integer IMG_HEIGHT =  (int)(IMG_WIDTH / ratio);
		System.out.println("Ratio is : " + ratio + "New image hight: " + IMG_HEIGHT );
		
		BufferedImage resizeImageHintPng = resizeImageWithHint(IMG_WIDTH, IMG_HEIGHT, originalImage, type);
		ImageIO.write(resizeImageHintPng, "png", new File(sourceImage));
	}
	

	private static BufferedImage resizeImageWithHint(Integer IMG_WIDTH, Integer IMG_HEIGHT,BufferedImage originalImage, int type) {

		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}

}
