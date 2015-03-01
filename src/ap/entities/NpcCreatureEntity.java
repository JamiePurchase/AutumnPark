package ap.entities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ap.Game;
import ap.gfx.Assets;

public class NpcCreatureEntity extends CreatureEntity
{
	public static BufferedImage imageIdleE, imageIdleN, imageIdleS, imageIdleW;

	public NpcCreatureEntity()
	{
		
	}
	
	public static BufferedImage getImageIdle(String direction)
	{
		if(direction=="E"){return imageIdleE;}
		if(direction=="N"){return imageIdleN;}
		if(direction=="W"){return imageIdleW;}
		return imageIdleS;
	}
	
	public void render(Graphics g)
	{
		// Note: Is the entity idle? What about actions?
		int drawX = ((this.getPositionX() - Game.world.getGridOffsetX()) * 32) - 21;
		int drawY = ((this.getPositionY() - Game.world.getGridOffsetY()) * 32) - 16;
		g.drawImage(getImageIdle(getDirection()), drawX, drawY, null);
		
		// Debug
		String debug1 = "Npc is at " + this.getPositionX() + ", " + this.getPositionY();
		//String debug2 = "drawX = " + drawX + " and drawY = " + drawY;
		System.out.println(debug1);
		//System.out.println(debug2);
	}
	
	public void setImageIdle(BufferedImage image, String direction)
	{
		if(direction=="E"){imageIdleE = image;}
		if(direction=="N"){imageIdleN = image;}
		if(direction=="S"){imageIdleS = image;}
		if(direction=="W"){imageIdleW = image;}
	}
	
	public void tick()
	{
	}
}