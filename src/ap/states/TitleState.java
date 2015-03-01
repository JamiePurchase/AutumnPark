package ap.states;
import ap.Game;
import ap.Keyboard;
import ap.gfx.Assets;
import ap.gfx.Drawing;
import ap.gfx.ImageLoader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TitleState extends State
{
	private int cursorAnimTick = 0;
	private int cursorAnimMove = 0;
	private int glowAnimFrame = 1;
	private boolean glowAnimGrow = true;
	private int glowAnimTick = 0;
	private boolean menuActive = false;
	private int menuPos;
	private int menuMax;
	private int mapAnimTick = 0;
	
	public TitleState()
	{
		
	}
	
	public void tick()
	{
		// Background Map
		tickMap();
		
		// Menu Options
		if(menuActive==true){tickMenu();}
		
		// Press any key
		else{tickGlow();}
	}

	public void tickGlow()
	{
		tickGlowAnim();
		tickGlowKey();
	}
	
	public void tickGlowAnim()
	{
		glowAnimTick += 1;
		if(glowAnimTick<2)
		{
			glowAnimTick = 0;
			if(glowAnimGrow==true)
			{
				glowAnimFrame += 1;
				if(glowAnimFrame==5){glowAnimGrow=false;}
			}
			else
			{
				glowAnimFrame -= 1;
				if(glowAnimFrame==1){glowAnimGrow=true;}
			}
		}
	}
	
	public void tickGlowKey()
	{
		if(Keyboard.getKeyPressed()!="none")
		{
			Keyboard.setKeyDone();
			menuActive = true;
			menuPos = 1;
			menuMax = 5;
		}
	}
	
	public void tickMap()
	{
		mapAnimTick -= 1;
	}
	
	public void tickMenu()
	{
		tickMenuCursor();
		tickMenuKey();
	}
	
	public void tickMenuCursor()
	{
		cursorAnimTick+=1;
		if(cursorAnimTick==15){cursorAnimMove = 2;}
		if(cursorAnimTick==30){cursorAnimMove = 3;}
		if(cursorAnimTick==45){cursorAnimMove = 4;}
		if(cursorAnimTick==60){cursorAnimMove = 5;}
		if(cursorAnimTick==75){cursorAnimMove = 4;}
		if(cursorAnimTick==90){cursorAnimMove = 3;}
		if(cursorAnimTick==105){cursorAnimMove = 2;}
		if(cursorAnimTick==120)
		{
			cursorAnimMove = 1;
			cursorAnimTick = 0;
		}
	}
	
	public void tickMenuKey()
	{
		if(Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Enter")
		{
			Keyboard.setKeyDone();
			if(menuPos==1)
			{
				// Character Selection
				State.setStateChange("Character");
				Keyboard.setKeyDone();
			}
			if(menuPos==2)
			{
				// Load Game
				//State.setStateChange("Load");
				//Keyboard.setKeyDone();
			}
			if(menuPos==3)
			{
				// Basic Instructions
				State.setStateChange("Tutorial");
				Keyboard.setKeyDone();
			}
			if(menuPos==4)
			{
				// Game Options
				State.setStateChange("Options");
				Keyboard.setKeyDone();
			}
			if(menuPos==5)
			{
				// Project Information
				State.setStateChange("About");
				Keyboard.setKeyDone();
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			// Quit
			System.exit(0);
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos>1)
		{
			menuPos-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos<menuMax)
		{
			menuPos+=1;
			Keyboard.setKeyDone();
		}
	}
	
	public void render(Graphics g)
	{
		// Test
		//renderBackground(g);
		//renderOptions(g);
		
		renderMap(g);
		g.drawImage(ImageLoader.loadImage("/title/logo.png"), 286, 20, null);
		//Drawing.drawImageOpaque(g, ImageLoader.loadImage("/title/logo.png"), 200, 100, 0.50f);
		
		// Menu Options
		if(menuActive==true){renderMenu(g);}
		
		// Press any key
		else{renderGlow(g);}
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiTitleBkg,  0, 0, null);
	}
	
	public void renderGlow(Graphics g)
	{
		String image = "/title/any" + glowAnimFrame + ".png";
		g.drawImage(ImageLoader.loadImage(image), 533, 620, null);
	}
	
	public void renderMap(Graphics g)
	{
		int drawX = mapAnimTick * 2 - 400;
		g.drawImage(ImageLoader.loadImage("/title/map.png"), drawX, 0, null);
	}
	
	public void renderMenu(Graphics g)
	{
		//renderOptions(g);
		g.drawImage(ImageLoader.loadImage("/title/button.png"), 400, 650, null);
	}
	
	public void renderOptions(Graphics g)
	{		
		Drawing.drawStringShadow(g, "New Game", 250, 350, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Continue", 250, 400, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Tutorial", 250, 450, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Options", 250, 500, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "About", 250, 550, 1, Color.GRAY);
		
		int cursorX = 215 + cursorAnimMove;
		int cursorY = menuPos * 50 + 300;
		
		// Temp (the continue option is currently disabled)
		if(menuPos==2){cursorX=217;}
		
		Drawing.drawStringShadow(g, ">", cursorX, cursorY, 1, Color.GRAY);
		
		/*if(menuPos==1){g.drawImage(Assets.uiTitleOpt1a,  200, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt1,  200, 275, null);}
		if(menuPos==2){g.drawImage(Assets.uiTitleOpt5a,  400, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt5,  400, 275, null);}
		if(menuPos==3){g.drawImage(Assets.uiTitleOpt2a,  200, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt2,  200, 350, null);}
		if(menuPos==4){g.drawImage(Assets.uiTitleOpt3a,  400, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt3,  400, 350, null);}
		if(menuPos==5){g.drawImage(Assets.uiTitleOpt4a,  300, 425, null);}
		else{g.drawImage(Assets.uiTitleOpt4,  300, 425, null);}*/
	}
}