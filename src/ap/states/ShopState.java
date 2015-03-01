package ap.states;
import ap.gfx.Assets;
import ap.inventory.Shop;

import java.awt.Color;
import java.awt.Graphics;

import ap.Keyboard;

public class ShopState extends State
{
	public Shop shopObject;
	public int menuPos;
	public int menuMax;
	
	public ShopState()
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
		renderInterface(g);
		renderMerchandise(g);
	}
	
	public void renderInterface(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
	}
	
	public void renderMerchandise(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontStandard);
		int itemMax = shopObject.itemCount; 
		if(shopObject.itemCount>20){itemMax = 20;}
		for(int item=1;item<=itemMax;item+=1)
		{
			//g.drawString(str, x, y);
		}
	}

}