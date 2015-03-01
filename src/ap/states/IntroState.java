package ap.states;
import ap.Keyboard;
import ap.gfx.Assets;
import ap.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class IntroState extends State
{
	private boolean introAdvance = false;
	private int introFrame = 1;
	
	public IntroState()
	{
	}
	
	public void tick()
	{
		tickKey();
		if(introAdvance==true){tickFrame();}
	}
	
	public void tickFrame()
	{
		introFrame += 1;
		if(introFrame>800)
		{
			State.setStateChange("Title");
		}
	}
	
	public void tickKey()
	{
		if(introAdvance==false){tickKeyMessage();}
		if(introAdvance==true){tickKeyIntro();}
	}
	
	public void tickKeyIntro()
	{
		if(Keyboard.getKeyPressed()!="none")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Title");
		}
	}
	
	public void tickKeyMessage()
	{
		if(Keyboard.getKeyPressed()!="none")
		{
			Keyboard.setKeyDone();
			introAdvance = true;
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0,0,1366,768);
		if(introAdvance==false){renderInitial(g);}
		if(introAdvance==true){renderFrame(g);}
	}
	
	public void renderFrame(Graphics g)
	{
		if(introFrame>=100 && introFrame <= 300)
		{
			g.drawImage(Assets.uiIntro1, 0, 0, null);
		}
		if(introFrame>=350 && introFrame <= 500)
		{
			g.drawImage(Assets.uiIntro2, 0, 0, null);
		}
		if(introFrame>=550 && introFrame <= 750)
		{
			g.drawImage(Assets.uiIntro3, 0, 0, null);
		}
	}
	
	public void renderInitial(Graphics g)
	{
		Drawing.drawStringShadow(g, "Press any key to continue", 500, 300, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "If nothing happens please close the game (ALT+F4)", 360, 450, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "and load again. This is due to key listener focus issues.", 350, 500, 1, Color.GRAY);
	}
}