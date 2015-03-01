package ap.battle;

import java.awt.image.BufferedImage;

import ap.Game;

public class BattleEngine
{
	// Background
	public BufferedImage bkgImage;
	
	// Allies
	public UnitAlly[] unitAlly = new UnitAlly[4];
	public int unitAllyCount = 0;
	
	// Enemies
	public UnitEnemy[] unitEnemy = new UnitEnemy[4];
	public int unitEnemyCount = 0;
	
	// Action
	public Action battleAction;
	
	public BattleEngine()
	{
	}
	
	public int addUnitAlly(UnitAlly unit)
	{
		unitAllyCount += 1;
		unitAlly[unitAllyCount] = unit;		
		return unitAllyCount;
	}
	
	public int addUnitEnemy(UnitEnemy unit)
	{
		unitEnemyCount += 1;
		unitEnemy[unitEnemyCount] = unit;
		return unitEnemyCount;
	}
	
	public int getUnitAllyCountActive()
	{
		int count = 0;
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			if(Game.battleEngine.unitAlly[ally].statusActive==true)
			{
				count += 1;
			}
		}
		return count;
	}
	
	public int getUnitEnemyCountActive()
	{
		int count = 0;
		for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
		{
			if(Game.battleEngine.unitEnemy[enemy].statusActive==true)
			{
				count += 1;
			}
		}
		return count;
	}
	
	public UnitAlly getUnitAlly(int pos)
	{
		return unitAlly[pos];
	}

	public UnitEnemy getUnitEnemy(int pos)
	{
		return unitEnemy[pos];
	}
}