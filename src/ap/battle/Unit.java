package ap.battle;

import java.awt.image.BufferedImage;

public abstract class Unit
{
	// Details
	public String unitName;
	
	// Stats
	public int statHealthNow;
	public int statHealthMax;
	
	// Anim
	public int animPosX;
	public int animPosY;
	public int animWide;
	public int animHigh;
	public BufferedImage[] animSheet;
	public int animSheetIdle = 1;
	public int animSheetCombat = 1;
	public int animSheetDefend = 1;
	public int animSheetDeath = 1;
	public int animSheetMystic = 1;
	
	// Stance
	public String stanceType = "Idle";
	public int stanceTick;
	public int stanceTickMax;
	public int stanceFrame;
	public int stanceFrameMax;
	
	// Status
	public boolean statusActive = true;
	public boolean statusKO = false;
	public boolean statusFrenzy = false;
	
	// Action
	public String actionStance;
	public int actionCharge;
	public int actionChargeDelay;
	public Action[] actionObject = new Action[50];
	public int actionCount = 0;
	
	// Temp
	public boolean tempActionActive = false;
	public String tempActionStance;
	public int tempActionFrame;
	public int tempActionTick = 0;
	
	public Unit()
	{
		
	}
	
	public void actionAdd(Action object)
	{
		actionCount += 1;
		actionObject[actionCount] = object;
	}
	
	public BufferedImage getAnim(String stance)
	{
		return getAnim(stance, 1);
	}
	
	public BufferedImage getAnim(String stance, int frame)
	{
		int animID = 7;
		if(stance=="Idle"){animID = 7 + (frame - 1);}
		if(stance=="Combat"){animID = 13 + (frame - 1);}
		if(stance=="Defend"){animID = 19 + (frame - 1);}
		if(stance=="Death"){animID = 25 + (frame - 1);}
		if(stance=="Mystic"){animID = 31 + (frame - 1);}
		if(stance=="KO"){animID = 29;}
		return animSheet[animID];
	}
	
	public void inflictDamage(int amount)
	{
		statHealthNow -= amount;
		if(statHealthNow<1)
		{
			statHealthNow = 0;
			statusKO = true;
			actionStance = "KO";
		}
	}
}