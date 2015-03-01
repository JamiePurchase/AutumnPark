package ap.states;
import ap.Keyboard;
import ap.gfx.Assets;
import ap.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State
{

	private String menuState;
	private String menuStateChange;
	private int menuPosMain;
	private int menuMaxMain;
	private int menuPosInventory;
	private int menuMaxInventory;
	
	public MenuState()
	{
		menuState = "Main";
		menuPosMain = 1;
		menuMaxMain = 7;
	}
	
	public void tick()
	{
		if(menuState=="Main"){tickMain();}
		else if(menuState=="Inventory"){tickInventory();}
		else if(menuState=="Equipment"){tickEquipment();}
		else if(menuState=="Abilities"){tickAbilities();}
		else if(menuState=="Formation"){tickFormation();}
		else if(menuState=="Journal"){tickJournal();}
		else if(menuState=="Options"){tickOptions();}
	}
	
	public void tickAbilities()
	{
		
	}
	
	public void tickEquipment()
	{
		
	}
	
	public void tickFormation()
	{
		
	}
	
	public void tickInventory()
	{
		if(Keyboard.getKeyPressed()=="Escape")
		{
			menuState = "Inventory";
			menuPosInventory = 1;
			menuMaxInventory = 7;
		}
	}
	
	public void tickJournal()
	{
		
	}
	
	public void tickMain()
	{
		if(Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Enter")
		{
			if(menuPosMain==1)
			{
				menuState = "Inventory";
				menuPosInventory = 1;
				menuMaxInventory = 7;
			}
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			State.setStateChange("Game");
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPosMain>1)
		{
			menuPosMain-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPosMain<menuMaxMain)
		{
			menuPosMain+=1;
			Keyboard.setKeyDone();
		}
	}
	
	public void tickOptions()
	{
		
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		if(menuState=="Main")
		{
			//renderInformation(g);
			renderMainOptions(g);
			renderParty(g);
			renderHint(g);
		}
		if(menuState=="Inventory")
		{
			renderInventoryItems(g);
			renderInventoryOptions(g);
			renderHint(g);
		}
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiMenuBkg, 0, 0, null);
		//g.setColor(Color.BLACK);
		//g.fillRect(11, 16, 1344, 736);
	}
	
	public void renderHint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontStandard);
		g.drawString("Hint", 100, 75);
	}
	
	public void renderInformation(Graphics g)
	{
		// Frame
		//Drawing.drawFrame(g, 15, 470, 770, 110);
		
		// Text
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontStandard);
		g.drawString("Information", 100, 700);
	}
	
	public void renderInventoryItems(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontStandard);
		g.drawString("Sunroot Potion", 600, 150);
	}
	
	public void renderInventoryOptions(Graphics g)
	{		
		Drawing.drawStringShadow(g, "Consumables", 100, 150);
		Drawing.drawStringShadow(g, "Weapons", 100, 200);
		Drawing.drawStringShadow(g, "Ammunition", 100, 250);
		Drawing.drawStringShadow(g, "Accessories", 100, 300);
		Drawing.drawStringShadow(g, "Crafting", 100, 350);
		Drawing.drawStringShadow(g, "Key Items", 100, 400);
		Drawing.drawStringShadow(g, "Done", 100, 450);
		
		int cursorY = 50 * menuPosInventory + 75;
		g.drawImage(Assets.uiCursor2, 55, cursorY, null);
	}
	
	public void renderMainOptions(Graphics g)
	{		
		Drawing.drawStringShadow(g, "Inventory", 100, 150);
		Drawing.drawStringShadow(g, "Equipment", 100, 200);
		Drawing.drawStringShadow(g, "Abilities", 100, 250);
		Drawing.drawStringShadow(g, "Formation", 100, 300);
		Drawing.drawStringShadow(g, "Journal", 100, 350);
		Drawing.drawStringShadow(g, "Options", 100, 400);
		Drawing.drawStringShadow(g, "Done", 100, 450);
		
		int cursorY = 50 * menuPosMain + 75;
		g.drawImage(Assets.uiCursor2, 55, cursorY, null);
	}
	
	public void renderParty(Graphics g)
	{
		renderPartyCharacter(g, 1, 1);
	}
	
	public void renderPartyCharacter(Graphics g, int character, int position)
	{
		// Note: We should get the avatar bufferedImage from the character class 
		g.drawImage(Assets.avtPlayer1, 400, 150, null);
		Drawing.drawStringShadow(g, "Player 1", 600, 150);
	}
}