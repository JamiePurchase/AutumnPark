package ap.gfx;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Drawing
{
	public static void drawImageOpaque(Graphics g, BufferedImage image, int posX, int posY, float alpha)
	{
		// Set Opacity
		Graphics2D g2D = (Graphics2D) g;
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2D.setComposite(composite);
		
		// Draw Image
		g2D.drawImage(image, posX, posY, null);
		
		// Clear Opacity
		composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
		g2D.setComposite(composite);
	}
	
	public static void drawStringShadow(Graphics g, String text, int x, int y)
	{
		drawStringShadow(g, text, x, y, 2, Color.BLACK, Assets.fontStandard);
	}
	
	public static void drawStringShadow(Graphics g, String text, int x, int y, int shadow, Color color)
	{
		drawStringShadow(g, text, x, y, shadow, color, Assets.fontStandard);
	}
		
	public static void drawStringShadow(Graphics g, String text, int x, int y, int shadow, Color color, Font font)
	{
		g.setFont(font);
		g.setColor(color);
		for(int n=1;n<=shadow;n+=1)
		{
			g.drawString(text, x+n, y+n);
		}
		g.setColor(Color.WHITE);
		g.drawString(text, x, y);
	}
	
	public static void drawFrame(Graphics g, int x, int y, int width, int height)
	{
		// Shadow
		g.setColor(Color.gray);
		g.fillRect(x+5, y+5, width, height);
		
		// Background
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		
		// Border
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
	}
	
	public static void drawMenuItem(Graphics g, String text, int x, int y, int hover)
	{
		g.setFont(Assets.fontEditorMenu);
		if(hover==1){g.setFont(Assets.fontEditorMenuBold);}
		g.setColor(Color.BLACK);
		g.drawString(text, x, y);
		/*g.setFont(Assets.fontStandardUnderline);
		String character = "" + text.charAt(1);
		g.drawString(character, x, y);*/
	}
	
	public static Color getColorRGB(int r, int g, int b)
	{
		float hsb[] = Color.RGBtoHSB(185,122,87,null);
		return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
	}
	
	public static BufferedImage getImage(String filepath)
	{
		filepath = "C:/Eclipse/Workspace/AutumnPark/res/" + filepath;
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(new File(filepath));
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		return image;
	}
}