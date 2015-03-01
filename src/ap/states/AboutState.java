package ap.states;
import ap.Keyboard;
import ap.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;

public class AboutState extends State
{
	private int menuPos = 1;
	
	public AboutState()
	{
		
	}
	
	public void tick()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Title");
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderDetails(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiAboutBkg,  0, 0, null);
	}
	
	public void renderDetails(Graphics g)
	{
		g.setFont(Assets.fontStandard);
		g.setColor(Color.WHITE);
		g.drawString("This game was developed in a weekend,", 150, 250);
		g.drawString("while I started to learn Java.", 200, 300);
		g.drawString("Created with Eclipse. Sprites from", 175, 350);
		g.drawString("famitsu. Inspiration from Youtube.", 175, 400);
		g.drawImage(Assets.uiOptDoneA,  300, 425, null);
	}
}