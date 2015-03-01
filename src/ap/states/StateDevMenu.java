package ap.states;
import java.awt.Color;
import java.awt.Graphics;

import ap.Game;
import ap.Keyboard;
import ap.gfx.Assets;

public class StateDevMenu extends State
{
	private int menuRef;
	private String[][] menuOption = new String[10][10];
	private int[] menuPos = new int[10];
	private int[] menuMax = new int[10];
	private String[] menuTitle = new String[10];
	
	public StateDevMenu()
	{
		// Main
		menuTitle[0] = "Main";
		menuOption[0][1] = "Settings";
		menuOption[0][2] = "Inventory";
		menuOption[0][3] = "Battle";
		menuOption[0][4] = "Back";
		menuMax[0] = 4;
		
		// Settings
		menuTitle[1] = "Settings";
		menuOption[1][1] = "Board Info";
		menuOption[1][2] = "Walk Speed";
		menuOption[1][3] = "???";
		menuOption[1][4] = "Back";
		menuMax[1] = 4;
	}
	
	public void init()
	{
		menuRef = 0;
		menuPos[0] = 1;
		menuPos[1] = 1;
	}
	
	public void tick()
	{
		// Reinitialise State
		if(State.getStateReinit())
		{
			init();
			State.setStateReinit(false);
		}
		
		// Key Events
		tickKey();
	}
	
	public void tickKey()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			if(menuRef==0){tickKeyMain();}
			if(menuRef==1){tickKeySettings();}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Game");
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos[menuRef]>1)
		{
			Keyboard.setKeyDone();
			menuPos[menuRef]-=1;
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos[menuRef]<menuMax[menuRef])
		{
			Keyboard.setKeyDone();
			menuPos[menuRef]+=1;
		}
		if(Keyboard.getKeyPressed()=="Left" && menuRef==1){tickKeySettings();}
		if(Keyboard.getKeyPressed()=="Right" && menuRef==1){tickKeySettings();}
	}
	
	public void tickKeyMain()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos[0]==1){menuRef = 1;}
			if(menuPos[0]==4){State.setStateChange("Game");}
		}
	}
	
	public void tickKeySettings()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos[0]==4){menuRef = 0;}
		}
		if(Keyboard.getKeyPressed()=="Left")
		{
			Keyboard.setKeyDone();
			if(menuPos[menuRef]==1)
			{
				if(Game.devBoardInfo==true){Game.devBoardInfo = false;}
				else{Game.devBoardInfo = true;}
			}
			if(menuPos[menuRef]==2)
			{
				int newSpeed = Assets.entPlayer.getWalkSpeed() - 1;
				if(newSpeed>=1){Assets.entPlayer.setWalkSpeed(newSpeed);}
			}
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			Keyboard.setKeyDone();
			if(menuPos[menuRef]==1)
			{
				if(Game.devBoardInfo==true){Game.devBoardInfo = false;}
				else{Game.devBoardInfo = true;}
			}
			if(menuPos[menuRef]==2)
			{
				int newSpeed = Assets.entPlayer.getWalkSpeed() + 1;
				if(newSpeed<20){Assets.entPlayer.setWalkSpeed(newSpeed);}
			}
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderMenu(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1366,768);
	}
	
	public void renderMenu(Graphics g)
	{
		renderMenuOptions(g);
		renderMenuCursor(g);
		if(menuRef==1){renderMenuSettings(g);}
	}
	
	public void renderMenuCursor(Graphics g)
	{
		int cursorPosX = 0;
		int cursorPosY = 0;
		//if(menuRef==0)
		//{
			cursorPosX = 75;
			cursorPosY = 30 * menuPos[menuRef] + 70;
		//}
		g.setColor(Color.GREEN);
		g.setFont(Assets.fontDebugStandard);
		g.drawString(">", cursorPosX, cursorPosY);
	}
	
	public void renderMenuOptions(Graphics g)
	{
		String title = "Development Menu: " + menuTitle[menuRef];
		g.setFont(Assets.fontDebugTitle);
		g.setColor(Color.GREEN);
		g.drawString(title, 50, 50);
		g.setFont(Assets.fontDebugStandard);
		for(int opt=1;opt<=menuMax[menuRef];opt+=1)
		{
			int drawX = 100;
			int drawY = (opt * 30) + 70;
			g.drawString(menuOption[menuRef][opt], drawX, drawY);
		}
	}
	
	public void renderMenuSettings(Graphics g)
	{
		String valueBoardInfo = "DISABLED";
		if(Game.devBoardInfo==true){valueBoardInfo = "ENABLED";}
		String valueWalkSpeed = "" + Assets.entPlayer.getWalkSpeed();
		g.setColor(Color.GREEN);
		g.setFont(Assets.fontDebugValue);
		g.drawString(valueBoardInfo, 400, 100);
		g.drawString(valueWalkSpeed, 400, 130);
	}
}