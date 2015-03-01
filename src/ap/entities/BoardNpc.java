package ap.entities;

import java.awt.image.BufferedImage;

import ap.dialogue.talkHofmann;

public class BoardNpc
{
	// Details
	public static int positionX;
	public static int positionY;
	public static String positionD;
	
	// Animation
	public static BufferedImage imageIdleE, imageIdleN, imageIdleS, imageIdleW;
	public static String action;
	public static int walkFrame;
	public static int walkFrameTick;
	public static int walkSpeed;
	
	// Dialogue
	public talkHofmann dialogue;
	
	public BoardNpc(int x, int y, String d)
	{
		positionX = x;
		positionY = y;
		positionD = d;
		action = "Idle";
		walkFrame = 0;
		walkFrameTick = 0;
		walkSpeed = 1;
	}
	
	public static BufferedImage getImageIdle(String direction)
	{
		if(direction=="E"){return imageIdleE;}
		if(direction=="N"){return imageIdleN;}
		if(direction=="W"){return imageIdleW;}
		return imageIdleS;
	}
	
	public void setImageIdle(BufferedImage image, String direction)
	{
		if(direction=="E"){imageIdleE = image;}
		if(direction=="N"){imageIdleN = image;}
		if(direction=="S"){imageIdleS = image;}
		if(direction=="W"){imageIdleW = image;}
	}
	
	public void setImageIdleAuto(BufferedImage[] tileset)
	{
		imageIdleE = tileset[7];
		imageIdleN = tileset[10];
		imageIdleS = tileset[1];
		imageIdleW = tileset[4];
	}

}