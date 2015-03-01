package ap.gfx;

import java.awt.Graphics;

public class BoardCinematic
{
	private static boolean done = false;
	
	// Logo Options
	public static boolean logoActive = false;
	private static String logoImage;
	private static int logoFrameStart;
	private static int logoFrameEnd;
	private static int logoX;
	private static int logoY;
	
	// Grid Offset
	private static int offsetMoveS = 0;
	private static int offsetMoveX = 0;
	private static int offsetMoveY = 0;
	private static int offsetPosX = 0;
	private static int offsetPosY = 0;
	private static int offsetTick = 0;
	
	// Render Options
	public static boolean renderNPCs = true;
	public static boolean renderPlayer = true;
	
	// Timing
	private static int tickCount = 0;
	private static int tickMax = 0;
	
	public BoardCinematic()
	{
		done = false;
	}
	
	public int getOffsetPosX()
	{
		return offsetPosX;
	}
	
	public int getOffsetPosY()
	{
		return offsetPosY;
	}
	
	public void render(Graphics g)
	{
		if(logoActive==true && tickCount>=logoFrameStart && tickCount<=logoFrameEnd)
		{
			g.drawImage(Drawing.getImage(logoImage),  logoX, logoY, null);
		}
	}
	
	public void setLogoActive(boolean active)
	{
		logoActive = active;
	}
	
	public void setLogoFrames(int start, int end)
	{
		logoFrameStart = start;
		logoFrameEnd = end;
	}
	
	public void setLogoImage(String image)
	{
		logoImage = "boards/logo" + image + ".png";
	}
	
	public void setLogoPosition(int x, int y)
	{
		logoX = x;
		logoY = y;
	}
	
	public void setOffsetMove(int x, int y, int speed)
	{
		offsetMoveX = x;
		offsetMoveY = y;
		offsetMoveS = speed;
	}
	
	public void setOffsetPos(int x, int y)
	{
		offsetPosX = x;
		offsetPosY = y;
	}
	
	public void setTickMax(int count)
	{
		tickMax = count;
	}
	
	public void tick()
	{
		// Timing
		tickCount += 1;
		
		// Grid Movement
		offsetTick += 1;
		if(offsetTick>=offsetMoveS)
		{
			offsetPosX += offsetMoveX;
			offsetPosY += offsetMoveY;
			offsetTick = 0;
		}
		
		// Cinematic End
		if(tickCount>tickMax){done = true;}
	}
}