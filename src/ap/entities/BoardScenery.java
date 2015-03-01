package ap.entities;

import java.awt.image.BufferedImage;

import ap.dialogue.talkHofmann;
//import ap.scenery.scnJvGateWooden;

public class BoardScenery
{
	// Details
	public static int positionX;
	public static int positionY;
	
	// Animation
	public static BufferedImage imageIdle;
	public static String action;
	public static int animFrame;
	public static int animFrameTick;
	
	// Interact
	//public scnJvGateWooden script;
	
	public BoardScenery(int x, int y)
	{
		positionX = x;
		positionY = y;
		animFrame = 0;
		animFrameTick = 0;
	}

}