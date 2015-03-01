package ap.entities;
import ap.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HarvestNatureEntity extends NatureEntity
{
	private static String entityName;
	private static int entityFrame;
	
	public HarvestNatureEntity(String name)
	{
		entityName = name;
		entityFrame = 1;
	}
	
	public static BufferedImage getImage()
	{
		if(entityFrame==2){return Assets.itemGarnet2;}
		return Assets.itemGarnet1;
	}
	
	public void render(Graphics g)
	{
		BufferedImage drawImage = getImage();
		int drawX = getPositionX() * 32 - 32;
		int drawY = getPositionY() * 32 + 24;
		g.drawImage(drawImage, drawX, drawY, null);
	}
	
	public void tick()
	{
		entityFrame = entityFrame + 1;
		if(entityFrame>2){entityFrame = 1;}
	}
}