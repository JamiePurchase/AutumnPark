package ap.battle;

import ap.Game;

public class Action
{
	// Details
	public String actionName;
	public String actionHint;
	public String actionType;
	
	// Cost
	public int costStamina = 0;
	public int costMagic = 0;
	
	// Target
	public String targetForceDefault = "Enemy";
	public boolean targetForceAll = false;
	public boolean targetSelectAlly = true;
	
	// Damage
	public boolean damageTarget;
	public String damageType = "Melee";
	public int damageBase;
	public boolean damageReflect = false;
	
	// Status Effect
	public boolean statusInflictActive = false;
	public String[] statusInflictType = new String[2];
	public int[] statusInflictChance = new int[2];
	
	// Anim
	public int animFrames;
	
	// Temp
	public int pieceCount;
	public int pieceDamage;
	
	// Temp
	public boolean[][] unitAllyAssign = new boolean[5][50];
	public String[][] unitAllyStance = new String[5][50];
	public String[][] unitAllyFrame = new String[5][50];
	public boolean[][] unitEnemyAssign = new boolean[5][50];
	public String[][] unitEnemyStance = new String[5][50];
	public String[][] unitEnemyFrame = new String[5][50];
	
	public Action(String name)
	{
		actionName = name;
		animFrames = 0;
		pieceCount = 0;
	}
	
	public void pieceAdd()
	{
		pieceCount += 1;
		// When a piece is first created, it doesn't modify any behaviours
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			unitAllyAssign[ally][pieceCount] = false;
		}
		for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
		{
			unitEnemyAssign[enemy][pieceCount] = false;
		}
	}

}