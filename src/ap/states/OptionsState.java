package ap.states;
import ap.Keyboard;
import ap.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;

public class OptionsState extends State
{
	private int menuPos = 1;
	
	public OptionsState()
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
		renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiOptionsBkg,  0, 0, null);
	}
	
	public void renderOptions(Graphics g)
	{
		g.setFont(Assets.fontStandard);
		g.setColor(Color.WHITE);
		g.drawString("Frame Rate", 225, 300);
		g.drawString("60 FPS", 450, 300);
		g.drawString("Sound Effects", 225, 350);
		g.drawString("Enabled", 450, 350);
		g.drawImage(Assets.uiOptDone,  300, 425, null);
	}
}