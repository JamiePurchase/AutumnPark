package ap.menu;

import java.awt.Graphics;

public class Menu
{
	public String reference;
	
	// Options
	private int optionCount;
	private int optionPosX;
	private int optionPosY;
	private String[] optionText = new String[20];

	public Menu(String ref)
	{
		reference = ref;
	}
	
	public void render(Graphics g)
	{
		renderOptions(g);
		renderCursor(g);
	}
	
	public void renderCursor(Graphics g)
	{
		
	}
	
	public void renderOptions(Graphics g)
	{
		for(int opt=1;opt<=optionCount;opt+=1)
		{
			
		}
	}
	
	public void tick()
	{
		tickKey();
	}
	
	public void tickKey()
	{
		
	}
}