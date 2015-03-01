package ap.states;
import ap.Keyboard;
import ap.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;

public class TutorialState extends State
{
	private int menuPos = 1;
	
	public TutorialState()
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
		g.drawImage(Assets.uiTutorialBkg,  0, 0, null);
	}
	
	public void renderDetails(Graphics g)
	{
		g.setFont(Assets.fontStandard);
		g.setColor(Color.WHITE);
		g.drawString("Move with the arrow keys.", 230, 250);
		g.drawString("Interact with the spacebar.", 220, 300);
		g.drawString("Press enter to access the menu.", 210, 350);
		g.drawString("Walk into items to collect them.", 210, 400);
		g.drawImage(Assets.uiOptDoneA,  300, 425, null);
	}
}