package ap.states;
import ap.Game;
import ap.Keyboard;
import ap.Session;
import ap.battle.MockData;
import ap.gfx.Assets;
import ap.gfx.Drawing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DebugState extends State
{
	private String menuRef = "Main";
	private int menuPos = 1;
	private int menuMax = 7;
	private int menuGamePos = 1;
	private int menuGameMax = 3;
	
	public DebugState()
	{
		
	}
	
	public void actionGame(int preset)
	{
		State.setStateChange("Game");
		Game.playerClass = "Spellweaver";
		if(preset==1)
		{
			Game.world.getData("JvExterior");
			Assets.entPlayer.setPosition(50, 44);
			Assets.entPlayer.setDirection("S");
			Game.world.setGridScroll(true);
			Game.world.setGridOffset(29, 33);
			Assets.entPlayer.setWalkSpeed(2);
		}
		if(preset==2)
		{
			Game.world.getData("JvPlayerBedroom");
			Assets.entPlayer.setPosition(21, 15);
			Assets.entPlayer.setDirection("S");
			Game.world.setGridScroll(true);
			Game.world.setGridOffset(0, 0);
			Assets.entPlayer.setWalkSpeed(2);
		}
		if(preset==3)
		{
			Game.world.getData("JvExterior");
			Assets.entPlayer.setPositionX(34);
			Assets.entPlayer.setPositionY(25);
			Game.world.setGridScroll(true);
			Game.world.setGridOffset();
			Assets.entPlayer.setWalkSpeed(2);
			Game.devAccelerateTime = true;
		}
	}
	
	public void actionTestBattle()
	{
		new MockData();
		State.setStateChange("Battle");
	}
	
	public void tick()
	{
		if(menuRef=="Main"){tickMenuMain();}
		if(menuRef=="Game"){tickMenuGame();}
	}
	
	public void tickMenuGame()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			actionGame(menuGamePos);
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			menuRef = "Main";
		}
		if(Keyboard.getKeyPressed()=="Up" && menuGamePos>1)
		{
			Keyboard.setKeyDone();
			menuGamePos-=1;
		}
		if(Keyboard.getKeyPressed()=="Down" && menuGamePos<menuGameMax)
		{
			Keyboard.setKeyDone();
			menuGamePos+=1;
		}
	}
	
	public void tickMenuMain()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos==1)
			{
				menuRef = "Game";
			}
			if(menuPos==2)
			{
				State.setStateChange("Editor");
			}
			if(menuPos==3)
			{
				actionTestBattle();
			}
			if(menuPos==4)
			{
				State.setStateChange("Menu");
			}
			if(menuPos==5)
			{
				actionGame(3);
			}
			if(menuPos==6)
			{
				State.setStateChange("Shop");
			}
			if(menuPos==7)
			{
				State.setStateChange("Title");
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Title");
			// Note: Consider setting a variable to say where we came from and return there (ie: title or game)
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos>1)
		{
			Keyboard.setKeyDone();
			menuPos-=1;
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos<menuMax)
		{
			Keyboard.setKeyDone();
			menuPos+=1;
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderDetails(g);
		renderCursor(g);
	}
	
	public void renderBackground(Graphics g)
	{
		//g.drawImage(Assets.uiAboutBkg,  0, 0, null);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1366,768);
	}
	
	public void renderCursor(Graphics g)
	{
		int cursorPosX = 0;
		int cursorPosY = 0;
		if(menuRef=="Main")
		{
			cursorPosX = 75;
			cursorPosY = 30 * menuPos + 70;
		}
		if(menuRef=="Game")
		{
			cursorPosX = 275;
			cursorPosY = 30 * menuGamePos + 70;
		}
		g.setColor(Color.GREEN);
		g.setFont(Assets.fontDebugStandard);
		g.drawString(">", cursorPosX, cursorPosY);
	}
	
	public void renderDetails(Graphics g)
	{
		renderDetailsMain(g);
		if(menuRef=="Game"){renderDetailsGame(g);}
	}
	
	public void renderDetailsGame(Graphics g)
	{
		g.setFont(Assets.fontDebugStandard);
		g.setColor(Color.GREEN);
		g.drawString("Jharva Village Exterior", 300, 100);
		g.drawString("Player Bedroom", 300, 130);
	}
	
	public void renderDetailsMain(Graphics g)
	{
		g.setFont(Assets.fontDebugTitle);
		g.setColor(Color.GREEN);
		g.drawString("Debug Menu", 50, 50);
		g.setFont(Assets.fontDebugStandard);
		g.drawString("Jharva Village", 100, 100);
		g.drawString("Board Editor", 100, 130);
		g.drawString("Battle System", 100, 160);
		g.drawString("Pause Menu", 100, 190);
		g.drawString("Day / Night Test", 100, 220);
		g.drawString("Shop", 100, 250);
		g.drawString("Close", 100, 280);
	}
}