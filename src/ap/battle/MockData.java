package ap.battle;

import java.awt.image.BufferedImage;

import ap.Game;
import ap.gfx.Assets;
import ap.gfx.ImageLoader;
import ap.gfx.Tileset;

public class MockData
{
	public MockData()
	{
		Game.battleEngine = new BattleEngine();
		Game.battleEngine.bkgImage = ImageLoader.loadImage("/battle/backgrounds/test1.png");
		loadForceAllies();
		loadForceEnemies();
	}
	
	public static void loadForceAllies()
	{
		UnitAlly ally1 = new UnitAlly("Jamie");
		ally1.statHealthNow = 1000;
		ally1.statHealthMax = 1000;
		ally1.statStaminaNow = 225;
		ally1.statStaminaMax = 225;
		ally1.statMagicNow = 100;
		ally1.statMagicMax = 100;
		ally1.statFrenzyNow = 0;
		ally1.animPosX = 1000;
		ally1.animPosY = 200;
		ally1.animWide = 160;
		ally1.animHigh = 160;
		ally1.animSheet = Tileset.getTileset("/battle/character2/battleSheet.png", 6, 6, 160, 160);
		ally1.animSheetIdle = 1;
		ally1.animSheetCombat = 5;
		ally1.animSheetDefend = 4;
		ally1.animSheetDeath = 5;
		ally1.animSheetMystic = 3;
		ally1.rankLevel = 1;
		ally1.rankExpTotal = 0;
		ally1.rankExpRequired = 100;
		ally1.actionStance = "Charge";
		ally1.actionCharge = 300;
		ally1.actionChargeDelay = 300;
		ally1.commandMenu[1] = new BattleCommand("Attack");
		ally1.commandMenu[2] = new BattleCommand("Combat Arts");
		ally1.commandMenu[3] = new BattleCommand("Mystic Arts");
		ally1.commandMenu[4] = new BattleCommand("Items");
		Game.battleEngine.addUnitAlly(ally1);
		
		// Note: We need to put this/these battle allies into the main engine
		// Note: Player should have Assets.battleCharacter2Idle for the idle anim
		
		// Temp
		Game.battleEngine.unitAlly[1].stanceFrame = 1;
		Game.battleEngine.unitAlly[1].stanceFrameMax = 1;
		Game.battleEngine.unitAlly[1].stanceTick = 0;
		Game.battleEngine.unitAlly[1].stanceType = "Idle";
	}
	
	public static void loadForceEnemies()
	{
		UnitEnemy enemy1 = new UnitEnemy("Boar");
		enemy1.statHealthNow = 500;
		enemy1.statHealthMax = 500;
		enemy1.animPosX = 200;
		enemy1.animPosY = 200;
		enemy1.animWide = 100;
		enemy1.animHigh = 100;
		enemy1.animSheet = Tileset.getTileset("/battle/boar/boar01.png", 6, 6, 100, 100);
		enemy1.animSheetIdle = 1;
		enemy1.animSheetCombat = 0;
		enemy1.animSheetDefend = 0;
		enemy1.animSheetDeath = 0;
		enemy1.animSheetMystic = 0;
		enemy1.actionStance = "Charge";
		enemy1.actionCharge = 200;
		enemy1.actionChargeDelay = 200;
		enemy1.rewardExp = 12;
		enemy1.rewardCoin = 0;
		Game.battleEngine.addUnitEnemy(enemy1);
	}
}