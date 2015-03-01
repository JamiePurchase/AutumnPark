package ap.states;
import ap.Game;
import ap.Keyboard;
import ap.battle.BattleAction;
import ap.gfx.Assets;
import ap.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class BattleState extends State
{
	// Details
	public String battleState = "Idle";
	
	// Settings
	public boolean settingForceCharge = true;
	
	// Command Menu
	private boolean menuNow = false;
	private int menuAlly = 0;
	private int menuPos = 0;
	private int menuMax = 0;
	private String menuRef;
	private String[] menuOption = new String[5];
	private String[] menuTech = new String[5];
	private String[] menuHint = new String[5];
	
	// Battle Action
	private BattleAction action = new BattleAction();
	
	public BattleState()
	{
	}
	
	//==========================> ACTION
	
	public void actionNew()
	{
		action = new BattleAction();
	}
	
	//==========================> MENU
	
	public void menuCommands()
	{
		menuNow = false;
		menuAlly = 0;
	}
	
	public void menuCommands(int ally)
	{
		menuNow = true;
		menuAlly = ally;
		menuPos = 1;
		menuMax = 4;
		menuRef = "Command";
		menuOption[1] = "Attack";
		menuTech[1] = "Attack";
		menuHint[1] = "Strike a target with your weapon.";
		menuOption[2] = "Sword Art";
		menuTech[2] = "CombatArt";
		menuHint[2] = "Physical techniques performed with your weapon.";
		menuOption[3] = "Defend";
		menuTech[3] = "Defend";
		menuHint[3] = "Stand firm and anticipate incoming attacks.";
		menuOption[4] = "Item";
		menuTech[4] = "Item";
		menuHint[4] = "Browse your inventory for an item to use.";
		// Note: need to get these values from elsewhere
	}
	
	//==========================> RENDER: START
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderForce(g);
		renderStats(g);
		if(action.actionActive==true)
		{
			if(action.damageRender==true){renderActionDamage(g);}
		}
		else
		{
			if(menuNow==true){renderMenu(g);}
		}
		
		// Development Info
		//renderDevInfo(g);
	}
	
	public void renderActionDamage(Graphics g)
	{
		for(int x=1;x<=action.targetCount;x+=1)
		{
			// Note: Use the x and y of the target unit
			String drawDamage = "" + action.targetDamage[x];
			int drawPosX = 200;
			int drawPosY = 185 - (action.damageFrameCount * 5);			
			Drawing.drawStringShadow(g, drawDamage, drawPosX, drawPosY, 1, Color.GRAY);
		}
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Game.battleEngine.bkgImage, 0, 0, null);
	}
	
	public void renderDevInfo(Graphics g)
	{
		// Shadow
		g.setColor(Color.GRAY);
		g.fillRect(484,210,400,350);
		g.fillRect(485,211,400,350);
		g.fillRect(486,212,400,350);
		g.fillRect(487,213,400,350);
		
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(483,209,400,350);
		
		// Border
		g.setColor(Color.WHITE);
		g.drawRect(483,209,400,350);
		g.drawRect(484,210,398,348);
		
		// Data
		String ally1Action = Game.battleEngine.unitAlly[1].stanceType + " (" + Game.battleEngine.unitAlly[1].stanceFrame + ")";
		
		// Write
		Drawing.drawStringShadow(g, Game.battleEngine.unitAlly[1].unitName, 525, 250, 1, Color.GRAY);
		Drawing.drawStringShadow(g, ally1Action, 650, 250, 1, Color.GRAY);
		/*Drawing.drawStringShadow(g, "Combat", 525, 300, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Mystic", 525, 350, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Item", 525, 400, 1, Color.GRAY);*/
	}
	
	//==========================> RENDER: FORCES
	
	public void renderForce(Graphics g)
	{
		// Allies
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			renderForceAlly(g, ally, Game.battleEngine.unitAlly[ally].stanceType, Game.battleEngine.unitAlly[ally].stanceFrame);
		}

		// Enemies
		for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
		{
			renderForceEnemy(g, enemy);
		}
	}
	
	public void renderForceAlly(Graphics g, int ally)
	{
		if(Game.battleEngine.unitAlly[ally].statusKO==true){renderForceAlly(g, ally, "Death", 1);}
		// Note: there should be many other variations (eg: poison, stone, frenzy, etc...)
		else{renderForceAlly(g, ally, "Idle", 1);}
	}

	public void renderForceAlly(Graphics g, int ally, String stance, int frame)
	{
		g.drawImage(Game.battleEngine.unitAlly[ally].getAnim(stance, frame), Game.battleEngine.unitAlly[ally].animPosX, Game.battleEngine.unitAlly[ally].animPosY, null);
	}
	
	public void renderForceEnemy(Graphics g, int enemy)
	{
		if(Game.battleEngine.unitEnemy[enemy].statusKO==true){renderForceEnemy(g, enemy, "Death", 1);}
		else{renderForceEnemy(g, enemy, "Idle", 1);}
	}
	
	public void renderForceEnemy(Graphics g, int enemy, String stance, int frame)
	{
		g.drawImage(Game.battleEngine.unitEnemy[enemy].getAnim(stance), Game.battleEngine.unitEnemy[enemy].animPosX, Game.battleEngine.unitEnemy[enemy].animPosY, null);
	}
	
	//==========================> RENDER: MENU
	
	public void renderMenu(Graphics g)
	{
		// Shadow
		g.setColor(Color.GRAY);
		g.fillRect(61,511,230,210);
		g.fillRect(62,512,230,210);
		g.fillRect(63,513,230,210);
		g.fillRect(64,514,230,210);
		
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(60,510,230,210);
		
		// Border
		g.setColor(Color.WHITE);
		g.drawRect(60,510,230,210);
		g.drawRect(61,511,228,208);
		
		// Options
		Drawing.drawStringShadow(g, menuOption[1], 100, 550, 1, Color.GRAY);
		Drawing.drawStringShadow(g, menuOption[2], 100, 600, 1, Color.GRAY);
		Drawing.drawStringShadow(g, menuOption[3], 100, 650, 1, Color.GRAY);
		Drawing.drawStringShadow(g, menuOption[4], 100, 700, 1, Color.GRAY);
		
		// Cursor (temporary)
		int cursorY = (50 * menuPos) + 500;
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontStandard);
		g.drawString(">", 75, cursorY);
		
		// Menu Hint
		if(menuHint[menuPos].length()>0){renderMenuHint(g);}
	}
	
	public void renderMenuHint(Graphics g)
	{
		// Shadow
		g.setColor(Color.GRAY);
		g.fillRect(26, 26, 1316, 50);
		g.fillRect(27, 27, 1316, 50);
		g.fillRect(28, 28, 1316, 50);
		g.fillRect(29, 29, 1316, 50);
		
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(25, 25, 1316, 50);
		
		// Border
		g.setColor(Color.WHITE);
		g.drawRect(25, 25, 1316, 50);
		g.drawRect(26, 26, 1314, 48);
		
		// Hint
		Drawing.drawStringShadow(g, menuHint[menuPos], 65, 60, 1, Color.GRAY);
	}
	
	//==========================> RENDER: STATS
	
	public void renderStats(Graphics g)
	{
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			renderStatsAlly(g, ally);
		}
	}
	
	public void renderStatsAlly(Graphics g, int ally)
	{
		renderStatsAllyHealth(g, ally);
		if(Game.battleEngine.unitAlly[ally].actionCharge>0){renderStatsAllyCharge(g, ally);}
		// Note: Keep the fully-charged bar on the screen for a few moments (create a timer to remove it)
		
		// Note: Wrap this drawTech line in an if statement (should be blank when player is idle and charged)
		renderStatsAllyAction(g, ally);
		
		String drawHPN = "" + Game.battleEngine.unitAlly[ally].statHealthNow;
		String drawHPM = "" + Game.battleEngine.unitAlly[ally].statHealthMax;
		String drawMPN = "" + Game.battleEngine.unitAlly[ally].statMagicNow;
		String drawMPM = "" + Game.battleEngine.unitAlly[ally].statMagicMax;
		int drawY = (50 * ally) + 540;
		Drawing.drawStringShadow(g, "Character 1", 770, drawY, 1, Color.GRAY);
		Drawing.drawStringShadow(g, drawHPN, 965, drawY, 1, Color.GRAY);
		Drawing.drawStringShadow(g, drawHPM, 1050, drawY, 1, Color.GRAY, Assets.fontReduced);
		Drawing.drawStringShadow(g, drawMPN, 1175, drawY, 1, Color.GRAY);
		Drawing.drawStringShadow(g, drawMPM, 1250, drawY, 1, Color.GRAY, Assets.fontReduced);
	}

	public void renderStatsAllyAction(Graphics g, int ally)
	{
		// Temporary
		String drawTech = "Charging";
		if(Game.battleEngine.unitAlly[ally].actionCharge<1){drawTech = "";}
		
		int drawY = (50 * ally) + 540;
		Drawing.drawStringShadow(g, drawTech, 665, drawY, 1, Color.GRAY, Assets.fontReduced);
	}

	public void renderStatsAllyCharge(Graphics g, int ally)
	{
		int drawY = (50 * ally) + 540;
		float chargeNow = Game.battleEngine.unitAlly[ally].actionCharge;
		float chargeMax = Game.battleEngine.unitAlly[ally].actionChargeDelay;
		float percent = (chargeNow / chargeMax) * 100;
		int width = (int) (100 - percent);
		g.setColor(Color.BLACK);
		g.fillRect(649, drawY-1, 102, 10);
		g.setColor(Color.RED);
		g.fillRect(650, drawY, width, 8);
	}
	
	public void renderStatsAllyHealth(Graphics g, int ally)
	{
		int drawY = (50 * ally) + 540;
		float healthNow = Game.battleEngine.unitAlly[ally].statHealthNow;
		float healthMax = Game.battleEngine.unitAlly[ally].statHealthMax;
		float percent = (healthNow / healthMax) * 100;
		int width = (int) (percent * 2);
		g.setColor(Color.BLACK);
		g.fillRect(949, drawY-1, 202, 10);
		g.setColor(Color.RED);
		g.fillRect(950, drawY, width, 8);
	}

	//==========================> TICK: MAIN
	
	public void tick()
	{
		// Check that each force still has active units
		if(battleState=="Idle")
		{
			if(Game.battleEngine.getUnitAllyCountActive()<1){battleState = "Defeat";}
			if(Game.battleEngine.getUnitEnemyCountActive()<1){battleState = "Victory";}
		}

		// Battle advances
		if(battleState=="Idle")
		{
			if(settingForceCharge==true){tickCharge();}
			if(menuNow==true){tickMenu();}
			tickStance();
			
			// Temp
			//actionDamageFrame
		}
		
		// Victory Screen
		if(battleState=="Victory"){tickVictory();}
		
		// Defeat Screen
		if(battleState=="Defeat"){tickDefeat();}
	}
	
	//==========================> TICK: CHARGE
	
	public void tickCharge()
	{
		// Allies
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			if(Game.battleEngine.unitAlly[ally].actionStance=="Charge")
			{
				Game.battleEngine.unitAlly[ally].actionCharge-=1;
				if(Game.battleEngine.unitAlly[ally].actionCharge==0)
				{
					Game.battleEngine.unitAlly[ally].actionStance="Idle";
					menuCommands(ally);
				}
			}
		}
		
		// Enemies
		for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
		{
			if(Game.battleEngine.unitEnemy[enemy].actionStance=="Charge")
			{
				Game.battleEngine.unitEnemy[enemy].actionCharge-=1;
				if(Game.battleEngine.unitEnemy[enemy].actionCharge==0)
				{
					Game.battleEngine.unitEnemy[enemy].actionStance="Idle";
				}
			}
		}
	}
	
	//==========================> TICK: DEFEAT
	
	public void tickDefeat()
	{
		
	}
	
	//==========================> TICK: MENU
	
	public void tickMenu()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuRef=="Command"){tickMenuCommand();}
			if(menuRef=="Item"){tickMenuItem();}
			if(menuRef=="Target"){tickMenuTarget();}
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos>1)
		{
			Keyboard.setKeyDone();
			menuPos -= 1;
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos<menuMax)
		{
			Keyboard.setKeyDone();
			menuPos += 1;
		}
	}
	
	public void tickMenuCommand()
	{
		if(menuTech[menuPos]=="Attack")
		{
			// Note: Start to build-up information about the action
			
			menuRef = "Target";
			menuPos = 1;
			
			// Temp
			menuMax = 1;
			menuOption[1] = "Boar";
			menuOption[2] = "";
			menuOption[3] = "";
			menuOption[4] = "";
			menuHint[1] = "";
			menuHint[2] = "";
			menuHint[3] = "";
			menuHint[4] = "";
			// Note: Write a method to clear/reset menu data
		}
	}
	
	public void tickMenuItem()
	{
		//
	}
	
	public void tickMenuTarget()
	{
		// Note: Use the menuPos to determine which unit has been selected
		
		menuNow = false;
		Game.battleEngine.unitAlly[1].stanceFrame = 1;
		Game.battleEngine.unitAlly[1].stanceFrameMax = 5;
		Game.battleEngine.unitAlly[1].stanceTick = 0;
		Game.battleEngine.unitAlly[1].stanceTickMax = 20;
		Game.battleEngine.unitAlly[1].stanceType = "Combat";
		
		action = new BattleAction();
		// Note: Set action data here
	}
	
	//==========================> TICK: STANCE
	
	public void tickStance()
	{
		// Allies
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			// Does this stance have multiple frames?
			if(Game.battleEngine.unitAlly[ally].stanceFrameMax>1)
			{
				Game.battleEngine.unitAlly[ally].stanceTick += 1;
				if(Game.battleEngine.unitAlly[ally].stanceTick>=Game.battleEngine.unitAlly[ally].stanceTickMax)
				{
					Game.battleEngine.unitAlly[ally].stanceTick = 0;
					Game.battleEngine.unitAlly[ally].stanceFrame += 1;
					
					if(Game.battleEngine.unitAlly[ally].stanceFrame>Game.battleEngine.unitAlly[ally].stanceFrameMax)
					{
						// Note: We must know whether to keep repeating or change
						Game.battleEngine.unitAlly[ally].stanceFrame = 1;
						Game.battleEngine.unitAlly[ally].stanceFrameMax = 1;
						Game.battleEngine.unitAlly[ally].stanceTick = 0;
						Game.battleEngine.unitAlly[ally].stanceTickMax = 0;
						Game.battleEngine.unitAlly[ally].stanceType = "Idle";
					}
				}
			}
		}
			
		// Enemies
		for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
		{
			// Note: Animate all enemy stances that have multiple frames
		}
	}
	
	//==========================> TICK: VICTORY
	
	public void tickVictory()
	{
		
	}

}