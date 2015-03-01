package ap.states;
import ap.Game;

import java.awt.Color;
import java.awt.Graphics;

import ap.Keyboard;
import ap.gfx.Assets;

public class CharacterState extends State
{

	private int menuPos = 1;
	private int menuMax = 3;
	private int spriteTick = 1;
	private int spriteFrame = 1;
	
	public CharacterState()
	{
		
	}
	
	public void tick()
	{
		tickKeyEvents();
		tickSprites();
	}
	
	public void tickKeyEvents()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos==1){Game.playerClass = "Warmonger";}
			if(menuPos==2){Game.playerClass = "Stalker";}
			if(menuPos==3){Game.playerClass = "Spellweaver";}
			State.setStateChange("GameNew");
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			// Back to Title
			State.setStateChange("Title");
		}
		if(Keyboard.getKeyPressed()=="Left")
		{
			menuPos = menuPos - 1;
			if(menuPos<1){menuPos = menuMax;}
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			menuPos = menuPos + 1;
			if(menuPos>menuMax){menuPos = 1;}
			Keyboard.setKeyDone();
		}
	}
	
	public void tickSprites()
	{
		spriteTick += 1;
		if(spriteTick>10)
		{
			spriteTick = 1;
			spriteFrame += 1;
			if(spriteFrame>4){spriteFrame = 1;}
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderSprites(g);
		renderOptions(g);
		renderInformation(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiCharacterBkg,  0, 0, null);
	}
	
	public void renderInformation(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontReduced);
		if(menuPos==1)
		{
			g.drawString("Get up-close and personal as you pummel", 180, 380);
			g.drawString("your foes. Pain only strengthens you.", 180, 405);
			g.drawString("Warmongers live for the thrill of battle", 180, 430);
			g.drawString("and never refuse a challenging fight.", 180, 455);
		}
		if(menuPos==2)
		{
			g.drawString("Why let morality govern your methods?", 180, 380);
			g.drawString("There are always opportunities to prosper.", 180, 405);
			g.drawString("Stalkers are swift and deadly - especially", 180, 430);
			g.drawString("when they have the element of surprise.", 180, 455);
		}
		if(menuPos==3)
		{
			g.drawString("Magic is an unbreakable force, so long as", 180, 380);
			g.drawString("the caster remains composed and focussed.", 180, 405);
			g.drawString("Spellweavers can study a huge range of", 180, 430);
			g.drawString("techniques and provide excellent support.", 180, 455);
		}
	}
	
	public void renderOptions(Graphics g)
	{
		if(menuPos==1){g.drawImage(Assets.uiCharacterOpt1a,  155, 300, null);}
		else{g.drawImage(Assets.uiCharacterOpt1,  155, 300, null);}
		if(menuPos==2){g.drawImage(Assets.uiCharacterOpt2a,  340, 300, null);}
		else{g.drawImage(Assets.uiCharacterOpt2,  340, 300, null);}
		if(menuPos==3){g.drawImage(Assets.uiCharacterOpt3a,  460, 300, null);}
		else{g.drawImage(Assets.uiCharacterOpt3,  460, 300, null);}
	}
	
	public void renderSprites(Graphics g)
	{
		// Warmonger
		if(menuPos==1)
		{
			if(spriteFrame==1){g.drawImage(Assets.charPlayer1S1, 248, 250, null);}
			if(spriteFrame==2){g.drawImage(Assets.charPlayer1S2, 248, 250, null);}
			if(spriteFrame==3){g.drawImage(Assets.charPlayer1S1, 248, 250, null);}
			if(spriteFrame==4){g.drawImage(Assets.charPlayer1S3, 248, 250, null);}
		}
		else
		{
			g.drawImage(Assets.charPlayer1S1, 248, 250, null);
		}
		
		// Stalker
		if(menuPos==2)
		{
			if(spriteFrame==1){g.drawImage(Assets.charPlayer2S1, 384, 250, null);}
			if(spriteFrame==2){g.drawImage(Assets.charPlayer2S2, 384, 250, null);}
			if(spriteFrame==3){g.drawImage(Assets.charPlayer2S1, 384, 250, null);}
			if(spriteFrame==4){g.drawImage(Assets.charPlayer2S3, 384, 250, null);}
		}
		else
		{
			g.drawImage(Assets.charPlayer2S1, 384, 250, null);
		}
		
		// Spellweaver
		if(menuPos==3)
		{
			if(spriteFrame==1){g.drawImage(Assets.charPlayer3S1, 520, 250, null);}
			if(spriteFrame==2){g.drawImage(Assets.charPlayer3S2, 520, 250, null);}
			if(spriteFrame==3){g.drawImage(Assets.charPlayer3S1, 520, 250, null);}
			if(spriteFrame==4){g.drawImage(Assets.charPlayer3S3, 520, 250, null);}
		}
		else
		{
			g.drawImage(Assets.charPlayer3S1, 520, 250, null);
		}
	}
}